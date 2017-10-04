package stepdefinition;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import cucumber.api.java.en.Given;
import main.CucumberRunner;

public class GenericSteps extends CucumberRunner{
	
	@Given("^I click on ([^\\\"]*)$")
	public void i_click_on(String arg1)
	{
		ah.click(repo.getProperty(arg1));
		ATUReports.add("I click on "+arg1,LogAs.INFO,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
	
}
