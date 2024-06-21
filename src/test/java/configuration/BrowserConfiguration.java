package configuration;

import com.codeborne.selenide.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

@Slf4j
public class BrowserConfiguration {


    public static void getCapabilities(String browserName) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        switch (browserName.toUpperCase()) {
            case "CHROME":
                Configuration.browserSize = "1920x1080";
                Configuration.reopenBrowserOnFail = true;
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addExtensions(new File("./Extensions/AdBlock.crx"));
                desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                Configuration.browserCapabilities = desiredCapabilities;
                break;
            case "FIREFOX":
                Configuration.browser = browserName;
                Configuration.browserSize = "1920x1080";
                Configuration.reopenBrowserOnFail = true;
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                // tu nie wiem jaki plik wgrać
                firefoxProfile.addExtension(new File(""));
                firefoxOptions.setProfile(firefoxProfile);
                desiredCapabilities.merge(firefoxOptions);
                Configuration.browserCapabilities = desiredCapabilities;
                break;
        }
    }


}
