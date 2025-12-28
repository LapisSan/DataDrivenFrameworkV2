package com.framework.keywords;

import org.testng.*;





public class ValidationKeywords extends GenericKeywords {

    public void validateText(String element, String expectedText) {
        // Code to validate that the text of the specified element matches the expected text
    }
    public void validateTitle(String expectedTitle) {
        // Code to validate that the current page title matches the expected title
    	Assert.assertEquals(driver.getTitle(), expectedTitle, "Page title matched!");

    }
    public void validateElementIsDisplayed(String element) {
        // Code to validate that the specified element is displayed on the page
    }
    public void validateElementIsPresent(String element) {
        // Code to validate that the specified element is enabled
    }
    public void validateElementClickable(String element) {
        // Code to validate that the specified element is clickable
    }
}