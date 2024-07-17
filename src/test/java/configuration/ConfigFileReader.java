package configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    public static Properties appConfigurationReader() {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("src\\test\\resources\\configuration.properties")) {
            prop.load(fis);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ignored) {
            System.out.println(ignored.getMessage());
        }
        return prop;
    }

}

