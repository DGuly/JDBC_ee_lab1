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
        Connection connection = ConnectionHandler.getConnectionToDb(DatabaseProperties.DBHOST, DatabaseProperties.DBPORT, DatabaseProperties.DBNAME);
        Statement statement = null;
        try {
            statement = connection.createStatement();

//            int result = statement.executeUpdate(
//                    "CREATE TABLE Club (ID BIGSERIAL)");
//            result = statement.executeUpdate(
//                    "CREATE TABLE Player (ID BIGSERIAL, CLUB_ID INT, NAME VARCHAR(20))");
//            result = statement.executeUpdate(
//                    "CREATE TABLE Goal (ID BIGSERIAL, PLAYERSCORED_ID INT, KEEPERLOST_ID INT, MATCH_ID INT)");
//            result = statement.executeUpdate(
//                    "CREATE TABLE Match (ID BIGSERIAL, HOME_CLUB_ID INT, GUEST_CLUB_ID INT)");
//            result = statement.executeUpdate(
//                    "CREATE TABLE Coach (ID BIGSERIAL, CLUB_ID INT, NAME VARCHAR(20))");
//            result = statement.executeUpdate(
//                    "CREATE TABLE Player_matches (PLAYER_ID BIGSERIAL, MATCH_ID INT)");

//               int result = statement.executeUpdate(
//                    "INSERT INTO Player (CLUB_ID, NAME) VALUES (1, 'Urec')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ConnectionHandler.closeStatement(statement);
        ConnectionHandler.closeConnection(connection);
    }
}
