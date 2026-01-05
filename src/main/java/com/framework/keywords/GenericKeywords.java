package com.framework.keywords;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// This class can contain generic keywords that can be used across different test cases
// For example, methods for opening a browser, navigating to a URL, etc.

public class GenericKeywords {
	public WebDriver driver = null; // creating public instance of Webdriver
	public WebElement element;
	public Properties prop;

	public void openBrowser(String browserkey) {
		String browserName = prop.getProperty(browserkey);
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized", "--disable-infobars");
			options.addArguments("--disable-extensions");

			options.addArguments("--incognito");
			options.addArguments("--disable-notifications");
			options.addArguments("ignore-certificate-errors");

			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();

			ProfilesIni profiles = new ProfilesIni();
			FirefoxProfile ffprofile = profiles.getProfile("TestUser");

			ffprofile.setPreference("dom.webnotifications.enabled", false);
			ffprofile.setAcceptUntrustedCertificates(true);
			ffprofile.setAssumeUntrustedCertificateIssuer(false);

			options.setProfile(ffprofile);
			driver = new FirefoxDriver(options);
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void open(String urlKey) {
		// Code to navigate to the specified URL
		driver.get(prop.getProperty(urlKey));
	}

	public By getLocator(String locatorKey) {
		By by = null;
		if (locatorKey.endsWith("_id"))
			by = By.id(prop.getProperty(locatorKey));
		else if (locatorKey.endsWith("_xpath"))
			by = By.xpath(prop.getProperty(locatorKey));
		else if (locatorKey.endsWith("_parLinkText"))
			by = By.partialLinkText(prop.getProperty(locatorKey));
		else if (locatorKey.endsWith("_linktext"))
			by = By.linkText(prop.getProperty(locatorKey));
		else if (locatorKey.endsWith("_name"))
			by = By.name(prop.getProperty(locatorKey));
		else if (locatorKey.endsWith("_css"))
			by = By.cssSelector(prop.getProperty(locatorKey));
		else if (locatorKey.endsWith("_tagName"))
			by = By.tagName(prop.getProperty(locatorKey));
		return by;
	}

	public WebElement getElement(String locatorKey) {
		if (!isElementPresent(locatorKey))
			System.out.println("❌ Failed to find element" + locatorKey);
		if (!isElementVisible(locatorKey))
			System.out.println("❌ Element is not visible" + locatorKey);
		element = driver.findElement(getLocator(locatorKey));
		return element;
	}

	public List<WebElement> getElements(String locatorKey) {
		List<WebElement> element = driver.findElements(getLocator(locatorKey));
		return element;
	}

	public boolean isElementPresent(String locatorKey) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isElementVisible(String locatorKey) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void wait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public static void pause(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Code to click on the specified element
	public void click(String locatorKey) {
		// Code to click on the specified element
		// driver.findElement(By.xpath(locator)).click();
		// By locator = By.xpath(prop.getProperty(locatorKey));
		// By locator = getLocator(locatorKey);
		getElement(locatorKey);
		try {
			// element = waitForelementToBePresent(locator, 10);
			element.click();
			System.out.println("✅ Successfully clicked on element:" + locatorKey);
		} catch (Exception e) {
			System.out.println("❌ Failed to click on element " + locatorKey + " | Reason: " + e.getMessage());
		}
	}

	public void set(String locatorKey, String text) {
		// Code to enter text into the specified element
		// By locator = getLocator(locatorKey);
		// element = driver.findElement(locator);
		getElement(locatorKey);
		try {
			// element = waitForelementToBePresent(locator, 10);
			element.sendKeys(text);
			System.out.println("✅ Successfully set text: '" + text + "' in element: " + locatorKey);
		} catch (Exception e) {
			System.out.println("❌ Failed to set text in element: " + locatorKey + " | Reason: " + e.getMessage());
		}
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

	// Code to wait for the specified element to be present
	public void waitForelementToBePresent(String locatorKey, int timeOutInSeconds) {
		By locator = getLocator(locatorKey);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("❌ Failed to find element: " + locatorKey);
		}

	}

	public void verifyElementPresent(String element) {
		// Code to verify that the specified element is present on the page
	}

	public void takeScreenshot(String fileName) {
		// Code to take a screenshot and save it with the specified file name
		try {
			// creating time stamp to make the file name as unique
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			// Taking sc
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// set destination file
			String destPath = System.getProperty("user.dir") + "/screenshots/" + fileName + "_" + timeStamp + "_"
					+ ".png";
			File file = new File(destPath);
			// copy file to destination
			FileUtils.copyFile(srcFile, file);
			System.out.println("Screenshot saved in : " + destPath);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to save screenshot." + e.getMessage());
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