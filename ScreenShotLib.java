package com.actitime.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotLib 
{
	WebDriver driver;
	
	public ScreenShotLib (WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void takeScreenshot(String scriptName)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./screenshots/"+scriptName+".png");
		try
		{
			FileUtils.copyFile(srcFile, destFile);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
