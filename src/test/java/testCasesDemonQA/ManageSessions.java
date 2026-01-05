package testCasesDemonQA;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.framework.keywords.ApplicationKeywords;

import TestBase.BaseClass;

public class ManageSessions extends BaseClass {
	@Test
	public void doLogin() {
		extentTest.log(Status.INFO, "Logging in");
		/*Object app need to be declared in every method to access generic methods which is not good.
		 * so we will declare in before method in base class.*/
		//ApplicationKeywords app = (ApplicationKeywords) con.getAttribute("app");
		extentTest.log(Status.INFO, "Opening browser");
		app.openBrowser("browser_name");
		
	}

	@Test
	public void doLogout() {
		System.out.println("Logging out");
	}

}
