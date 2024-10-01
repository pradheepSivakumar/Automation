package com.saucelab.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucelab.constants.FrameworkConstants;
import com.saucelab.driver.DriverManager;
import com.saucelab.enums.WaitStrategy;

public class ExplicitWaitFactory {


	public static WebElement performExplicitWait(WaitStrategy waitstrategy, By by) {
		WebElement element = null;
		if(waitstrategy==WaitStrategy.CLICKABLE) {
			element= new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
			.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if(waitstrategy==WaitStrategy.PRESENCE) {
			element=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
			.until(ExpectedConditions.presenceOfElementLocated(by));
		}

		else if(waitstrategy==WaitStrategy.VISIBLE) {
			element=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
			.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		else if(waitstrategy==WaitStrategy.NONE) {
			element=DriverManager.getDriver().findElement(by);

		}
		return element;


	}
}
