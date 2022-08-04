package stepdefinition;

import com.selenium.nosalty.data.User;
import com.selenium.nosalty.pageobject.RegistrationPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationPageStep extends BaseStepDefinition {
    private final RegistrationPage registrationPage = new RegistrationPage(driver);

    @When("I register with valid {} data")
    public void i_register_with_valid_user_data(User user) {
        registrationPage.registerUser(user);
    }

    @Then("I should get {string} message")
    public void i_should_get_x_message(String message) {
        registrationPage.checkIfEmailValidationRequestIsDisplayed(message);
    }

    @When("I try to register with not matching {} passwords")
    public void i_try_to_register_with_not_matching_passwords(User user) {
        registrationPage.registerUserWithNotMatchingPasswords(user);
    }

    @Then("I should get {string} warning message")
    public void i_should_get_x_warning_message(String message) {
        registrationPage.checkIfCorrectWarningMessageIsDisplayed(message);
    }

    @When("I try to register with {} without checking the terms checkbox")
    public void i_try_to_register_without_checking_the_terms_checkbox(User user) {
        registrationPage.registerUserWithoutCheckingTerms(user);
    }

    @Then("the Registration button should be disabled")
    public void the_registration_button_should_be_disabled() {
        registrationPage.checkIfRegistrationButtonIsDisabled();
    }
}
