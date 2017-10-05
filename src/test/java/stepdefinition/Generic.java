package stepdefinition;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import main.CucumberRunner;

public class Generic extends CucumberRunner{
	@Given("^I click on (.*)$")
	public void i_click_on(String arg1)
	{
		System.out.println(repo.getProperty(arg1));
		ah.click(repo.getProperty(arg1));
		ATUReports.add("I click on "+arg1,LogAs.INFO,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
	
	@Given("^I enter \"(.*)\" in (.*)$")
	public void i_enter_in(String arg1,String arg2){
		ah.type(repo.getProperty(arg2), arg1);
		ATUReports.add("I enter "+arg1+" in "+arg2,LogAs.INFO,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
	
	@Given("^I set date as \"(.*)\"$")
	public void i_set_date_as(String arg)
	{
		String day = arg.split(" ")[0];
		String month = arg.split(" ")[1];
		String year = arg.split(" ")[2];
		System.out.println("day"+day+"month"+month+"year"+year);
//Set month
		while(!ah.text(repo.getProperty("month")).equals(month))
		{
			driver.findElementsById("com.earthflare.android.medhelper.lite:id/np_increment").get(Integer.parseInt(repo.getProperty("month").split(",")[1])-1).click();
		}
		while(!ah.text(repo.getProperty("day")).equals(day))
		{
			driver.findElementsById("com.earthflare.android.medhelper.lite:id/np_increment").get(Integer.parseInt(repo.getProperty("day").split(",")[1])-1).click();
		}
		while(!ah.text(repo.getProperty("year")).equals(year))
		{
			driver.findElementsById("com.earthflare.android.medhelper.lite:id/np_increment").get(Integer.parseInt(repo.getProperty("year").split(",")[1])-1).click();
		}
		ah.click(repo.getProperty("set"));
	}
	@Given("^I swipe (.*) to click on (.*)$")
	public void i_swipe_to_click_on(String dir,String arg2)
	{
		ah.swipe(dir, repo.getProperty(arg2));
		ah.click(repo.getProperty(arg2));
	}
}
