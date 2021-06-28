package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class CommercialMemberEmailSearchHistory extends Utils {

	private WebDriver driver;

	public CommercialMemberEmailSearchHistory(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	/* All elements of email search history page are captured. */

	@FindBy(xpath = "//div[text()='Email History Search']")
	WebElement emailHistorySearchTitle;

	@FindBy(xpath = "(//td[contains(@data-attribute-name,'Preferred')]//span)[1]")
	WebElement latestPreferredValueInEmailHistoryTable;

	@FindBy(xpath = "(//td[contains(@data-attribute-name,'Email Address')]//span)[1]")
	WebElement latestEmailAddressInEmailHistoryTable;

	@FindBy(xpath = "(//td[contains(@data-attribute-name,'Email Status')]//span)[1]")
	WebElement latestEmailStatusInEmailHistoryTable;

	@FindBy(xpath = "(//td[contains(@data-attribute-name,'Source Channel')]//span)[1]")
	WebElement latestSourceChannelInEmailHistoryTable;

	@FindBy(xpath = "(//td[contains(@data-attribute-name,'Source Origin')]//span)[1]")
	WebElement latestSourceOriginInEmailHistoryTable;

	@FindBy(xpath = "(//td[contains(@data-attribute-name,'Updated By')]//span)[1]")
	WebElement latestUpdatedByInEmailHistoryTable;

	@FindBy(xpath = "(//td[contains(@data-attribute-name,'Last Updated Date Time Stamp')]//span)[1]")
	WebElement latestUpdatedDateAndTimeInEmailHistoryTable;

	@FindBy(xpath = "//td[contains(@data-attribute-name,'Preferred')]//div//span")
	List<WebElement> allPreferredValueInEmailHistoryTable;

	@FindBy(xpath = "//td[contains(@data-attribute-name,'Email Address')]//div//span")
	List<WebElement> allEmailAddressInEmailHistoryTable;

	@FindBy(xpath = "//td[contains(@data-attribute-name,'Email Status')]//div//span")
	List<WebElement> allEmailStatusInEmailHistoryTable;

	@FindBy(xpath = "//td[contains(@data-attribute-name,'Source Channel')]//div//span")
	List<WebElement> allSourceChannelInEmailHistoryTable;

	@FindBy(xpath = "//td[contains(@data-attribute-name,'Source Origin')]//div//span")
	List<WebElement> allSourceOriginInEmailHistoryTable;

	@FindBy(xpath = "//td[contains(@data-attribute-name,'Updated By')]//div//span")
	List<WebElement> allUpdatedByInEmailHistoryTable;

	@FindBy(xpath = "//td[contains(@data-attribute-name,'Last Updated Date Time Stamp')]//div//span")
	List<WebElement> allUpdatedDateAndTimeInEmailHistoryTable;

	@FindBy(name = "$PpyWorkPage$pHistoryDetails$pFromDate")
	WebElement fromDate;

	@FindBy(name = "$PpyWorkPage$pHistoryDetails$pEmailHistoryEndDate")
	WebElement endDate;

	@FindBy(xpath = "//div[text()='Search']")
	WebElement searchInEmailHistory;

	@FindBy(xpath = "//div[text()='Search Previous 1 Year']")
	WebElement searchPrevious1Year;

	@FindBy(xpath = "//div[text()='Cancel']")
	WebElement cancelnEmailHistory;

	@FindBy(xpath = "//a[text()='Back To Member Information']")
	WebElement backToMemberInformation;

	@FindBy(xpath = "//th[contains(@data-attribute-name='Preferred')]")
	WebElement preferredHeader;

	@FindBy(xpath = "//th[contains(@data-attribute-name='Email Address')]//div[@class='cellIn ']")
	WebElement emailAddressHeader;

	@FindBy(xpath = "//th[contains(@data-attribute-name='Email Status')]//div[@class='cellIn ']")
	WebElement emailStatusHeader;

	@FindBy(xpath = "//th[contains(@data-attribute-name='Source Channel')]//div[@class='cellIn ']")
	WebElement sourceChannelHeader;

	@FindBy(xpath = "//th[contains(@data-attribute-name='Updated By')]//div[@class='cellIn ']")
	WebElement updatedByHeader;

	@FindBy(xpath = "//th[contains(@data-attribute-name='Source Origin')]//div[@class='cellIn ']")
	WebElement sourceOriginHeader;

	@FindBy(xpath = "//th[contains(@data-attribute-name='Last Updated Date Time Stamp')]//div[@class='cellIn ']")
	WebElement lastUpdatedDateTimeHeader;

	@FindBy(xpath = "(//div[@data-node-id='CommercialHistoryDetails'][contains(@uniqueid,'SID')])[1]")
	WebElement isSearchResultsDisplayed;

	@FindBy(xpath = "//div[@datasource='pyWorkPage.HistoryDetails.EmailList_CommercialHistoryDetails_1'][contains(@id,'PEGA_GRID')]")
	WebElement isValuesSorted;

	@FindBy(xpath = "//span[@id='ERRORMESSAGES_ALL']//ul/li")
	WebElement moreThan1Year;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pHistoryDetails$pFromDateError']//span[1]")
	WebElement fromDateMustNotBeGreaterThanCurrentDate;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pHistoryDetails$pFromDateError']//span")
	WebElement fromDateMustComeBeforeEndDate;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pHistoryDetails$pEmailHistoryEndDateError']//span")
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
	public void verifyTheEmailDetailsInHistorySearchPage(String preferredValue, String emailAddress,
			String sourceChannel, String sourceOrigin, String updatedBy, String lastUpdatedDateTimeStamp) {
		if (preferredValue != null) {
			compareTexts(preferredValue, getText(latestPreferredValueInEmailHistoryTable));
		}
		if (emailAddress != null) {
			compareTexts(emailAddress, getText(latestEmailAddressInEmailHistoryTable));
		}
		if (sourceChannel != null) {
			compareTexts(sourceChannel, getText(latestSourceChannelInEmailHistoryTable));
		}
		if (sourceOrigin != null) {
			compareTexts(sourceOrigin, getText(latestSourceOriginInEmailHistoryTable));
		}
		if (updatedBy != null) {
			compareTexts(updatedBy, getText(latestUpdatedByInEmailHistoryTable));
		}
		if (latestUpdatedDateAndTimeInEmailHistoryTable != null) {
			containsTexts(getText(latestUpdatedDateAndTimeInEmailHistoryTable), lastUpdatedDateTimeStamp);
		}
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
		waitForTheElementToBeClickable(emailAddressHeader);
		if (!validateAscendingSortingOrder(allEmailAddressInEmailHistoryTable)) {
			Assert.fail("Email addresses are not sorted in ascending order.");
		}

		clickAnElement(emailAddressHeader);
		waitForTheElementToBeClickable(emailAddressHeader);
		if (!validateDescendingSortingOrder(allEmailAddressInEmailHistoryTable)) {
			Assert.fail("Email addresses are not sorted in descending order.");
		}

		clickAnElement(sourceChannelHeader);
		waitForTheElementToBeClickable(sourceChannelHeader);
		if (!validateAscendingSortingOrder(allSourceChannelInEmailHistoryTable)) {
			Assert.fail("Source channel values are not sorted in ascending order.");
		}
		clickAnElement(sourceChannelHeader);
		waitForTheElementToBeClickable(sourceChannelHeader);
		if (!validateDescendingSortingOrder(allSourceChannelInEmailHistoryTable)) {
			Assert.fail("Source channel values are not sorted in descending order.");
		}

		clickAnElement(sourceOriginHeader);
		waitForTheElementToBeClickable(sourceOriginHeader);
		if (!validateAscendingSortingOrder(allSourceOriginInEmailHistoryTable)) {
			Assert.fail("Source origin values are not sorted in ascending order.");
		}
		clickAnElement(sourceOriginHeader);
		waitForTheElementToBeClickable(sourceOriginHeader);
		if (!validateDescendingSortingOrder(allSourceOriginInEmailHistoryTable)) {
			Assert.fail("Source origin values are not sorted in descending order.");
		}

		clickAnElement(updatedByHeader);
		waitForTheElementToBeClickable(updatedByHeader);
		if (!validateAscendingSortingOrder(allUpdatedByInEmailHistoryTable)) {
			Assert.fail("Updated by values are not sorted in ascending order.");
		}
		clickAnElement(updatedByHeader);
		waitForTheElementToBeClickable(updatedByHeader);
		if (!validateDescendingSortingOrder(allUpdatedByInEmailHistoryTable)) {
			Assert.fail("Updated by values are not sorted in descending order.");
		}

		clickAnElement(lastUpdatedDateTimeHeader);
		waitForTheElementToBeClickable(lastUpdatedDateTimeHeader);
		if (!validateAscendingSortingOrder(allUpdatedDateAndTimeInEmailHistoryTable)) {
			Assert.fail("Updated date and time values are not sorted in ascending order.");
		}
		clickAnElement(lastUpdatedDateTimeHeader);
		waitForTheElementToBeClickable(lastUpdatedDateTimeHeader);
		if (!validateDescendingSortingOrder(allUpdatedDateAndTimeInEmailHistoryTable)) {
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
	public void backToMemberContactInformationPage() {
		clickElement(backToMemberInformation);
		verifyThePageTitle("Member Information", commercialMemberInformationContactInfo.memberInformationTitle);
	}

}
