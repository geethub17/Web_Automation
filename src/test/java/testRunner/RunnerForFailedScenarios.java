package testRunner;

import java.io.IOException;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/failedScenarios.txt",
								glue = {"stepDefinitions","driver"},
								dryRun = false,
								plugin = {"pretty", "html:reportForFailedScenarios/CPSUI_Report_For_Failed_Scenarios.html"},
								monochrome = true
								,stepNotifications = true
								)

public class RunnerForFailedScenarios {
		
	@AfterClass
	public static void killDrivers() throws IOException {
			Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
		}
}
