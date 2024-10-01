package com.saucelab.constants;

import com.saucelab.enums.ConfigProperties;
import com.saucelab.utils.PropertyUtils;

public final class FrameworkConstants {

	private static final int EXPLICITWAIT = 20;
	private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/executables/chromedriver.exe";
	private static final String GECKODRIVERPATH = RESOURCESPATH + "/executables/geckodriver.exe";
	private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";
	private static final String EXCElFILEPATH = RESOURCESPATH + "/excel/testdata.xlsx";
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	private static final String ITERATIONDATASHEET = "USERCREDENTIALS";

	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-report-output/";
	private static String extentreportfilepath = "";

	public static String getChromedriverPath() {
		return CHROMEDRIVERPATH;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static int getExplicitWait() {
		return EXPLICITWAIT;
	}

	public static String getExcelfilepath() {
		return EXCElFILEPATH;
	}

	public static String getRunmanagersheet() {
		return RUNMANAGERSHEET;
	}

	public static String getIterationdatasheet() {
		return ITERATIONDATASHEET;
	}

	public static String getGeckodriverpath() {
		return GECKODRIVERPATH;
	}

	public static String getExtentreportfilepath() throws Exception {
		if (extentreportfilepath.isEmpty()) {
			extentreportfilepath = createReportPath();
		}
		return extentreportfilepath;
	}

	private static String createReportPath() throws Exception {
		if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "- index.html";
		}
		return EXTENTREPORTFOLDERPATH + "index.html";
	}

	private FrameworkConstants() {

	}

}
