package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class CreateScrubFile extends Utils {

	private WebDriver driver;

	public CreateScrubFile(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	/*
	 * All elements of create a scrub file page are captured.
	 */

	@FindBy(xpath = "//span[text()='Create a Scrub File']")
	WebElement createAScrubFilePageTitle;

	@FindBy(id = "ScrubFileType")
	WebElement scrubFileTypeDropDown;

	@FindBy(id = "CallType")
	WebElement anthemCallTypeDropDown;

	@FindBy(id = "ProgramName")
	WebElement programName;

	@FindBy(id = "$PpyWorkPage$ppyFileName")
	WebElement chooseFile;

	@FindBy(xpath = "(//div[text()='Cancel'])[2]")
	WebElement cancel;

	@FindBy(xpath = "//div[text()='Reset']")
	WebElement reset;

	@FindBy(xpath = "//div[text()='Submit']")
	WebElement submit;

	@FindBy(id = "$PpyWorkPage$pFileHeaderDetails$pProgramNameError")
	WebElement emptyProgramTypeError;

	@FindBy(xpath = "//Span[text()='Non-sales']")
	WebElement anthemCallTypeNonSalesWhenScrubFileIsWrongNumber;

	@FindBy(xpath = "//div[text()='Please upload only text files with .txt extension']")
	WebElement invalidFileFormatErrorMessage;

	@FindBy(xpath = "//div[text()='Please select the file to upload']")
	WebElement noFileMessage;

	@FindBy(xpath = "//div[@data-node-id='CreateScrubFile'][contains(@uniqueid,'SID')]")
	WebElement isDropDownValueChanged;

	@FindBy(xpath = "//select[@id='CallType']//option[@selected]")
	WebElement selectedAnthemCallType;

	/* This method is to verify the create a scrub file page title */
	public void validateCreateAScrubFilePageTitle() {
		verifyThePageTitle("Create a Scrub File", createAScrubFilePageTitle);
	}

	/* This method is to select header details in create a scrub file page */
	public void selectHeaderDetails(String scrubFileType, String anthemCallType) {
		String oldAttributeValue = isDropDownValueChanged.getAttribute("uniqueid");
		selectDropDownValueByText(scrubFileTypeDropDown, scrubFileType);
		
		if (scrubFileType.equalsIgnoreCase("Wrong Number Scrub")) {
			waitTillAttributeValueChanges(isDropDownValueChanged, oldAttributeValue, "uniqueid");
			compareTexts("Non-sales", getText(anthemCallTypeNonSalesWhenScrubFileIsWrongNumber));
		} else if (getText(selectedAnthemCallType).equalsIgnoreCase(anthemCallType)) {
			// if anthem call type is already selected as Non-sales then no need to select again
		} else {
			selectDropDownValueByText(anthemCallTypeDropDown, anthemCallType);
			waitTillAttributeValueChanges(isDropDownValueChanged, oldAttributeValue, "uniqueid");
		}
		enterTheText(programName, generateRandomName());
	}

	/* This method is to upload the scrub file */
	public void uploadDocumentToCreateScrubFile(String fileLocation) {
		enterTheText(chooseFile, System.getProperty("user.dir") + fileLocation);
	}

	/* This method is to click on submit */
	public void clickOnSubmit() {
		validateCreateAScrubFilePageTitle();
		clickAnElement(submit);
	}

	/* This method is to validate the error messages in create scrub file page. */
	public void validateErrorMessage(String errorMessage) {
		if (errorMessage.contains("file")) {
			compareTexts(errorMessage, getText(noFileMessage));
		} else {
			compareTexts(errorMessage, getText(emptyProgramTypeError));
		}
	}

	/* This method is navigate back to scrubbing status page. */
	public void clickOnCancelAndVerifyTheScrubbingStatusPage() {
		clickOnCancel();
		scrubbingStatus.validateScrubbingStatusPageTitle();
	}

	/* This method is to click on cancel */
	public void clickOnCancel() {
		clickAnElement(cancel);
	}

	/* This method is to click on reset button */
	public void clickOnReset() {
		clickAnElement(reset);
		waitForTheElementTobeAbsent(noFileMessage);
	}
}
