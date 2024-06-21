package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    public SelenideElement consentButton = $("button.fc-cta-consent p");
    public SelenideElement signupLoginButton = $("a[href='/login']");
    public SelenideElement loggedInButton = $x("//ul//a[contains(text(),'Logged')]");
    public SelenideElement deleteAccountButton = $x("//ul//a[contains(text(),'Delete')]");

    @Step
    public HomePage clickDeleteAccountButton() {
        deleteAccountButton.click();
        return this;
    }
}
