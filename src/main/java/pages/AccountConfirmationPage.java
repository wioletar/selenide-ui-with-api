package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class AccountConfirmationPage {

    public SelenideElement accountCreatedText = $("h2[data-qa='account-created']").as("Account created header");
    public SelenideElement accounDeletedText = $("h2[data-qa='account-deleted']").as("Account deleted header");
    public SelenideElement continueButton = $("a[data-qa='continue-button']").as("Continue button");

    @Step
    public void clickContinue() {
        continueButton.click();
    }
}
