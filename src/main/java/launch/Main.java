package launch;

import db.ConnectionHandler;
import utils.DatabaseProperties;

import java.sql.Connection;

/**
 * Created by Dmytry on 10/1/2015.
 */
public class Main {

    public static void main(String[] args) {

        Connection connection = ConnectionHandler.getConnectionToDb(DatabaseProperties.dbHost, DatabaseProperties.dbPort, DatabaseProperties.dbName);
        ConnectionHandler.closeConnection(connection);
    }

}
