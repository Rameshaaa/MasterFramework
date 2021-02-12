package com.mas.resources;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileFunctionsBase {
	
	AndroidDriver<AndroidElement> Mobiledriver;
	String Host = "http://127.0.0.1:4723/wd/hub";
	String ChromePath = System.getProperty("user.dir")+"\\Drivers\\ChromeMobileversiondriver\\chromedriver.exe";
	
	public AndroidDriver<AndroidElement> LaunchMobileWebApp(String platformName, String deviceName, String browserName) throws MalformedURLException
	{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
		cap.setCapability("chromedriverExecutable",ChromePath);
		
		Mobiledriver=new AndroidDriver<AndroidElement>(new URL(Host),cap);
		return Mobiledriver;
	}	
	
	public AndroidDriver<AndroidElement> LaunchNativeApp(String platformName, String deviceName, String appPackageName, String appActivityName) throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability("appPackage", appPackageName);
		cap.setCapability("appActivity",appActivityName);
		
		
		Mobiledriver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return Mobiledriver;
	}
	
	public AndroidElement Click(By Obj)
	{
		AndroidElement element =Mobiledriver.findElement(Obj);
		element.click();
		return element;
	}
	
	public AndroidElement Entertext(By obj, String Value)
	{
		AndroidElement element = Mobiledriver.findElement(obj);
		element.sendKeys(Value);
		return element;
	}

	public void getURL(String URL)
	{
		Mobiledriver.get(URL);
		
	}
}
