package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class Login extends Utils {
	
	private WebDriver driver;

	public Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(css = "#USER")
	WebElement userName;
	
	@FindBy(id = "PASSWORD")
	WebElement password;

	@FindBy(xpath = "//button[text()='Log In']")
	WebElement logInButton;
	
	@FindBy(className = "Strong_White")
	WebElement logOutButton;
	
	public void setUserName(String userName) {
		enterTheText(this.userName, userName);
	}

	public void setPassword(String password) {
		enterTheText(this.password, password);
	}
	
	public void clickLogin() {
		clickAnElement(logInButton);	
	}
	
	public void clickLogOut()  {
		clickAnElement(logOutButton);	
	}
	
}
