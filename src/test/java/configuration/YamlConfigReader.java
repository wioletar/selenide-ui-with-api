package configuration;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

public class YamlConfigReader {

    public static Map<String, String> appConfiguration() throws Exception {
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream("src/test/resources/configuration.yaml");
        Map<String, String> config = yaml.load(inputStream);
        return config;
    }

}

