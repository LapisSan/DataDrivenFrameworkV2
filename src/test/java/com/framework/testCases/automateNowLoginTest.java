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
		aK.click("new_user");
		aK.waitForelementToBePresent(By.id("register"), 10);
		aK.set("firstName_id", "Souradip");
		aK.pause(10);
		aK.set("lastName_id", "Nath");
		aK.pause(10);
		aK.set("userName_id", "Lapis05");
		aK.pause(10);
		aK.set("password", "Lapis@1234");
		aK.pause(10);
		aK.click("register_id");
		aK.pause(10);
		
		aK.takeScreenshot("loginTest");
		
		
		
		aK.quiteBrowser();
	}

}
