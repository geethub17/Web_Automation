package driver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import reader.PropertiesReader;
import stepDefinitions.BaseClass;

/*
 * All classes will be instantiated in BaseClass and its a parent class. 
 * Extended to base class. So that all the child's of BaseClass can use the WebDriver. 
 */

public class Driver extends BaseClass {

	String runType;
	String browserType;
	String ip;
	WebDriver driver;

	public Driver() {
		propertiesReader = new PropertiesReader();
		runType = propertiesReader.getRunType();
		browserType = propertiesReader.getBrowserType();
		ip = propertiesReader.getIp();
	}

	@Before
	public void loginCPSUI() throws MalformedURLException {
		if (runType.equalsIgnoreCase("local")) {
			if (browserType.equalsIgnoreCase("chrome")) {
				/* Setting up the chrome driver Path */
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "//drivers//chromedriver.exe");

				/* Chrome options to remove the automation warning messages in infobar */
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				options.setExperimentalOption("useAutomationExtension", false);
				options.addArguments("start-maximized");

				/* Initialize and adding chrome options to the driver. */
				driver = new ChromeDriver(options);
				driver.manage().deleteAllCookies();

			} else if (browserType.equalsIgnoreCase("ie")) {
				/* Setting up the ie driver Path */
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "//drivers//IEDriverServer.exe");

				/* IE options to use java script and not native events */
				InternetExplorerOptions ieOptions = new InternetExplorerOptions();
				ieOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				ieOptions.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				ieOptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);

				/* Initialize and adding IE options to the driver. */
				driver = new InternetExplorerDriver(ieOptions);
				driver.manage().deleteAllCookies();
			}
		} else if (runType.equalsIgnoreCase("grid")) {
			if (browserType.equalsIgnoreCase("chrome")) {

				/* Chrome options to remove the automation warning messages in infobar */
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				options.setExperimentalOption("useAutomationExtension", false);
				options.addArguments("start-maximized");

				/* Adding options to chrome capabilities */
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				capabilities.setBrowserName("chrome");

				/* Initialize and adding chrome capabilities to the driver. */
				driver = new RemoteWebDriver(new URL("http://" + ip + "/wd/hub"), capabilities);
				driver.manage().deleteAllCookies();

			} else if (browserType.equalsIgnoreCase("ie")) {

				/* IE options to use java script and not native events */
				InternetExplorerOptions ieOptions = new InternetExplorerOptions();
				ieOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				ieOptions.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				ieOptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);

				/* Adding options to ie capabilities */
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(ChromeOptions.CAPABILITY, ieOptions);
				capabilities.setBrowserName("internet explorer");

				/* Initialize and adding chrome capabilities to the driver. */
				driver = new RemoteWebDriver(new URL("http://" + ip + "/wd/hub"), capabilities);
				driver.manage().deleteAllCookies();
			}
		}

		/* Initialize all classes */
		intializeClasses(driver);

		/* Launching the application URL */
		driver.get(propertiesReader.getURL());

		/* Maximizing the window */
		driver.manage().window().maximize();

		/* Logging and verify the application login page. */
		login.setUserName(propertiesReader.getUserName());
		login.setPassword(propertiesReader.getPassword());
		login.clickLogin();
		Assert.assertEquals("CPSUI", driver.getTitle());

	}

	@After
	public void logOutCPSUI() throws InterruptedException {
		login.clickLogOut();
		driver.quit();
	}
	
	@AfterStep
	public void takeScreenShotAfterStep(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/jpg", scenario.getName());
		}
	}

}
