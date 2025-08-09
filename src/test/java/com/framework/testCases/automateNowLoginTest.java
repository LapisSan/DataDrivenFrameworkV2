package com.framework.testCases;

import org.testng.annotations.Test;

import com.framework.keywords.ApplicationKeywords;

public class automateNowLoginTest extends ApplicationKeywords {
	@Test
	public void loginTest() {
		ApplicationKeywords aK = new ApplicationKeywords();
		aK.openBrowser("chrome");
		aK.open("https://practice-automation.com/");
		aK.takeScreenshot("loginTest");
		aK.quiteBrowser();
	}

}
