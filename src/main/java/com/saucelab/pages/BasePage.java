package com.saucelab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.saucelab.driver.DriverManager;
import com.saucelab.enums.WaitStrategy;
import com.saucelab.factories.ExplicitWaitFactory;
import com.saucelab.reports.ExtentLogger;

public class BasePage {



	protected void click(By by, WaitStrategy waitStrategy,String elementName) {
	WebElement element=	ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
	element.click();
	try {
		ExtentLogger.pass(elementName+" is clicked",true);
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

	protected void sendKeys(By by, String value, WaitStrategy waitStrategy,String elementName)  {
		WebElement element= ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.sendKeys(value);
		try {
			ExtentLogger.pass(value+" is entered successfully in "+elementName, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}


}
