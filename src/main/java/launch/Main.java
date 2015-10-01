package launch;

import db.ConnectionHandler;
import db.DAO.ClubDAO;
import db.DAO.PlayerDAO;
import db.entities.Club;
import db.entities.Player;
import utils.DatabaseProperties;

import java.sql.Connection;

/**
 * Created by Dmytry on 10/1/2015.
 */
public class Main {

    public static void main(String[] args) {

        Connection connection = ConnectionHandler.getConnectionToDb(DatabaseProperties.DBHOST, DatabaseProperties.DBPORT, DatabaseProperties.DBNAME);

        PlayerDAO playerDAO = new PlayerDAO();
        Player player = playerDAO.findById(1);

        ClubDAO clubDAO = new ClubDAO();
        Club club = clubDAO.findById(2);

        Player player2 = new Player();
        player2.setName("Gerrard");
        player2.setCurrentClub(club);
        playerDAO.insert(player2);

        ConnectionHandler.closeConnection(connection);
    }

}
