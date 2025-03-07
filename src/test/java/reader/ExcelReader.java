package reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import stepDefinitions.BaseClass;

public class ExcelReader extends BaseClass {

	private File file;
	private FileInputStream inputStream;
	private String testID;
	private String sheetName;
	private int testIdColumn;
	private int numberOfColumns;
	private XSSFCell cell;

	public ExcelReader(String testId, String sheetName) {
		file = new File(System.getProperty("user.dir") + "//data//Application_Automation_Data.xlsx");
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found at given location: " + e);
		}
		this.testID = testId;
		this.sheetName = sheetName;

		this.readExcelAndCreateHashMapForData();
	}

	public HashMap<String, String> readExcelAndCreateHashMapForData() {
		try {
			fieldsAndValues = new HashMap<String, String>();

			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workBook.getSheet(sheetName);

			/* Get number of rows */
			int lastRow = sheet.getLastRowNum();
			int firstRow = sheet.getFirstRowNum();
			int numberOfRows = lastRow - firstRow;

			/*
			 * Search for test id column. Why I need test id column number? Because when I
			 * get the values corresponding to test id row then I need to map those values
			 * with field names(header) so that I need test id column number.
			 */
			outerloop: for (int row = 0; row < numberOfRows; row++) {
				numberOfColumns = sheet.getRow(row).getLastCellNum();
				for (int cellNumber = 0; cellNumber < numberOfColumns; cellNumber++) {
					cell = sheet.getRow(row).getCell(cellNumber);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					if (sheet.getRow(row).getCell(cellNumber).getStringCellValue().equalsIgnoreCase("test_ID")) {
						testIdColumn = sheet.getRow(row).getCell(cellNumber).getColumnIndex();
						break outerloop;
					}
				}
			}

			/*
			 * Search for the test id value in test id column and get that row values(if not
			 * empty) then create hash map
			 */
			outerloop: for (int i = 0; i <= numberOfRows; i++) {
				/*
				 * We know, we define the test id numbers in test id column so that directly am
				 * checking for test id match in test id column.
				 */
				cell = sheet.getRow(i).getCell(testIdColumn);
				cell.setCellType(Cell.CELL_TYPE_STRING);

				/* This if condition checks for the test id number match.s */
				if (testID.equals(sheet.getRow(i).getCell(testIdColumn).getStringCellValue())) {

					/*
					 * If match found then it will get the field names(header) and values of that
					 * row.
					 */
					for (int j = 0; j < numberOfColumns; j++) {
						XSSFCell key = sheet.getRow(testIdColumn).getCell(j);
						XSSFCell value = sheet.getRow(i).getCell(j);

						key.setCellType(Cell.CELL_TYPE_STRING);

						if (value == null) {
							// Not capturing blank cells.
						} else if (value.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
							// Not capturing blank cells.
						} else {
							value.setCellType(Cell.CELL_TYPE_STRING);
							String fieldName = sheet.getRow(testIdColumn).getCell(j).getStringCellValue().trim();
							String fieldValue = sheet.getRow(i).getCell(j).getStringCellValue().trim();
							fieldsAndValues.put(fieldName, fieldValue);
						}
					}
					System.out.println("Fields and values: " + Arrays.toString(fieldsAndValues.entrySet().toArray()));
					break outerloop;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occured at getting the sheet: " + e);
		}
		/* Return the hash map */
		return fieldsAndValues;
	}

}
