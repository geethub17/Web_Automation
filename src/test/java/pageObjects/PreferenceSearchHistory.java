package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class PreferenceSearchHistory extends Utils {

	private WebDriver driver;

	public PreferenceSearchHistory(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	/* All elements of preference search history page are captured. */

	@FindBy(xpath = "//div[text()='Preference History Search']")
	WebElement preferenceHistorySearchTitle;

	@FindBy(xpath = "(//td[@data-attribute-name='Contact Channel']//span)[1]")
	WebElement latestContactChannelValueInPreferenceHistoryTable;

	@FindBy(xpath = "(//td[@data-attribute-name='Contact Value']//span)[1]")
	WebElement latestContactValueInPreferenceHistoryTable;

	@FindBy(xpath = "(//td[@data-attribute-name='Source Channel']//span)[1]")
	WebElement latestSourceChannelInPreferenceHistoryTable;

	@FindBy(xpath = "(//td[@data-attribute-name='Source Origin']//span)[1]")
	WebElement latestSourceOriginInPreferenceHistoryTable;

	@FindBy(xpath = "(//td[@data-attribute-name='Updated By']//span)[1]")
	WebElement latestUpdatedByInPreferenceHistoryTable;

	@FindBy(xpath = "(//td[@data-attribute-name='Last Updated Date Time Stamp']//span)[1]")
	WebElement latestUpdatedDateAndTimeInPreferenceHistoryTable;

	@FindBy(xpath = "//td[@data-attribute-name='Contact Channel']//div//span")
	List<WebElement> allContactChannelValuesInPreferenceHistoryTable;

	@FindBy(xpath = "//td[@data-attribute-name='Contact Value']//div//span")
	List<WebElement> allContactValuesInPreferenceHistoryTable;

	@FindBy(xpath = "//td[@data-attribute-name='Source Channel']//div//span")
	List<WebElement> allSourceChannelInPreferenceHistoryTable;

	@FindBy(xpath = "//td[@data-attribute-name='Source Origin']//div//span")
	List<WebElement> allSourceOriginInPreferenceHistoryTable;

	@FindBy(xpath = "//td[@data-attribute-name='Updated By']//div//span")
	List<WebElement> allUpdatedByInPreferenceHistoryTable;

	@FindBy(xpath = "//td[@data-attribute-name='Last Updated Date Time Stamp']//div//span")
	List<WebElement> allUpdatedDateAndTimeInPreferenceHistoryTable;

	@FindBy(id = "FromDate")
	WebElement fromDate;

	@FindBy(id = "EmailHistoryEndDate")
	WebElement endDate;

	@FindBy(xpath = "//div[text()='Search']")
	WebElement searchInPreferenceHistory;

	@FindBy(xpath = "//div[text()='Search Previous 1 Year']")
	WebElement searchPrevious1Year;

	@FindBy(xpath = "//div[text()='Cancel']")
	WebElement cancelnPreferenceHistory;

	@FindBy(xpath = "//a[text()=' Back To Member Information']")
	WebElement backToMemberInformation;

	@FindBy(xpath = "//th[@data-attribute-name='Contact Channel']//div[@class='cellIn ']")
	WebElement contactChannelHeader;

	@FindBy(xpath = "//th[@data-attribute-name='Contact Value']//div[@class='cellIn ']")
	WebElement contactValueHeader;

	@FindBy(xpath = "//th[@data-attribute-name='Source Channel']//div[@class='cellIn ']")
	WebElement sourceChannelHeader;

	@FindBy(xpath = "//th[@data-attribute-name='Updated By']//div[@class='cellIn ']")
	WebElement updatedByHeader;

	@FindBy(xpath = "//th[@data-attribute-name='Source Origin']//div[@class='cellIn ']")
	WebElement sourceOriginHeader;

	@FindBy(xpath = "//th[@data-attribute-name='Last Updated Date Time Stamp']//div[@class='cellIn ']")
	WebElement lastUpdatedDateTimeHeader;

	@FindBy(xpath = "(//div[@data-node-id='ComPrefHistoryDetails'][contains(@uniqueid,'SID')])[1]")
	WebElement isSearchResultsDisplayed;

	@FindBy(xpath = "//div[@datasource='pyWorkPage.CommercialMember.PreferenceHistory_ComPrefHistoryDetails_1'][contains(@id,'PEGA_GRID')]")
	WebElement isValuesSorted;

	@FindBy(xpath = "//li[text()='Commercial Member:Please enter From Date and End Date within 1 year range.']")
	WebElement moreThan1Year;

	@FindBy(xpath = "//span[text()='From Date must not be greater than current date.']")
	WebElement fromDateMustNotBeGreaterThanCurrentDate;

	@FindBy(xpath = "//span[text()='The From Date must come before the End Date.']")
	WebElement fromDateMustComeBeforeEndDate;

	@FindBy(xpath = "//span[text()='End Date must not be greater than current date']")
	WebElement endDateMustNotBeGreaterThanCurrentDate;

	@FindBy(xpath = "//span[text()='No Records found for the input criteria']")
	WebElement noRecordsFound;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPreferenceHistory$l1']")
	List<WebElement> firstRecordOfHistoryTable;

	/* This method is to verify the page title of preference search history */
	public void validatePreferenceSearchHistoryPage() {
		verifyThePageTitle("Preference History Search", preferenceHistorySearchTitle);
	}

	/*
	 * This method is to verify the updated preference in history search page.
	 */
	public void verifyTheUpdatePreferenceDetailsInHistorySearchPage(String contactChannel, String contactValue,
			String sourceChannel, String sourceOrigin, String updatedBy, String lastUpdatedDateTimeStamp) {
		compareTexts(contactChannel, getText(latestContactChannelValueInPreferenceHistoryTable));
		containsTexts(contactValue, getText(latestContactValueInPreferenceHistoryTable));
		compareTexts(sourceChannel, getText(latestSourceChannelInPreferenceHistoryTable));
		compareTexts(sourceOrigin, getText(latestSourceOriginInPreferenceHistoryTable));
		compareTexts(updatedBy, getText(latestUpdatedByInPreferenceHistoryTable));
		containsTexts(lastUpdatedDateTimeStamp, getText(latestUpdatedDateAndTimeInPreferenceHistoryTable));
	}

	/* This method is search for the history with specific dates */
	public void searchForHistoryWithSpecificDates(String fromDate, String endDate) {
		enterTheText(this.fromDate, fromDate);
		enterTheText(this.endDate, endDate);
		clickAnElement(searchInPreferenceHistory);
	}

	/* This method is to validate the sorting order */
	public void validateSortingInHistoryTable() {
		String oldAttributeValue = isSearchResultsDisplayed.getAttribute("uniqueid");
		waitTillAttributeValueChanges(isSearchResultsDisplayed, oldAttributeValue, "uniqueid");

		clickAnElement(contactChannelHeader);
		waitForTheElementToBeClickable(contactChannelHeader);
		if (!validateAscendingSortingOrder(allContactChannelValuesInPreferenceHistoryTable)) {
			Assert.fail("Contact channel values are not sorted in ascending order.");
		}

		clickAnElement(contactChannelHeader);
		waitForTheElementToBeClickable(contactChannelHeader);
		if (!validateDescendingSortingOrder(allContactChannelValuesInPreferenceHistoryTable)) {
			Assert.fail("Contact channel values are not sorted in descending order.");
		}

		clickAnElement(contactValueHeader);
		waitForTheElementToBeClickable(contactValueHeader);
		if (!validateAscendingSortingOrder(allContactValuesInPreferenceHistoryTable)) {
			Assert.fail("Contact values are not sorted in ascending order.");
		}

		clickAnElement(contactValueHeader);
		waitForTheElementToBeClickable(contactValueHeader);
		if (!validateDescendingSortingOrder(allContactValuesInPreferenceHistoryTable)) {
			Assert.fail("Contact values are not sorted in descending order.");
		}

		clickAnElement(sourceChannelHeader);
		waitForTheElementToBeClickable(sourceChannelHeader);
		if (!validateAscendingSortingOrder(allSourceChannelInPreferenceHistoryTable)) {
			Assert.fail("Source channel values are not sorted in ascending order.");
		}
		clickAnElement(sourceChannelHeader);
		waitForTheElementToBeClickable(sourceChannelHeader);
		if (!validateDescendingSortingOrder(allSourceChannelInPreferenceHistoryTable)) {
			Assert.fail("Source channel values are not sorted in descending order.");
		}

		clickAnElement(sourceOriginHeader);
		waitForTheElementToBeClickable(sourceOriginHeader);
		if (!validateAscendingSortingOrder(allSourceOriginInPreferenceHistoryTable)) {
			Assert.fail("Source origin values are not sorted in ascending order.");
		}
		clickAnElement(sourceOriginHeader);
		waitForTheElementToBeClickable(sourceOriginHeader);
		if (!validateDescendingSortingOrder(allSourceOriginInPreferenceHistoryTable)) {
			Assert.fail("Source origin values are not sorted in descending order.");
		}

		clickAnElement(updatedByHeader);
		waitForTheElementToBeClickable(updatedByHeader);
		if (!validateAscendingSortingOrder(allUpdatedByInPreferenceHistoryTable)) {
			Assert.fail("Updated by values are not sorted in ascending order.");
		}
		clickAnElement(updatedByHeader);
		waitForTheElementToBeClickable(updatedByHeader);
		if (!validateDescendingSortingOrder(allUpdatedByInPreferenceHistoryTable)) {
			Assert.fail("Updated by values are not sorted in descending order.");
		}

		clickAnElement(lastUpdatedDateTimeHeader);
		waitForTheElementToBeClickable(lastUpdatedDateTimeHeader);
		if (!validateAscendingSortingOrder(allUpdatedDateAndTimeInPreferenceHistoryTable)) {
			Assert.fail("Updated date and time values are not sorted in ascending order.");
		}
		clickAnElement(lastUpdatedDateTimeHeader);
		waitForTheElementToBeClickable(lastUpdatedDateTimeHeader);
		if (!validateDescendingSortingOrder(allUpdatedDateAndTimeInPreferenceHistoryTable)) {
			Assert.fail("Updated date and time values are not sorted in descending order.");
		}
	}

	/*
	 * This method is search for the history with specific dates and validates the
	 * error message
	 */
	public void validateErrorMessagesInEmailHisorySearch(String fromDate, String endDate, String erroMessage) {
		searchForHistoryWithSpecificDates(fromDate, endDate);
		if (compareDates(fromDate, endDate, estTodaysDate()).equalsIgnoreCase("from date > end date")) {
			compareTexts(erroMessage, getText(fromDateMustComeBeforeEndDate));
		} else if (compareDates(fromDate, endDate, estTodaysDate()).equalsIgnoreCase("end date > from date")) {
			compareTexts(erroMessage, getText(fromDateMustComeBeforeEndDate));
		} else if (compareDates(fromDate, endDate, estTodaysDate()).equalsIgnoreCase("more than 1 year")) {
			compareTexts(erroMessage, getText(moreThan1Year));
		} else if (compareDates(fromDate, endDate, estTodaysDate()).equalsIgnoreCase("from date is future date")) {
			compareTexts(erroMessage, getText(fromDateMustNotBeGreaterThanCurrentDate));
		} else if (compareDates(fromDate, endDate, estTodaysDate()).equalsIgnoreCase("end date is future date")) {
			compareTexts(erroMessage, getText(endDateMustNotBeGreaterThanCurrentDate));
		}
	}

	/* This method is to validate the search previous 1 year functionality */
	public void validateSearchPreviousOneYearFunctionality(String error) {
		clickAnElement(searchPrevious1Year);
		if (!firstRecordOfHistoryTable.isEmpty()) {
			// checking whether error message is displayed or not. If not it will fail the
			// script.
		} else if (compareTexts(error, getText(noRecordsFound))) {
			// checking whether first record is present or not. If not then it will go for
			// next check.
		} else {
			Assert.fail("On clicking search for previos 1 year, either its not displayed 'no records found message'"
					+ "or search results.");
		}
	}

	/* This method is to navigate back to member information screen */
	public void backToMemberContactInformationPages() {
		clickAnElement(backToMemberInformation);
		verifyThePageTitle("Member Information", commercialMemberInformationContactInfo.memberInformationTitle);
	}
}
