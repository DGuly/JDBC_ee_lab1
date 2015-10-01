package db;

import utils.DatabaseProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Dmytry on 10/1/2015.
 */
public class ConnectionHandler {
    public static Connection getConnectionToDb(String dbLocation, String dbPort, String dbName) {
        Connection connection = null;

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Include in your library path, please");
            e.printStackTrace();
            return null;
        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        try {

            connection = DriverManager.getConnection(
                    String.format("jdbc:postgresql://%s:%s/%s", dbLocation, dbPort, dbName), DatabaseProperties.DBUSER,
                    DatabaseProperties.DBPASSWORD);

        } catch (SQLException e) {
            if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
                System.out.println("EXCEPTION DURING CLOSING DB CONNECTION");
            }
        }
        e.printStackTrace();
        System.out.println("Connection was not set. Please, check your db settings!");
    }

    return connection;
}

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR DURING CLOSING CONNECTION TO DB");
        }
        System.out.println("Connection to DB was closed successfully");
    }

    public static void closeStatement(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR DURING CLOSING STATEMENT");
        }
        System.out.println("Statement closing succeed");
    }


}
