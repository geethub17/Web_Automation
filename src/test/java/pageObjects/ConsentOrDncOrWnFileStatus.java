package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reader.PropertiesReader;
import utilities.Utils;

public class ConsentOrDncOrWnFileStatus extends Utils {

	private WebDriver driver;

	public ConsentOrDncOrWnFileStatus(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		propertiesReader = new PropertiesReader();
	}

	/*
	 * All elements of Consent/Do Not Call/Wrong Number File Status status page are
	 * captured.
	 */

	@FindBy(xpath = "//span[text()='Consent/Do Not Call/Wrong Number File Status']")
	WebElement consentOrDncOrWnFileStatusPageTitle;

	@FindBy(xpath = "//div[text()='File']")
	WebElement fileHeader;

	@FindBy(xpath = "//div[text()='Submitted By']")
	WebElement submittedByHeader;

	@FindBy(xpath = "//div[text()='Submitted Date']")
	WebElement submittedDateHeader;

	@FindBy(xpath = "//div[text()='Status']")
	WebElement statusHeader;

	@FindBy(xpath = "//div[text()='Status Change Date']")
	WebElement statusChangeDateHeader;

	@FindBy(xpath = "//div[text()='File Upload Successful.']")
	WebElement fileUploadSuccessful;

	@FindBy(xpath = "//div[contains(text(),'ERROR')]")
	WebElement moreThan20000Members;

	@FindBy(xpath = "//td[@data-attribute-name='File']//div//span")
	List<WebElement> fileValuesInConsentOrDncOrWnTable;

	@FindBy(xpath = "//td[@data-attribute-name='Submitted By']//div//span")
	List<WebElement> submittedByValuesInConsentOrDncOrWnTable;

	@FindBy(xpath = "//td[@data-attribute-name='Submitted Date']//div//span")
	List<WebElement> submittedDateValuesInConsentOrDncOrWnTable;

	@FindBy(xpath = "//td[@data-attribute-name='Status']//div//span")
	List<WebElement> statusValuesInConsentOrDncOrWnTable;

	@FindBy(xpath = "//td[@data-attribute-name='Status Change Date']//div//span")
	List<WebElement> statusChangeDateValuesInConsentOrDncOrWnTable;

	@FindBy(xpath = "(//td[@data-attribute-name='File']//div//span)[1]")
	WebElement latestFileValueInConsentOrDncOrWnTable;

	@FindBy(xpath = "(//td[@data-attribute-name='Submitted By']//div//span)[1]")
	WebElement latestSubmittedByValueInConsentOrDncOrWnTable;

	@FindBy(xpath = "(//td[@data-attribute-name='Submitted Date']//div//span)[1]")
	WebElement latestSubmittedDateValueInConsentOrDncOrWnTable;

	@FindBy(xpath = "(//td[@data-attribute-name='Status']//div//span)[1]")
	WebElement latestStatusValueInConsentOrDncOrWnTable;

	@FindBy(xpath = "(//td[@data-attribute-name='Status Change Date']//div//span)[1]")
	WebElement latestStatusChangeDateValueInConsentOrDncOrWnTable;

	@FindBy(xpath = "//div[text()='Add Consent/Do Not Call/Wrong Number File']")
	WebElement addConsentOrDncOrWnFileButton;

	@FindBy(xpath = "//div[text()='Refresh']")
	WebElement refreshButton;

	@FindBy(xpath = "//div[@datasource='pyWorkPage.FileList_DisplayConsentDNCStatus_1'][contains(@id,'PEGA_GRID')]")
	WebElement isValuesSorted;

	/*
	 * This method is to verify the Consent/Do Not Call/Wrong Number File status
	 * page title
	 */
	public void validateConsentOrDncOrWnStatusPageTitle() {
		verifyThePageTitle("Consent/Do Not Call/Wrong Number File Status", consentOrDncOrWnFileStatusPageTitle);
	}

	/*
	 * This method is to validate the latest records in Consent/Do Not Call/Wrong
	 * Number File status page
	 */
	public void validateLatestRecordInConsentOrDncOrWnStatus() {
		compareTexts(propertiesReader.getUserName(), getText(latestSubmittedByValueInConsentOrDncOrWnTable));
		compareTexts(pstTodaysDate(), getText(latestSubmittedDateValueInConsentOrDncOrWnTable));
		compareTexts("File Accepted", getText(latestStatusValueInConsentOrDncOrWnTable));
		compareTexts(pstTodaysDate(), getText(latestStatusChangeDateValueInConsentOrDncOrWnTable));
	}

	/*
	 * This method is to click on add Consent/Do Not Call/Wrong Number File Status
	 */
	public void clickOnAddConsentOrDncOrWnFile() {
		clickAnElement(addConsentOrDncOrWnFileButton);
		createConsentOrDncOrWnFile.validateCreateAConsentOrDncorWnPageTitle();
	}

	/*
	 * This method is verify the message after creating Consent/Do Not Call/Wrong
	 * Number File
	 */
	public void validteConsentOrDncOrWnCreationMessage(String message) {
		if (message.toLowerCase().contains("successful")) {
			consentOrDncOrWnFileStatus.validateConsentOrDncOrWnStatusPageTitle();
			compareTexts(message, getText(fileUploadSuccessful));
		} else {
			compareTexts(message, getText(moreThan20000Members));
		}
	}

	/*
	 * This method is to verify the sorting order in Consent/Do Not Call/Wrong
	 * Number File status page
	 */
	public void validateSortingOrderInConsentOrDncOrWnStatusPage() {
		clickAnElement(fileHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateAscendingSortingOrder(fileValuesInConsentOrDncOrWnTable)) {
			Assert.fail("File values are not sorted in ascending order.");
		}

		clickAnElement(fileHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateDescendingSortingOrder(fileValuesInConsentOrDncOrWnTable)) {
			Assert.fail("File values are not sorted in descending order.");
		}

		clickAnElement(submittedByHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateAscendingSortingOrder(submittedByValuesInConsentOrDncOrWnTable)) {
			Assert.fail("Submitted by values are not sorted in ascending order.");
		}

		clickAnElement(submittedByHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateDescendingSortingOrder(submittedByValuesInConsentOrDncOrWnTable)) {
			Assert.fail("Submitted by values are not sorted in descending order.");
		}

		clickAnElement(submittedDateHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateAscendingSortingOrder(submittedDateValuesInConsentOrDncOrWnTable)) {
			Assert.fail("Submitted by date values are not sorted in ascending order.");
		}

		clickAnElement(submittedDateHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateDescendingSortingOrder(submittedDateValuesInConsentOrDncOrWnTable)) {
			Assert.fail("Submitted by date values are not sorted in descending order.");
		}

		clickAnElement(statusHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateAscendingSortingOrder(statusValuesInConsentOrDncOrWnTable)) {
			Assert.fail("Status values are not sorted in ascending order.");
		}

		clickAnElement(statusHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateDescendingSortingOrder(statusValuesInConsentOrDncOrWnTable)) {
			Assert.fail("Status values are not sorted in descending order.");
		}

		clickAnElement(statusChangeDateHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateAscendingSortingOrder(statusChangeDateValuesInConsentOrDncOrWnTable)) {
			Assert.fail("Status change date values are not sorted in ascending order.");
		}

		clickAnElement(statusChangeDateHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateDescendingSortingOrder(statusChangeDateValuesInConsentOrDncOrWnTable)) {
			Assert.fail("Status change date values are not sorted in descending order.");
		}
	}
}
