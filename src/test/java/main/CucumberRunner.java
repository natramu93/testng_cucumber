package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
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
	public static DesiredCapabilities cap = new DesiredCapabilities();
	public static Properties config = null;
	public static Properties repo = null;
	public static AndroidDriver<AndroidElement> driver = null;
	public static AndroidHelper ah=null;

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
	public void launchApp() throws IOException {
		LoadConfigProperty();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,config.getProperty("deviceName"));
		cap.setCapability(MobileCapabilityType.PLATFORM,config.getProperty("platform"));
		cap.setCapability("appPackage","com.homeshop18.activity");
		cap.setCapability("appActivity", "com.homeshop18.ui.activities.HomeActivity");
		driver = new AndroidDriver<AndroidElement>(new URL(config.getProperty("url")),cap);
		
	}
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void pageLoad(int time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	public void setEnv() throws Exception {
		LoadConfigProperty();
		String baseUrl = config.getProperty("siteUrl");
		driver.get(baseUrl);
	}

	public static String currentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String cal1 = dateFormat.format(cal.getTime());
		return cal1;
	}

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {
		launchApp();
		ATUReports.setWebDriver(driver);
		implicitWait(30);
		ah = new AndroidHelper(driver);
	}

	/*@AfterClass(alwaysRun = true)
	public void takeScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "//screenshots/screenshot.png"));

	}

	@AfterMethod(alwaysRun = true)
	public void tearDownr(ITestResult result) throws IOException {
		if (!result.isSuccess()) {
			File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String failureImageFileName = result.getMethod().getMethodName()
					+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
			File failureImageFile = new File(System.getProperty("user.dir") + "//screenshots//" + failureImageFileName);
			FileUtils.copyFile(imageFile, failureImageFile);
		}
	}*/
	@AfterSuite(alwaysRun = true)
	public void quit() throws IOException, InterruptedException {
		driver.quit();
	}
}
