package stepDefinitions;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CommercialMemberEmailSearchHistory;
import pageObjects.Login;
import pageObjects.MemberSearch;
import pageObjects.PhoneSearch;
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
	public static CommercialMemberEmailSearchHistory commercialMemberEmailSearchHistory;
	
	public void intializeClasses(WebDriver driver) {
		login = new Login(driver);
		phoneSearch = new PhoneSearch(driver);
		memberSearch = new MemberSearch(driver);
		commercialMemberEmailSearchHistory = new CommercialMemberEmailSearchHistory(driver);
	}
}
