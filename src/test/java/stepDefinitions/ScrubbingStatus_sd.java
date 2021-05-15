package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ScrubbingStatus_sd extends BaseClass{
	

	@Given("click on add scrub file button")
	public void click_on_add_scrub_file_button() {
		scrubbingStatus.clickOnAddScrubFile();
	}
	
	@Then("click on submit in create scrub file page")
	public void click_on_submit() {
		createScrubFile.clickOnSubmit();
	}

	@Then("verify the success message {string} in scrubbing status page")
	public void verify_the_success_message_in_scrubbing_status_page(String successMessage) {
		scrubbingStatus.validateScrubbingStatusPageTitle();
		scrubbingStatus.validteSuccsfulScrubCreationMessage(successMessage);
	}
	
	@Then("verify the latest record details in scrubbing status page")
	public void verify_the_latest_record_details_in_scrubbing_status_page() {
		scrubbingStatus.validateLatestRecordInScrubbingStatus();
	}
	
	@Given("verify the sorting order in scrubbing status page")
	public void verify_the_sorting_order_in_scrubbing_status_page() {
		scrubbingStatus.validateSortingOrderInScrubStatusPage();
	}

}
