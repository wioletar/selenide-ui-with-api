package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    public SelenideElement consentButton = $("button.fc-cta-consent p").as("Consent button");
    public SelenideElement signupLoginButton = $("a[href='/login']").as("Signup / Login");
    public SelenideElement loggedInButton = $x("//ul//a[contains(text(),'Logged')]").as("Logged in as");
    public SelenideElement deleteAccountButton = $x("//ul//a[contains(text(),'Delete')]").as("Delete Account");

    @Step
    public void deleteAccount() {
        deleteAccountButton.click();
    }
}
