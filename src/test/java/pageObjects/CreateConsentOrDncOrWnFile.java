package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class CreateConsentOrDncOrWnFile extends Utils {

	private WebDriver driver;

	public CreateConsentOrDncOrWnFile(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	/*
	 * All elements of create a Consent/Do Not Call/Wrong Number file page are
	 * captured.
	 */

	@FindBy(xpath = "//span[text()='Create Consent/Do Not Call/Wrong Number File']")
	WebElement createAConsentOrDncOrWnFilePageTitle;

	@FindBy(id = "DataType")
	WebElement dataTypeDropDown;

	@FindBy(id = "ConsentCallType")
	WebElement anthemCallTypeDropDown;

	@FindBy(id = "SourceName")
	WebElement sourceNameDropDown;

	@FindBy(id = "$PpyWorkPage$ppyFileName")
	WebElement chooseFile;

	@FindBy(xpath = "(//div[text()='Cancel'])[2]")
	WebElement cancel;

	@FindBy(xpath = "//div[text()='Reset']")
	WebElement reset;

	@FindBy(xpath = "//div[text()='Submit']")
	WebElement submit;

	@FindBy(id = "$PpyWorkPage$pFileHeaderDetails$pConsentCallTypeError")
	WebElement anthemCallTypeError;

	@FindBy(id = "$PpyWorkPage$pFileHeaderDetails$pDataTypeError")
	WebElement dataTypeError;

	@FindBy(id = "$PpyWorkPage$pFileHeaderDetails$pSourceNameError")
	WebElement sourceNameError;

	@FindBy(xpath = "//Span[text()='Do Not Call']")
	WebElement dataTypeDncWhenAnthemCallTypeIsSalesOrBoth;

	@FindBy(xpath = "//div[text()='Please upload only text files with .txt extension']")
	WebElement invalidFileFormatErrorMessage;

	@FindBy(xpath = "//div[text()='Please select the file to upload']")
	WebElement noFileMessage;

	@FindBy(xpath = "//div[@data-node-id='CreateConsentDNCFile'][contains(@uniqueid,'SID')]")
	WebElement isDropDownValueChanged;

	@FindBy(css = "select[id='ConsentCallType']>option[selected]")
	WebElement selectedAnthemCallType;

	@FindBy(css = "select[id='DataType']>option[selected]")
	WebElement selectedDataType;

	@FindBy(css = "select[id='SourceName']>option[selected]")
	WebElement selectedSourceName;

	@FindBy(xpath = "//div[@data-node-id='ConfirmConsentFileUpload']//div[contains(text(),'STOP')]")
	WebElement confirmConsentFileUploadMessage;

	@FindBy(xpath = "//div[text()='Yes']")
	WebElement yesinConfirmConsentFileUploadPopUp;

	/*
	 * This method is to verify the create a Consent/Do Not Call/Wrong Number file
	 * page title
	 */
	public void validateCreateAConsentOrDncorWnPageTitle() {
		verifyThePageTitle("Create Consent/Do Not Call/Wrong Number File", createAConsentOrDncOrWnFilePageTitle);
	}

	/*
	 * This method is to select header details in create a Consent/Do Not Call/Wrong
	 * Number file page
	 */
	public void selectHeaderDetails(String anthemCallType, String dataType, String sourceName) {
		String oldAttributeValue;

		if (getText(selectedAnthemCallType).equalsIgnoreCase(anthemCallType)) {
			// if anthem call type is already selected as sales then no need to select again
		} else {
			oldAttributeValue = isDropDownValueChanged.getAttribute("uniqueid");
			selectDropDownValueByText(anthemCallTypeDropDown, anthemCallType);
			waitTillAttributeValueChanges(isDropDownValueChanged, oldAttributeValue, "uniqueid");
		}

		/*
		 * Below if condition checks if the anthem call type is sales or both then the
		 * data type field changes as text field
		 */
		if (anthemCallType.equalsIgnoreCase("Sales") || anthemCallType.equalsIgnoreCase("Both")) {
			compareTexts("Do Not Call", getText(dataTypeDncWhenAnthemCallTypeIsSalesOrBoth));
		} else if (getText(selectedDataType).equalsIgnoreCase(dataType)) {
			// if data type is already selected as sales then no need to select again
		} else {
			oldAttributeValue = isDropDownValueChanged.getAttribute("uniqueid");
			selectDropDownValueByText(dataTypeDropDown, dataType);
			waitTillAttributeValueChanges(isDropDownValueChanged, oldAttributeValue, "uniqueid");
		}

		oldAttributeValue = isDropDownValueChanged.getAttribute("uniqueid");
		selectDropDownValueByText(sourceNameDropDown, sourceName);
		waitTillAttributeValueChanges(isDropDownValueChanged, oldAttributeValue, "uniqueid");
	}

	/* This method is to upload the Consent/Do Not Call/Wrong Number file */
	public void uploadDocumentToCreateScrubFile(String fileLocation) {
		enterTheText(chooseFile, System.getProperty("user.dir") + fileLocation);
	}

	/* This method is to click on submit */
	public void clickOnSubmit() {
		validateCreateAConsentOrDncorWnPageTitle();
		clickElement(submit);
		clickElement(yesinConfirmConsentFileUploadPopUp);
	}

	/*
	 * This method is to validate the error messages in create Consent/Do Not
	 * Call/Wrong Number file page.
	 */
	public void validateErrorMessage(String errorMessage) {
		if (errorMessage.contains("file")) {
			compareTexts(errorMessage, getText(noFileMessage));
		} else {
			compareTexts(errorMessage, getText(anthemCallTypeError));
			compareTexts(errorMessage, getText(dataTypeError));
			compareTexts(errorMessage, getText(sourceNameError));
		}
	}

	/*
	 * This method is navigate back to Consent/Do Not Call/Wrong Number status page.
	 */
	public void clickOnCancelAndVerifyTheScrubbingStatusPage() {
		clickOnCancel();
		consentOrDncOrWnFileStatus.validateConsentOrDncOrWnStatusPageTitle();
	}

	/* This method is to click on cancel */
	public void clickOnCancel() {
		clickAnElement(cancel);
	}

	/* This method is to click on reset button */
	public void clickOnReset() {
		clickAnElement(reset);
		waitForTheElementTobeAbsent(anthemCallTypeError);
	}
}
