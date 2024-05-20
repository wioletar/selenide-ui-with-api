import configuration.YamlConfigReader;
import org.junit.BeforeClass;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeClass
    public static void beforeClass() throws Exception {
        String appAddress = YamlConfigReader.appConfiguration().get("applicationAddress");
        open(appAddress);
    }
}