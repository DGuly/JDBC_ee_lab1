package utils;

import java.io.FileReader;
import java.util.Properties;

/**
 * Created by Dmytry on 10/1/2015.
 */
public class DatabaseProperties {
    public static final Properties properties = loadProperties("/Users/dmytryguly/IdeaProjects/JDBC_ee_lab1/target/classes/src/main/resources/database.properties");

    public static final String DB_HOST = properties.getProperty("host").trim();
    public static final String DB_USER = properties.getProperty("dbuser").trim();
    public static final String DB_NAME = properties.getProperty("dbname").trim();
    public static final String DB_PORT = properties.getProperty("dbport").trim();
    public static final String DB_PASSWORD = properties.getProperty("dbpassword").trim();

    public static Properties loadProperties(String file) {
        Properties properties = new Properties();
        try (FileReader fileReader = new FileReader(file)) {
            properties.load(fileReader);
        } catch (Exception e) {
            throw new RuntimeException("Exception in In DatabaseProperties.loadProperties(): " + e.getMessage(), e);
        }
        return properties;
    }
}
