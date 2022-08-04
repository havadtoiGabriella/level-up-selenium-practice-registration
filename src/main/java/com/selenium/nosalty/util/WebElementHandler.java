package com.selenium.nosalty.util;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import com.selenium.nosalty.logger.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementHandler {
    private static final Logger LOGGER = new Logger(WebElementHandler.class);
    private static final long DEFAULT_TIMEOUT = 10;
    private static final long WAIT_TIMEOUT = 5;

    private WebElementHandler() {
    }

    public static void waitForElementToBeVisible(WebElement element, ChromeDriver driver) {
        LOGGER.debug("Waiting for the element to be visible.");
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        wait.withTimeout(ofSeconds(WAIT_TIMEOUT)).until(visibilityOf(element));
    }

    public static void clickOn(WebElement element, ChromeDriver driver) {
        LOGGER.debug("Clicking on the element.");
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        wait.withTimeout(ofSeconds(WAIT_TIMEOUT)).until(elementToBeClickable(element));
        element.click();
    }

    public static void sendKeysTo(WebElement inputField, String text) {
        LOGGER.debug("Sending text " + "'" + text + "'" + " to element.");
        inputField.sendKeys(text);
    }

    public static void selectFromByVisibleText(Select select, String option) {
        LOGGER.debug("Selecting from dropdown by visible text: '" + option + "'");
        select.selectByVisibleText(option);
    }

    public static boolean elementAttributeContains(WebElement element, String attribute, String value) {
        LOGGER.debug("Checking if element '" + attribute + "' contains '" + value + "'");
        return element.getAttribute(attribute).contains(value);
    }
}
