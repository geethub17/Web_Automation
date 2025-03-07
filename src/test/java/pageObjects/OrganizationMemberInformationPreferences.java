package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class GovernmentMemberInformationPreferences extends Utils {

	private WebDriver driver;
	private String updatedBy;
	private String updatedDate;
	private boolean noTextNumber = false;
	private String contactChannel;
	private String contactValue;
	

	public GovernmentMemberInformationPreferences(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	/*
	 * All elements of government member information preference page are captured.
	 */

	@FindBy(xpath = "//label[text()='Member Emails']")
	WebElement isContractInfoTabLoaded;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pPrefInfo$l1']//td[@data-attribute-name='Email']//div//img[@role='link']")
	WebElement emailInHelpfulInformation;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pPrefInfo$l1']//td[@data-attribute-name='Text']//div//img[@role='link']")
	WebElement textlInHelpfulInformation;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pPrefInfo$l1']//a[text()='Clear Selection']")
	WebElement clearSelectionInHelpfulInformation;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pPrefInfo$l1']//a[text()='View History']")
	WebElement viewHistoryInHelpfulInformation;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pPrefInfo$l2']//td[@data-attribute-name='Email']//div//img[@role='link']")
	WebElement emailInEcert;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pPrefInfo$l2']//td[@data-attribute-name='Mail']//div//img[@role='link']")
	WebElement mailInEcert;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pPrefInfo$l2']//a[text()='View History']")
	WebElement viewHistoryInEcert;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pPrefInfo$l3']//td[@data-attribute-name='Email']//div//img[@role='link']")
	WebElement emailInEob;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pPrefInfo$l3']//td[@data-attribute-name='Mail']//div//img[@role='link']")
	WebElement mailInEob;

	@FindBy(xpath = "//tr[@id='$PpyWorkPage$pMemberDetails$pPrefInfo$l3']//a[text()='View History']")
	WebElement viewHistoryInEob;

	@FindBy(xpath = "//div[text()='Reset']")
	WebElement resetInPreference;

	@FindBy(xpath = "//div[text()='Submit']")
	WebElement submitInPreference;

	@FindBy(xpath = "//div[text()='Preferences Updated Successfully.']")
	WebElement preferenceUpdateSuccessfulMessage;

	@FindBy(xpath = "//div[text()='Please update minimum one preference to continue.']")
	WebElement errorMessageWhileUpdatingWithoutChnagingPreference;

	@FindBy(xpath = "//h3[text()='Contact Info']")
	WebElement contactInfoTab;

	@FindBy(xpath = "//div[@data-node-id='GovtMbrPreferencesInfo'][contains(@uniqueid, SID)]")
	WebElement isPreferenceValueSelected;
	
	@FindBy(xpath = "//div[text()='There is no preferred Text Number.']")
	WebElement noPreferenceTextNumber;
	
	@FindBy(xpath = "//div[text()='Yes']")
	WebElement yesInConfirmUpdatesForPhone;

	/* This method is update the member preferences */
	public void updatedAndVerifyTheSuccessMessageInMemberpreferences(String preference) {
		if (preference.equalsIgnoreCase("hepfulInformation")) {
			updateTheMemberpreferences(emailInHelpfulInformation, textlInHelpfulInformation);
		}
		if (preference.equalsIgnoreCase("eCert")) {
			updateTheMemberpreferences(emailInEcert, mailInEcert);
		}
		if (preference.equalsIgnoreCase("eob")) {
			updateTheMemberpreferences(emailInEob, mailInEob);
		}
	}

	/* This method is to update and validate the member preferences */
	public void updateTheMemberpreferences(WebElement preference1, WebElement preference2) {
		updatedBy = propertiesReader.getUserName();
		updatedDate = estTodaysDate();
		String preferenceAttributeValue = isPreferenceValueSelected.getAttribute("uniqueid");

		if (isElementDisplaying(preference1)) {
			clickAnElement(preference1);
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
			if (isTextNumberAvailable(noPreferenceTextNumber)) {
				// If text number doesn't exists then it won't perform any update.
			} else {
				waitTillAttributeValueChanges(isPreferenceValueSelected, preferenceAttributeValue, "uniqueid");
				clickOnUpdate();
				validateUpdateSuccessfulMessage();
				captureTheContactChannelAndContactValues(preference2);
				noTextNumber = false;
			}
		}else {
			noTextNumber = true;
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
		} 
	}

	/* This method is to navigate to EOB preference history screen */
	public void navigateToEOBPrefrenceHistoryScreen() {
		if (!noTextNumber) {
		clickAnElement(viewHistoryInEob);
		preferenceSearchHistory.validatePreferenceSearchHistoryPage();
		}
	}

	/*
	 * This method is to navigate to E-cert preference history
	 * screen
	 */
	public void navigateToEcertPrefrenceHistoryScreen() {
		if (!noTextNumber) {
			clickAnElement(viewHistoryInEcert);
			preferenceSearchHistory.validatePreferenceSearchHistoryPage();
		}
	}

	/* This method is to navigate to helpful information preference history screen */
	public void navigateToHelpFulInformationPrefrenceHistoryScreen() {
		if (!noTextNumber) {
		clickAnElement(viewHistoryInHelpfulInformation);
		preferenceSearchHistory.validatePreferenceSearchHistoryPage();
		}
	}

	/* This method is validate the clear selection */
	public void validateClearSelection() {
		clickAnElement(clearSelectionInHelpfulInformation);
		String clearSelectionAttributeValue = isPreferenceValueSelected.getAttribute("uniqueid");
		waitTillAttributeValueChanges(isPreferenceValueSelected, clearSelectionAttributeValue, "uniqueid");
		isElementDisplayingOrNot(emailInHelpfulInformation);
		isElementDisplayingOrNot(textlInHelpfulInformation);
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
	
	/* This method is navigate back to member information screen */
	public void navigateBackToMemberInformationScreen() {
		if (!noTextNumber) {
			preferenceSearchHistory.backToMemberContactInformationPages();
		}
	}

}
