package stepDefinitions;

import io.cucumber.java.en.Then;
import pageObjects.GovernmentMemberInformationContactInfo;

public class GovernmentMemberInformationContactInfo_sd extends BaseClass {

	@Then("validate the email details {string}, {string}, {string}, {string}, {string}, {string}, {string} in government member email section in member contact information page")
	public void validate_the_email_details_in_government_member_email_section_in_member_contact_information_page(
			String string, String string2, String string3, String string4, String string5, String string6,
			String string7) {
		governmentMemberInformationContactInfo.validateEmailDetailsInMemberInformationPage(
				fieldsAndValues.get("emailType"), fieldsAndValues.get("manualConfirmation"),
				fieldsAndValues.get("emailAddress"), fieldsAndValues.get("updatedBy"),
				fieldsAndValues.get("updatedDateAndTimeInMemberInformation"), fieldsAndValues.get("sourceChannel"),
				fieldsAndValues.get("sourceOrigin"));
	}

	@Then("navigate to government email history page")
	public void navigate_to_government_email_history_page() {
		governmentMemberInformationContactInfo.navigateToMemberEmailHistoryPage();
	}

	@Then("enter the new {string} and click on reset and verify in government member contact information page")
	public void enter_the_new_and_click_on_reset_and_verify_in_government_member_contact_information_page(
			String string) {
		governmentMemberInformationContactInfo.verifyResetInMemberEmailSection();
	}

	@Then("update and validate the {string} in government member contact information page")
	public void update_and_validate_the_in_government_member_contact_information_page(String string) {
		governmentMemberInformationContactInfo.updateAndVerifyTheEmailAddress();
	}

	@Then("verify the phone number details {string}, {string}, {string}, {string}, {string} in government member contact information page")
	public void verify_the_phone_number_details_in_government_member_contact_information_page(String string,
			String string2, String string3, String string4, String string5) {
		governmentMemberInformationContactInfo.validatePhoneDetailsInMemberInformationPage(
				fieldsAndValues.get("phoneNumber"), fieldsAndValues.get("salesValue"),
				fieldsAndValues.get("nonSalesValue"), fieldsAndValues.get("updatedBy"),
				fieldsAndValues.get("updatedDate"));
	}

	@Then("navigate to government phone history page")
	public void navigate_to_government_phone_history_page() {
		governmentMemberInformationContactInfo.navigateToMemberPhoneHistoryPage();
	}

	@Then("update and validate the phone number non-sales preference with {string} and {string} details in government member contact information page")
	public void update_and_validate_the_phone_number_non_sales_preference_with_and_details_in_government_member_contact_information_page(
			String string, String string2) {
		governmentMemberInformationContactInfo.updateAndVerifyThePhoneDetails(fieldsAndValues.get("value1"),
				fieldsAndValues.get("value2"));
	}

	@Then("if the non-sales value is consent then the reconfirm checkbox should be enabled else disabled in government member contact information page")
	public void if_the_non_sales_value_is_consent_then_the_reconfirm_checkbox_should_be_enabled_else_disabled_in_government_member_contact_information_page() {
		governmentMemberInformationContactInfo.validateReconfirmationCheckBox();
	}

	@Then("validate the member text number details {string}, {string}, {string},  {string}, {string}, {string}  in government member contact information page")
	public void validate_the_member_text_number_details_in_government_member_contact_information_page(String string,
			String string2, String string3, String string4, String string5, String string6) {
		governmentMemberInformationContactInfo.validateMemberTextDetailsInMemberInformationPage(
				fieldsAndValues.get("preferredValueOfText"), fieldsAndValues.get("phoneNumberOfText"),
				fieldsAndValues.get("sourceChannelOfText"), fieldsAndValues.get("sourceOriginOfText"),
				fieldsAndValues.get("updatedByIntext"), fieldsAndValues.get("updatedDateInText"));
	}
	
	@Then("verify the updated details in phone history table through government member information page")
	public void verify_the_updated_details_in_phone_history_table_through_government_member_information_page() {
		governmentMemberInformationContactInfo.verifyThePhoneDetailsInPhoneHistoryPage();
	}
	
	@Then("verify the existing details {string}, {string}, {string}, {string}, {string} in government member phone history page")
	public void verify_the_existing_details_in_phone_history_page(String string, String string2, String string3,
			String string4, String string5) {
		governmentMemberInformationContactInfo.verifyThePhoneDetailsInPhoneHistoryPage(
				fieldsAndValues.get("phoneNumber"), fieldsAndValues.get("nonSalesValue"),
				fieldsAndValues.get("updatedBy"), fieldsAndValues.get("updatedDateInPhoneHistory"));
	}

}
