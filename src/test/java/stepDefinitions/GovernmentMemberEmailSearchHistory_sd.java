package stepDefinitions;

import io.cucumber.java.en.Then;

public class GovernmentMemberEmailSearchHistory_sd extends BaseClass {

	@Then("search for the specific dates {string}, {string} in government email history page")
	public void search_for_the_specific_dates_in_government_email_history_page(String string, String string2) {
		governmentMemberEmailSearchHistory.searchForHistoryWithSpecificDates(fieldsAndValues.get("fromDateForEmailHistory"),
				fieldsAndValues.get("endDateForEmailHistory"));
	}

	@Then("verify the updated email details in government email history page")
	public void verify_the_updated_email_details_in_government_email_history_page() {
		governmentMemberInformationContactInfo.verifyTheEmailDetailsInEmailHistoryPage();
	}

	@Then("click on back to member information page in government email history page")
	public void click_on_back_to_member_information_page_in_government_email_history_page() {
		governmentMemberEmailSearchHistory.backToMemberContactInformationPage();
	}

	@Then("verify the email details in government email history page")
	public void verify_the_email_details_in_government_email_history_page() {
		governmentMemberEmailSearchHistory.verifyTheEmailDetailsInHistorySearchPage(fieldsAndValues.get("emailAddress"),
				fieldsAndValues.get("updatedBy"), fieldsAndValues.get("updatedDateAndTimeInEmailHistory"),
				fieldsAndValues.get("sourceChannel"), fieldsAndValues.get("sourceOrigin"));
	}

	@Then("validate the sorting options in government email history table")
	public void validate_the_sorting_options_in_government_email_history_table() {
		governmentMemberEmailSearchHistory.validateSortingInHistoryTable();
	}

	@Then("click on search pervious six months button and validate the results or {string} message in government email history page")
	public void click_on_search_pervious_six_months_button_and_validate_the_results_or_message_in_government_email_history_page(
			String error) {
		governmentMemberEmailSearchHistory.validateSearchPreviousSixMonthsFunctionality(error);
	}

	@Then("serach with {string} and {string} then validate the {string} in government email history page")
	public void serach_with_and_then_validate_the_in_government_email_history_page(String string, String string2,
			String string3) {
		governmentMemberEmailSearchHistory.validateErrorMessagesInEmailHisorySearch(
				fieldsAndValues.get("fromDateForEmailHistory"), fieldsAndValues.get("endDateForEmailHistory"),
				fieldsAndValues.get("errorMessageForEmailHistory"));
	}

}
