package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ConsentOrDncOrWnFileStatus_sd extends BaseClass {
	

	@Given("click on add consent or do not call or wrong number file button")
	public void click_on_add_consent_or_do_not_call_or_wrong_number_file_button() {
		consentOrDncOrWnFileStatus.clickOnAddConsentOrDncOrWnFile();
	}

	@Then("^verify the message \"(.*)\" in create a consent or do not call or wrong number file page$")
	public void verify_the_message_in_create_a_consent_or_do_not_call_or_wrong_number_file_page(String message) {
		consentOrDncOrWnFileStatus.validteConsentOrDncOrWnCreationMessage(message);
	}

	@Then("verify the latest record details in consent or do not call or wrong number file status page")
	public void verify_the_latest_record_details_in_consent_or_do_not_call_or_wrong_number_file_status_page() {
		consentOrDncOrWnFileStatus.validateLatestRecordInConsentOrDncOrWnStatus();
	}
	
	@Given("verify the sorting order in consent or do not call or wrong number file status page")
	public void verify_the_sorting_order_in_consent_or_do_not_call_or_wrong_number_file_status_page() {
		consentOrDncOrWnFileStatus.validateSortingOrderInConsentOrDncOrWnStatusPage();
	}

}
