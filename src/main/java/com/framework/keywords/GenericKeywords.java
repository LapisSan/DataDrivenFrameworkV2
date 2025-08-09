package com.framework.keywords;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.safari.SafariDriver;

// This class can contain generic keywords that can be used across different test cases
// For example, methods for opening a browser, navigating to a URL, etc.


public class GenericKeywords {
    public WebDriver driver=null; //creating public instance of Webdriver

    public void openBrowser(String browserName) {
        
        if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized", "--disable-infobars");
			options.addArguments("--disable-extensions");
			
			options.addArguments("--incognito");
			options.addArguments("--disable-notifications");
			options.addArguments("ignore-certificate-errors");
			
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			FirefoxOptions options  = new FirefoxOptions();
			
			ProfilesIni profiles = new ProfilesIni();
			FirefoxProfile ffprofile = profiles.getProfile("TestUser");
			
			ffprofile.setPreference("dom.webnotifications.enabled", false);
			ffprofile.setAcceptUntrustedCertificates(true);
			ffprofile.setAssumeUntrustedCertificateIssuer(false);
			
			options.setProfile(ffprofile);
			driver = new FirefoxDriver(options);
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }
    public void open(String url) {
        // Code to navigate to the specified URL
    	driver.get(url);
    }
    public void click(String element) {
        // Code to click on the specified element
    }
    public void enterText(String element, String text) {
        // Code to enter text into the specified element
    }
    public void verifyElementPresent(String element) {
        // Code to verify that the specified element is present on the page
    }
     public void waitForElement(String element) {
        // Code to wait for the specified element to be present
    }
    public void select() {
        // Code to wait for the page to load completely
    }
    public void getText() {
        // Code to wait for the page to load completely
    }
    public void refreshPage() {
        // Code to refresh the current page
    }
    public void takeScreenshot(String fileName) {
        // Code to take a screenshot and save it with the specified file name
    	try {
    	//creating time stamp to make the file name as unique
    	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    	//Taking sc
    	File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	//set destination file
    	String destPath = System.getProperty("user.dir")+"/screenshots/"+fileName+"_"+timeStamp+"_"+".png";
    	File file = new File(destPath);
    	//copy file to destination
    	FileUtils.copyFile(srcFile, file);
    	System.out.println("Screenshot saved in : "+destPath);
    	}catch(IOException e) {
    		e.printStackTrace();
    		System.out.println("Failed to save screenshot."+e.getMessage());
    	}
    	
    	
    }
    public void log(String message) {
        // Code to log messages for debugging or reporting purposes
    }
    public void acceptAlert() {
        // Code to accept an alert dialog
    }
    public void dismissAlert() {
        // Code to dismiss an alert dialog
    }
    public void closeBrowser() {
        // Code to close the browser
    	driver.close();
    }
    public void quiteBrowser() {
        // Code to close the browser
    	driver.quit();
    }
   


}