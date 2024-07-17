package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SignupLoginPage {

    public SelenideElement newUserSignupHeaderText = $(".signup-form h2");
    public SelenideElement loginHeaderText = $(".login-form h2");
    public SelenideElement signupName = $("form[action='/signup'] input[type='text']");
    public SelenideElement signupEmail = $("form[action='/signup'] input[type='email']");
    public SelenideElement signupButton = $("button[data-qa='signup-button']");

    @Step
    public SignupLoginPage inputSignupName(String name) {
        signupName.setValue(name);
        return this;
    }

    @Step
    public SignupLoginPage inputSignupEmail(String email) {
        signupEmail.setValue(email);
        return this;
    }
}
