package com.saucelab.tests;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.saucelab.driver.DriverManager;

public final  class HomepageTest extends BaseTest {

	private HomepageTest() {

	}


	/*
	 * Validate whether the title contains Swag Labs Validate whether the title
	 * we fetched is not null and the length of title is lesser than 15 and less
	 *
	 */


	@Test
	public void test3() {
		DriverManager.getDriver().findElement(By.xpath("//input[@id='user-name']")).sendKeys("problem_user");
		DriverManager.getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		DriverManager.getDriver().findElement(By.xpath("//input[@id='login-button']")).click();
		String title = DriverManager.getDriver().getTitle();
	/*	Assert.assertTrue(Objects.nonNull(title));
		Assert.assertTrue(title.toLowerCase().contains("Swag"));*/

		Assertions.assertThat(title)
		.isNotEmpty()
		.isNotBlank()
		.isNotNull()
		.containsIgnoringCase("labs");

	}

}
