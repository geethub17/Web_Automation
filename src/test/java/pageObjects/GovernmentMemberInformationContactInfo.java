package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class GovernmentMemberInformationContactInfo extends Utils {

	private WebDriver driver;
	private String userName;
	private String todaysDate;
	private String newEmailAddress;
	private String currentEmailAddress;
	private String sourceOriginOfMemberEmail;
	private String sourceChannelOfMemberEmail;
	private String currentNonSalesPreferenceValue;
	private String newValue;
	private String phoneNumber;

	public GovernmentMemberInformationContactInfo(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	/* All elements of government member contact information page are captured. */

	@FindBy(xpath = "//div[text()='Member Information']")
	WebElement memberInformationTitle;

	@FindBy(xpath = "//span[text()='Explanation of Benefits (EOBs)']")
	WebElement isPreferenceTabLoaded;

	@FindBy(xpath = "(//label[@for='MbrFirstName']//following::div//span)[1]")
	WebElement firstNameInMemberInformationSection;

	@FindBy(xpath = "(//label[@for='MemberLastName']//following::div//span)[1]")
	WebElement lastNameInMemberInformationSection;

	@FindBy(xpath = "(//label[@for='MbrDOB']//following::div//span)[1]")
	WebElement dobInMemberInformationSection;

	@FindBy(xpath = "(//label[@for='SequenceNumber']//following::div//span)[1]")
	WebElement seqNumberInMemberInformationSection;

	@FindBy(xpath = "(//label[@for='Group']//following::div//span)[1]")
	WebElement groupNumberInMemberInformationSection;

	@FindBy(xpath = "(//label[@for='SourceSystemDisplay']//following::div//span)[1]")
	WebElement sourceSystemInMemberInformationSection;

	@FindBy(xpath = "(//label[@for='CoverageStatusDesc']//following::div//span)[1]")
	WebElement memberStatusInMemberInformationSection;

	@FindBy(xpath = "(//label[@for='Email']//following::div//span)[1]")
	WebElement preferredEmailInMemberInformationSection;

	@FindBy(xpath = "(//label[@for='MailingAddress']//following::div//span)[1]")
	WebElement preferredEmailAddressInMemberInformationSection;

	@FindBy(xpath = "(//label[@for='PhoneNumber']//following::div//span)[1]")
	WebElement preferrredTelephoneNumberInMemberInformationSection;

	@FindBy(xpath = "(//label[@for='PreferredText']//following::div//span)[1]")
	WebElement preferredTextInMemberInformationSection;
	//
	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l1']//td[@data-attribute-name='<b>Type</b>']//span")
	WebElement primaryTypeInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l1']//td[@data-attribute-name='<b>Manual Confirmation</b>']//span")
	WebElement primaryManulConfirmationInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l1']//td[@data-attribute-name='<b>Email Address</b>']//span//input")
	WebElement primaryEmailAddressInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l1']//td[@data-attribute-name='<b>Updated By</b>']")
	WebElement primaryUpdatedByInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l1']//td[@data-attribute-name='<b>Updated Date Time Stamp</b>']")
	WebElement primaryUpdatedDateTimeStampInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l1']//td[@data-attribute-name='<b>Source Channel</b>']//span")
	WebElement primarySourceChannelInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l1']//td[@data-attribute-name='<b>Source Origin</b>']//span")
	WebElement primarySourceOriginInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l2']//td[@data-attribute-name='<b>Type</b>']//span")
	WebElement alternate1TypeInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l2']//td[@data-attribute-name='<b>Manual Confirmation</b>']//span")
	WebElement alternate1ManulConfirmationInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l2']//td[@data-attribute-name='<b>Email Address</b>']//span")
	WebElement alternate1EmailAddressInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l2']//td[@data-attribute-name='<b>Updated By</b>']//span")
	WebElement alternate1UpdatedByInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l2']//td[@data-attribute-name='<b>Updated Date Time Stamp</b>']//span")
	WebElement alternate1UpdatedDateTimeStampInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l2']//td[@data-attribute-name='<b>Source Channel</b>']//span")
	WebElement alternate1SourceChannelInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l2']//td[@data-attribute-name='<b>Source Origin</b>']//span")
	WebElement alternate1SourceOriginInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l3']//td[@data-attribute-name='<b>Type</b>']//span")
	WebElement alternate2TypeInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l3']//td[@data-attribute-name='<b>Manual Confirmation</b>']//span")
	WebElement alternate2ManulConfirmationInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l3']//td[@data-attribute-name='<b>Email Address</b>']//span")
	WebElement alternate2EmailAddressInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l3']//td[@data-attribute-name='<b>Updated By</b>']//span")
	WebElement alternate2UpdatedByInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l3']//td[@data-attribute-name='<b>Updated Date Time Stamp</b>']//span")
	WebElement alternate2UpdatedDateTimeStampInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l3']//td[@data-attribute-name='<b>Source Channel</b>']//span")
	WebElement alternate2SourceChannelInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l3']//td[@data-attribute-name='<b>Source Origin</b>']//span")
	WebElement alternate2SourceOriginInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pTextNumberList$l1']//td[@data-attribute-name='Preferred']//span")
	WebElement preferredInMemberTextNumberSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pTextNumberList$l1']//td[@data-attribute-name='Phone Number']//span")
	WebElement phoneNumberInMemberTextNumberSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pTextNumberList$l1']//td[@data-attribute-name='Source Channel']//span")
	WebElement sourceChannelInMemberTextNumberSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pTextNumberList$l1']//td[@data-attribute-name='Source Origin']//span")
	WebElement sourceOriginInMemberTextNumberSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pTextNumberList$l1']//td[@data-attribute-name='Updated By']//span")
	WebElement updatedByInMemberTextNumberSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pTextNumberList$l1']//td[@data-attribute-name='Updated Date']//span")
	WebElement updatedDateInMemberTextNumberSection;

	@FindBy(xpath = "//a[text()='Mark Preferred']")
	WebElement markPreferredInMemberTextNumberSection;

	@FindBy(xpath = "//button[@type='button']//div[text()='Yes']")
	WebElement yesInUpdatePreferenceDialog;

	@FindBy(xpath = "//button[@type='button']//div[text()='No']")
	WebElement noInUpdatePreferenceDialog;

	@FindBy(xpath = "//h3[text()='Preferences']")
	WebElement preferencesTab;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l1']//a[text()='Apply']")
	WebElement applyInPrimaryEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l1']//a[text()='Reset']")
	WebElement resetInPrimaryEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l1']//a[text()='Delete']")
	WebElement deleteInPrimaryEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l1']//a[text()='View History']")
	WebElement viewHistoryInPrimaryEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l2']//a[text()='Apply']")
	WebElement applyInSecondaryEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l2']//a[text()='Reset']")
	WebElement resetInSecondaryEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l2']//a[text()='Delete']")
	WebElement deleteAlternate1EmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l2']//a[text()='View History']")
	WebElement viewHistoryInSecondaryEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l3']//a[text()='Apply']")
	WebElement applyInAlternate2EmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l3']//a[text()='Reset']")
	WebElement resetInAlternate2EmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l3']//a[text()='Delete']")
	WebElement deleteInAlternate2EmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pEmailList$l3']//a[text()='View History']")
	WebElement viewHistoryInAlternate2EmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pMemberPhoneDetails$l1']//td[@data-attribute-name='Telephone Number']//span")
	WebElement telephoneNumberInMemberTelephoneSection;

	@FindBy(css = "select[id='SalesPrefCode1']>option[selected]")
	WebElement salesValueInMemberTelephoneSection;

	@FindBy(css = "select[id='NonSalesPrefCode1']>option[selected]")
	WebElement nonSalesValueInMemberTelephoneSection;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement enabledCheckBox;

	@FindBy(xpath = "//input[@type='checkbox'][@disabled]")
	WebElement disabledCheckBox;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pMemberPhoneDetails$l1']//td[@data-attribute-name='Federal']//span")
	WebElement federalInMemberTelephoneSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pMemberPhoneDetails$l1']//td[@data-attribute-name='State']//span")
	WebElement stateInMemberTelephoneSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pMemberPhoneDetails$l1']//td[@data-attribute-name='Cell']//span")
	WebElement cellInMemberTelephoneSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pMemberPhoneDetails$l1']//td[@data-attribute-name='Updated By']//span")
	WebElement updatedByInMemberTelephoneSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pMemberPhoneDetails$l1']//td[@data-attribute-name='Updated Date']//span")
	WebElement updatedDateInMemberTelephoneSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pMemberPhoneDetails$l1']//a[text()='Apply']")
	WebElement applyInMemberTelephoneSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pMemberPhoneDetails$l1']//a[text()='Reset']")
	WebElement resetInMemberTelephoneSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pMemberPhoneDetails$l1']//a[text()='View History']")
	WebElement viewHistoryInMemberTelephoneSection;

	@FindBy(xpath = "(//div[@data-node-id='MemberEmailDetails'][contains(@uniqueid,'SID')])[1]")
	WebElement isEmailPreferencesUpdated;

	@FindBy(xpath = "(//div[@data-node-id='MemberTelephoneDetails'][contains(@uniqueid,'SID')])[1]")
	WebElement isPhonePreferencesUpdated;

	@FindBy(id = "SalesPrefCode1")
	WebElement salesDropDown;

	@FindBy(id = "NonSalesPrefCode1")
	WebElement nonSalesDropDown;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pMemberPhoneDetails$l1']//a[text()='Apply']")
	WebElement applyInMemberTelephoneNumbersSection;

	@FindBy(xpath = "(//div[@data-node-id='MemberEmailDetails'][contains(@uniqueid,'SID')])[1]")
	WebElement isEmailUpdated;

	/* This method is to verify email details in member email section. */
	public void validateEmailDetailsInMemberInformationPage(String type, String manualConfirmation, String emailAddress,
			String upadtedBy, String updatedDate, String sourceChannel, String sourceOrigin) {

		if (type != null) {
			compareTexts(type, getText(primaryTypeInMemberEmailSection));
		}
		if (manualConfirmation != null) {
			compareTexts(manualConfirmation, getText(primaryManulConfirmationInMemberEmailSection));
		}
		if (emailAddress != null) {
			compareTexts(emailAddress, getAttributeValue(primaryEmailAddressInMemberEmailSection, "value"));
		}
		if (upadtedBy != null) {
			compareTexts(upadtedBy, getText(primaryUpdatedByInMemberEmailSection));
		}
		if (updatedDate != null) {
			compareTexts(updatedDate, getText(primaryUpdatedDateTimeStampInMemberEmailSection));
		}
		if (sourceChannel != null) {
			compareTexts(sourceChannel, getText(primarySourceChannelInMemberEmailSection));
		}
		if (sourceOrigin != null) {
			compareTexts(sourceOrigin, getText(primarySourceOriginInMemberEmailSection));
		}
	}

	/*
	 * This method is update the email address and verify the details in email
	 * history page.
	 */
	public void updateAndVerifyTheEmailAddress() {
		userName = propertiesReader.getUserName();
		todaysDate = estTodaysDateForEmailHistoryPage();

		String oldAttributeValue = getAttributeValue(isEmailUpdated, "uniqueid");

		enterTheText(primaryEmailAddressInMemberEmailSection, newEmailAddress);
		clickAnElement(applyInPrimaryEmailSection);
		clickAnElement(yesInUpdatePreferenceDialog);
		waitTillAttributeValueChanges(isEmailUpdated, oldAttributeValue, "uniqueid");

		sourceOriginOfMemberEmail = getText(primarySourceOriginInMemberEmailSection);
		sourceChannelOfMemberEmail = getText(primarySourceChannelInMemberEmailSection);

		verifyTheEmailDetailsInMemberContactInformationPage(newEmailAddress);
	}

	/* This method to validate the reset in member email section */
	public void verifyResetInMemberEmailSection() {
		String oldAttributeValue = isEmailPreferencesUpdated.getAttribute("uniqueid");
		newEmailAddress = generateRandomEmail();
		currentEmailAddress = getAttributeValue(primaryEmailAddressInMemberEmailSection, "value");
		enterTheText(primaryEmailAddressInMemberEmailSection, newEmailAddress);
		clickAnElement(resetInPrimaryEmailSection);
		waitTillAttributeValueChanges(isEmailPreferencesUpdated, oldAttributeValue, "uniqueid");
		compareTexts(currentEmailAddress, getAttributeValue(primaryEmailAddressInMemberEmailSection, "value"));
	}

	/*
	 * This method is verify the updated email address in member contact information
	 * page.
	 */
	public void verifyTheEmailDetailsInMemberContactInformationPage(String emailAddress) {
		compareTexts(emailAddress, getAttributeValue(primaryEmailAddressInMemberEmailSection, "value"));
		compareTexts(userName, getText(primaryUpdatedByInMemberEmailSection));
		containsTexts(getText(primaryUpdatedDateTimeStampInMemberEmailSection), todaysDate);
	}

	/* This method is to navigate to email history page */
	public void navigateToMemberEmailHistoryPage() {
		clickAnElement(viewHistoryInPrimaryEmailSection);
		governmentMemberEmailSearchHistory.validateEmailSearchHistoryPage();
	}

	/* This method is to verify the updated email details in email history page. */
	public void verifyTheEmailDetailsInEmailHistoryPage() {
		governmentMemberEmailSearchHistory.verifyTheEmailDetailsInHistorySearchPage(newEmailAddress, userName,
				estTodaysDateForEmailHistoryPage(), sourceChannelOfMemberEmail, sourceOriginOfMemberEmail);
	}

	/*
	 * This method is to verify telephone details in member telephone number
	 * section.
	 */
	public void validatePhoneDetailsInMemberInformationPage(String phoneNumber, String sales, String nonSales,
			String updatedBy, String updatedDate) {

		scrollDown(250);

		if (phoneNumber != null) {
			compareTexts(phoneNumber, getText(telephoneNumberInMemberTelephoneSection));
		}
		if (sales != null) {
			compareTexts(sales, getText(salesValueInMemberTelephoneSection));
		}
		if (nonSales != null) {
			compareTexts(nonSales, getText(nonSalesValueInMemberTelephoneSection));
		}
		if (updatedBy != null) {
			compareTexts(updatedBy, getText(updatedByInMemberTelephoneSection));
		}
		if (updatedDate != null) {
			compareTexts(updatedDate, getText(updatedDateInMemberTelephoneSection));
		}
	}

	/*
	 * This method is update the phone preferences and verify the details in phone
	 * history page.
	 */
	public void updateAndVerifyThePhoneDetails(String value1, String value2) {
		userName = propertiesReader.getUserName();
		todaysDate = estTodaysDate();
		String attributeValue = getAttributeValue(isPhonePreferencesUpdated, "uniqueid");

		scrollDown(250);

		currentNonSalesPreferenceValue = getText(nonSalesValueInMemberTelephoneSection);
		if (currentNonSalesPreferenceValue.equalsIgnoreCase(value1)) {
			selectDropDownValueByText(nonSalesDropDown, value2);
			clickAnElement(applyInMemberTelephoneNumbersSection);
			clickAnElement(yesInUpdatePreferenceDialog);
			newValue = value2;
			waitTillAttributeValueChanges(isPhonePreferencesUpdated, attributeValue, "uniqueid");
			validateTheUpdatedDetails();
		} else if (currentNonSalesPreferenceValue.equalsIgnoreCase(value2)) {
			selectDropDownValueByText(nonSalesDropDown, value1);
			clickAnElement(applyInMemberTelephoneNumbersSection);
			clickAnElement(yesInUpdatePreferenceDialog);
			newValue = value1;
			waitTillAttributeValueChanges(isPhonePreferencesUpdated, attributeValue, "uniqueid");
			validateTheUpdatedDetails();
		} else {
			Assert.fail("The phone number value is not set to either " + value1 + " or " + value2);
		}
		phoneNumber = getText(telephoneNumberInMemberTelephoneSection);
	}

	/* This method is to validate the updated phone details. */
	public void validateTheUpdatedDetails() {
		compareTexts(newValue, getText(nonSalesValueInMemberTelephoneSection));
		compareTexts(userName, getText(updatedByInMemberTelephoneSection));
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
				Assert.fail("Checbox is enabled when nonsales value is "+newValue);
			}
		}
	}

	/* This method is to navigate to phone history page */
	public void navigateToMemberPhoneHistoryPage() {
		clickAnElement(viewHistoryInMemberTelephoneSection);
		phoneSearchHistory.validatePhoneSearchHistoryPage();
	}

	/* This method is to verify the updated phone details in phone history page. */
	public void verifyThePhoneDetailsInPhoneHistoryPage() {
		phoneSearchHistory.verifyTheUpdatePhoneDetailsInHistorySearchPage(phoneNumber, newValue, userName, todaysDate);
	}

	/* This method is to verify the phone details in phone history page. */
	public void verifyThePhoneDetailsInPhoneHistoryPage(String phoneNumber, String nonSales, String userName,
			String todaysDate) {
		phoneSearchHistory.verifyTheUpdatePhoneDetailsInHistorySearchPage(phoneNumber, nonSales, userName, todaysDate);
	}

	/* This method is to verify the member text number section details. */
	public void validateMemberTextDetailsInMemberInformationPage(String preferredValue, String phoneNumber,
			String sourceChannel, String sourceOrigin, String updatedBy, String updatedDate) {

		scrollDown(350);

		if (preferredValue != null) {
			compareTexts(preferredValue, getText(preferredInMemberTextNumberSection));
		}
		if (phoneNumber != null) {
			compareTexts(phoneNumber, getText(phoneNumberInMemberTextNumberSection));
		}
		if (sourceChannel != null) {
			compareTexts(sourceChannel, getText(sourceChannelInMemberTextNumberSection));
		}
		if (sourceOrigin != null) {
			compareTexts(sourceOrigin, getText(sourceOriginInMemberTextNumberSection));
		}
		if (updatedBy != null) {
			compareTexts(updatedBy, getText(updatedByInMemberTextNumberSection));
		}
		if (updatedDate != null) {
			compareTexts(updatedDate, getText(updatedDateInMemberTextNumberSection));
		}
	}

	/* This method is to navigate to preference tab */
	public void navigateToMemberPreferenceTab() {
		clickAnElement(preferencesTab);
		commercialMemberInformationPreferences.validateMemberInformationPreferenceTab();
	}

}
