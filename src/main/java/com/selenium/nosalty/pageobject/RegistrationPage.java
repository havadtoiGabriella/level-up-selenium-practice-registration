package com.selenium.nosalty.pageobject;

import static com.selenium.nosalty.util.WebElementAssertions.elementHasText;
import static com.selenium.nosalty.util.WebElementAssertions.elementIsDisabled;
import static com.selenium.nosalty.util.WebElementHandler.*;
import java.util.List;
import com.selenium.nosalty.data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {
    private By select = By.id("user.attributes.titulus");
    private Select prefixSelect = new Select(driver.findElement(select));

    @FindBy(id = "lastName")
    private WebElement lastNameInputField;

    @FindBy(id = "firstName")
    private WebElement firstNameInputField;

    @FindBy(id = "email")
    private WebElement emailInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "password-confirm")
    private WebElement confirmPasswordInputField;

    @FindBy(id = "user.attributes.birthyear")
    private WebElement birthdayInputField;

    @FindBy(id = "user.attributes.zipcode")
    private WebElement zipcodeInputField;

    @FindBy(className = "form__label--radio")
    private List<WebElement> genders;

    @FindBy(css = "label[for='user.attributes.terms']")
    private WebElement termsCheckbox;

    @FindBy(css = "label[for='user.attributes.edm']")
    private WebElement eDirectMailCheckbox;

    @FindBy(id = "js-submit")
    private WebElement registrationButton;

    @FindBy(css = ".alert.alert--warning")
    private WebElement emailValidationRequestMessage;

    @FindBy(id = "js-confirm-message")
    private WebElement warningMessage;

    public void registerUser(User user) {
        LOGGER.info("Registering with user data");
        long timeStamp = System.currentTimeMillis();
        String[] splittedEmailAddress = user.getEmailAddress().split("@");
        String emailAddress = splittedEmailAddress[0] + timeStamp + '@' + splittedEmailAddress[1];
        selectingPrefix(user.getPrefix());
        fillLastNameFieldWith(user.getLastName());
        fillFirstNameFieldWith(user.getFirstName());
        fillEmailFieldWith(emailAddress);
        fillPasswordFieldWith(user.getPassword());
        fillConfirmPasswordFieldWith(user.getPassword());
        fillBirthdayFieldWith(user.getBirthdayYear());
        fillZipcodeFieldWith(user.getZipcode());
        selectGender(user.getGender());
        acceptTerms();
        checkEDirectMailCheckBox();
        clickOnRegistrationButton();
    }

    public void registerUserWithNotMatchingPasswords(User user) {
        LOGGER.info("Registering with not matching passwords");
        long timeStamp = System.currentTimeMillis();
        String[] splittedEmailAddress = user.getEmailAddress().split("@");
        String emailAddress = splittedEmailAddress[0] + timeStamp + '@' + splittedEmailAddress[1];
        selectingPrefix(user.getPrefix());
        fillLastNameFieldWith(user.getLastName());
        fillFirstNameFieldWith(user.getFirstName());
        fillEmailFieldWith(emailAddress);
        fillPasswordFieldWith(user.getPassword());
        fillConfirmPasswordFieldWith(timeStamp + user.getPassword());
        fillBirthdayFieldWith(user.getBirthdayYear());
        fillZipcodeFieldWith(user.getZipcode());
        selectGender(user.getGender());
        acceptTerms();
        checkEDirectMailCheckBox();
    }

    public void registerUserWithoutCheckingTerms(User user) {
        LOGGER.info("Registering without checking the terms checkbox");
        long timeStamp = System.currentTimeMillis();
        String[] splittedEmailAddress = user.getEmailAddress().split("@");
        String emailAddress = splittedEmailAddress[0] + timeStamp + '@' + splittedEmailAddress[1];
        selectingPrefix(user.getPrefix());
        fillLastNameFieldWith(user.getLastName());
        fillFirstNameFieldWith(user.getFirstName());
        fillEmailFieldWith(emailAddress);
        fillPasswordFieldWith(user.getPassword());
        fillConfirmPasswordFieldWith(user.getPassword());
        fillBirthdayFieldWith(user.getBirthdayYear());
        fillZipcodeFieldWith(user.getZipcode());
        selectGender(user.getGender());
        checkEDirectMailCheckBox();
    }

    public void checkIfEmailValidationRequestIsDisplayed(String message) {
        LOGGER.info("Checking if email validation request message: '" + message + "' is displayed");
        waitForElementToBeVisible(emailValidationRequestMessage, driver);
        elementHasText(emailValidationRequestMessage, message);
    }

    public void checkIfCorrectWarningMessageIsDisplayed(String message) {
        LOGGER.info("Checking if correct warning message: '" + message + "' is displayed");
        elementHasText(warningMessage, message);
    }

    public void checkIfRegistrationButtonIsDisabled() {
        LOGGER.info("Checking if Registration button is disabled");
        elementIsDisabled(registrationButton);
    }

    private void selectingPrefix(String option) {
        LOGGER.info("Selecting prefix: '" + option + "'");
        selectFromByVisibleText(prefixSelect, option);
    }

    private void fillLastNameFieldWith(String lastName) {
        LOGGER.info("Filling last name with: '" + lastName + "'");
        sendKeysTo(lastNameInputField, lastName);
    }

    private void fillFirstNameFieldWith(String firstName) {
        LOGGER.info("Filling first name with: '" + firstName + "'");
        sendKeysTo(firstNameInputField, firstName);
    }

    private void fillEmailFieldWith(String emailAddress) {
        LOGGER.info("Filling email address with: '" + emailAddress + "'");
        sendKeysTo(emailInputField, emailAddress);
    }

    private void fillPasswordFieldWith(String password) {
        LOGGER.info("Filling password with: '" + password + "'");
        sendKeysTo(passwordInputField, password);
    }

    private void fillConfirmPasswordFieldWith(String confirmPassword) {
        LOGGER.info("Filling confirm password with: '" + confirmPassword + "'");
        sendKeysTo(confirmPasswordInputField, confirmPassword);
    }

    private void fillBirthdayFieldWith(String birthYear) {
        LOGGER.info("Filling birth year with: '" + birthYear + "'");
        sendKeysTo(birthdayInputField, birthYear);
    }

    private void fillZipcodeFieldWith(String zipcode) {
        LOGGER.info("Filling zip code with: '" + zipcode + "'");
        sendKeysTo(zipcodeInputField, zipcode);
    }

    private void selectGender(String gender) {
        LOGGER.info("Selecting: '" + gender + "' gender");
        for (WebElement genderType : genders) {
            if (elementAttributeContains(genderType, "for", gender)) {
                clickOn(genderType, driver);
            }
        }
    }

    private void acceptTerms() {
        LOGGER.info("Accepting the terms checkbox");
        clickOn(termsCheckbox, driver);
    }

    private void checkEDirectMailCheckBox() {
        LOGGER.info("Checking the electronic direct mail checkbox");
        clickOn(eDirectMailCheckbox, driver);
    }

    private void clickOnRegistrationButton() {
        LOGGER.info("Clicking on the registration button");
        clickOn(registrationButton, driver);
    }

    public RegistrationPage(ChromeDriver driver) {
        super(driver);
    }
}
