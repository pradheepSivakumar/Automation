package com.saucelab.pages;

import org.openqa.selenium.By;

import com.saucelab.enums.WaitStrategy;

public final class SauseLabHomepage extends BasePage {

	private final By iconHamburger = By.id("react-burger-menu-btn");
	private final By linkLogout = By.id("logout_sidebar_link");

	public SauseLabHomepage clickHamburger() {
		click(iconHamburger, WaitStrategy.PRESENCE, "Hamburger icon");

		return this;
	}

	public SauseLabLoginpage clickLogout() {
		// Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));

		click(linkLogout, WaitStrategy.CLICKABLE, "Logout link");
		return new SauseLabLoginpage();
	}

}
