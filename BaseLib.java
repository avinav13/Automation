package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class BaseLib 
{
	public static WebDriver driver;            //global driver
	
	@BeforeMethod
	@Parameters({"browser", "baseurl"})
	public static void setUp(String browserName, String url)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:/Selenium/Chrome/Latest/chromedriver.exe");
			driver=new ChromeDriver();
			Reporter.log("Chrome Launched", true);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.driver", "D:/Selenium/Firefox/Geckodriver v0.23.0/geckodriver.exe");
			driver=new ChromeDriver();
			Reporter.log("Firefox Launched", true);
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "D:/Selenium/Internet Explorer.IEDriverServer.exe");
			driver=new ChromeDriver();
			Reporter.log("IE Launched", true);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to(url);
		Reporter.log(url+"url is navigated", true);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		String scriptName = result.getMethod().getMethodName();
		if(result.isSuccess())      //true
		{
			Reporter.log(scriptName+"script is passed :)", true);
		}
		else   //false
		{
			ScreenShotLib slib = new ScreenShotLib(driver);
			slib.takeScreenshot(scriptName);
			Reporter.log("Screenshot has been taken", true);
		}
	}
	
}
