package po;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Test {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "abc");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		cap.setCapability("appPackage", "com.earthflare.android.medhelper.lite");
		cap.setCapability("appActivity", "com.earthflare.android.medhelper.act2.Dashboard");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		TouchAction act = new TouchAction(driver);
		System.out.println(driver.findElementByAndroidUIAutomator("UiSelector().text(\"Schedule\")").getCenter());
		act.press(700, 700).waitAction(Duration.ofSeconds(2)).moveTo(700,300).release().perform();
	}

}
