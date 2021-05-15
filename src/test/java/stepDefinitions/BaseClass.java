package stepDefinitions;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CommercialMemberInformationContactInfo;
import pageObjects.CommercialMemberInformationPreferences;
import pageObjects.ConsentOrDncOrWnFileStatus;
import pageObjects.CreateConsentOrDncOrWnFile;
import pageObjects.CreateScrubFile;
import pageObjects.GovernmentMemberEmailSearchHistory;
import pageObjects.GovernmentMemberInformationContactInfo;
import pageObjects.GovernmentMemberInformationPreferences;
import pageObjects.CommercialMemberEmailSearchHistory;
import pageObjects.Login;
import pageObjects.MemberSearch;
import pageObjects.PhoneSearch;
import pageObjects.PhoneSearchHistory;
import pageObjects.PreferenceSearchHistory;
import pageObjects.ScrubbingStatus;
import reader.ExcelReader;
import reader.PropertiesReader;
import utilities.Utils;

public class BaseClass {

	/*
	 * Declared variables as static, then exactly a single copy of that field is
	 * created and shared among all instances of that class and sub-classes or else
	 * it will create multiple instance when ever we initialize the class.
	 */

	public static WebDriverWait wait;
	public static WebDriverWait waitForDisplay;
	public static PropertiesReader propertiesReader;
	public static HashMap<String, String> fieldsAndValues;
	public static ExcelReader excelReader;
	public static Utils utils;
	public static Login login;
	public static MemberSearch memberSearch;
	public static PhoneSearch phoneSearch;
	public static PhoneSearchHistory phoneSearchHistory;
	public static ScrubbingStatus scrubbingStatus;
	public static CreateScrubFile createScrubFile;
	public static CreateConsentOrDncOrWnFile createConsentOrDncOrWnFile;
	public static ConsentOrDncOrWnFileStatus consentOrDncOrWnFileStatus;
	public static CommercialMemberInformationContactInfo commercialMemberInformationContactInfo;
	public static CommercialMemberEmailSearchHistory commercialMemberEmailSearchHistory;
	public static CommercialMemberInformationPreferences commercialMemberInformationPreferences;
	public static PreferenceSearchHistory preferenceSearchHistory;
	public static GovernmentMemberInformationContactInfo governmentMemberInformationContactInfo;
	public static GovernmentMemberEmailSearchHistory governmentMemberEmailSearchHistory;
	public static GovernmentMemberInformationPreferences goverMemberInformationPreferences;

	public void intializeClasses(WebDriver driver) {
		login = new Login(driver);
		phoneSearch = new PhoneSearch(driver);
		phoneSearchHistory = new PhoneSearchHistory(driver);
		scrubbingStatus = new ScrubbingStatus(driver);
		createScrubFile = new CreateScrubFile(driver);
		createConsentOrDncOrWnFile = new CreateConsentOrDncOrWnFile(driver);
		consentOrDncOrWnFileStatus = new ConsentOrDncOrWnFileStatus(driver);
		memberSearch = new MemberSearch(driver);
		commercialMemberInformationContactInfo = new CommercialMemberInformationContactInfo(driver);
		commercialMemberEmailSearchHistory = new CommercialMemberEmailSearchHistory(driver);
		commercialMemberInformationPreferences = new CommercialMemberInformationPreferences(driver);
		preferenceSearchHistory = new PreferenceSearchHistory(driver);
		governmentMemberInformationContactInfo = new GovernmentMemberInformationContactInfo(driver);
		governmentMemberEmailSearchHistory = new GovernmentMemberEmailSearchHistory(driver);
		goverMemberInformationPreferences = new GovernmentMemberInformationPreferences(driver);
	}
}
