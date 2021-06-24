package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reader.PropertiesReader;
import utilities.Utils;

public class ScrubbingStatus extends Utils {

	private WebDriver driver;

	public ScrubbingStatus(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		propertiesReader = new PropertiesReader();
	}

	/*
	 * All elements of scrubbing status page are captured.
	 */

	@FindBy(xpath = "//span[text()='Scrubbing Status']")
	WebElement scrubbingStatusPageTitle;

	@FindBy(xpath = "//th[@data-attribute-name='File']//div[@class='cellIn ']")
	WebElement fileHeader;

	@FindBy(xpath = "//th[@data-attribute-name='Submitted By']//div[@class='cellIn ']")
	WebElement submittedByHeader;

	@FindBy(xpath = "//th[@data-attribute-name='Submitted Date']//div[@class='cellIn ']")
	WebElement submittedDateHeader;

	@FindBy(xpath = "//th[@data-attribute-name='Status']//div[@class='cellIn ']")
	WebElement statusHeader;

	@FindBy(xpath = "//th[@data-attribute-name='Status Change Date']//div[@class='cellIn ']")
	WebElement statusChangeDateHeader;

	@FindBy(xpath = "//div[text()='File Upload Successful.']")
	WebElement fileUploadSuccessful;

	@FindBy(xpath = "//td[@data-attribute-name='File']//div//span")
	List<WebElement> fileValuesInScrubbingTable;

	@FindBy(xpath = "//td[@data-attribute-name='Submitted By']//div//span")
	List<WebElement> submittedByValuesInScrubbingTable;

	@FindBy(xpath = "//td[@data-attribute-name='Submitted Date']//div//span")
	List<WebElement> submittedDateValuesInScrubbingTable;

	@FindBy(xpath = "//td[@data-attribute-name='Status']//div//span")
	List<WebElement> statusValuesInScrubbingTable;

	@FindBy(xpath = "//td[@data-attribute-name='Status Change Date']//div//span")
	List<WebElement> statusChangeDateValuesInScrubbingTable;

	@FindBy(xpath = "(//td[@data-attribute-name='File']//div//span)[1]")
	WebElement latestFileValueInScrubbingTable;

	@FindBy(xpath = "(//td[@data-attribute-name='Submitted By']//span)[1]")
	WebElement latestSubmittedByValueInScrubbingTable;

	@FindBy(xpath = "(//td[@data-attribute-name='Submitted Date']//span)[1]")
	WebElement latestSubmittedDateValueInScrubbingTable;

	@FindBy(xpath = "(//td[@data-attribute-name='Status']//span)[1]")
	WebElement latestStatusValueInScrubbingTable;

	@FindBy(xpath = "(//td[@data-attribute-name='Status Change Date']//span)[1]")
	WebElement latestStatusChangeDateValueInScrubbingTable;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][text()='Add Scrub File']")
	WebElement addScrubFileButton;

	@FindBy(xpath = "//div[text()='Refresh']")
	WebElement refreshButton;

	@FindBy(xpath = "//div[@datasource='pyWorkPage.FileList_DisplayScrubbingStatus_1'][contains(@id,'PEGA_GRID')]")
	WebElement isValuesSorted;

	/* This method is to verify the scrubbing status page title */
	public void validateScrubbingStatusPageTitle() {
		verifyThePageTitle("Scrubbing Status", scrubbingStatusPageTitle);
	}

	/* This method is to validate the latest records in scrubbing status page */
	public void validateLatestRecordInScrubbingStatus() {
		compareTexts(propertiesReader.getUserName(), getText(latestSubmittedByValueInScrubbingTable));
		compareTexts(pstTodaysDate(), getText(latestSubmittedDateValueInScrubbingTable));
		compareTexts("File Accepted", getText(latestStatusValueInScrubbingTable));
		compareTexts(pstTodaysDate(), getText(latestStatusChangeDateValueInScrubbingTable));
	}

	/* This method is to click on add scrub file */
	public void clickOnAddScrubFile() {
		clickElement(addScrubFileButton);
		createScrubFile.validateCreateAScrubFilePageTitle();
	}

	/* This method is verify the successful message after creating scrub */
	public void validteSuccsfulScrubCreationMessage(String successMessage) {
		compareTexts(successMessage, getText(fileUploadSuccessful));
	}

	/* This method is to verify the sorting order in scrubbing status page */
	public void validateSortingOrderInScrubStatusPage() {
		clickAnElement(fileHeader);
		waitForTheElementToBeClickable(fileHeader);
		if (!validateAscendingSortingOrder(fileValuesInScrubbingTable)) {
			Assert.fail("File values are not sorted in ascending order.");
		}

		clickAnElement(fileHeader);
		waitForTheElementToBeClickable(fileHeader);
		if (!validateDescendingSortingOrder(fileValuesInScrubbingTable)) {
			Assert.fail("File values are not sorted in descending order.");
		}

		clickAnElement(submittedByHeader);
		waitForTheElementToBeClickable(submittedByHeader);
		if (!validateAscendingSortingOrder(submittedByValuesInScrubbingTable)) {
			Assert.fail("Submitted by values are not sorted in ascending order.");
		}

		clickAnElement(submittedByHeader);
		waitForTheElementToBeClickable(submittedByHeader);
		if (!validateDescendingSortingOrder(submittedByValuesInScrubbingTable)) {
			Assert.fail("Submitted by values are not sorted in descending order.");
		}

		clickAnElement(submittedDateHeader);
		waitForTheElementToBeClickable(submittedDateHeader);
		if (!validateAscendingSortingOrder(submittedDateValuesInScrubbingTable)) {
			Assert.fail("Submitted by date values are not sorted in ascending order.");
		}

		clickAnElement(submittedDateHeader);
		waitForTheElementToBeClickable(submittedDateHeader);
		if (!validateDescendingSortingOrder(submittedDateValuesInScrubbingTable)) {
			Assert.fail("Submitted by date values are not sorted in descending order.");
		}

		clickAnElement(statusHeader);
		waitForTheElementToBeClickable(statusHeader);
		if (!validateAscendingSortingOrder(statusValuesInScrubbingTable)) {
			Assert.fail("Status values are not sorted in ascending order.");
		}

		clickAnElement(statusHeader);
		waitForTheElementToBeClickable(statusHeader);
		if (!validateDescendingSortingOrder(statusValuesInScrubbingTable)) {
			Assert.fail("Status values are not sorted in descending order.");
		}

		clickAnElement(statusChangeDateHeader);
		waitForTheElementToBeClickable(statusChangeDateHeader);
		if (!validateAscendingSortingOrder(statusChangeDateValuesInScrubbingTable)) {
			Assert.fail("Status change date values are not sorted in ascending order.");
		}

		clickAnElement(statusChangeDateHeader);
		waitForTheElementToBeClickable(statusChangeDateHeader);
		if (!validateDescendingSortingOrder(statusChangeDateValuesInScrubbingTable)) {
			Assert.fail("Status change date values are not sorted in descending order.");
		}
	}
}
