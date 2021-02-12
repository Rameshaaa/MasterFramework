package com.mas.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebFunctionsBase {
	
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	String browserName;
	String URL ;
	String ChromePath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
	String firefoxPath = System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe";		
	String Edgedriver = System.getProperty("user.dir")+"\\Drivers\\MicrosoftWebDriver.exe";
	String dataprop = System.getProperty("user.dir")+"\\src\\main\\java\\com\\mas\\resources\\data.properties";

	public WebDriver getWebDriver() throws IOException
	
	{		
		fis = new FileInputStream(dataprop);
		prop = new Properties();
		prop.load(fis);
		browserName =prop.getProperty("browser");
		System.out.println(browserName);
		
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ChromePath);
			driver =new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",firefoxPath);
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", Edgedriver);
			driver = new EdgeDriver();
		}
		
		URL = prop.getProperty("url");
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		return driver;
	}
	
	
	
		
	public Timeouts ImplicitWait()
	{		
		Timeouts wait = driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return wait;

	}
	
	public WebElement click(By Object)
	{
		WebElement element = driver.findElement(Object);
		element.click();
		return element;	
		
	}
	
	public WebElement Entertext(By Object, String text)
	{
		WebElement element = driver.findElement(Object);
		element.sendKeys(text);
		return element;
	}
	
	public WebDriver close()
	
	{
		 driver.quit();
		 return driver;
	}
	
	public Select dropdown(By Object, int index)
	{
		Select s =new Select(driver.findElement(Object));
		s.selectByIndex(index);
		return s;
	
	}
	
	public void ExplicitWait(By Object, String Conditions)
	
	{
		WebDriverWait w =new WebDriverWait(driver, 60);
		String mode = Conditions.toUpperCase();
		switch(mode){
		
		case "VISIBILITY" :
			w.until(ExpectedConditions.visibilityOfElementLocated(Object));
			break;
			
		case "CLICKABLE" :
			
			w.until(ExpectedConditions.elementToBeClickable(Object));
			break;
			
		case "PRESENCE" :
			
			w.until(ExpectedConditions.presenceOfElementLocated(Object));
			break;
			
		}
		
	}

	public Actions hoverElement(By Object)
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(Object)).build().perform();
		return action;
	}
	
	public WebElement getText(By Object)
	{
		
		WebElement element = driver.findElement(Object);
		element.getText().trim();
		return element;
	}
	
	public WebDriver switchWindow()
	{
		String mainWindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> iterator = allwindows.iterator();
		while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
                if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                System.out.println(driver.switchTo().window(ChildWindow).getTitle());
            }
                
	}
		return driver;
	
	}
	
	public WebDriver getPageSource()
	{
		
		driver.getPageSource();
		
		return driver;
	}
	
	public WebDriver AlertAccept()
	
	{
		driver.switchTo().alert().accept();
		return driver;
		
	}
	
	public String screenshot() throws IOException
	
	{	
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\Screenshots\\screenshot.png";
		FileUtils.copyFile(source, new File(destination));
		return destination;	
	}
}























































































