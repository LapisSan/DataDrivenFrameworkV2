package testCasesDemonQA;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import TestBase.BaseClass;

/*Login - Elements-Webtables-Add one user in webTables
Login - Elements-Webtables- Edit one user in webTables*/

public class WebTablesFunctions extends BaseClass {
	@Test
	public void addUser() {
		extentTest.log(Status.INFO, "Adding User");
		extentTest.log(Status.INFO, "Opening URL");
		app.open("URL");
	}

	@Test
	public void editUser() {
		System.out.println("Editing User");
	}
}
