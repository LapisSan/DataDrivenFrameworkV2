package com.framework.testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


import com.framework.keywords.ApplicationKeywords;

public class automateNowLoginTest extends ApplicationKeywords {
	@Test
	public void loginTest() {
		ApplicationKeywords aK = new ApplicationKeywords();
		aK.openBrowser("browser_name");
		aK.open("URL");
		aK.takeScreenshot("loginTest");
		aK.validateTitle("DEMOQA");
		aK.click("newUser_xpath");
		aK.set("firstName_id", "Souradip");
		aK.set("lastName_id", "Nath");
		aK.set("userName_id", "Lapis05");
		aK.set("password_id", "Lapis@1234");
		aK.click("register_id");
		aK.takeScreenshot("loginTest");
		
		
		
		aK.quiteBrowser();
	}

}
