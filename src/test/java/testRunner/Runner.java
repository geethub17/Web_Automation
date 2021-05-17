package testRunner;

import java.io.IOException;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\features",
								glue = {"stepDefinitions","driver"},
								dryRun = false,
								plugin = {"pretty", "html:report/CPSUI_Report.html", 
										"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
										"rerun:target/failedScenarios.txt"},
								monochrome = true,
								stepNotifications = true
								,tags = "@Regression"
								)

public class Runner {
		
	@AfterClass
	public static void killDrivers() throws IOException {
			Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
		}
}
