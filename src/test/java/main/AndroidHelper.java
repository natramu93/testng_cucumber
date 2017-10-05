package main;

import java.time.Duration;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidHelper {
public TouchAction act;
public static AndroidDriver<AndroidElement> driver;
	public AndroidHelper(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}
	
	public void click(String arg)
	{
		String by = arg.split("@")[0];
		String loc = arg.split("@")[1];
		if(!loc.contains(","))
		{
		switch(by.toLowerCase())
		{
		case "id":
			driver.findElementById(loc).click();
			break;
		case "classname":
			driver.findElementByClassName(loc).click();
			break;
		case "css":
			driver.findElementByCssSelector(loc).click();
			break;
		case "name":
			driver.findElementByName(loc).click();
			break;
		case "xpath":
			driver.findElementByXPath(loc).click();
			break;
		case "text":
			driver.findElementByAndroidUIAutomator("UiSelector().text(\""+loc+"\")").click();
			break;
		}
		}
		else
		{
			int index = Integer.parseInt(loc.split(",")[1]);
			loc = loc.split(",")[0];
			switch(by.toLowerCase())
			{
			case "id":
				driver.findElementsById(loc).get(index-1).click();
				break;
			case "classname":
				driver.findElementsByClassName(loc).get(index-1).click();
				break;
			case "css":
				driver.findElementsByCssSelector(loc).get(index-1).click();
				break;
			case "name":
				driver.findElementsByName(loc).get(index-1).click();
				break;
			case "xpath":
				driver.findElementsByXPath(loc).get(index-1).click();
				break;
			case "text":
				driver.findElementsByAndroidUIAutomator("UiSelector().text(\""+loc+"\")").get(index-1).click();
				break;
			}
		}
	}
	public String text(String arg)
	{
		String by = arg.split("@")[0];
		String loc = arg.split("@")[1];
		String text = null;
		if(!loc.contains(","))
		{
		switch(by.toLowerCase())
		{
		case "id":
			text = driver.findElementById(loc).getText();
			break;
		case "classname":
			text = driver.findElementByClassName(loc).getText();
			break;
		case "css":
			text = driver.findElementByCssSelector(loc).getText();
			break;
		case "name":
			text = driver.findElementByName(loc).getText();
			break;
		case "xpath":
			text = driver.findElementByXPath(loc).getText();
			break;
		case "text":
			text = driver.findElementByAndroidUIAutomator("UiSelector().text(\""+loc+"\")").getText();
			break;
		}
		}
		else
		{
			int index = Integer.parseInt(loc.split(",")[1]);
			loc = loc.split(",")[0];
			switch(by.toLowerCase())
			{
			case "id":
				text = driver.findElementsById(loc).get(index-1).getText();
				break;
			case "classname":
				text = driver.findElementsByClassName(loc).get(index-1).getText();
				break;
			case "css":
				text = driver.findElementsByCssSelector(loc).get(index-1).getText();
				break;
			case "name":
				text = driver.findElementsByName(loc).get(index-1).getText();
				break;
			case "xpath":
				text = driver.findElementsByXPath(loc).get(index-1).getText();
				break;
			case "text":
				text = driver.findElementsByAndroidUIAutomator("UiSelector().text(\""+loc+"\")").get(index-1).getText();
				break;
			}
		}
		return text;
	}
	public void type(String arg,String arg2)
	{
		String by = arg.split("@")[0];
		String loc = arg.split("@")[1];
		if(!loc.contains(","))
		{
		switch(by.toLowerCase())
		{
		case "id":
			driver.findElementById(loc).sendKeys(arg2);
			break;
		case "classname":
			driver.findElementByClassName(loc).sendKeys(arg2);
			break;
		case "css":
			driver.findElementByCssSelector(loc).sendKeys(arg2);
			break;
		case "name":
			driver.findElementByName(loc).sendKeys(arg2);
			break;
		case "xpath":
			driver.findElementByXPath(loc).sendKeys(arg2);
			break;
		case "text":
			driver.findElementByAndroidUIAutomator("UiSelector().text(\""+loc+"\")").sendKeys(arg2);
			break;
		}
	}
		else
		{
			int index = Integer.parseInt(loc.split(",")[1]);
			loc = loc.split(",")[0];
			switch(by.toLowerCase())
			{
			case "id":
				driver.findElementsById(loc).get(index-1).sendKeys(arg2);
				break;
			case "classname":
				driver.findElementsByClassName(loc).get(index-1).sendKeys(arg2);
				break;
			case "css":
				driver.findElementsByCssSelector(loc).get(index-1).sendKeys(arg2);
				break;
			case "name":
				driver.findElementsByName(loc).get(index-1).sendKeys(arg2);
				break;
			case "xpath":
				driver.findElementsByXPath(loc).get(index-1).sendKeys(arg2);
				break;
			case "text":
				driver.findElementsByAndroidUIAutomator("UiSelector().text(\""+loc+"\")").get(index-1).sendKeys(arg2);
				break;
			}
		}
	}
	public void swipe(String arg1,String arg2)
	{
		act = new TouchAction(driver);
		while(!isDisplayed(arg2))
		if(arg1.toLowerCase().equals("down"))
		{
			act.press(700, 700).waitAction(Duration.ofSeconds(2)).moveTo(700,300).release().perform();
		}
	}
	public boolean isDisplayed(String arg)
	{
			String by = arg.split("@")[0];
			String loc = arg.split("@")[1];
			boolean state=false;
			if(!loc.contains(","))
			{
			switch(by.toLowerCase())
			{
			case "id":
				state = driver.findElementById(loc).isDisplayed();
				break;
			case "classname":
				state = driver.findElementByClassName(loc).isDisplayed();
				break;
			case "css":
				state = driver.findElementByCssSelector(loc).isDisplayed();
				break;
			case "name":
				state = driver.findElementByName(loc).isDisplayed();
				break;
			case "xpath":
				state = driver.findElementByXPath(loc).isDisplayed();
				break;
			case "text":
				state = driver.findElementByAndroidUIAutomator("UiSelector().text(\""+loc+"\")").isDisplayed();
				break;
			}
		}
			else
			{
				int index = Integer.parseInt(loc.split(",")[1]);
				loc = loc.split(",")[0];
				switch(by.toLowerCase())
				{
				case "id":
					state = driver.findElementsById(loc).get(index-1).isDisplayed();
					break;
				case "classname":
					state = driver.findElementsByClassName(loc).get(index-1).isDisplayed();
					break;
				case "css":
					state = driver.findElementsByCssSelector(loc).get(index-1).isDisplayed();
					break;
				case "name":
					state = driver.findElementsByName(loc).get(index-1).isDisplayed();
					break;
				case "xpath":
					state = driver.findElementsByXPath(loc).get(index-1).isDisplayed();
					break;
				case "text":
					state = driver.findElementsByAndroidUIAutomator("UiSelector().text(\""+loc+"\")").get(index-1).isDisplayed();
					break;
				}
			}
			return state;
}
	
}