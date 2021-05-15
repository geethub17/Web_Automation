package stepDefinitions;

import io.cucumber.java.en.Then;

public class PreferenceSearchHistory_sd extends BaseClass {

	@Then("search for history between {string} and {string} to validate preference search history")
	public void search_for_history_between_and_to_validate_preference_search_history(String string, String string2) {
		preferenceSearchHistory.searchForHistoryWithSpecificDates(fieldsAndValues.get("fromDateForPreferenceHistory"),
				fieldsAndValues.get("endDateForPreferenceHistory"));
	}

	@Then("validate the sorting options in preference history table")
	public void validate_the_sorting_options_in_preference_history_table() {
		preferenceSearchHistory.validateSortingInHistoryTable();
	}

	@Then("click on search pervious one year button and validate the results or {string} message in preference history page")
	public void click_on_search_pervious_one_year_button_and_validate_the_results_or_message_in_preference_history_page(
			String error) {
		preferenceSearchHistory
				.validateSearchPreviousOneYearFunctionality(error);
	}

	@Then("serach with {string} and {string} then validate the {string} in preference history page")
	public void serach_with_and_then_validate_the_in_preference_history_page(String string, String string2,
			String string3) {
		preferenceSearchHistory.validateErrorMessagesInEmailHisorySearch(
				fieldsAndValues.get("fromDateForPreferenceHistory"), fieldsAndValues.get("endDateForPreferenceHistory"),
				fieldsAndValues.get("errorMessageForPreferenceHistory"));
	}

	@Then("click on back to member information page in preference history page")
	public void click_on_back_to_member_information_page_in_preference_history_page() {
		commercialMemberInformationPreferences.navigateBackToMemberInformationScreen();
	}

}
