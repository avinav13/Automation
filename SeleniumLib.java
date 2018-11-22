package com.actitime.generic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class SeleniumLib 
{
	WebDriver driver;
	/*********************************************constructor************************/
	public SeleniumLib(WebDriver driver)
	{
		this.driver=driver;
	}
	/*****************************************enter data into textbox****************/
	public void enterData(WebElement txtBx, String input)
	{
		txtBx.clear();
		txtBx.sendKeys(input);
	}
	/******************verify and click checkbox*********************/
	public void clickChkBx(WebElement chkBx)
	{
		if(chkBx.isSelected())             //true
		{
			Reporter.log("Checkbox is already selected", true);
		}
		else                               //false
		{
			chkBx.click();
		}
	}
//	/**********************verify element present in the HTML doc*************************/
//	public void verifyElementExist(WebElement ele)
//	{
//		try
//		{
//			
//		}
//		catch
//	}
	
	/*****************mouse overing****************************************************/
	public void mouseOver(WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	/************************select option by text in dropdown*********************/
	public void selectOptionByText (WebElement drpdwn, String optiontext)
	{
		Select sel = new Select(drpdwn);
		sel.selectByVisibleText(optiontext);
	}
	/*************************get total options text from dropdown*******************/
	public List<String> getAllOptionsText(WebElement drpdwn)
	{
		Select sel=new Select(drpdwn);
		List<WebElement> allOps = sel.getOptions();
		
		List<String> lt = new ArrayList<String>();

		for(int i=0; i< allOps.size(); i++)
		{
			lt.add(allOps.get(i).getText());
		}
		return lt;
	}
	/********************explicit wait for visiblity**************************/
	public void eWaitForVisible(WebElement ele, int secs)
	{
		WebDriverWait wait = new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	/****************************Hardcore wait***********************************/
	public void iSleep(int secs)
	{
		try
		{
			Thread.sleep(secs*1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	/*******************assertEquals by text*********************************/
	public void assertByText(String actText, String expText)
	{
		Assert.assertEquals(actText, expText);
		Reporter.log(expText+"is verified", true);
	}
	/*********************assertEquals by Object Array***********************/
	public void assertByObjectArray(Object[] actual, Object[] exp)
	{
		Assert.assertEquals(actual, exp);
		for(int i=0; i< exp.length; i++)
		{
			Reporter.log(exp[i]+"is verified", true);
		}
	}
	/***********************************assertTrue by text contains************///used to verify the message whether the customer is created or not
	public void assertByTextContains(WebElement ele, String actText)
	{
		Assert.assertTrue(ele.getText().contains(actText));
		Reporter.log(ele.getText(), true);
	}
	/*********************************assertTrue whether element displayed*********///                         "
	public void assertElementDisplayed(WebElement ele)
	{
		Assert.assertTrue(ele.isDisplayed());
		Reporter.log("Element isn displayed", true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
