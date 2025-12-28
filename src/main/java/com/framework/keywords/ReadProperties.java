package com.framework.keywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadProperties {
	
	public static void main(String ar[]) {
		Properties prop = new Properties();
		
		try {
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Object.properties");
			prop.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("browser_name"));
		System.out.println(prop.getProperty("new_user"));
		System.out.println(prop.getProperty("password"));
	}

}
