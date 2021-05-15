package stepDefinitions;

import io.cucumber.java.en.Then;

public class CommercialMemberInformationPreferences_sd extends BaseClass {

	@Then("click on preference tab in member information page")
	public void click_on_preference_tab_in_member_information_page() {
		commercialMemberInformationContactInfo.navigateToMemberPreferenceTab();
	}

	@Then("update the Explanation of Benefits \\(EOBs) section with {string} or {string} and validate in preference tab")
	public void update_the_explanation_of_benefits_eo_bs_section_with_or_and_validate_in_preference_tab(String string,
			String string2) {
		commercialMemberInformationPreferences.updatedAndVerifyTheSuccessMessageInMemberpreferences("eob");
	}

	@Then("navigate to EOB preference history search screen")
	public void navigate_to_eob_preference_history_search_screen() {
		commercialMemberInformationPreferences.navigateToEOBPrefrenceHistoryScreen();
	}

	@Then("validate the updated details {string}, {string}, {string}, {string}, {string} and {string} in prefernce history search screen")
	public void validate_the_updated_details_and_in_prefernce_history_search_screen(String string, String string2,
			String string3, String string4, String string5, String string6) {
		commercialMemberInformationPreferences.validateTheUpdatedPreferenceDetailsInPreferenceSearchHistory();
	}

	@Then("update the Status Updates \\(Optional) section with {string} or {string} and validate in preference tab")
	public void update_the_status_updates_optional_section_with_or_and_validate_in_preference_tab(String string,
			String string2) {
		commercialMemberInformationPreferences
				.updatedAndVerifyTheSuccessMessageInMemberpreferences("statusUpdatesOptional");
	}

	@Then("navigate to status update preference history search screen")
	public void navigate_to_status_update_preference_history_search_screen() {
		commercialMemberInformationPreferences.navigateToStatusUpdatesOptionalPrefrenceHistoryScreen();
	}

	@Then("click on clear selection and see email and text options are deselected in status update section")
	public void click_on_clear_selection_and_see_email_and_text_options_are_deselected_in_status_update_section() {
		commercialMemberInformationPreferences.validateClearSelection();
	}

	@Then("update the preventative care reminders section with {string} or {string} and validate in preference tab")
	public void update_the_preventative_care_reminders_section_with_or_and_validate_in_preference_tab(String string,
			String string2) {
		commercialMemberInformationPreferences.updatedAndVerifyTheSuccessMessageInMemberpreferences("preventiveCare");
	}

	@Then("navigate to preventative care preference history search screen")
	public void navigate_to_preventative_care_preference_history_search_screen() {
		commercialMemberInformationPreferences.navigateToPreventiveCarePrefrenceHistoryScreen();
	}

	@Then("update the health and wellness information section with {string} or {string} and validate in preference tab")
	public void update_the_health_and_wellness_information_section_with_or_and_validate_in_preference_tab(String string,
			String string2) {
		commercialMemberInformationPreferences
				.updatedAndVerifyTheSuccessMessageInMemberpreferences("healthAndWellness");
	}

	@Then("navigate to health and wellness information preference history search screen")
	public void navigate_to_health_and_wellness_information_preference_history_search_screen() {
		commercialMemberInformationPreferences.navigateToWellnessInformationPrefrenceHistoryScreen();
	}

	@Then("select the {string} and {string} in member preference tab")
	public void select_the_and_in_member_preference_tab(String string, String string2) {
		commercialMemberInformationPreferences.selectSpokenAndWrittenLanguages(fieldsAndValues.get("language1"),
				fieldsAndValues.get("language2"));
	}

	@Then("click on reset button in member preference tab")
	public void click_on_reset_button_in_member_preference_tab() {
		commercialMemberInformationPreferences.clickOnReset();
	}

	@Then("validate the language options are reset to old options")
	public void validate_the_language_options_are_reset_to_old_options() {
		commercialMemberInformationPreferences.validateTheSelectedSpokenAndWrittenLanguses();
	}

	@Then("click on submit in member preference tab")
	public void click_on_submit_in_member_preference_tab() {
		commercialMemberInformationPreferences.clickOnUpdate();
	}

	@Then("validate the {string} in member preference tab")
	public void validate_the_in_member_preference_tab(String string) {
		commercialMemberInformationPreferences.validateErrorMessage(fieldsAndValues.get("messageInPreferenceTab"));
	}

	@Then("validate the updated language preferences in member preference tab.")
	public void validate_the_updated_language_preferences_in_member_preference_tab() {
		commercialMemberInformationPreferences.validateTheUpdatedSpokenAndWrittenLanguses();
	}

	@Then("update the health and wellness programs section with {string}, {string} , {string} and {string} and validate the details in preference history page")
	public void update_the_health_and_wellness_programs_section (String string, String string2, String string3, String string4) {
		commercialMemberInformationPreferences.updateAndValidateAllPreferencesInWellnessProgramsSection();
	}
	
}
