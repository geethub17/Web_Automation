package stepDefinitions;

import io.cucumber.java.en.Then;

public class PhoneSearchHistory_sd extends BaseClass{
	
	@Then("search for history between {string} and {string} to validate search history")
	public void search_for_history_between_and_to_validate_search_history(String fromDate, String endDate) {
		phoneSearchHistory.searchForHistoryWithSpecificDates(fieldsAndValues.get("fromDate"),
				fieldsAndValues.get("endDate"));
	}

	@Then("validate the sorting options in history table")
	public void validate_the_sorting_options_in_history_table() {
		phoneSearchHistory.validateSortingInHistoryTable();
	}

	@Then("click on search three months pervious button and validate the results or {string} message")
	public void click_on_search_three_months_pervious_button_and_validate_the_results_or_message(String errorMessage) {
		phoneSearchHistory.validateSearchPreviousThreeMonthsFunctionality(errorMessage);
	}

	@Then("navigate back to phone search results screen")
	public void navigate_back_to_phone_search_results_screen() {
		phoneSearchHistory.backToPhoneSearchScreen();
	}

	@Then("serach with {string} and {string} then validate the {string}")
	public void serach_with_and_then_validate_the(String fromDate, String endDate, String errorMessage) {
		phoneSearchHistory.validateErrorMessagesInHisorySearch(fieldsAndValues.get("fromDate"),
				fieldsAndValues.get("endDate"), fieldsAndValues.get("errorMessage"));
	}

}
