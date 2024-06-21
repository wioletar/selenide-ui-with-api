import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ConfigFileReader;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.open;
import static configuration.BrowserConfiguration.getCapabilities;

public class BaseTest {

    HomePage homePage = new HomePage();

    @Before
    public void before() {
        setUpAllureReports();
        getCapabilities(ConfigFileReader.appConfigurationReader("browser"));
        String appAddress = ConfigFileReader.appConfigurationReader("applicationAddress");
        open(appAddress);
        Assert.assertEquals(WebDriverRunner.url(), appAddress);
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