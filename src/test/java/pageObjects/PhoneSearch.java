package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reader.PropertiesReader;
import utilities.Utils;

public class PhoneSearch extends Utils {

	private WebDriver driver;
	private String currentNonSalesPreferenceValue;
	private String expectedTelePhoneNumber;
	private String userName;
	private String todaysDate;
	private String newValue;

	public PhoneSearch(WebDriver driver) {
		super(driver);
		this.driver = driver;
		propertiesReader = new PropertiesReader();
		PageFactory.initElements(this.driver, this);
	}

	/*
	 * All elements of phone search page are captured.
	 */
	@FindBy(css = "a.StrongWhiteAction")
	WebElement actions;

	@FindBy(css = "ul[id*='pyNavigation']>li:nth-of-type(2)")
	WebElement memberSearchPage;

	@FindBy(xpath = "//span[text()='Phone Number Scrub']")
	WebElement phoneNumberScrubPage;

	@FindBy(xpath = "//span[text()='Consent/Do Not Call/Wrong Number Upload']")
	WebElement consentOrDncOrWnFileStatusPage;

	@FindBy(css = "div[class*='heading_1_dataLabelWrite']")
	WebElement phoneSearchTitle;

	@FindBy(id = "TelephoneNumber")
	WebElement phoneSearchTextBox;

	@FindBy(xpath = "//div[text()='Search']")
	WebElement searchInPhoneSearch;

	@FindBy(xpath = "//button[@name='SearchPhone_pgPhoneSearch_16']//div[text()='Reset']")
	WebElement resetInPhoneSearchTextBox;

	@FindBy(xpath = "//td[@data-attribute-name='Telephone Number']//div//span")
	WebElement telephoneNumberInPhoneSearch;

	@FindBy(css = "select[id='SalesPrefCode1']>option")
	WebElement salesValue;

	@FindBy(css = "select[id='NonSalesPrefCode1']>option[selected]")
	WebElement nonSalesValue;

	@FindBy(css = "input[id='ReConfirmNonSales1'][disabled]")
	WebElement disabledCheckBox;

	@FindBy(css = "input#ReConfirmNonSales1")
	WebElement enabledCheckBox;

	@FindBy(css = "td[data-attribute-name='Federal']>div>span")
	WebElement federal;

	@FindBy(css = "td[data-attribute-name='State']>div>span")
	WebElement state;

	@FindBy(css = "td[data-attribute-name='Cell']>div>span")
	WebElement cell;

	@FindBy(xpath = "//td[@data-attribute-name='Updated By']//span")
	WebElement updatedByInPhoneSearch;

	@FindBy(css = "td[data-attribute-name='Updated Date']>div>span")
	WebElement updatedDate;

	@FindBy(css = "a[name='UpdateLinks_pgPhoneSearch.NewDetails(1)_1']")
	WebElement apply;

	@FindBy(css = "a[name='UpdateLinks_pgPhoneSearch.NewDetails(1)_3']")
	WebElement resetInActions;

	@FindBy(css = "a[name='UpdateLinks_pgPhoneSearch.NewDetails(1)_5']")
	WebElement viewHistory;

	@FindBy(css = "ul[class='pageErrorList layout-noheader-errors']>li")
	WebElement errorMessage;

	@FindBy(css = "select[id='NonSalesPrefCode1']")
	WebElement nonSalesPreferenceDropDown;

	@FindBy(xpath = "//div[@id='modaldialog_con']//div[text()='Yes']")
	WebElement yesInUpdateDetails;

	@FindBy(css = "div[class='field-item dataLabelWrite privacyalert_dataLabelWrite']")
	WebElement privacyAlert;

	@FindBy(css = "div[data-node-id='TelephoneDetails'][uniqueid]")
	WebElement isPhonePreferenceUpdated;

	@FindBy(css = "div[data-node-id='DisplayError']>div[uniqueid*='SID']")
	WebElement isSearchResultsDisplayed;

	/* This method is to search for a phone number. */
	public void searchPhoneNumber(String phoneNumber) {
		if (verifyThePageTitle("Phone Search", phoneSearchTitle))
			enterTheText(phoneSearchTextBox, phoneNumber);
		clickAnElement(searchInPhoneSearch);
	}

	/*
	 * This method is to validate the error message of invalid phone number search
	 */
	public void validateErrorMessage(String expectedMessage) {
		compareTexts(expectedMessage, getText(errorMessage));
	}

