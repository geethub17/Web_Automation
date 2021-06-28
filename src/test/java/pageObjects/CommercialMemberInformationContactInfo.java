package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class CommercialMemberInformationContactInfo extends Utils {

	private WebDriver driver;
	private String currentEmailAddress;
	private String newEmailAddress;
	private String userName;
	private String todaysDate;
	private String preferredValueOfMemberEmail;
	private String sourceChannelOfMemberEmail;
	private String sourceOriginOfMemberEmail;
	private String currentNonSalesPreferenceValue;
	private String newValue;
	private String phoneNumber;

	public CommercialMemberInformationContactInfo(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	/* All elements of commercial member contact information page are captured. */

	@FindBy(xpath = "//div[text()='Member Information']")
	WebElement memberInformationTitle;

	@FindBy(xpath = "//span[text()='First Name']//following-sibling::div//span")
	WebElement firstNameInMemberInformationSection;

	@FindBy(xpath = "//span[text()='Last Name']//following-sibling::div//span")
	WebElement lastNameInMemberInformationSection;

	@FindBy(xpath = "//span[text()='DOB']//following-sibling::div//span")
	WebElement dobInMemberInformationSection;

	@FindBy(xpath = "//span[text()='Sequence No.']//following-sibling::div//span")
	WebElement seqNumberInMemberInformationSection;

	@FindBy(xpath = "//span[text()='Group']//following-sibling::div//span")
	WebElement groupNumberInMemberInformationSection;

	@FindBy(xpath = "//span[text()='Source System']//following-sibling::div//span")
	WebElement sourceSystemInMemberInformationSection;

	@FindBy(xpath = "//span[text()='Member Status']//following-sibling::div//span")
	WebElement memberStatusInMemberInformationSection;

	@FindBy(xpath = "//span[text()='Preferred Email']//following-sibling::div//span")
	WebElement preferredEmailInMemberInformationSection;

	@FindBy(xpath = "//span[text()='Preferred Mailing Address']//following-sibling::div//span")
	WebElement preferredEmailAddressLine1InMemberInformationSection;

	@FindBy(xpath = "(//span[text()='Preferred Mailing Address']//parent::div//parent::div//following-sibling::div)[2]//span")
	WebElement preferredEmailAddressLine2InMemberInformationSection;

	@FindBy(xpath = "//span[text()='Preferred TelePhone']//following-sibling::div//span")
	WebElement preferrredTelephoneNumberInMemberInformationSection;

	@FindBy(xpath = "//span[text()='Preferred Text']//following-sibling::div//span")
	WebElement preferredTextInMemberInformationSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pEmailList$l1']//td[@data-attribute-name='Preferred']//span")
	WebElement preferredValueInMemberEmailSection;

	@FindBy(name = "$PpyWorkPage$pCommercialMember$pEmailList$l1$pEmailAddress")
	WebElement emailAddressValueInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pEmailList$l1']//td[@data-attribute-name='Email Status']//span")
	WebElement emailStatusValueInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pEmailList$l1']//td[@data-attribute-name='Source Channel']//span")
	WebElement sourceChannelValueInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pEmailList$l1']//td[@data-attribute-name='Source Origin']//span")
	WebElement sourceOriginValueInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pEmailList$l1']//td[@data-attribute-name='Updated By']//span")
	WebElement updatedByValueInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pEmailList$l1']//td[@data-attribute-name='Updated Date Time Stamp']//span")
	WebElement updatedDateTimeStampValueInMemberEmailSection;

	@FindBy(xpath = "//a[contains(@name,'CommercialEmailUpdateLinks')][text()='Apply']")
	WebElement applyInMemberEmailSection;

	@FindBy(xpath = "//a[contains(@name,'CommercialEmailUpdateLinks')][text()='Reset']")
	WebElement resetInMemberEmailSection;

	@FindBy(xpath = "//div[@node_name='CommercialEmailUpdateLinks']//a[text()='View History']")
	WebElement viewHistoryInMemberEmailSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pMemberPhoneDetails$l1']//td[@data-attribute-name='Phone Type']//span")
	WebElement phoneTypeInMemberTelephoneNumbersSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pMemberPhoneDetails$l1']//td[@data-attribute-name='Preferred*']//span")
	WebElement preferredInMemberTelephoneNumbersSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pMemberPhoneDetails$l1']//td[@data-attribute-name='Phone Number']//span")
	WebElement phoneNumberInMemberTelephoneNumbersSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pMemberPhoneDetails$l1']//td[@data-attribute-name='Federal']//span")
	WebElement federalInMemberTelephoneNumbersSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pMemberPhoneDetails$l1']//td[@data-attribute-name='State']//span")
	WebElement stateTypeInMemberTelephoneNumbersSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pMemberPhoneDetails$l1']//td[@data-attribute-name='Cell']//span")
	WebElement cellInMemberTelephoneNumbersSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pMemberPhoneDetails$l1']//td[@data-attribute-name='Updated By']//span")
	WebElement updatedByInMemberTelephoneNumbersSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pMemberPhoneDetails$l1']//td[@data-attribute-name='Updated Date']//span")
	WebElement updatedDateInMemberTelephoneNumbersSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pMemberPhoneDetails$l1']//td[@data-attribute-name='Source Channel']//span")
	WebElement sourceChannelInMemberTelephoneNumbersSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pMemberPhoneDetails$l1']//td[@data-attribute-name='Source Origin']//span")
	WebElement sourceOriginInMemberTelephoneNumbersSection;

	@FindBy(css = "select[name='$PpyWorkPage$pCommercialMember$pMemberPhoneDetails$l1$pSalesPrefCode']>option[selected]")
	WebElement salesValue;

	@FindBy(css = "select[name='$PpyWorkPage$pCommercialMember$pMemberPhoneDetails$l1$pNonSalesPrefCode']>option[selected]")
	WebElement nonSalesValue;

	@FindBy(name = "$PpyWorkPage$pCommercialMember$pMemberPhoneDetails$l1$pSalesPrefCode")
	WebElement salesDropDownInMemberTelephoneNumbersSection;

	@FindBy(name = "$PpyWorkPage$pCommercialMember$pMemberPhoneDetails$l1$pNonSalesPrefCode")
	WebElement nonSalesDropDownInMemberTelephoneNumbersSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pMemberPhoneDetails$l1']//input[@type='checkbox']")
	WebElement enabledCheckBox;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pMemberPhoneDetails$l1']//input[@type='checkbox'][@disabled]")
	WebElement disabledCheckBox;

	@FindBy(xpath = "//a[contains(@name,'CommMbrPhoneUpdateLinks')][text()='Apply']")
	WebElement applyInMemberTelephoneNumbersSection;

	@FindBy(xpath = "//a[contains(@name,'CommMbrPhoneUpdateLinks')][text()='Reset']")
	WebElement resetInMemberTelephoneNumbersSection;

	@FindBy(xpath = "//div[@node_name='CommMbrPhoneUpdateLinks']//a[text()='View History']")
	WebElement viewHistoryInMemberTelephoneNumbersSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pTextNumberList$l1']//td[@data-attribute-name='Preferred']//span")
	WebElement preferredInMemberTextNumberSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pTextNumberList$l1']//td[@data-attribute-name='Phone Number']//span")
	WebElement phoneNumberInMemberTextNumberSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pTextNumberList$l1']//td[@data-attribute-name='Source Channel']//span")
	WebElement sourceChannelInMemberTextNumberSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pTextNumberList$l1']//td[@data-attribute-name='Source Origin']//span")
	WebElement sourceOriginInMemberTextNumberSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pTextNumberList$l1']//td[@data-attribute-name='Updated By']//span")
	WebElement updatedByInMemberTextNumberSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pTextNumberList$l1']//td[@data-attribute-name='Updated Date']//span")
	WebElement updatedDateInMemberTextNumberSection;

	@FindBy(xpath = "//a[text()='Mark Preferred']")
	WebElement markPreferredInMemberTextNumberSection;

	@FindBy(xpath = "//button[@type='button']//div[text()='Yes']")
	WebElement yesInUpdatePreferenceDialog;

	@FindBy(xpath = "//button[@type='button']//div[text()='No']")
	WebElement noInUpdatePreferenceDialog;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pMailingAddressList$l1']//td[@data-attribute-name='Preferred']//span")
	WebElement preferredInMemberMailingAddressSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pMailingAddressList$l1']//td[@data-attribute-name='Mailing Address']//span")
	WebElement mailingAddressInMemberMailingAddressSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pMailingAddressList$l1']//td[@data-attribute-name='Source Channel']//span")
	WebElement sourceChannelInMemberMailingAddressSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pMailingAddressList$l1']//td[@data-attribute-name='Source Origin']//span")
	WebElement sourceOriginInMemberMailingAddressSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pMailingAddressList$l1']//td[@data-attribute-name='Updated By']//span")
	WebElement updatedByInMemberMailingAddressSection;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pMailingAddressList$l1']//td[@data-attribute-name='Updated Date']//span")
	WebElement updatedDateInMemberMailingAddressSection;

	@FindBy(xpath = "//h3[text()='Preferences']")
	WebElement preferencesTab;

	@FindBy(xpath = "(//div[@data-node-id='CommercialMemberEmailDetails'][contains(@uniqueid,'SID')])[1]")
	WebElement isEmailPreferencesUpdated;

	@FindBy(xpath = "(//div[@data-node-id='CommercialMemberTelephoneDetails'][contains(@uniqueid,'SID')])[1]")
	WebElement isPhonePreferencesUpdated;

	@FindBy(xpath = "(//div[@data-node-id='CommercialMemberEmailDetails'][contains(@uniqueid,'SID')])[1]")
	WebElement isEmailUpdated;

	/* This method is to validate the member information page title. */
	public void validateMemberInformationPageTitle() {
		verifyThePageTitle("Member Information", memberInformationTitle);
	}

	/* This method is to validate the member details */
	public void validateMemberDetailsInMemberInformationPage(String firstName, String lastName, String dob,
			String sequenceNumber, String group, String sourceSystem, String memberStatus, String preferredEmail,
			String preferredMailingAddress, String preferredTelephoneNumber, String preferredText) {

		if (firstName != null) {
			compareTexts(firstName, getText(firstNameInMemberInformationSection));
		}
		if (lastName != null) {
			compareTexts(lastName, getText(lastNameInMemberInformationSection));
		}
		if (dob != null) {
			compareTexts(dob, getText(dobInMemberInformationSection));
		}
		if (sequenceNumber != null) {
			compareTexts(sequenceNumber, getText(seqNumberInMemberInformationSection));
		}
		if (group != null) {
			compareTexts(group, getText(groupNumberInMemberInformationSection));
		}
		if (sourceSystem != null) {
			compareTexts(sourceSystem, getText(sourceSystemInMemberInformationSection));
		}
		if (memberStatus != null) {
			compareTexts(memberStatus, getText(memberStatusInMemberInformationSection));
		}
		if (preferredEmail != null) {
			compareTexts(preferredEmail, getText(preferredEmailInMemberInformationSection));
		}
		if (preferredMailingAddress != null) {
			compareTexts(preferredMailingAddress, concatenateText(preferredEmailAddressLine1InMemberInformationSection,
					preferredEmailAddressLine2InMemberInformationSection));
		}
		if (preferredTelephoneNumber != null) {
			compareTexts(preferredTelephoneNumber, getText(preferrredTelephoneNumberInMemberInformationSection));
		}
		if (preferredText != null) {
			compareTexts(preferredText, getText(preferredTextInMemberInformationSection));
		}
	}

	/* This method is to verify email details in member email section. */
	public void validateEmailDetailsInMemberInformationPage(String preferredValue, String emailAddress,
			String emailStatus, String sourceChannel, String sourceOrigin, String updatedBy, String updatedDate) {

		if (preferredValue != null) {
			compareTexts(preferredValue, getText(preferredValueInMemberEmailSection));
		}
		if (emailAddress != null) {
			compareTexts(emailAddress, getAttributeValue(emailAddressValueInMemberEmailSection, "value"));
		}
		if (emailStatus != null) {
			compareTexts(emailStatus, getText(emailStatusValueInMemberEmailSection));
		}
		if (sourceChannel != null) {
			compareTexts(sourceChannel, getText(sourceChannelValueInMemberEmailSection));
		}
		if (sourceOrigin != null) {
			compareTexts(sourceOrigin, getText(sourceOriginValueInMemberEmailSection));
		}
		if (updatedBy != null) {
			compareTexts(updatedBy, getText(updatedByValueInMemberEmailSection));
		}
		if (updatedDate != null) {
			compareTexts(updatedDate, getText(updatedDateTimeStampValueInMemberEmailSection));
		}
	}

	/*
	 * This method is update the email address and verify the details in email
	 * history page.
	 */
	public void updateAndVerifyTheEmailAddress() {
		userName = propertiesReader.getUserName();
		todaysDate = estTodaysDate();

		String oldAttributeValue = getAttributeValue(isEmailUpdated, "uniqueid");

		enterTheText(emailAddressValueInMemberEmailSection, newEmailAddress);
		clickAnElement(applyInMemberEmailSection);
		clickAnElement(yesInUpdatePreferenceDialog);
		waitTillAttributeValueChanges(isEmailUpdated, oldAttributeValue, "uniqueid");

		preferredValueOfMemberEmail = getText(preferredValueInMemberEmailSection);
		sourceOriginOfMemberEmail = getText(sourceOriginValueInMemberEmailSection);
		sourceChannelOfMemberEmail = getText(sourceChannelValueInMemberEmailSection);

		verifyTheEmailDetailsInMemberContactInformationPage(newEmailAddress);
	}

	/* This method to validate the reset in member email section */
	public void verifyResetInMemberEmailSection() {
		String oldAttributeValue = isEmailPreferencesUpdated.getAttribute("uniqueid");
		newEmailAddress = generateRandomEmail();
		currentEmailAddress = getAttributeValue(emailAddressValueInMemberEmailSection, "value");
		enterTheText(emailAddressValueInMemberEmailSection, newEmailAddress);
		clickAnElement(resetInMemberEmailSection);
		waitTillAttributeValueChanges(isEmailPreferencesUpdated, oldAttributeValue, "uniqueid");
		compareTexts(currentEmailAddress, getAttributeValue(emailAddressValueInMemberEmailSection, "value"));
	}

	/*
	 * This method is verify the updated email address in member contact information
	 * page.
	 */
	public void verifyTheEmailDetailsInMemberContactInformationPage(String emailAddress) {
		compareTexts(emailAddress, getAttributeValue(emailAddressValueInMemberEmailSection, "value"));
		compareTexts(userName, getText(updatedByValueInMemberEmailSection));
		containsTexts(getText(updatedDateTimeStampValueInMemberEmailSection), todaysDate);
	}

	/* This method is to navigate to email history page */
	public void navigateToMemberEmailHistoryPage() {
		clickAnElement(viewHistoryInMemberEmailSection);
		commercialMemberEmailSearchHistory.validateEmailSearchHistoryPage();
	}

	/* This method is to verify the updated email details in email history page. */
	public void verifyTheEmailDetailsInEmailHistoryPage() {
		commercialMemberEmailSearchHistory.verifyTheEmailDetailsInHistorySearchPage(preferredValueOfMemberEmail,
				newEmailAddress, sourceChannelOfMemberEmail, sourceOriginOfMemberEmail, userName,
				estTodaysDateForEmailHistoryPage());
	}

	/* This method is to verify the existing email details in email history page. */
	public void verifyTheEmailDetailsInEmailHistoryPage(String preferredValueOfMemberEmail, String EmailAddress,
			String sourceChannelOfMemberEmail, String sourceOriginOfMemberEmail, String userName, String todaysDate) {
		commercialMemberEmailSearchHistory.verifyTheEmailDetailsInHistorySearchPage(preferredValueOfMemberEmail,
				EmailAddress, sourceChannelOfMemberEmail, sourceOriginOfMemberEmail, userName, todaysDate);
	}

	/*
	 * This method is to verify telephone details in member telephone number
	 * section.
	 */
	public void validatePhoneDetailsInMemberInformationPage(String phoneType, String preferredValue, String phoneNumber,
			String sales, String nonSales, String sourceChannel, String sourceOrigin, String updatedBy,
			String updatedDate) {

		scrollDown(250);

		if (preferredValue != null) {
			compareTexts(preferredValue, getText(preferredInMemberTelephoneNumbersSection));
		}
		if (phoneType != null) {
			compareTexts(phoneType, getText(phoneTypeInMemberTelephoneNumbersSection));
		}
		if (phoneNumber != null) {
			compareTexts(phoneNumber, getText(phoneNumberInMemberTelephoneNumbersSection));
		}
		if (sourceChannel != null) {
			compareTexts(sourceChannel, getText(sourceChannelInMemberTelephoneNumbersSection));
		}
		if (sourceOrigin != null) {
			compareTexts(sourceOrigin, getText(sourceOriginInMemberTelephoneNumbersSection));
		}
		if (updatedBy != null) {
			compareTexts(updatedBy, getText(updatedByInMemberTelephoneNumbersSection));
		}
		if (updatedDate != null) {
			compareTexts(updatedDate, getText(updatedDateInMemberTelephoneNumbersSection));
		}
		if (sales != null) {
			compareTexts(sales, getText(salesValue));
		}
		if (nonSales != null) {
			compareTexts(nonSales, getText(nonSalesValue));
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

		currentNonSalesPreferenceValue = getText(nonSalesValue);
		if (currentNonSalesPreferenceValue.equalsIgnoreCase(value1)) {
			selectDropDownValueByText(nonSalesDropDownInMemberTelephoneNumbersSection, value2);
			clickAnElement(applyInMemberTelephoneNumbersSection);
			clickAnElement(yesInUpdatePreferenceDialog);
			newValue = value2;
			waitTillAttributeValueChanges(isPhonePreferencesUpdated, attributeValue, "uniqueid");
			validateTheUpdatedDetails();
		} else if (currentNonSalesPreferenceValue.equalsIgnoreCase(value2)) {
			selectDropDownValueByText(nonSalesDropDownInMemberTelephoneNumbersSection, value1);
			clickAnElement(applyInMemberTelephoneNumbersSection);
			clickAnElement(yesInUpdatePreferenceDialog);
			newValue = value1;
			waitTillAttributeValueChanges(isPhonePreferencesUpdated, attributeValue, "uniqueid");
			validateTheUpdatedDetails();
		} else {
			Assert.fail("The phone number value is not set to either " + value1 + " or " + value2);
		}
		phoneNumber = getText(phoneNumberInMemberTelephoneNumbersSection);
	}

	/* This method is to validate the updated phone details. */
	public void validateTheUpdatedDetails() {
		waitForTheElementTobeAbsent(yesInUpdatePreferenceDialog);
		compareTexts(newValue, getText(nonSalesValue));
		compareTexts(userName, getText(updatedByInMemberTelephoneNumbersSection));
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

	/* This method is to navigate to phone history page */
	public void navigateToMemberPhoneHistoryPage() {
		clickAnElement(viewHistoryInMemberTelephoneNumbersSection);
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

		scrollDown(300);

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

	/* This method is to verify the member mailing address section details */
	public void validateMemberMailingDetailsInMemberInformationPage(String preferredValue, String mailingAddress,
			String sourceChannel, String sourceOrigin, String updatedBy, String updatedDate) {

		scrollDown(450);

		if (preferredValue != null) {
			compareTexts(preferredValue, getText(preferredInMemberTextNumberSection));
		}
		if (mailingAddress != null) {
			compareTexts(mailingAddress, getText(mailingAddressInMemberMailingAddressSection));
		}
		if (sourceChannel != null) {
			compareTexts(sourceChannel, getText(sourceChannelInMemberMailingAddressSection));
		}
		if (sourceOrigin != null) {
			compareTexts(sourceOrigin, getText(sourceOriginInMemberMailingAddressSection));
		}
		if (updatedBy != null) {
			compareTexts(updatedBy, getText(updatedByInMemberMailingAddressSection));
		}
		if (updatedDate != null) {
			compareTexts(updatedDate, getText(updatedDateInMemberMailingAddressSection));
		}
	}

	/* This method is to navigate to preference tab */
	public void navigateToMemberPreferenceTab() {
		clickAnElement(preferencesTab);
		commercialMemberInformationPreferences.validateMemberInformationPreferenceTab();
	}

}
