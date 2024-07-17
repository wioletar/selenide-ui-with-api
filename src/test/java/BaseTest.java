import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ConfigFileReader;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import pages.HomePage;
import pages.SignupLoginPage;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static configuration.BrowserConfiguration.getCapabilities;

public class BaseTest {

    SignupLoginPage signupLoginPage = new SignupLoginPage();
    HomePage homePage = new HomePage();
    public static Properties properties = ConfigFileReader.appConfigurationReader();

    @BeforeClass
    public static void beforeClass() {
        setUpAllureReports();
        getCapabilities(properties.getProperty("browser"));
        String appAddress = properties.getProperty("applicationAddress");
        open(appAddress);
        Assert.assertEquals(WebDriverRunner.url(), appAddress);
        HomePage homePage = new HomePage();
        homePage.consentButton.click();
    }

    @After
    public void afterClass() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    private static void setUpAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }
}