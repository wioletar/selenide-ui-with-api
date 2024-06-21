import com.codeborne.selenide.Condition;
import factory.UserFactory;
import org.junit.Test;
import pages.AccountConfirmationPage;
import pages.HomePage;
import pages.RegisterPage;
import pages.SignupLoginPage;

/**
 * Test Case 1: Register User
 * 1. Launch browser
 * 2. Navigate to url 'http://automationexercise.com'
 * 3. Verify that home page is visible successfully
 * 4. Click on 'Signup / Login' button
 * 5. Verify 'New User Signup!' is visible
 * 6. Enter name and email address
 * 7. Click 'Signup' button
 * 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
 * 9. Fill details: Title, Name, Email, Password, Date of birth
 * 10. Select checkbox 'Sign up for our newsletter!'
 * 11. Select checkbox 'Receive special offers from our partners!'
 * 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
 * 13. Click 'Create Account button'
 * 14. Verify that 'ACCOUNT CREATED!' is visible
 * 15. Click 'Continue' button
 * 16. Verify that 'Logged in as username' is visible
 * 17. Click 'Delete Account' button
 * 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
 */

public class RegisterUserTest extends BaseTest {

    HomePage homePage = new HomePage();
    SignupLoginPage signupLoginPage = new SignupLoginPage();
    RegisterPage registerPage = new RegisterPage();
    UserFactory userFactory = new UserFactory();
    AccountConfirmationPage accountConfirmationPage = new AccountConfirmationPage();

    @Test
    public void userCanRegister() {
        homePage.signupLoginButton.click();
        signupLoginPage.newUserSignupHeaderText.shouldHave(Condition.exactText("New User Signup!"));
        signupLoginPage.inputSignupName(userFactory.userWithAllData);
        signupLoginPage.inputSignupEmail(userFactory.userWithAllData);
        signupLoginPage.signupButton.click();
        registerPage.clickRandomTitle()
                .inputPassword(userFactory.userWithAllData)
                .clickRandomYear()
                .clickRandomMonth()
                .clickRandomDay()
                .clickNewsletterCheckbox()
                .clickOffersCheckbox()
                .inputFirstName(userFactory.userWithAllData)
                .inputLastName(userFactory.userWithAllData)
                .inputCompany(userFactory.userWithAllData)
                .inputAddress(userFactory.userWithAllData)
                .inputAddress2(userFactory.userWithAllData)
                .clickRandomCountry()
                .inputState(userFactory.userWithAllData)
                .inputCity(userFactory.userWithAllData)
                .inputZipcode(userFactory.userWithAllData)
                .inputMobileNumber(userFactory.userWithAllData)
                .clickCreateAccountButton();
        accountConfirmationPage.accountCreatedText.shouldHave(Condition.exactText("Account Created!"));
        accountConfirmationPage.clickContinueButton();
        homePage.loggedInButton.shouldHave(Condition.partialText(userFactory.userWithAllData.getName()));
        homePage.clickDeleteAccountButton();
        accountConfirmationPage.accounDeletedText.shouldHave(Condition.exactText("Account Deleted!"));
    }
}
