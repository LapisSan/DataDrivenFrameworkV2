package com.framework.engine;

import com.framework.keywords.ApplicationKeywords;

public class KeywordEngine extends ApplicationKeywords {
	
	public void executeKeyword(String keyword, String locator, String data) {
		switch (keyword.toLowerCase()) {
		
		case "click":
			click(locator);
			break;
			
		case "type":
			set(locator, data);
			break;
			
		case "openBrowser":
			openBrowser(data);
			break;
		
		case "openurl":
			open(data);
			break;
		
		case "validate_title":
			validateTitle(data);
			break;
			
		case "screenshot":
			takeScreenshot(data);
			break;
			
		default:
			System.out.println("Invalid Keyword: "+ keyword);
		}
	}

}
