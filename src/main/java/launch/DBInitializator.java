package launch;

import db.ConnectionHandler;
import utils.DatabaseProperties;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Dmytry on 10/1/2015.
 */
public class DBInitializator {
    public static void main(String[] args) {
        Connection connection = ConnectionHandler.getConnectionToDb(DatabaseProperties.dbHost, DatabaseProperties.dbPort, DatabaseProperties.dbName);
        Statement statement = null;
        try {
            statement = connection.createStatement();

            int result = statement.executeUpdate(
                    "CREATE TABLE Club (ID INT)");
            result = statement.executeUpdate(
                    "CREATE TABLE Player (ID INT, CLUB_ID INT)");
            result = statement.executeUpdate(
                    "CREATE TABLE Goal (ID INT, PLAYERSCORED_ID INT, KEEPERLOST_ID INT)");
            result = statement.executeUpdate(
                    "CREATE TABLE Match (ID INT, PLAYERSCORED_ID INT, KEEPERLOST_ID INT)");
            result = statement.executeUpdate(
                    "CREATE TABLE Goal (ID INT, PLAYERSCORED_ID INT, KEEPERLOST_ID INT)");
            result = statement.executeUpdate(
                    "CREATE TABLE Goal (ID INT, PLAYERSCORED_ID INT, KEEPERLOST_ID INT)");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ConnectionHandler.closeStatement(statement);
        ConnectionHandler.closeConnection(connection);
    }
}
