package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateConsentOrDncOrWnFile_sd extends BaseClass{
	
	@Given("select header details by using {string}, {string} and {string}")
	public void select_header_details_by_using_and(String anthemCallType, String dataType, String sourceName) {
		createConsentOrDncOrWnFile.selectHeaderDetails(fieldsAndValues.get("anthemCallType"), fieldsAndValues.get("dataType"), fieldsAndValues.get("sourceName"));
	}

	@Then("upload the {string} in create a consent or do not call or wrong number file page")
	public void upload_the_in_create_a_consent_or_do_not_call_or_wrong_number_file_page(String fileLocation) {
		createConsentOrDncOrWnFile.uploadDocumentToCreateScrubFile(fieldsAndValues.get("fileLocation"));
	}

	@Then("click on submit in create consent or do not call or wrong number file  page")
	public void click_on_submit_in_create_a_consent_or_do_not_call_or_wrong_number_file_page() {
		createConsentOrDncOrWnFile.clickOnSubmit();
	}
	
	@Then("validate the error message {string} in create consent or do not call or wrong number file page")
	public void validate_the_error_message_in_create_consent_or_do_not_call_or_wrong_number_file_page(
			String errorMessage) {
		createConsentOrDncOrWnFile.validateErrorMessage(errorMessage);
	}

	@Then("click on reset button in create consent or do not call or wrong number file page")
	public void click_on_reset_button_in_create_consent_or_do_not_call_or_wrong_number_file_page() {
		createConsentOrDncOrWnFile.clickOnReset();
	}

	@Then("click on cancel button in create consent or do not call or wrong number file page and verify user navigated back to consent or do not call or wrong number file page")
	public void click_on_cancel_button_in_create_consent_or_do_not_call_or_wrong_number_file_page_and_verify_user_navigated_back_to_consent_or_do_not_call_or_wrong_number_file_page() {
		createConsentOrDncOrWnFile.clickOnCancelAndVerifyTheScrubbingStatusPage();
	}

}
