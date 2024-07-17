package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import model.User;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegisterPage {

    Random random = new Random();
    SignupLoginPage signupLoginPage = new SignupLoginPage();
    public ElementsCollection genderRadioButtons = $$("div.radio-inline input[type='radio']");
    public SelenideElement passwordInput = $("input[type='password']");
    public SelenideElement newsletterCheckbox = $("label[for='newsletter']");
    public SelenideElement offersCheckbox = $("label[for='optin']");
    public SelenideElement createAccountButton = $("button[data-qa='create-account']");
    public SelenideElement firstNameInput = $("#first_name");
    public SelenideElement lastNameInput = $("#last_name");
    public SelenideElement yearSelect = $("#years");
    public SelenideElement monthsSelect = $("#months");
    public SelenideElement daySelect = $("#days");
    public SelenideElement countryInput = $("#country");
    public ElementsCollection countryList = $$("select[data-qa='country'] option");
    public SelenideElement companyInput = $("#company");
    public SelenideElement address1Input = $("#address1");
    public SelenideElement address2Input = $("#address2");
    public SelenideElement stateInput = $("#state");
    public SelenideElement cityInput = $("#city");
    public SelenideElement zipcodeInput = $("#zipcode");
    public SelenideElement mobileNumberInput = $("#mobile_number");

    @Step
    public void clickRandomTitle() {
        int randomItem = random.nextInt(genderRadioButtons.size() - 1);
        genderRadioButtons.get(randomItem).click();
    }

    @Step
    public void enterPassword(String password) {
        passwordInput.setValue(password);
    }

    @Step
    public void checkNewsletter() {
        newsletterCheckbox.scrollTo();
        newsletterCheckbox.click();
    }

    @Step
    public void checkOffers() {
        offersCheckbox.click();
    }

    @Step
    public void clickCreateAccountButton() {
        createAccountButton.scrollTo();
        createAccountButton.click();
    }

    @Step
    public void clickRandomYear() {
        yearSelect.scrollTo();
        ElementsCollection yearList = $$("select[data-qa='years'] option");
        int randomItem = random.nextInt(1, yearList.size() - 1);
        yearSelect.selectOption(randomItem);
    }

    @Step
    public void clickRandomMonth() {
        ElementsCollection monthList = $$("select[data-qa='months'] option");
        int randomItem = random.nextInt(1, monthList.size() - 1);
        monthsSelect.selectOption(randomItem);
    }

    @Step
    public void clickRandomDay() {
        ElementsCollection dayList = $$("select[data-qa='days'] option");
        int randomItem = random.nextInt(1, dayList.size() - 1);
        daySelect.selectOption(randomItem);
    }

    @Step
    public void clickRandomCountry() {
        int randomItem = random.nextInt(0, countryList.size() - 1);
        countryInput.selectOption(randomItem);
    }

    @Step
    public void inputFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }

    @Step
    public void inputLastName(String lastName) {
        lastNameInput.setValue(lastName);

    }

    @Step
    public void inputCompany(String company) {
        companyInput.setValue(company);
    }

    @Step
    public void inputAddress(String address) {
        address1Input.setValue(address);
    }

    @Step
    public void inputAddress2(String address2) {
        address2Input.setValue(address2);
    }

    @Step
    public void inputState(String state) {
        stateInput.setValue(state);
    }

    @Step
    public void inputCity(String city) {
        cityInput.setValue(city);
    }

    @Step
    public void inputZipcode(String zipcode) {
        zipcodeInput.setValue(zipcode);
    }

    @Step
    public void inputMobileNumber(String mobileNumber) {
        mobileNumberInput.setValue(mobileNumber);
    }

    public void fillFormCorrectly(User user) {
        signupLoginPage.inputSignupName(user.getName());
        signupLoginPage.inputSignupEmail(user.getEmail());
        signupLoginPage.signupButton.click();
        clickRandomTitle();
        enterPassword(user.getPassword());
        clickRandomYear();
        clickRandomMonth();
        clickRandomDay();
        checkNewsletter();
        checkOffers();
        inputFirstName(user.getFirstName());
        inputLastName(user.getLastName());
        inputCompany(user.getCompany());
        inputAddress(user.getAddress());
        inputAddress2(user.getAddress2());
        clickRandomCountry();
        inputState(user.getState());
        inputCity(user.getCity());
        inputZipcode(user.getZipcode());
        inputMobileNumber(user.getMobileNumber());
        clickCreateAccountButton();
    }
}
