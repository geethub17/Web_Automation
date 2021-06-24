package pageObjects;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class PhoneSearchHistory extends Utils {

	private WebDriver driver;

	public PhoneSearchHistory(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	/*
	 * All elements of history search page are captured.
	 */

	@FindBy(xpath = "//div[text()='History Search']")
	WebElement historySearchTitle;

	@FindBy(xpath = "(//td[@data-attribute-name='Non-sales']//span)[1]")
	WebElement latestNonSalesValueInPhoneHistoryTable;

	@FindBy(xpath = "(//td[@data-attribute-name='Telephone Number']//span)[1]")
	WebElement latestTelephoneNumberInPhoneHistoryTable;

	@FindBy(xpath = "(//td[@data-attribute-name='Updated By']//span)[1]")
	WebElement latestUpdatedByInPhoneHistoryTable;

	@FindBy(xpath = "(//td[@data-attribute-name='Last Updated Date']//span)[1]")
	WebElement latestLastUpatedDateinPhoneHistoryTable;

	@FindBy(xpath = "//td[@data-attribute-name='Sales']//div//span")
	List<WebElement> allSalesValuesInPhoneHistoryTable;

	@FindBy(xpath = "//td[@data-attribute-name='Non-sales']//div//span")
	List<WebElement> allNonSalesValuesInPhoneHistoryTable;

	@FindBy(xpath = "//td[@data-attribute-name='Telephone Number']//div//span")
	List<WebElement> allTelephoneNumbersInPhoneHistoryTable;

	@FindBy(xpath = "//td[@data-attribute-name='Updated By']//div//span")
	List<WebElement> allUpdatedByInPhoneHistoryTable;

	@FindBy(xpath = "//td[@data-attribute-name='Last Updated Date']//div//span")
	List<WebElement> allLastUpatedDatesInPhoneHistoryTable;

	@FindBy(id = "FromDate")
	WebElement fromDate;

	@FindBy(id = "ViewEndaDate")
	WebElement endDate;

	@FindBy(xpath = "//div[text()='Search']")
	WebElement searchInPhoneHistory;

	@FindBy(xpath = "//div[text()='Search Previous 3 Months']")
	WebElement searchPrevious3Months;

	@FindBy(xpath = "//div[text()='Cancel']")
	WebElement cancelnPhoneHistory;

	@FindBy(xpath = "//a[text()=' Back To Phone Search Results']")
	WebElement backToPhoneSearchResults;

	@FindBy(xpath = "//th[@data-attribute-name='Telephone Number']//div[@class='cellIn ']")
	WebElement telephoneNumberHeader;

	@FindBy(xpath = "//th[@data-attribute-name='Sales']//div[@class='cellIn ']")
	WebElement salesHeader;

	@FindBy(xpath = "//th[@data-attribute-name='Non-sales']//div[@class='cellIn ']")
	WebElement nonSalesHeader;

	@FindBy(xpath = "//th[@data-attribute-name='Updated By']//div[@class='cellIn ']")
	WebElement updatedByHeader;

	@FindBy(xpath = "//th[@data-attribute-name='Last Updated Date']//div[@class='cellIn ']")
	WebElement lastUpdatedDateHeader;

	@FindBy(xpath = "(//div[@data-node-id='ViewPhoneHistory']//div[contains(@uniqueid,'SID')])[1]")
	WebElement isSearchResultsDisplayed;

	@FindBy(xpath = "//div[@datasource='pgPhoneSearch.PhoneHistory_PhoneHistoryDetails_1'][contains(@id,'PEGA_GRID')]")
	WebElement isValuesSorted;

	@FindBy(xpath = "//li[text()='Please enter From Date and End Date within 3 months range.']")
	WebElement moreThan3Months;

	@FindBy(xpath = "//span[text()='From Date Must Not Be Greater Than Current Date.']")
	WebElement fromDateMustNotBeGreaterThanCurrentDate;

	@FindBy(xpath = "//span[text()='The From Date must come before the End Date.']")
	WebElement fromDateMustComeBeforeEndDate;

	@FindBy(xpath = "//span[text()='End Date must not be greater than current date.']")
	WebElement endDateMustNotBeGreaterThanCurrentDate;

	@FindBy(xpath = "//div[text()='*No Records found']")
	WebElement noRecordsFound;

	@FindBy(xpath = "//tr[@id='$PpgPhoneSearch$pPhoneHistory$l1']")
	List<WebElement> firstRecordOfHistoryTable;

	/* This method is to verify the page title of phone search history */
	public void validatePhoneSearchHistoryPage() {
		verifyThePageTitle("History Search", historySearchTitle);
	}

	/*
	 * This method is to verify the updated phone preference in history search page.
	 */
	public void verifyTheUpdatePhoneDetailsInHistorySearchPage(String telePhoneNumber, String nonSalesValue,
			String updatedBy, String updatedDate) {
		compareTexts(telePhoneNumber.trim(), getText(latestTelephoneNumberInPhoneHistoryTable));
		compareTexts(nonSalesValue, getText(latestNonSalesValueInPhoneHistoryTable));
		compareTexts(updatedBy, getText(latestUpdatedByInPhoneHistoryTable));
		compareTexts(updatedDate, getText(latestLastUpatedDateinPhoneHistoryTable));
	}

	/* This method is search for the history with specific dates */
	public void searchForHistoryWithSpecificDates(String fromDate, String endDate) {
		enterTheText(this.fromDate, fromDate);
		enterTheText(this.endDate, endDate);
		clickAnElement(searchInPhoneHistory);
	}

	/* This method is to validate the sorting order */
	public void validateSortingInHistoryTable() {
		String oldAttributeValue = isSearchResultsDisplayed.getAttribute("uniqueid");
		waitTillAttributeValueChanges(isSearchResultsDisplayed, oldAttributeValue, "uniqueid");

		clickAnElement(telephoneNumberHeader);
		waitForTheElementToBeClickable(telephoneNumberHeader);
		if (!validateAscendingSortingOrder(allTelephoneNumbersInPhoneHistoryTable)) {
			Assert.fail("Telephone number are not sorted in ascending order.");
		}

		clickAnElement(telephoneNumberHeader);
		waitForTheElementToBeClickable(telephoneNumberHeader);
		if (!validateDescendingSortingOrder(allTelephoneNumbersInPhoneHistoryTable)) {
			Assert.fail("Telephone number are not sorted in descending order.");
		}

		clickAnElement(salesHeader);
		waitForTheElementToBeClickable(salesHeader);
		if (!validateAscendingSortingOrder(allSalesValuesInPhoneHistoryTable)) {
			Assert.fail("Sales values are not sorted in ascending order.");
		}

		clickAnElement(salesHeader);
		waitForTheElementToBeClickable(salesHeader);
		if (!validateDescendingSortingOrder(allSalesValuesInPhoneHistoryTable)) {
			Assert.fail("Sales values are not sorted in descending order.");
		}

		clickAnElement(nonSalesHeader);
		waitForTheElementToBeClickable(nonSalesHeader);
		if (!validateAscendingSortingOrder(allNonSalesValuesInPhoneHistoryTable)) {
			Assert.fail("Non sales values are not sorted in ascending order.");
		}
		
		clickAnElement(nonSalesHeader);
		waitForTheElementToBeClickable(nonSalesHeader);
		if (!validateDescendingSortingOrder(allNonSalesValuesInPhoneHistoryTable)) {
			Assert.fail("Non sales values are not sorted in descending order.");
		}

		clickAnElement(updatedByHeader);
		waitForTheElementToBeClickable(updatedByHeader);
		if (!validateAscendingSortingOrder(allUpdatedByInPhoneHistoryTable)) {
			Assert.fail("Updated by values are not sorted in ascending order.");
		}
		clickAnElement(updatedByHeader);
		waitForTheElementToBeClickable(updatedByHeader);
		if (!validateDescendingSortingOrder(allUpdatedByInPhoneHistoryTable)) {
			Assert.fail("Updated by values are not sorted in descending order.");
		}

		clickAnElement(lastUpdatedDateHeader);
		waitForTheElementToBeClickable(lastUpdatedDateHeader);
		if (!validateAscendingSortingOrder(allLastUpatedDatesInPhoneHistoryTable)) {
			Assert.fail("Last updated by values are not sorted in ascending order.");
		}
		clickAnElement(lastUpdatedDateHeader);
		waitForTheElementToBeClickable(lastUpdatedDateHeader);
		if (!validateDescendingSortingOrder(allLastUpatedDatesInPhoneHistoryTable)) {
			Assert.fail("Last updated by values are not sorted in descending order.");
		}
	}

	/*
	 * This method is search for the history with specific dates and validates the
	 * error message
	 */
	public void validateErrorMessagesInHisorySearch(String fromDate, String endDate, String erroMessage) {
		searchForHistoryWithSpecificDates(fromDate, endDate);
		if (compareDates(fromDate, endDate, estTodaysDate()).equalsIgnoreCase("from date > end date")) {
			compareTexts(erroMessage, getText(fromDateMustComeBeforeEndDate));
		} else if (compareDates(fromDate, endDate, estTodaysDate()).equalsIgnoreCase("end date > from date")) {
			compareTexts(erroMessage, getText(fromDateMustComeBeforeEndDate));
		} else if (compareDates(fromDate, endDate, estTodaysDate()).equalsIgnoreCase("more than 3 months")) {
			compareTexts(erroMessage, getText(moreThan3Months));
		} else if (compareDates(fromDate, endDate, estTodaysDate()).equalsIgnoreCase("from date is future date")) {
			compareTexts(erroMessage, getText(fromDateMustNotBeGreaterThanCurrentDate));
		} else if (compareDates(fromDate, endDate, estTodaysDate()).equalsIgnoreCase("end date is future date")) {
			compareTexts(erroMessage, getText(endDateMustNotBeGreaterThanCurrentDate));
		}
	}

	/* This method is to validate the search previous 3 months functionality */
	public void validateSearchPreviousThreeMonthsFunctionality(String error) {
		clickAnElement(searchPrevious3Months);
		if (!firstRecordOfHistoryTable.isEmpty()) {
			// checking whether error message is displayed or not. If not it will fail the
			// script.
		} else if (compareTexts(error, getText(noRecordsFound))) {
			// checking whether first record is present or not. If not then it will go for
			// next check.
		} else {
			Assert.fail("On clicking search for previos 3 months, either its not displayed 'no records found message'"
					+ "or search results.");
		}
	}

	/* This method is to navigate back to the phone search screen */
	public void backToPhoneSearchScreen() {
		clickAnElement(backToPhoneSearchResults);
		verifyThePageTitle("Phone Search", phoneSearch.phoneSearchTitle);
	}

}
