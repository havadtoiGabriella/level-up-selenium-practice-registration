package com.selenium.nosalty.driver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static ChromeDriver driver;

    public static ChromeDriver getChromeDriver() {
        return driver;
    }

    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void closeDriver() {
        driver.quit();
    }
}
