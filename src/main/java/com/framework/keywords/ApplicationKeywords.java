package com.framework.keywords;

import java.io.FileInputStream;
import java.util.Properties;

public class ApplicationKeywords extends ValidationKeywords {

	public ApplicationKeywords() {
		prop = new Properties();
		try {
			FileInputStream fs = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Object.properties");
			prop.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void login() {
		// Code to perform login action
	}

	public void selectDate() {
		// Code to select a date from a date picker
	}

}