package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class AccountConfirmationPage {

    public SelenideElement accountCreatedText = $("h2[data-qa='account-created']");
    public SelenideElement accounDeletedText = $("h2[data-qa='account-deleted']");
    public SelenideElement continueButton = $("a[data-qa='continue-button']");

    @Step
    public AccountConfirmationPage clickContinueButton() {
        continueButton.click();
        return this;
    }
}