	/*
	 * This method is to update and validate the non-sales preference and other
	 * parameters in results table.
	 */
	public void updateAndValidateNonSalesPreference(String value1, String value2) {
		currentNonSalesPreferenceValue = getText(nonSalesValue);
		String oldAttributeValue = getAttributeValue(isPhonePreferenceUpdated, "uniqueid");

		if (currentNonSalesPreferenceValue.equalsIgnoreCase(value1)) {
			selectDropDownValueByText(nonSalesPreferenceDropDown, value2);
			clickAnElement(apply);
			clickAnElement(yesInUpdateDetails);
			newValue = value2;
			waitTillAttributeValueChanges(isPhonePreferenceUpdated, oldAttributeValue, "uniqueid");
			validateTheUpdatedDetails();
		} else if (currentNonSalesPreferenceValue.equalsIgnoreCase(value2)) {
			selectDropDownValueByText(nonSalesPreferenceDropDown, value1);
			clickAnElement(apply);
			clickAnElement(yesInUpdateDetails);
			newValue = value1;
			waitTillAttributeValueChanges(isPhonePreferenceUpdated, oldAttributeValue, "uniqueid");
			validateTheUpdatedDetails();
		} else {
			Assert.fail("The phone number value is not set to either " + value1 + " or " + value2);
		}

	}

	public void validateTheUpdatedDetails() {

		expectedTelePhoneNumber = phoneSearchTextBox.getAttribute("value");
		userName = propertiesReader.getUserName();
		todaysDate = estTodaysDate();

		compareTexts(expectedTelePhoneNumber, getText(telephoneNumberInPhoneSearch));
		compareTexts(newValue, getText(nonSalesValue));
		compareTexts(userName, getText(updatedByInPhoneSearch));
		compareTexts(todaysDate, getText(updatedDate));

	}

	/*
	 * This method is to validate the re-confirmation check box enabled or disabled
	 * based upon non-sales value.
	 */
	public void validateReconfirmationCheckBox() {
		if (newValue.equalsIgnoreCase("consent")) {
			clickAnElement(enabledCheckBox);
		} else {
			if (isElementClickable(enabledCheckBox)) {
				Assert.fail("Checbox is enabled when nonsales value is " + newValue);
			}
		}
	}

	/*
	 * This method is to update non-sales preference value from wrong number to
	 * consent or DNC if it was last updated by ‘MARPLTN’
	 */
	public void updateWrongNumberValueIfLastUpdateByMARPLTN(String value1) {
		currentNonSalesPreferenceValue = getText(nonSalesValue);
		if (currentNonSalesPreferenceValue.equalsIgnoreCase("Wrong Number")
				&& updatedByInPhoneSearch.getText().equalsIgnoreCase("MARPLTN")) {
			selectDropDownValueByText(nonSalesPreferenceDropDown, value1);
			clickAnElement(apply);
			clickAnElement(yesInUpdateDetails);
		} else {
			Assert.fail("The phone number value is not set to either " + value1 + " or " + "updated by is not MARPLTN");
		}
	}

	/*
	 * This method is to check the unauthorized error
	 * messavalidatePhoneSearchHistoryPagege.
	 */
	public void validateTheUnAuthorizedMessage(String unAuthorizedMessage) {
		if (compareTexts(unAuthorizedMessage, getText(privacyAlert))) {
			clickAnElement(resetInActions);
		}
	}

	/* This method is to validate the reset link in phone search screen */
	public void validateResetInPhoneSearchScreen() {
		currentNonSalesPreferenceValue = getText(nonSalesValue);
		selectDropDownValueByIndex(nonSalesPreferenceDropDown, 1);
		clickAnElement(resetInActions);
		compareTexts(currentNonSalesPreferenceValue, getText(nonSalesValue));
	}

	/* This method is to verify the updated details in phone history screen. */
	public void verifyTheUpdatedDetailsInPhoneHistoryScreen() {
		phoneSearchHistory.verifyTheUpdatePhoneDetailsInHistorySearchPage(expectedTelePhoneNumber, this.newValue,
				userName, todaysDate);
	}

	/* This method is to navigate to phone search history screen. */
	public void navigateToPhoneSearchHistoryScreen() {
		clickAnElement(viewHistory);
		phoneSearchHistory.validatePhoneSearchHistoryPage();
	}

	/* This method is to navigate to phone number scrub screen */
	public void navigateToPhoneNumberScrubScreen() {
		clickAnElement(actions);
		clickAnElement(phoneNumberScrubPage);
		scrubbingStatus.validateScrubbingStatusPageTitle();
	}

	/* This method is to navigate to Consent/Do Not Call/Wrong Number File screen */
	public void navigateToConsentOrDncOrWnFileScreen() {
		clickAnElement(actions);
		clickAnElement(consentOrDncOrWnFileStatusPage);
		consentOrDncOrWnFileStatus.validateConsentOrDncOrWnStatusPageTitle();
	}

	/* This method is to navigate to member search page */
	public void navigateToMemberSearchPage() {
		clickAnElement(actions);
		clickAnElement(memberSearchPage);
		memberSearch.validateMemberSearchPageTitle();
	}

}
