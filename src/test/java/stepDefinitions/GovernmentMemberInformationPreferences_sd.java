package stepDefinitions;

import io.cucumber.java.en.Then;

public class GovernmentMemberInformationPreferences_sd extends BaseClass {

	@Then("update the Helpful information section with {string} or {string} and validate in preference tab")
	public void update_the_helpful_information_section_with_or_and_validate_in_preference_tab(String string,
			String string2) {
		goverMemberInformationPreferences.updatedAndVerifyTheSuccessMessageInMemberpreferences("hepfulInformation");
	}

	@Then("navigate to helpful information preference history search screen")
	public void navigate_to_helpful_information_preference_history_search_screen() {
		goverMemberInformationPreferences.navigateToHelpFulInformationPrefrenceHistoryScreen();
	}

	@Then("click on clear selection in helpful selection and see email and text options are deselected in status update section")
	public void click_on_clear_selection_in_helpful_selection_and_see_email_and_text_options_are_deselected_in_status_update_section() {
		goverMemberInformationPreferences.validateClearSelection();
	}

	@Then("validate the updated details {string}, {string}, {string}, {string}, {string} and {string} in prefernce history search screen for government member")
	public void validate_the_updated_details_and_in_prefernce_history_search_screen(String string, String string2,
			String string3, String string4, String string5, String string6) {
		goverMemberInformationPreferences.validateTheUpdatedPreferenceDetailsInPreferenceSearchHistory();
	}
	
	@Then("click on back to member information page in preference history page for government member")
	public void click_on_back_to_member_information_page_in_preference_history_page() {
		goverMemberInformationPreferences.navigateBackToMemberInformationScreen();
	}
}
