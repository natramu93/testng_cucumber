package main;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
	  MethodListener.class })
@CucumberOptions(
		strict = true,
		monochrome = true, 
		features = "src/test/resources/features",
		glue = "stepdefinition",
		plugin = {"pretty", "html:target/cucumber-html-report" })

public class CucumberRunner extends AbstractTestNGCucumberTests {
	{
        System.setProperty("atu.reporter.config", "atu.properties");

    }
	public static Properties config = null;
	public static Properties repo = null;
	public static DesiredCapabilities cap = null;
	public static AndroidDriver<AndroidElement> driver = null;
	public static AndroidHelper ah;
	public void LoadConfigProperty() throws IOException {
		config = new Properties();
		repo = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//config//config.properties");
		config.load(ip);
		FileInputStream ip2 = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//java//po//repo.properties");
		repo.load(ip2);
	}
	public void launchapp() throws IOException{
		LoadConfigProperty();
		cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, config.getProperty("deviceName"));
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, config.getProperty("platformName"));
		cap.setCapability("appPackage", config.getProperty("appPackage"));
		cap.setCapability("appActivity",config.getProperty("appActivity"));
		driver = new AndroidDriver<AndroidElement>(new URL(config.getProperty("url")),cap);
	}
	
	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static String currentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String cal1 = dateFormat.format(cal.getTime());
		return cal1;
	}

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {
		launchapp();
		implicitWait(30);
		ah = new AndroidHelper(driver);
	}

	@AfterSuite(alwaysRun = true)
	public void quit() throws IOException, InterruptedException {
		//driver.quit();
	}
}
