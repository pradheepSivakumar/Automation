package com.saucelab.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.saucelab.constants.FrameworkConstants;
import com.saucelab.enums.ConfigProperties;
import com.saucelab.utils.PropertyUtils;

public final class Driver {

	private Driver() {

	}




	public static void initDriver(String browser) throws Exception {
		if (Objects.isNull(DriverManager.getDriver())) {
			
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverPath());
				DriverManager.setDriver(new ChromeDriver());
			}
				
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckodriverpath());
				DriverManager.setDriver(new FirefoxDriver());
			}
				
			//WebDriver driver = new ChromeDriver();
			
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();

		}
	}
}
