package stepdefinition;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.CucumberRunner;

public class Clearpage extends CucumberRunner {
	
	@Given("^I am able to access the MedHelper Dashboard$")
	public void i_am_on_medhelper(){
		//driver.findElementByXPath("//*[text()='Don\'t show again'").click();
	}
	
	@Given("^I should see the profile created$")
	public void test(){
		
	}
	@When("^I enable details in Settings Tab$")
	public void i_enable_details_in_Settings_Tab() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
}
