package com.framework.reports;

import java.io.File;
import java.util.Date;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static ExtentReports result;

	// Initialize & generate extent report.
	@Test
	public static ExtentReports getReports() {
		if (result == null) {
			result = new ExtentReports();
			Date date = new Date();
			String folderPath = date.toString().replaceAll(":", "_").replaceAll(" ", "_");
			String resultPath = System.getProperty("user.dir") + "\\results\\" + folderPath;
			String scPath = resultPath + "\\screenshots";
			File file = new File(resultPath);
			file.mkdirs();

			ExtentSparkReporter reporter = new ExtentSparkReporter(resultPath);
			reporter.config().setTheme(Theme.STANDARD);
			reporter.config().setReportName("Test Report");
			reporter.config().setDocumentTitle("Data Driven Test Report");//set the tab name when u open with web browser
			reporter.config().setEncoding("utf-8");
			result.attachReporter(reporter);
		}
		return result;
	}

}
