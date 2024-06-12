import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ConfigFileReader;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeClass
    public static void beforeClass() {
        setUpAllureReports();
        Configuration.browser = ConfigFileReader.appConfigurationReader("browser");
        String appAddress = ConfigFileReader.appConfigurationReader("applicationAddress");
        open(appAddress);
    }

    @AfterClass
    public static void afterClass() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    private static void setUpAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }
}