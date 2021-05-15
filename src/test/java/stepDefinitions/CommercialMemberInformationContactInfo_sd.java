package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommercialMemberInformationContactInfo_sd extends BaseClass {

	@Then("validate the member details {string} , {string} , {string}, {string}, {string} , {string}, {string}, {string}, {string} and {string} in member contact information page")
	public void validate_the_member_details_and_in_member_contact_information_page(String string, String string2,
			String string3, String string4, String string5, String string6, String string7, String string8,
			String string9, String string10) {
		commercialMemberInformationContactInfo.validateMemberDetailsInMemberInformationPage(
				fieldsAndValues.get("firstName"), fieldsAndValues.get("lastName"), fieldsAndValues.get("dob"),
				fieldsAndValues.get("seqNumber"), fieldsAndValues.get("groupNumber"),
				fieldsAndValues.get("sourceSystem"), fieldsAndValues.get("memberStatus"),
				fieldsAndValues.get("preferredEmail"), fieldsAndValues.get("preferredMailingAddress"),
				fieldsAndValues.get("preferredTelephone"), fieldsAndValues.get("preferredText"));
	}

	@Then("validate the email details {string}, {string}, {string}, {string}, {string}, {string}, {string} in member email section in member contact information page")
	public void validate_the_email_details_in_member_email_section_in_member_contact_information_page(String string,
			String string2, String string3, String string4, String string5, String string6, String string7) {
		commercialMemberInformationContactInfo.validateEmailDetailsInMemberInformationPage(
				fieldsAndValues.get("emailPreferredValue"), fieldsAndValues.get("emailAddress"),
				fieldsAndValues.get("emailStatus"), fieldsAndValues.get("sourceChannel"),
				fieldsAndValues.get("sourceOrigin"), fieldsAndValues.get("updatedBy"),
				fieldsAndValues.get("updatedDateAndTimeInMemberInformation"));
	}

	@Then("navigate to email history page")
	public void navigate_to_email_history_page() {
		commercialMemberInformationContactInfo.navigateToMemberEmailHistoryPage();
	}

	@Then("search for the specific dates {string}, {string} in email history page")
	public void search_for_the_specific_dates_in_email_history_page(String string, String string2) {
		commercialMemberEmailSearchHistory.searchForHistoryWithSpecificDates(fieldsAndValues.get("fromDate"),
				fieldsAndValues.get("endDate"));
	}

	@Then("enter the new {string} and click on reset and verify in member contact information page")
	public void enter_the_new_and_click_on_reset_and_verify_in_member_contact_information_page(String string) {
		commercialMemberInformationContactInfo.verifyResetInMemberEmailSection();
	}

	@Then("update and validate the {string} in member contact information page")
	public void update_and_validate_the_in_member_contact_information_page(String string) {
		commercialMemberInformationContactInfo.updateAndVerifyTheEmailAddress();
	}

	@Then("verify the email details in email history page")
	public void verify_the_email_details_in_email_history_page() {
		commercialMemberEmailSearchHistory.verifyTheEmailDetailsInHistorySearchPage(
				fieldsAndValues.get("emailPreferredValue"), fieldsAndValues.get("emailAddress"),
				fieldsAndValues.get("sourceChannel"), fieldsAndValues.get("sourceOrigin"),
				fieldsAndValues.get("updatedBy"), fieldsAndValues.get("updatedDateAndTimeInEmailHistory"));
	}

	@Then("verify the updated email details in email history page")
	public void verify_the_updated_email_details_in_email_history_page() {
		commercialMemberInformationContactInfo.verifyTheEmailDetailsInEmailHistoryPage();
	}

	@Then("click on back to member information page in email history page")
	public void click_on_back_to_member_information_page_in_email_history_page() {
		commercialMemberEmailSearchHistory.backToMemberContactInformationPage();
	}

	@Then("verify the phone number details {string},  {string}, {string}, {string}, {string}, {string}, {string}, {string} in member contact information page")
	public void verify_the_phone_number_details_in_member_contact_information_page(String string, String string2,
			String string3, String string4, String string5, String string6, String string7, String string8) {
		commercialMemberInformationContactInfo.validatePhoneDetailsInMemberInformationPage(
				fieldsAndValues.get("phoneType"), fieldsAndValues.get("phonePreferredValue"),
				fieldsAndValues.get("phoneNumber"), fieldsAndValues.get("salesValue"),
				fieldsAndValues.get("nonSalesValue"), fieldsAndValues.get("sourceChannel"),
				fieldsAndValues.get("sourceOrigin"), fieldsAndValues.get("updatedBy"),
				fieldsAndValues.get("updatedDate"));
	}

	@Then("navigate to phone history page")
	public void navigate_to_phone_history_page() {
		commercialMemberInformationContactInfo.navigateToMemberPhoneHistoryPage();
	}

	@Then("search for the specific dates {string}, {string} in phone history page")
	public void search_for_the_specific_dates_in_phone_history_page(String string, String string2) {
		phoneSearchHistory.searchForHistoryWithSpecificDates(fieldsAndValues.get("fromDate"),
				fieldsAndValues.get("endDate"));
	}

	@Then("verify the existing details {string}, {string}, {string}, {string}, {string} in phone history page")
	public void verify_the_existing_details_in_phone_history_page(String string, String string2, String string3,
			String string4, String string5) {
		commercialMemberInformationContactInfo.verifyThePhoneDetailsInPhoneHistoryPage(
				fieldsAndValues.get("phoneNumber"), fieldsAndValues.get("nonSalesValue"),
				fieldsAndValues.get("updatedBy"), fieldsAndValues.get("updatedDate"));
	}

	@Then("verify the updated details in phone history table through member information page")
	public void verify_the_updated_details_in_phone_history_table_through_member_information_page() {
		commercialMemberInformationContactInfo.verifyThePhoneDetailsInPhoneHistoryPage();
	}

	@Then("update and validate the phone number non-sales preference with {string} and {string} details in member contact information page")
	public void update_and_validate_the_phone_number_non_sales_preference_with_and_details_in_member_contact_information_page(
			String string, String string2) {
		commercialMemberInformationContactInfo.updateAndVerifyThePhoneDetails(fieldsAndValues.get("value1"),
				fieldsAndValues.get("value2"));
	}

	@Then("if the non-sales value is consent then the reconfirm checkbox should be enabled else disabled in member contact information page")
	public void if_the_non_sales_value_is_consent_then_the_reconfirm_checkbox_should_be_enabled_else_disabled_in_member_contact_information_page() {
		commercialMemberInformationContactInfo.validateReconfirmationCheckBox();
	}

	@Given("validate the member text number details {string}, {string}, {string},  {string}, {string}, {string}  in member contact information page")
	public void validate_the_member_text_number_details_in_member_contact_information_page(String string,
			String string2, String string3, String string4, String string5, String string6) {
		commercialMemberInformationContactInfo.validateMemberTextDetailsInMemberInformationPage(
				fieldsAndValues.get("preferredValueOfText"), fieldsAndValues.get("phoneNumberOfText"),
				fieldsAndValues.get("sourceChannelOfText"), fieldsAndValues.get("sourceOriginOfText"),
				fieldsAndValues.get("updatedByInText"), fieldsAndValues.get("updatedDateInText"));
	}

	@Given("validate the member mailing address details {string}, {string}, {string},  {string}, {string}, \"<updatedDate>\"in member contact information page")
	public void validate_the_member_mailing_address_details_updated_date_in_member_contact_information_page(
			String string, String string2, String string3, String string4, String string5) {
		commercialMemberInformationContactInfo.validateMemberMailingDetailsInMemberInformationPage(
				fieldsAndValues.get("preferredValueOfMailing"), fieldsAndValues.get("addressOfMailing"),
				fieldsAndValues.get("sourceChannelOfMailing"), fieldsAndValues.get("sourceOriginOfMailing"),
				fieldsAndValues.get("updatedByInMailing"), fieldsAndValues.get("updatedDateInMailing"));
	}

}
