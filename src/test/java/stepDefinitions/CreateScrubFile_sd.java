package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateScrubFile_sd extends BaseClass{
	
	@Given("select header details by using {string} , {string} and program name")
	public void select_header_details_by_using_and_program_name(String scrubFileType, String anthemCallType) {
		createScrubFile.selectHeaderDetails(fieldsAndValues.get("scrubFileType"), fieldsAndValues.get("anthemCallType"));
	}

	@Then("upload the {string}")
	public void upload_the(String fileLocation) {
		createScrubFile.uploadDocumentToCreateScrubFile(fieldsAndValues.get("fileLocation"));
	}

	@Then("validate the error message {string}")
	public void validate_the_error_message(String errorMessage) {
		createScrubFile.validateErrorMessage(errorMessage);
	}

	@Then("click on reset button in create scrub file page")
	public void click_on_reset_button() {
		createScrubFile.clickOnReset();
	}

	@Then("click on cancel button in create scrub file page and verify user navigated back to scrubbing status page")
	public void click_on_cancel_button_and_verify_navigated_backTo_scrubbing_status_page() {
		createScrubFile.clickOnCancelAndVerifyTheScrubbingStatusPage();
	}

}
