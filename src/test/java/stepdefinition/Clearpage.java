package stepdefinition;

import org.openqa.selenium.By;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import main.CucumberRunner;
import po.Home;

public class Clearpage extends CucumberRunner {
	

	@Then("^I am able to access the HS18 App$")
	public void Clear() throws Throwable {
		ATUReports.add("Given : I am able to access the HS18 App",LogAs.INFO,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
	@When("^I update the right user credentials$")
	public void i_update_the_right_user_credentials() throws Throwable {
		driver.findElementById(Home.mobileNumber).sendKeys(config.getProperty("username"));
		driver.findElementById(Home.password).sendKeys(config.getProperty("password"));
		ATUReports.add("When : I update the right user credentials",LogAs.INFO,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

	/*@When("^I click on SignIn_Button$")
	public void i_click_on_Sign_In_Button() throws Throwable {
		driver.findElementById(Home.signIn).click();
		ATUReports.add("When : I click on Sign In Button",LogAs.INFO,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}*/

	@Then("^I should get access to the Shopping Terminal$")
	public void i_should_get_access_to_the_Shopping_Terminal() throws Throwable {
	    Assert.assertEquals(true, driver.findElementById("com.homeshop18.activity:id/banner_image").isDisplayed());
	    ATUReports.add("Then : I should get access to the Shopping Terminal",LogAs.INFO,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}


}
