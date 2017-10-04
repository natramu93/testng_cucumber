package main;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidHelper{
public static AndroidDriver<AndroidElement> driver=null;
	public AndroidHelper(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}
	public void click(String arg1)
	{
		System.out.println(arg1);
		String by = arg1.split("@")[0];
		String loc = arg1.split("@")[1];
		System.out.println(by+" "+loc);
		switch(by.toLowerCase())
		{
		case "id":
			driver.findElementById(loc).click();
			break;
		case "name":
			driver.findElementByName(loc).click();
			break;
		case "classname":
			driver.findElementByClassName(loc).click();
			break;
		case "css":
			driver.findElementByCssSelector(loc).click();
			break;
		case "xpath":
			driver.findElementByXPath(loc).click();
			break;
		case "linktext":
			driver.findElementByLinkText(loc).click();
			break;
		case "partiallinktext":
			driver.findElementByPartialLinkText(loc).click();
			break;
		case "tagname":
			driver.findElementByTagName(loc).click();
			break;
		}
	}
}
