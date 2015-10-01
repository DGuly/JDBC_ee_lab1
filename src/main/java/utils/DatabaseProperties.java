package utils;

import java.io.FileReader;
import java.util.Properties;

/**
 * Created by Dmytry on 10/1/2015.
 */
public class DatabaseProperties {
    public static final Properties properties = loadProperties("D:\\Projects\\JDBC_ee_lab1\\src\\main\\resources\\database.properties");

    public static final String dbHost = properties.getProperty("host").trim();
    public static final String dbUser = properties.getProperty("dbuser").trim();
    public static final String dbName = properties.getProperty("dbname").trim();
    public static final String dbPort = properties.getProperty("dbport").trim();
    public static final String dbPassword = properties.getProperty("dbpassword").trim();

    public static Properties loadProperties(String file) {
        Properties properties = new Properties();
        try {
            FileReader fr = new FileReader(file);
            properties.load(fr);
        } catch (Exception e) {
            throw new RuntimeException("Exception in In DatabaseProperties.loadProperties(): " + e.getMessage(), e);
        }
        return properties;
    }
}
