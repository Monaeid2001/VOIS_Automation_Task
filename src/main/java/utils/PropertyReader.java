package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties;

    public static String getProperty(String key) {
        try {
            if (properties == null) {
                properties = new Properties();
                properties.load(new FileInputStream("src/main/resources/config.properties"));
            }
            String systemValue = System.getProperty(key);
            if (systemValue != null) {
                return systemValue;
            }
            return properties.getProperty(key);
        } catch (Exception e) {
            System.out.println("Error reading property: " + key + " - " + e.getMessage());
            return "";
        }
    }
}
