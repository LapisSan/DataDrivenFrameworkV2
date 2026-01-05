package TestBase;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.framework.keywords.ApplicationKeywords;
import com.framework.reports.ExtentManager;

public class BaseClass {
	// creating object of ApplicationKeywords class to use GenericKeywords method.
	public ApplicationKeywords app;
	public ExtentReports extentReport;
	public ExtentTest extentTest;

	@BeforeTest
	public void beforeTest(ITestContext context) {

		// single app object for single tc
		// initialize and share with every tc as we are initializing in @BeforeTest
		app = new ApplicationKeywords();
		context.setAttribute("app", app);

		/*
		 * init report context.getCurrentXmlTest().getName() will supply the name of tc
		 * which is given in TestNG xml file
		 */
		extentReport = ExtentManager.getReports();
		extentTest = extentReport.createTest(context.getCurrentXmlTest().getName());
		extentTest.log(Status.INFO, "Starting test : " + extentTest);
		context.setAttribute("extentReport", extentReport);
		context.setAttribute("extentTest", extentTest);
	}

	@AfterTest
	public void afterTest(ITestContext context) {
		extentReport = (ExtentReports) context.getAttribute("extentReport");
		extentTest = (ExtentTest) context.getAttribute("extentTest");
		if (extentReport != null)
			extentReport.flush(); // will save the report
		app = (ApplicationKeywords) context.getAttribute("app");
		if (app != null)
			app.quiteBrowser();
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(ITestContext context) {

		app = (ApplicationKeywords) context.getAttribute("app");
		extentReport = (ExtentReports) context.getAttribute("extentReport");
		extentTest = (ExtentTest) context.getAttribute("extentTest");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("After Method");
	}

}
