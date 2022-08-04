package com.selenium.nosalty.pageobject;

import static com.selenium.nosalty.util.WebElementHandler.clickOn;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "kc-registration")
    private WebElement registrationPageButton;

    public void clickOnRegistrationButton() {
        LOGGER.info("Clicking on the Registration button on the Login page");
        clickOn(registrationPageButton, driver);
    }

    public LoginPage(ChromeDriver driver) {
        super(driver);
    }
}
