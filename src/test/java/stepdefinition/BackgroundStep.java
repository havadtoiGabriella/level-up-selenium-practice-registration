package stepdefinition;

import com.selenium.nosalty.pageobject.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class BackgroundStep extends BaseStepDefinition {
    private final LoginPage loginPage = new LoginPage(driver);

    @Given("I navigate to to the Login page")
    public void i_navigate_to_the_login_page() {
        driver.navigate().to(BASE_URL);
    }

    @And("I navigate to the Registration page")
    public void i_navigate_to_the_registration_page() {
        loginPage.clickOnRegistrationButton();
    }
}
