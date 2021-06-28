package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class MemberSearch extends Utils {

	private WebDriver driver;
	private String oldAttributeValue;

	public MemberSearch(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	/* All elements of member search page are captured. */

	@FindBy(xpath = "//div[text()='Member Search']")
	WebElement memberSearchPageTitle;

	@FindBy(id = "30d0bb36Search By Subscriber ID")
	WebElement searchBySubscriberId;

	@FindBy(name = "$PpyWorkPage$pMemberSearch$pSearchMember")
	WebElement searchByMemberName;

	@FindBy(name = "$PpyWorkPage$pMemberSearch$pSubscriberID")
	WebElement subscriberId;

	@FindBy(name = "$PpyWorkPage$pMemberSearch$pSequenceNumber")
	WebElement sequenceNumber;

	@FindBy(name = "$PpyWorkPage$pMemberSearch$pDateOfBirth")
	WebElement dateOfBirth;

	@FindBy(name = "$PpyWorkPage$pMemberSearch$pMemberState")
	WebElement memberStateDropDown;

	@FindBy(name = "$PpyWorkPage$pMemberSearch$pGroupID")
	WebElement groupNumber;

	@FindBy(name = "$PpyWorkPage$pMemberSearch$pSourceSystem")
	WebElement sourceSystem;

	@FindBy(xpath = "//div[text()='Search']")
	WebElement search;

	@FindBy(xpath = "//div[text()='Reset']")
	WebElement reset;

	@FindBy(name = "$PpyWorkPage$pMemberSearch$pMemberFirstName")
	WebElement memberFirstNameDropDown;

	@FindBy(name = "$PpyWorkPage$pMemberSearch$ppyFirstName")
	WebElement memberFirstNameTextField;

	@FindBy(name = "$PpyWorkPage$pMemberSearch$pMbrLastName")
	WebElement memberLastNameDropDown;

	@FindBy(name = "$PpyWorkPage$pMemberSearch$ppyLastName")
	WebElement memberLastNameTextField;

	@FindBy(xpath = "//div[@data-node-id='SearchByMember'][contains(@uniqueid, SID)]")
	WebElement isSearchResultsDisplayed;

	@FindBy(xpath = "(//div[@datasource='pyWorkPage.MemberSearch.pxResults_SubscriberDetails_3'][contains(@id,'PEGA_GRID')])")
	WebElement isValuesSorted;

	@FindBy(xpath = "//div[text()='Seq No']")
	WebElement seqNoHeader;

	@FindBy(xpath = "//div[text()='First Name']")
	WebElement firstNameHeader;

	@FindBy(xpath = "//div[text()='Last Name']")
	WebElement lastNameHeader;

	@FindBy(xpath = "//div[text()='Date Of Birth']")
	WebElement dateOfBirthHeader;

	@FindBy(xpath = "//div[text()='Member State']")
	WebElement memberStateHeader;

	@FindBy(xpath = "//div[text()='Source System']")
	WebElement sourceSystemHeader;

	@FindBy(xpath = "//td[@data-attribute-name ='Seq No']//div//span")
	List<WebElement> allSeqNoValuesInSearchResultsTable;

	@FindBy(xpath = "//td[@data-attribute-name ='First Name']//div//span")
	List<WebElement> allFirstNameValuesInSearchResultsTable;

	@FindBy(xpath = "//td[@data-attribute-name ='Last Name']//div//span")
	List<WebElement> allLastNameValuesInSearchResultsTable;

	@FindBy(xpath = "//td[@data-attribute-name ='Date Of Birth']//div//span")
	List<WebElement> allDateOfBirthValuesInSearchResultsTable;

	@FindBy(xpath = "//td[@data-attribute-name ='Member State']//div//span")
	List<WebElement> allMemberStateValuesInSearchResultsTable;

	@FindBy(xpath = "//td[@data-attribute-name ='Source System']//div//span")
	List<WebElement> allSourceSystemValuesInSearchResultsTable;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pMemberSearch$ppyFirstNameError']//span")
	WebElement firstNameRequiredError;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pMemberSearch$ppyLastNameError']//span")
	WebElement lastNameRequiredError;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pMemberSearch$ppyFirstNameError']//span")
	WebElement firstNameLengthError;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pMemberSearch$ppyLastNameError']//span")
	WebElement lastNameLengthError;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pMemberSearch$pSubscriberIDError']//span")
	WebElement subscriberRequiredError;

	/*
	 * This method is to verify the member search page title
	 */
	public void validateMemberSearchPageTitle() {
		verifyThePageTitle("Member Search", memberSearchPageTitle);
	}

	/* This method is to select the subscriber id option in member search page. */
	public void selectSubscriberIdOption() {
		oldAttributeValue = isSearchResultsDisplayed.getAttribute("uniqueid");
		clickAnElement(searchBySubscriberId);
		waitTillAttributeValueChanges(isSearchResultsDisplayed, oldAttributeValue, "uniqueid");
	}

	/*
	 * This method is to search by subscriber id in member search page and wait
	 * tills results displayed.
	 */
	public void searchBySubscriberId(String subscriberId, String seqNo, String dob, String memberState,
			String groupNumber, String sourceSystem) {

		oldAttributeValue = isSearchResultsDisplayed.getAttribute("uniqueid");
		clickAnElement(searchBySubscriberId);
		waitTillAttributeValueChanges(isSearchResultsDisplayed, oldAttributeValue, "uniqueid");
		enterTheText(this.subscriberId, subscriberId);
		if (seqNo != null) {
			enterTheText(sequenceNumber, seqNo);
		}
		if (dob != null) {
			enterTheText(dateOfBirth, dob);
		}
		if (memberState != null) {
			selectDropDownValueByText(memberStateDropDown, memberState);
		}
		if (groupNumber != null) {
			enterTheText(this.groupNumber, groupNumber);
		}
		if (sourceSystem != null) {
		selectDropDownValueByText(this.sourceSystem, sourceSystem);
		}
		oldAttributeValue = isSearchResultsDisplayed.getAttribute("uniqueid");
		clickOnSearchInMemberSearch();
		waitTillAttributeValueChanges(isSearchResultsDisplayed, oldAttributeValue, "uniqueid");
	}

	/* This method is to select the first and last name type of searches. */
	public void selectTheFirstAndLastNameTypeSearches(String firstNameKindOfSearch, String lastNameKindOfSearch) {
		selectDropDownValueByText(memberFirstNameDropDown, firstNameKindOfSearch);
		selectDropDownValueByText(memberLastNameDropDown, lastNameKindOfSearch);
	}

	/*
	 * This method is to search by member first name and last name in member search
	 * page and wait tills results displayed.
	 */
	public void searchByMemberName(String firstName, String lastName, String dob, String memberState,
			String groupNumber, String sourceSystem) {

		enterTheText(memberFirstNameTextField, firstName);
		enterTheText(memberLastNameTextField, lastName);
		if (dob != null) {
			enterTheText(dateOfBirth, dob);
		}
		if (memberState != null) {
			selectDropDownValueByText(memberStateDropDown, memberState);
		}
		if (groupNumber != null) {
			enterTheText(this.groupNumber, groupNumber);
		}
		selectDropDownValueByText(this.sourceSystem, sourceSystem);
		oldAttributeValue = isSearchResultsDisplayed.getAttribute("uniqueid");
		clickOnSearchInMemberSearch();
		waitTillAttributeValueChanges(isSearchResultsDisplayed, oldAttributeValue, "uniqueid");
	}

	/*
	 * This method is to validate the sorting functionality in member search
	 * results.
	 */
	public void validateSortingOrderInMemberSearchResultsTable() {
		clickAnElement(seqNoHeader);
		waitForTheElementToBeClickable(seqNoHeader);
		if (!validateAscendingSortingOrder(allSeqNoValuesInSearchResultsTable)) {
			Assert.fail("Sequence numbers are not sorted in ascending order.");
		}

		clickAnElement(seqNoHeader);
		waitForTheElementToBeClickable(seqNoHeader);
		if (!validateDescendingSortingOrder(allSeqNoValuesInSearchResultsTable)) {
			Assert.fail("Sequence numbers are not sorted in descending order.");
		}

		clickAnElement(firstNameHeader);
		waitForTheElementToBeClickable(firstNameHeader);
		if (!validateAscendingSortingOrder(allFirstNameValuesInSearchResultsTable)) {
			Assert.fail("First name values are not sorted in ascending order.");
		}

		clickAnElement(firstNameHeader);
		waitForTheElementToBeClickable(firstNameHeader);
		if (!validateDescendingSortingOrder(allFirstNameValuesInSearchResultsTable)) {
			Assert.fail("First name values are not sorted in descending order.");
		}

		clickAnElement(lastNameHeader);
		waitForTheElementToBeClickable(lastNameHeader);
		if (!validateAscendingSortingOrder(allLastNameValuesInSearchResultsTable)) {
			Assert.fail("Last name values are not sorted in ascending order.");
		}

		clickAnElement(lastNameHeader);
		waitForTheElementToBeClickable(lastNameHeader);
		if (!validateDescendingSortingOrder(allLastNameValuesInSearchResultsTable)) {
			Assert.fail("Last name values are not sorted in descending order.");
		}

		clickAnElement(dateOfBirthHeader);
		waitForTheElementToBeClickable(dateOfBirthHeader);
		if (!validateAscendingSortingOrder(allDateOfBirthValuesInSearchResultsTable)) {
			Assert.fail("DOB values are not sorted in ascending order.");
		}

		clickAnElement(dateOfBirthHeader);
		waitForTheElementToBeClickable(dateOfBirthHeader);
		if (!validateDescendingSortingOrder(allDateOfBirthValuesInSearchResultsTable)) {
			Assert.fail("DOB values are not sorted in descending order.");
		}

		clickAnElement(memberStateHeader);
		waitForTheElementToBeClickable(memberStateHeader);
		if (!validateAscendingSortingOrder(allMemberStateValuesInSearchResultsTable)) {
			Assert.fail("Member state values are not sorted in ascending order.");
		}

		clickAnElement(memberStateHeader);
		waitForTheElementToBeClickable(memberStateHeader);
		if (!validateDescendingSortingOrder(allMemberStateValuesInSearchResultsTable)) {
			Assert.fail("Member state values are not sorted in descending order.");
		}

		clickAnElement(sourceSystemHeader);
		waitForTheElementToBeClickable(sourceSystemHeader);
		if (!validateAscendingSortingOrder(allSourceSystemValuesInSearchResultsTable)) {
			Assert.fail("Source system values are not sorted in ascending order.");
		}

		clickAnElement(sourceSystemHeader);
		waitForTheElementToBeClickable(sourceSystemHeader);
		if (!validateDescendingSortingOrder(allSourceSystemValuesInSearchResultsTable)) {
			Assert.fail("Source system values are not sorted in descending order.");
		}
	}

	/*
	 * This method is to validate the error messages for invalid member name search.
	 */
	public void validateErrorMessagesForInvalidMemberNameSearch(String errorMessage) {

		if (errorMessage.toLowerCase().contains("first name - this field")) {
			clickAnElement(search);
			waitTillAttributeValueChanges(isSearchResultsDisplayed, oldAttributeValue, "uniqueid");
			compareTexts(errorMessage, getText(firstNameRequiredError));
			clickOnResetInMemberSearch();
			waitForTheElementTobeAbsent(firstNameRequiredError);
		} else if (errorMessage.toLowerCase().contains("first name - length")) {
			enterTheText(memberFirstNameTextField, "J");
			oldAttributeValue = isSearchResultsDisplayed.getAttribute("uniqueid");
			clickAnElement(search);
			waitTillAttributeValueChanges(isSearchResultsDisplayed, oldAttributeValue, "uniqueid");
			compareTexts(errorMessage, getText(firstNameLengthError));
			clickOnResetInMemberSearch();
			waitForTheElementTobeAbsent(firstNameLengthError);
		} else if (errorMessage.toLowerCase().contains("last name - this field")) {
			enterTheText(memberFirstNameTextField, "John");
			clickAnElement(search);
			waitTillAttributeValueChanges(isSearchResultsDisplayed, oldAttributeValue, "uniqueid");
			compareTexts(errorMessage, getText(lastNameRequiredError));
			clickOnResetInMemberSearch();
			waitForTheElementTobeAbsent(lastNameRequiredError);
		} else if (errorMessage.toLowerCase().contains("last name - length")) {
			enterTheText(memberFirstNameTextField, "John");
			enterTheText(memberLastNameTextField, "S");
			oldAttributeValue = isSearchResultsDisplayed.getAttribute("uniqueid");
			clickAnElement(search);
			waitTillAttributeValueChanges(isSearchResultsDisplayed, oldAttributeValue, "uniqueid");
			compareTexts(errorMessage, getText(lastNameLengthError));
			clickOnResetInMemberSearch();
			waitForTheElementTobeAbsent(lastNameLengthError);
		}
	}

	/*
	 * This method is to validate the error messages for invalid subscriber id
	 * search.
	 */
	public void validateErrorMessagesForInvalidSubscriberIdSearch(String errorMessage) {
		oldAttributeValue = isSearchResultsDisplayed.getAttribute("uniqueid");
		clickAnElement(searchBySubscriberId);
		waitTillAttributeValueChanges(isSearchResultsDisplayed, oldAttributeValue, "uniqueid");
		clickAnElement(search);
		compareTexts(errorMessage, getText(subscriberRequiredError));
	}

	/* This method is to click on search in member search page */
	public void clickOnSearchInMemberSearch() {
		String attributeValue = getAttributeValue(isSearchResultsDisplayed, "uniqueid");
		clickAnElement(search);
		waitTillAttributeValueChanges(isSearchResultsDisplayed, attributeValue, "uniqueid");
	}

	/* This method is to click on reset in member search page */
	public void clickOnResetInMemberSearch() {
		clickAnElement(reset);
	}

	/* This method is to navigate to member information screen. */
	public void clickOnMemberLastName(String seqNumber, String firstName, String lastName, String dob) {
//		System.out.println("WebElement: "+createWebElementForMemberLastName(seqNumber, firstName, lastName, dob));
		createWebElementForMemberLastName(seqNumber, firstName, lastName, dob);
		commercialMemberInformationContactInfo.validateMemberInformationPageTitle();
	}
}
