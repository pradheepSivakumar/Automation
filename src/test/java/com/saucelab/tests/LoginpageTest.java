package com.saucelab.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.saucelab.pages.SauseLabLoginpage;

public final class LoginpageTest extends BaseTest {

	private LoginpageTest() {

	}

	@Test
	public void loginLogoutTest(Map<String, String> data) {

		String title = new SauseLabLoginpage().enterUsername(data.get("username")).enterPassword(data.get("password"))
				.clickLogin().clickHamburger().clickLogout().getTitle();

		Assertions.assertThat(title).isEqualTo("Swag Labs");

	}
	


}
