package stepDefinitions;

import io.cucumber.java.en.Then;

public class CommercialMemberEmailSearchHistory_sd extends BaseClass {

	@Then("search for history between {string} and {string} to validate email search history")
	public void search_for_history_between_and_to_validate_email_search_history(String string, String string2) {
		commercialMemberEmailSearchHistory.searchForHistoryWithSpecificDates(fieldsAndValues.get("fromDateForEmailHistory"),
				fieldsAndValues.get("endDateForEmailHistory"));
	}

	@Then("validate the sorting options in email history table")
	public void validate_the_sorting_options_in_email_history_table() {
		commercialMemberEmailSearchHistory.validateSortingInHistoryTable();
	}

	@Then("click on search pervious one year button and validate the results or {string} message")
	public void click_on_search_pervious_one_year_button_and_validate_the_results_or_message(String errorMessage) {
		commercialMemberEmailSearchHistory.validateSearchPreviousOneYearFunctionality(errorMessage);
	}

	@Then("serach with {string} and {string} then validate the {string} in email history page")
	public void serach_with_and_then_validate_the_in_email_history_page(String string, String string2, String string3) {
		commercialMemberEmailSearchHistory.validateErrorMessagesInEmailHisorySearch(
				fieldsAndValues.get("fromDateForEmailHistory"), fieldsAndValues.get("endDateForEmailHistory"),
				fieldsAndValues.get("errorMessageForEmailHistory"));
	}
}
