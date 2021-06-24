package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class CommercialMemberInformationPreferences extends Utils {

	private WebDriver driver;
	private String contactChannel;
	private String contactValue;
	private String updatedBy;
	private String updatedDate;
	private String currentSpokenLanguage;
	private String currentWrittenLanguage;
	private String newWrittenLanguage;
	private String newSpokenLanguage;
	private boolean noTextNumber = false;

	public CommercialMemberInformationPreferences(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	/*
	 * All elements of commercial member information preference page are captured.
	 */

	@FindBy(xpath = "//span[text()='Explanation of Benefits (EOBs)']")
	WebElement isPreferenceTabLoaded;

	@FindBy(xpath = "//label[text()='Member Emails']")
	WebElement isContractInfoTabLoaded;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l1']//td[@data-attribute-name='Email']//div//img[@role='link']")
	WebElement emailInEcert;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l1']//td[@data-attribute-name='Mail']//div//img[@role='link']")
	WebElement mailInEcert;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l1']//td[@data-attribute-name='Phone']//div//img[@role='link']")
	WebElement phoneInEcert;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l1']//td[@data-attribute-name='Text']//div//img[@role='link']")
	WebElement textlInEcert;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l2']//td[@data-attribute-name='Email']//div//img[@role='link']")
	WebElement emailInEOB;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l2']//td[@data-attribute-name='Mail']//div//img[@role='link']")
	WebElement mailInEOB;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l2']//td[@data-attribute-name='Phone']//div//img[@role='link']")
	WebElement phoneInEOB;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l2']//td[@data-attribute-name='Text']//div//img[@role='link']")
	WebElement textlInEOB;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l3']//td[@data-attribute-name='Email']//div//img[@role='link']")
	WebElement emailInMonthlyBill;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l3']//td[@data-attribute-name='Mail']//div//img[@role='link']")
	WebElement mailInMonthlyBill;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l3']//td[@data-attribute-name='Phone']//div//img[@role='link']")
	WebElement phoneInMonthlyBill;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l3']//td[@data-attribute-name='Text']//div//img[@role='link']")
	WebElement textlInMonthlyBill;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l7']//td[@data-attribute-name='Email']//div//img[@role='link']")
	WebElement emailInHelpful;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l7']//td[@data-attribute-name='Mail']//div//img[@role='link']")
	WebElement mailInHelpful;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l7']//td[@data-attribute-name='Phone']//div//img[@role='link']")
	WebElement phoneInHelpful;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l7']//td[@data-attribute-name='Text']//div//img[@role='link']")
	WebElement textlInHelpful;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l8']//td[@data-attribute-name='Email']//div//img[@role='link']")
	WebElement emailInStatusUpdate;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l8']//td[@data-attribute-name='Mail']//div//img[@role='link']")
	WebElement mailInStatusUpdate;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l8']//td[@data-attribute-name='Phone']//div//img[@role='link']")
	WebElement phoneInStatusUpdate;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l8']//td[@data-attribute-name='Text']//div//img[@role='link']")
	WebElement textlInStatusUpdate;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l9']//td[@data-attribute-name='Email']//div//img[@role='link']")
	WebElement emailInPaymentReminder;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l9']//td[@data-attribute-name='Mail']//div//img[@role='link']")
	WebElement mailInPaymentReminder;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l9']//td[@data-attribute-name='Phone']//div//img[@role='link']")
	WebElement phoneInPaymentReminder;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l9']//td[@data-attribute-name='Text']//div//img[@role='link']")
	WebElement textlInPaymentReminder;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l4']//td[@data-attribute-name='Email']//div//img[@role='link']")
	WebElement emailInPreventativeCare;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l4']//td[@data-attribute-name='Mail']//div//img[@role='link']")
	WebElement mailInPreventativeCare;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l4']//td[@data-attribute-name='Phone']//div//img[@role='link']")
	WebElement phoneInPreventativeCare;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l4']//td[@data-attribute-name='Text']//div//img[@role='link']")
	WebElement textlInPreventativeCare;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l5']//td[@data-attribute-name='Email']//div//img[@role='link']")
	WebElement emailInHealthAndWellnessPrograms;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l5']//td[@data-attribute-name='Mail']//div//img[@role='link']")
	WebElement mailInHealthAndWellnessPrograms;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l5']//td[@data-attribute-name='Phone']//div//img[@role='link']")
	WebElement phoneInHealthAndWellnessPrograms;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l5']//td[@data-attribute-name='Text']//div//img[@role='link']")
	WebElement textlInHealthAndWellnessPrograms;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l6']//td[@data-attribute-name='Email']//div//img[@role='link']")
	WebElement emailInHealthAndWellnessInformation;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l6']//td[@data-attribute-name='Mail']//div//img[@role='link']")
	WebElement mailInHealthAndWellnessInformation;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l6']//td[@data-attribute-name='Phone']//div//img[@role='link']")
	WebElement phoneInHealthAndWellnessInformation;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l6']//td[@data-attribute-name='Text']//div//img[@role='link']")
	WebElement textlInHealthAndWellnessInformation;

	@FindBy(id = "MbrSpokenLanguage")
	WebElement memberSpokenLanguageDropDown;

	@FindBy(id = "MbrWrittenLanguage")
	WebElement memberWrittenLanguageDropDown;

	@FindBy(css = "select[id='MbrSpokenLanguage']>option[selected]")
	WebElement selectedMemberSpokenLanguage;

	@FindBy(css = "select[id='MbrWrittenLanguage']>option[selected]")
	WebElement selectedMemberWrittenLanguage;

	@FindBy(xpath = "//div[text()='Reset']")
	WebElement resetInPreference;

	@FindBy(xpath = "//div[text()='Submit']")
	WebElement submitInPreference;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l1']//a[text()='View History']")
	WebElement viewHistoryInEcert;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l2']//a[text()='View History']")
	WebElement viewHistoryInEob;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l3']//a[text()='View History']")
	WebElement viewHistoryInMonthlyBill;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l7']//a[text()='View History']")
	WebElement viewHistoryInHelpfulInformation;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l7']//a[text()='Clear Selection']")
	WebElement clearSelectionInHelpfulInformation;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l8']//a[text()='View History']")
	WebElement viewHistoryInStatusUpdatesOptional;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l8']//a[text()='Clear Selection']")
	WebElement clearSelectionInStatusUpdated;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l9']//a[text()='View History']")
	WebElement viewHistoryInPaymentReminder;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l9']//a[text()='Clear Selection']")
	WebElement clearSelectionInPaymentReminder;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l4']//a[text()='View History']")
	WebElement viewHistoryInPreventativeCare;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l5']//a[text()='View History']")
	WebElement viewHistoryInHealthAndWellnessPrograms;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l5']//a[text()='Clear Selection']")
	WebElement clearSelectionInHealthAndWellnessPrograms;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l6']//a[text()='View History']")
	WebElement viewHistoryInHealthAndWellnessInformation;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pCommercialMember$pPrefInfo$l6']//a[text()='Clear Selection']")
	WebElement clearSelectionInHealthAndWellnessInformation;

	@FindBy(xpath = "//div[@data-node-id='PreferencesInfo'][contains(@uniqueid, SID)]")
	WebElement isPreferenceValueSelected;

	@FindBy(xpath = "//div[text()='Preferences Updated Successfully.']")
	WebElement preferenceUpdateSuccessfulMessage;

	@FindBy(xpath = "//div[text()='Please update minimum one preference to continue.']")
	WebElement errorMessageWhileUpdatingWithoutChnagingPreference;

	@FindBy(xpath = "//h3[text()='Contact Info']")
	WebElement contactInfoTab;

	@FindBy(xpath = "//div[text()='Yes']")
	WebElement yesInConfirmUpdatesForPhone;

	@FindBy(xpath = "//div[text()='There is no preferred Text Number.']")
	WebElement noPreferenceTextNumber;

	/* This method is to validate the member preference tab . */
	public void validateMemberInformationPreferenceTab() {
		verifyThePageTitle("Explanation of Benefits (EOBs)", isPreferenceTabLoaded);
	}

	/* This method is update the member preferences */
	public void updatedAndVerifyTheSuccessMessageInMemberpreferences(String preference) {
		if (preference.equalsIgnoreCase("eob")) {
			updateTheMemberpreferences(emailInEOB, mailInEOB);
		}
		if (preference.equalsIgnoreCase("statusUpdatesOptional")) {
			scrollDown(250);
			updateTheMemberpreferences(emailInStatusUpdate, textlInStatusUpdate);
		}
		if (preference.equalsIgnoreCase("preventiveCare")) {
			scrollDown(300);
			updateTheMemberpreferences(mailInPreventativeCare, phoneInPreventativeCare);
		}
		if (preference.equalsIgnoreCase("healthAndWellness")) {
			scrollDown(400);
			updateTheMemberpreferences(emailInHealthAndWellnessInformation, textlInHealthAndWellnessInformation);
		}
	}

	/* This method is to update and validate the member preferences */
	public void updateTheMemberpreferences(WebElement preference1, WebElement preference2) {
		updatedBy = propertiesReader.getUserName();
		updatedDate = estTodaysDate();
		String preferenceAttributeValue = isPreferenceValueSelected.getAttribute("uniqueid");

		if (isElementDisplaying(preference1)) {
			clickAnElement(preference1);
			clickOnYesInIfConfirmUpdatePopUpIsDisplayed(preference1);
			if (isTextNumberAvailable(noPreferenceTextNumber)) {
				// If text number doesn't exists then it won't perform any update.
			} else {
				waitTillAttributeValueChanges(isPreferenceValueSelected, preferenceAttributeValue, "uniqueid");
				clickOnUpdate();
				validateUpdateSuccessfulMessage();
				captureTheContactChannelAndContactValues(preference1);
				noTextNumber = false;
			}
		} else if (isElementDisplaying(preference2)) {
			clickAnElement(preference2);
			clickOnYesInIfConfirmUpdatePopUpIsDisplayed(preference2);
			if (isTextNumberAvailable(noPreferenceTextNumber)) {
				// If text number doesn't exists then it won't perform any update.
			} else {
				waitTillAttributeValueChanges(isPreferenceValueSelected, preferenceAttributeValue, "uniqueid");
				clickOnUpdate();
				validateUpdateSuccessfulMessage();
				captureTheContactChannelAndContactValues(preference2);
				noTextNumber = false;
			}
		}
	}

	/*
	 * This method is to check the confirm update pop-up on clicking the phone
	 * preference.It displays when phone preference value is set to DNC.
	 */
	public void clickOnYesInIfConfirmUpdatePopUpIsDisplayed(WebElement element) {
		if (element.toString().toLowerCase().contains("phone")) {
			if (isElementDisplaying(yesInConfirmUpdatesForPhone)) {
				clickAnElement(yesInConfirmUpdatesForPhone);
			}
		}
	}

	/* This method returns to if the text number is not exists else false. */
	public boolean isTextNumberAvailable(WebElement element) {
		if (element.toString().toLowerCase().contains("text")) {
			if (isElementDisplaying(noPreferenceTextNumber)) {
				noTextNumber = true;
				clickAnElement(resetInPreference);
				waitForTheElementTobeAbsent(resetInPreference);
				return true;
			}
		}
		return false;
	}

	/* This method is to click on submit button */
	public void clickOnUpdate() {
		String updateAttributeValue = isPreferenceValueSelected.getAttribute("uniqueid");
		clickAnElement(submitInPreference);
		waitTillAttributeValueChanges(isPreferenceValueSelected, updateAttributeValue, "uniqueid");
	}

	/* This method is to validate the update successful message. */
	public void validateUpdateSuccessfulMessage() {
		compareTexts("Preferences Updated Successfully.", getText(preferenceUpdateSuccessfulMessage));
	}

	/* This method is to click on reset button */
	public void clickOnReset() {
		String resetAttributeValue = isPreferenceValueSelected.getAttribute("uniqueid");
		scrollUp(200);
		clickAnElement(resetInPreference);
		waitTillAttributeValueChanges(isPreferenceValueSelected, resetAttributeValue, "uniqueid");
	}

	/* This method is to capture the contact channel and contact value */
	public void captureTheContactChannelAndContactValues(WebElement element) {
		if (element.toString().toLowerCase().contains("email")) {
			contactChannel = "Email";
			contactValue = getText(commercialMemberInformationContactInfo.preferredEmailInMemberInformationSection);
		} else if (element.toString().toLowerCase().contains("mail")) {
			contactChannel = "Address";
			contactValue = getText(
					commercialMemberInformationContactInfo.preferredEmailAddressLine1InMemberInformationSection);
		} else if (element.toString().toLowerCase().contains("text")) {
			contactChannel = "Text";
			contactValue = getText(commercialMemberInformationContactInfo.preferredTextInMemberInformationSection);
		} else if (element.toString().toLowerCase().contains("phone")) {
			contactChannel = "Telephone";
			contactValue = getText(
					commercialMemberInformationContactInfo.preferrredTelephoneNumberInMemberInformationSection);
		}
	}

	/* This method is to navigate to EOB preference history screen */
	public void navigateToEOBPrefrenceHistoryScreen() {
		clickAnElement(viewHistoryInEob);
		preferenceSearchHistory.validatePreferenceSearchHistoryPage();
	}

	/*
	 * This method is to navigate to status updates (optional) preference history
	 * screen
	 */
	public void navigateToStatusUpdatesOptionalPrefrenceHistoryScreen() {
		if (!noTextNumber) {
			clickAnElement(viewHistoryInStatusUpdatesOptional);
			preferenceSearchHistory.validatePreferenceSearchHistoryPage();
		}
	}

	/* This method is to navigate to preventive care preference history screen */
	public void navigateToPreventiveCarePrefrenceHistoryScreen() {
		clickAnElement(viewHistoryInPreventativeCare);
		preferenceSearchHistory.validatePreferenceSearchHistoryPage();
	}

	/*
	 * This method is to navigate to wellness information preference history screen
	 */
	public void navigateToWellnessInformationPrefrenceHistoryScreen() {
		if (!noTextNumber) {
			clickAnElement(viewHistoryInHealthAndWellnessInformation);
			preferenceSearchHistory.validatePreferenceSearchHistoryPage();
		}
	}

	/*
	 * This method is to navigate to wellness information program history screen
	 */
	public void navigateToWellnessInformationProgramHistoryScreen() {
		if (!noTextNumber) {
			clickAnElement(viewHistoryInHealthAndWellnessPrograms);
			preferenceSearchHistory.validatePreferenceSearchHistoryPage();
		}
	}

	/* This method is validate the clear selection */
	public void validateClearSelection() {
		scrollDown(400);
		clickAnElement(clearSelectionInHealthAndWellnessPrograms);
		String clearSelectionAttributeValue = isPreferenceValueSelected.getAttribute("uniqueid");
		waitTillAttributeValueChanges(isPreferenceValueSelected, clearSelectionAttributeValue, "uniqueid");
		isElementDisplayingOrNot(emailInHealthAndWellnessPrograms);
		isElementDisplayingOrNot(mailInHealthAndWellnessPrograms);
		isElementDisplayingOrNot(phoneInHealthAndWellnessPrograms);
		isElementDisplayingOrNot(textlInHealthAndWellnessPrograms);

	}

	/*
	 * This method is to validate the updated details in preference search history
	 * page
	 */
	public void validateTheUpdatedPreferenceDetailsInPreferenceSearchHistory() {
		if (!noTextNumber) {
			preferenceSearchHistory.verifyTheUpdatePreferenceDetailsInHistorySearchPage(contactChannel, contactValue,
					"Contact Preference Shared User Interface", "CPSUI", updatedBy, updatedDate);
		}
	}

	/* This method is to select the spoken and written languages. */
	public void selectSpokenAndWrittenLanguages(String language1, String language2) {
		scrollDown(450);

		currentSpokenLanguage = getText(selectedMemberSpokenLanguage);
		currentWrittenLanguage = getText(selectedMemberWrittenLanguage);

		String spokenLanguageAttributeValue = isPreferenceValueSelected.getAttribute("uniqueid");

		if (currentSpokenLanguage.equalsIgnoreCase(language1)) {
			selectDropDownValueByText(memberSpokenLanguageDropDown, language2);
			newSpokenLanguage = language2;
			waitTillAttributeValueChanges(isPreferenceValueSelected, spokenLanguageAttributeValue, "uniqueid");
		} else {
			selectDropDownValueByText(memberSpokenLanguageDropDown, language1);
			newSpokenLanguage = language1;
			waitTillAttributeValueChanges(isPreferenceValueSelected, spokenLanguageAttributeValue, "uniqueid");
		}

		String writtenLanguageAttributeValue = isPreferenceValueSelected.getAttribute("uniqueid");

		if (currentWrittenLanguage.equalsIgnoreCase(language1)) {
			selectDropDownValueByText(memberWrittenLanguageDropDown, language2);
			newWrittenLanguage = language2;
			waitTillAttributeValueChanges(isPreferenceValueSelected, writtenLanguageAttributeValue, "uniqueid");
		} else {
			selectDropDownValueByText(memberWrittenLanguageDropDown, language1);
			newWrittenLanguage = language1;
			waitTillAttributeValueChanges(isPreferenceValueSelected, writtenLanguageAttributeValue, "uniqueid");
		}
	}

	/* This method is to validate the selected spoken and written languages. */
	public void validateTheSelectedSpokenAndWrittenLanguses() {
		compareTexts(currentSpokenLanguage, getText(selectedMemberSpokenLanguage));
		compareTexts(currentWrittenLanguage, getText(selectedMemberWrittenLanguage));
	}

	/* This method is to validate the updated spoken and written languages. */
	public void validateTheUpdatedSpokenAndWrittenLanguses() {
		compareTexts(newSpokenLanguage, getText(selectedMemberSpokenLanguage));
		compareTexts(newWrittenLanguage, getText(selectedMemberWrittenLanguage));
	}

	/* This method is to validate the error message */
	public void validateErrorMessage(String errorMessage) {
		compareTexts(errorMessage, getText(errorMessageWhileUpdatingWithoutChnagingPreference));
	}

	/* This method is navigate back to member information screen */
	public void navigateBackToMemberInformationScreen() {
		if (!noTextNumber) {
			preferenceSearchHistory.backToMemberContactInformationPages();
		}
	}

	/*
	 * This method is to validate all preference options in wellness programs
	 * section
	 */
	public void updateAndValidateAllPreferencesInWellnessProgramsSection() {
		updatedBy = propertiesReader.getUserName();
		updatedDate = estTodaysDate();
		String preferenceAttributeValue = isPreferenceValueSelected.getAttribute("uniqueid");

		boolean mail = false, email = false, text = false, phone = false;

		for (int i = 0; i <= 3; i++) {

			scrollDown(450);

			if (mail == false && isElementDisplaying(mailInHealthAndWellnessPrograms)) {
				clickAnElement(mailInHealthAndWellnessPrograms);
				clickOnYesInIfConfirmUpdatePopUpIsDisplayed(mailInHealthAndWellnessPrograms);
				if (isTextNumberAvailable(noPreferenceTextNumber)) {
					// If text number doesn't exists then it won't perform any update.
				} else {
					waitTillAttributeValueChanges(isPreferenceValueSelected, preferenceAttributeValue, "uniqueid");
					clickOnUpdate();
					validateUpdateSuccessfulMessage();
					captureTheContactChannelAndContactValues(mailInHealthAndWellnessPrograms);
					navigateToHistoryAndValidate();
					noTextNumber = false;
					mail = true;
				}
			} else if (email == false && isElementDisplaying(emailInHealthAndWellnessPrograms)) {
				clickAnElement(emailInHealthAndWellnessPrograms);
				clickOnYesInIfConfirmUpdatePopUpIsDisplayed(emailInHealthAndWellnessPrograms);
				if (isTextNumberAvailable(noPreferenceTextNumber)) {
					// If text number doesn't exists then it won't perform any update.
				} else {
					waitTillAttributeValueChanges(isPreferenceValueSelected, preferenceAttributeValue, "uniqueid");
					clickOnUpdate();
					validateUpdateSuccessfulMessage();
					captureTheContactChannelAndContactValues(emailInHealthAndWellnessPrograms);
					navigateToHistoryAndValidate();
					noTextNumber = false;
					email = true;
				}
			} else if (phone == false && isElementDisplaying(phoneInHealthAndWellnessPrograms)) {
				clickAnElement(phoneInHealthAndWellnessPrograms);
				clickOnYesInIfConfirmUpdatePopUpIsDisplayed(phoneInHealthAndWellnessPrograms);
				if (isTextNumberAvailable(noPreferenceTextNumber)) {
					// If text number doesn't exists then it won't perform any update.
				} else {
					waitTillAttributeValueChanges(isPreferenceValueSelected, preferenceAttributeValue, "uniqueid");
					clickOnUpdate();
					validateUpdateSuccessfulMessage();
					captureTheContactChannelAndContactValues(phoneInHealthAndWellnessPrograms);
					navigateToHistoryAndValidate();
					noTextNumber = false;
					phone = true;
				}
			} else if (text == false && isElementDisplaying(textlInHealthAndWellnessPrograms)) {
				clickAnElement(textlInHealthAndWellnessPrograms);
				clickOnYesInIfConfirmUpdatePopUpIsDisplayed(textlInHealthAndWellnessPrograms);
				if (isTextNumberAvailable(noPreferenceTextNumber)) {
					// If text number doesn't exists then it won't perform any update.
				} else {
					waitTillAttributeValueChanges(isPreferenceValueSelected, preferenceAttributeValue, "uniqueid");
					clickOnUpdate();
					validateUpdateSuccessfulMessage();
					captureTheContactChannelAndContactValues(textlInHealthAndWellnessPrograms);
					navigateToHistoryAndValidate();
					noTextNumber = false;
					text = true;
				}
			}
		}
	}

	/* This method is to navigate to history and validate details. */
	public void navigateToHistoryAndValidate() {
		navigateToWellnessInformationProgramHistoryScreen();
		validateTheUpdatedPreferenceDetailsInPreferenceSearchHistory();
		navigateBackToMemberInformationScreen();
		commercialMemberInformationContactInfo.navigateToMemberPreferenceTab();
	}
}
