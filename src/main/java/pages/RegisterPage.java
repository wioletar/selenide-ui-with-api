package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import model.User;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegisterPage {

    Random random = new Random();
    public ElementsCollection genderRadioButtons = $$("div.radio-inline input[type='radio']");
    public SelenideElement passwordInput = $("input[type='password']");
    public SelenideElement newsletterCheckbox = $("label[for='newsletter']");
    public SelenideElement offersCheckbox = $("label[for='optin']");
    public SelenideElement createAccountButton = $("button[data-qa='create-account']");
    public SelenideElement firstNameInput = $(By.id("first_name"));
    public SelenideElement lastNameInput = $(By.id("last_name"));
    public SelenideElement yearSelect = $(By.id("years"));
    public ElementsCollection yearList = $$("select[data-qa='years'] option");
    public SelenideElement monthsSelect = $(By.id("months"));
    public ElementsCollection monthList = $$("select[data-qa='months'] option");
    public SelenideElement daySelect = $(By.id("days"));
    public ElementsCollection dayList = $$("select[data-qa='days'] option");
    public SelenideElement countryInput = $(By.id("country"));
    public ElementsCollection countryList = $$("select[data-qa='country'] option");
    public SelenideElement companyInput = $(By.id("company"));
    public SelenideElement address1Input = $(By.id("address1"));
    public SelenideElement address2Input = $(By.id("address2"));
    public SelenideElement stateInput = $(By.id("state"));
    public SelenideElement cityInput = $(By.id("city"));
    public SelenideElement zipcodeInput = $(By.id("zipcode"));
    public SelenideElement mobileNumberInput = $(By.id("mobile_number"));

    @Step
    public RegisterPage clickRandomTitle() {
        int randomItem = random.nextInt(genderRadioButtons.size() - 1);
        genderRadioButtons.get(randomItem).click();
        return this;
    }

    @Step
    public RegisterPage inputPassword(User user) {
        passwordInput.setValue(user.getPassword());
        return this;
    }

    @Step
    public RegisterPage clickNewsletterCheckbox() {
        newsletterCheckbox.scrollTo();
        newsletterCheckbox.click();
        return this;
    }

    @Step
    public RegisterPage clickOffersCheckbox() {
        offersCheckbox.click();
        return this;
    }

    @Step
    public RegisterPage clickCreateAccountButton() {
        createAccountButton.scrollTo();
        createAccountButton.click();
        return this;
    }

    @Step
    public RegisterPage clickRandomYear() {
        yearSelect.scrollTo();
        int randomItem = random.nextInt(1, yearList.size() - 1);
        yearSelect.selectOption(randomItem);
        return this;
    }

    @Step
    public RegisterPage clickRandomMonth() {
        int randomItem = random.nextInt(1, monthList.size() - 1);
        monthsSelect.selectOption(randomItem);
        return this;
    }

    @Step
    public RegisterPage clickRandomDay() {
        int randomItem = random.nextInt(1, dayList.size() - 1);
        daySelect.selectOption(randomItem);
        return this;
    }

    @Step
    public RegisterPage clickRandomCountry() {
        int randomItem = random.nextInt(0, countryList.size() - 1);
        countryInput.selectOption(randomItem);
        return this;
    }

    @Step
    public RegisterPage inputFirstName(User user) {
        firstNameInput.setValue(user.getFirstName());
        return this;
    }

    @Step
    public RegisterPage inputLastName(User user) {
        lastNameInput.setValue(user.getLastName());
        return this;
    }

    @Step
    public RegisterPage inputCompany(User user) {
        companyInput.setValue(user.getCompany());
        return this;
    }

    @Step
    public RegisterPage inputAddress(User user) {
        address1Input.setValue(user.getAddress());
        return this;
    }

    @Step
    public RegisterPage inputAddress2(User user) {
        address2Input.setValue(user.getAddress2());
        return this;
    }

    @Step
    public RegisterPage inputState(User user) {
        stateInput.setValue(user.getState());
        return this;
    }

    @Step
    public RegisterPage inputCity(User user) {
        cityInput.setValue(user.getCity());
        return this;
    }

    @Step
    public RegisterPage inputZipcode(User user) {
        zipcodeInput.setValue(user.getZipcode());
        return this;
    }

    @Step
    public RegisterPage inputMobileNumber(User user) {
        mobileNumberInput.setValue(user.getMobileNumber());
        return this;
    }
}
