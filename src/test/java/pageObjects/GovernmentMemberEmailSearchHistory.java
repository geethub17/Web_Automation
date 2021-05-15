package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class GovernmentMemberEmailSearchHistory extends Utils {

	private WebDriver driver;

	public GovernmentMemberEmailSearchHistory(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	/* All elements of government member email search history page are captured. */

	@FindBy(xpath = "//div[text()='Email History Search']")
	WebElement emailHistorySearchTitle;

	@FindBy(xpath = "(//td[@data-attribute-name='<b>Preferred</b>']//div//span)[1]")
	WebElement latestPreferredValueInEmailHistoryTable;

	@FindBy(xpath = "(//td[@data-attribute-name='<b>Email Address</b>']//div//span)[1]")
	WebElement latestEmailAddressInEmailHistoryTable;

	@FindBy(xpath = "(//td[@data-attribute-name='<b>Email Status</b>']//div//span)[1]")
	WebElement latestEmailStatusInEmailHistoryTable;

	@FindBy(xpath = "(//td[@data-attribute-name='<b>Source Channel</b>']//div//span)[1]")
	WebElement latestSourceChannelInEmailHistoryTable;

	@FindBy(xpath = "(//td[@data-attribute-name='<b>Source Origin</b>']//div//span)[1]")
	WebElement latestSourceOriginInEmailHistoryTable;

	@FindBy(xpath = "(//td[@data-attribute-name='<b>Updated By</b>']//div//span)[1]")
	WebElement latestUpdatedByInEmailHistoryTable;

	@FindBy(xpath = "(//td[@data-attribute-name='<b>Last Updated Date Time Stamp</b>']//div//span)[1]")
	WebElement latestUpdatedDateAndTimeInEmailHistoryTable;

	@FindBy(xpath = "//td[@data-attribute-name='<b>Preferred</b>']//div//span")
	List<WebElement> allPreferredValueInEmailHistoryTable;

	@FindBy(xpath = "//td[@data-attribute-name='<b>Email Address</b>']//div//span")
	List<WebElement> allEmailAddressInEmailHistoryTable;

	@FindBy(xpath = "//td[@data-attribute-name='<b>Email Status</b>']//div//span")
	List<WebElement> allEmailStatusInEmailHistoryTable;

	@FindBy(xpath = "//td[@data-attribute-name='<b>Source Channel</b>']//div//span")
	List<WebElement> allSourceChannelInEmailHistoryTable;

	@FindBy(xpath = "//td[@data-attribute-name='<b>Source Origin</b>']//div//span")
	List<WebElement> allSourceOriginInEmailHistoryTable;

	@FindBy(xpath = "//td[@data-attribute-name='<b>Updated By</b>']//div//span")
	List<WebElement> allUpdatedByInEmailHistoryTable;

	@FindBy(xpath = "//td[@data-attribute-name='<b>Last Updated Date Time Stamp</b>']//div//span")
	List<WebElement> allUpdatedDateAndTimeInEmailHistoryTable;

	@FindBy(id = "FromDate")
	WebElement fromDate;

	@FindBy(id = "EmailHistoryEndDate")
	WebElement endDate;

	@FindBy(xpath = "//div[text()='Search']")
	WebElement searchInEmailHistory;

	@FindBy(xpath = "//div[text()='Search Previous 6 Months']")
	WebElement searchPrevious6Months;

	@FindBy(xpath = "//div[text()='Cancel']")
	WebElement cancelnEmailHistory;

	@FindBy(xpath = "//a[text()=' Back to Member Information']")
	WebElement backToMemberInformation;

	@FindBy(xpath = "//th[@data-attribute-name='<b>Preferred</b>']")
	WebElement preferredHeader;

	@FindBy(xpath = "//th[@data-attribute-name='<b>Email Address</b>']")
	WebElement emailAddressHeader;

	@FindBy(xpath = "//th[@data-attribute-name='<b>Email Status</b>']")
	WebElement emailStatusHeader;

	@FindBy(xpath = "//th[@data-attribute-name='<b>Source Channel</b>']")
	WebElement sourceChannelHeader;

	@FindBy(xpath = "//th[@data-attribute-name='<b>Updated By</b>']")
	WebElement updatedByHeader;

	@FindBy(xpath = "//th[@data-attribute-name='<b>Source Origin</b>']")
	WebElement sourceOriginHeader;

	@FindBy(xpath = "//th[@data-attribute-name='<b>Last Updated Date Time Stamp</b>']")
	WebElement lastUpdatedDateTimeHeader;

	@FindBy(xpath = "(//div[@data-node-id='EmailHistorySearch'][contains(@uniqueid,'SID')])[1]")
	WebElement isSearchResultsDisplayed;

	@FindBy(xpath = "//div[@datasource='pyWorkPage.HistoryDetails.EmailList_EmailHistoryDetails_1'][contains(@id,'PEGA_GRID')]")
	WebElement isValuesSorted;

	@FindBy(xpath = "//li[text()='History Details:Please enter From Date and End Date within 6 months range.']")
	WebElement moreThan6Months;

	@FindBy(xpath = "//span[text()='** From Date must not be greater than current date.']")
	WebElement fromDateMustNotBeGreaterThanCurrentDate;

	@FindBy(xpath = "//span[text()='** The From Date must come before the End Date.']")
	WebElement fromDateMustComeBeforeEndDate;

	@FindBy(xpath = "//span[text()='** End Date must not be greater than current date.']")
	WebElement endDateMustNotBeGreaterThanCurrentDate;

	@FindBy(xpath = "//div[text()='* No records found']")
	WebElement noRecordsFound;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pHistoryDetails$pEmailList$l1']")
	List<WebElement> firstRecordOfHistoryTable;

	/* This method is to verify the page title of email search history */
	public void validateEmailSearchHistoryPage() {
		verifyThePageTitle("Email History Search", emailHistorySearchTitle);
	}

	/*
	 * This method is to verify the updated email preference in history search page.
	 */
	public void verifyTheEmailDetailsInHistorySearchPage(String emailAddress, String updatedBy, String updatedDate,
			String sourceChannel, String sourceOrigin) {
		compareTexts(emailAddress, getText(latestEmailAddressInEmailHistoryTable));
		compareTexts(updatedBy, getText(latestUpdatedByInEmailHistoryTable));
		compareTexts(sourceChannel, getText(latestSourceChannelInEmailHistoryTable));
		compareTexts(sourceOrigin, getText(latestSourceOriginInEmailHistoryTable));
		containsTexts(updatedDate, getText(latestUpdatedDateAndTimeInEmailHistoryTable));
	}

	/* This method is search for the history with specific dates */
	public void searchForHistoryWithSpecificDates(String fromDate, String endDate) {
		enterTheText(this.fromDate, fromDate);
		enterTheText(this.endDate, endDate);
		clickAnElement(searchInEmailHistory);
	}

	/* This method is to validate the sorting order */
	public void validateSortingInHistoryTable() {
		String oldAttributeValue = isSearchResultsDisplayed.getAttribute("uniqueid");
		waitTillAttributeValueChanges(isSearchResultsDisplayed, oldAttributeValue, "uniqueid");

		clickAnElement(emailAddressHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateAscendingSortingOrder(allEmailAddressInEmailHistoryTable)) {
			Assert.fail("Email addresses are not sorted in ascending order.");
		}

		clickAnElement(emailAddressHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateDescendingSortingOrder(allEmailAddressInEmailHistoryTable)) {
			Assert.fail("Email addresses are not sorted in descending order.");
		}

		clickAnElement(updatedByHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateAscendingSortingOrder(allUpdatedByInEmailHistoryTable)) {
			Assert.fail("Updated by values are not sorted in ascending order.");
		}
		clickAnElement(updatedByHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateDescendingSortingOrder(allUpdatedByInEmailHistoryTable)) {
			Assert.fail("Updated by values are not sorted in descending order.");
		}

		clickAnElement(lastUpdatedDateTimeHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateAscendingSortingOrder(allUpdatedDateAndTimeInEmailHistoryTable)) {
			Assert.fail("Updated date and time values are not sorted in ascending order.");
		}
		clickAnElement(lastUpdatedDateTimeHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateDescendingSortingOrder(allUpdatedDateAndTimeInEmailHistoryTable)) {
			Assert.fail("Updated date and time values are not sorted in descending order.");
		}

		clickAnElement(sourceChannelHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateAscendingSortingOrder(allSourceChannelInEmailHistoryTable)) {
			Assert.fail("Source channel values are not sorted in ascending order.");
		}
		clickAnElement(sourceChannelHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateDescendingSortingOrder(allSourceChannelInEmailHistoryTable)) {
			Assert.fail("Source channel values are not sorted in descending order.");
		}

		clickAnElement(sourceOriginHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateAscendingSortingOrder(allSourceOriginInEmailHistoryTable)) {
			Assert.fail("Source origin values are not sorted in ascending order.");
		}
		clickAnElement(sourceOriginHeader);
		waitTillSortingFinished(isValuesSorted);
		if (!validateDescendingSortingOrder(allSourceOriginInEmailHistoryTable)) {
			Assert.fail("Source origin values are not sorted in descending order.");
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
			compareTexts(erroMessage, getText(moreThan6Months));
		} else if (compareDates(fromDate, endDate, estTodaysDate()).equalsIgnoreCase("from date is future date")) {
			compareTexts(erroMessage, getText(fromDateMustNotBeGreaterThanCurrentDate));
		} else if (compareDates(fromDate, endDate, estTodaysDate()).equalsIgnoreCase("end date is future date")) {
			compareTexts(erroMessage, getText(endDateMustNotBeGreaterThanCurrentDate));
		}
	}

	/* This method is to validate the search previous 1 year functionality */
	public void validateSearchPreviousSixMonthsFunctionality(String error) {
		clickAnElement(searchPrevious6Months);
		if (compareTexts(error, getText(noRecordsFound))) {
			// checking whether first record is present or not. If not then it will go for
			// next check.
		} else if (!firstRecordOfHistoryTable.isEmpty()) {
			// checking whether error message is displayed or not. If not it will fail the
			// script.
		} else {
			Assert.fail("On clicking search for previos 1 year, either its not displayed 'no records found message'"
					+ "or search results.");
		}
	}

	/* This method is to navigate back to member information screen */
	public void backToMemberContactInformationPage() {
		clickAnElement(backToMemberInformation);
		verifyThePageTitle("Member Information", commercialMemberInformationContactInfo.memberInformationTitle);
	}

}
