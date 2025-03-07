package testRunner;

import org.junit.Test;

import io.cucumber.core.cli.Main;

public class RunnerForParllel {

	@Test
	public void test() {
		String[] params = new String[] { 
				"-p","pretty",
				"-p", "html:report/Application_Report.html", 
				"-g","stepDefinitions",	
				"-g","driver",
				"-t","@PhoneSearch", 
				"src/test/resources/features", 
				"--threads", "2" };
		Main.run(params, Thread.currentThread().getContextClassLoader());
	}
}