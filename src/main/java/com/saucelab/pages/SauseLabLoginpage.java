package com.saucelab.pages;

import org.openqa.selenium.By;

import com.saucelab.enums.WaitStrategy;

public final class SauseLabLoginpage extends BasePage {

	private final By textboxUsername = By.id("user-name");
	private final By textboxPassword = By.xpath("//input[@id='password' and @type='password']");
	private final By buttonLogin = By.id("login-button");

	public SauseLabLoginpage enterUsername(String username) {
		sendKeys(textboxUsername, username, WaitStrategy.PRESENCE,"Username");
		return this;

	}

	public SauseLabLoginpage enterPassword(String password) {
		sendKeys(textboxPassword, password, WaitStrategy.PRESENCE,"Password");
		return this;

	}

	public SauseLabHomepage clickLogin() {
		click(buttonLogin,  WaitStrategy.CLICKABLE,"Login button");
		return new SauseLabHomepage();
	}


	public String getTitle() {
		return getPageTitle();
	}


}
