package testRunner;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import reportSender.SendReport;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/failedScenarios.txt",
								glue = {"stepDefinitions","driver"},
								dryRun = false,
								plugin = {"pretty", "html:report/CPSUI_Report_For_Failed_Scenarios.html",
										"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
								monochrome = true
								,stepNotifications = true
								)

public class RunnerForFailedScenarios {
		
	@AfterClass
	public static void killDrivers() throws IOException, AddressException, MessagingException {
			Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			
			SendReport sendReport = new SendReport();
			sendReport.triggerMail("Report for failed scenarios", "//report//CPSUI_Extent_Report.html");
		}
}
