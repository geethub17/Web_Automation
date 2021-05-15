package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MemberSearch_sd extends BaseClass {

	@Given("Navigate to member search page")
	public void navigate_to_member_search_page() {
		phoneSearch.navigateToMemberSearchPage();
	}

	@Then("search for the member by using {string} , {string} , {string}, {string}, {string} and select the {string}")
	public void search_for_the_member_by_using_and_select_the(String firstName, String lastName, String dob,
			String memberState, String groupNumber, String sourceSystem) {
		memberSearch.searchByMemberName(fieldsAndValues.get("firstName"), fieldsAndValues.get("lastName"),
				fieldsAndValues.get("dob"), fieldsAndValues.get("memberState"), fieldsAndValues.get("groupNumber"),
				fieldsAndValues.get("sourceSystem"));
	}

	@Then("validate the sorting order in member search results table")
	public void validate_the_sorting_order_in_member_search_results_table() {
		memberSearch.validateSortingOrderInMemberSearchResultsTable();
	}

	@Given("select the first name {string} and last name {string} value from dropdown")
	public void select_the_first_and_last_name_value_from_dropdown(String firstNameKindOfSearch,
			String lastNameKindOfSearch) {
		memberSearch.selectTheFirstAndLastNameTypeSearches(fieldsAndValues.get("firstNameType"),
				fieldsAndValues.get("lastNameType"));
	}

	@Given("select the search by subscriber id option then search for the member by using {string} , {string} , {string},{string}, {string} and select the {string}")
	public void select_the_search_by_subscriber_id_option_then_search_for_the_member_by_using_and_select_the(
			String subscriberId, String seqNo, String dob, String memberState, String groupNumber,
			String sourceSystem) {
		memberSearch.searchBySubscriberId(fieldsAndValues.get("subscriberId"), fieldsAndValues.get("seqNo"),
				fieldsAndValues.get("dob"), fieldsAndValues.get("memberState"), fieldsAndValues.get("groupNumber"),
				fieldsAndValues.get("sourceSystem"));
	}

	@Given("click on member last name based on {string}, {string}, {string}, {string}")
	public void clickOnMemberLastName(String seqNumber, String firstName, String lastName, String dob) {
		memberSearch.clickOnMemberLastName(fieldsAndValues.get("seqNumber"), fieldsAndValues.get("firstName"),
				fieldsAndValues.get("lastName"), fieldsAndValues.get("dob"));
	}

	@Given("click on search in member search page")
	public void click_on_search_in_member_search_page() {
		memberSearch.clickOnSearchInMemberSearch();
	}

	@Given("validate the error message {string} in member search page")
	public void validate_the_error_message_in_member_search_page(String errorMessage) {
		if (errorMessage.toLowerCase().contains("subscriber")) {
			memberSearch.validateErrorMessagesForInvalidSubscriberIdSearch(errorMessage);
		} else {
			memberSearch.validateErrorMessagesForInvalidMemberNameSearch(errorMessage);
		}
	}

	@Given("click on reset in member search page")
	public void click_on_reset_in_member_search_page() {
		memberSearch.clickOnResetInMemberSearch();
	}

	@Given("select search by subscriber id option")
	public void select_search_by_subscriber_id_option() {
		memberSearch.selectSubscriberIdOption();
	}
}
