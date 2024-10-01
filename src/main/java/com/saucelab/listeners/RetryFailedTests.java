package com.saucelab.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.saucelab.enums.ConfigProperties;
import com.saucelab.utils.PropertyUtils;

public final class RetryFailedTests implements IRetryAnalyzer {

	private int count = 0;
	private int retries = 1;

	@Override
	public boolean retry(ITestResult result) {

		try {
			if (PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
				if (count < retries) {
					count++;
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
