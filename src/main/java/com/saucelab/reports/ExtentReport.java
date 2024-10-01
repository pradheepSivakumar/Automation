package com.saucelab.reports;

import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.saucelab.constants.FrameworkConstants;

public final class ExtentReport {

	private static ExtentReports extent;

	private ExtentReport() {
	}

	public static void initReports() throws Exception {

		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentreportfilepath());
			extent.attachReporter(spark);

			spark.config().setTheme(Theme.STANDARD);
			spark.config().setReportName("Sause Lab Test Report");
			spark.config().setDocumentTitle("Test Reports");
		}
	}

	public static void flushReports() throws Exception {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportfilepath()).toURI());

	}

	public static void createTest(String testCaseName) {
		ExtentTest test = extent.createTest(testCaseName);
		ExtentManager.setExtentTest(test);

	}

}
