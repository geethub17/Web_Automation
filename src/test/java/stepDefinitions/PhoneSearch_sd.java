package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import reader.ExcelReader;

public class PhoneSearch_sd extends BaseClass {
	
	@Given("get data from datasheet with \"(.*)\" and \"(.*)\"$")
	public void get_data_from_datasheet(String testId, String sheetName) {
		excelReader = new ExcelReader(testId, sheetName);
	}
	
	@Given("enter the {string} and search for it")
	public void enter_the_and_search_for_it(String phoneNumber) {
		phoneSearch.searchPhoneNumber(fieldsAndValues.get("phoneNumber"));
	}

	@Given("validate the error message {string} in phone search screen")
	public void validate_the_error_message_in_phone_search_screen(String phoneNumber) {
		phoneSearch.validateErrorMessage(phoneNumber);
	}

	@Given("update and validate the phone number non-sales preference with {string} and {string} details")
	public void update_and_validate_the_phone_number_non_sales_preference_with_and_details(String value1,
			String value2) {
		phoneSearch.updateAndValidateNonSalesPreference(fieldsAndValues.get("value1"), fieldsAndValues.get("value2"));
	}

	@Then("if the non-sales value is consent then the reconfirm checkbox should be enabled else disabled")
	public void if_the_non_sales_value_is_consent_then_the_reconfirm_checkbox_should_be_enabled_else_disabled() {
		phoneSearch.validateReconfirmationCheckBox();
	}

	@Given("update the non-sales preference value from wrong number to {string} if the last updated by is MARPLTN")
	public void update_the_non_sales_preference_value_from_wrong_number_to_if_the_last_updated_by_is_marpltn(
			String value1) {
		phoneSearch.updateWrongNumberValueIfLastUpdateByMARPLTN(fieldsAndValues.get("value1"));
	}

	@Then("validate the unauthorized error message {string}")
	public void validate_the_unauthorized_error_message(String unAuthorizedMessage) {
		phoneSearch.validateTheUnAuthorizedMessage(unAuthorizedMessage);
	}

	@Given("change the preferences of sales and non-sales values and then reset & verify the changes.")
	public void change_the_preferences_of_sales_and_non_sales_values_and_then_reset_verify_the_changes() {
		phoneSearch.validateResetInPhoneSearchScreen();
	}

	@Then("navigate to phone history screen")
	public void navigate_to_phone_history_screen() {
	}

	@Then("verify the updated details in phone history table")
	public void verify_the_updated_details_in_phone_history_table() {
	}

	@Given("Navigate to phone number scrub page")
	public void navigate_to_phone_number_scrub_page() {
		phoneSearch.navigateToPhoneNumberScrubScreen();
	}

	@Given("Navigate to consent or do not call or wrong number  page")
	public void navigate_to_consent_or_do_not_call_or_wrong_number_page() {
		phoneSearch.navigateToConsentOrDncOrWnFileScreen();
	}

}
