package launch;

import db.ConnectionHandler;
import db.DAO.ClubDAO;
import db.DAO.DAOFactory;
import db.DAO.PlayerDAO;
import db.entities.Club;
import db.entities.Player;
import utils.DatabaseProperties;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Dmytry on 10/1/2015.
 */
public class Main {

    public static void main(String[] args) {

        Connection connection = ConnectionHandler.getConnectionToDb(DatabaseProperties.DBHOST, DatabaseProperties.DBPORT, DatabaseProperties.DBNAME);

        PlayerDAO playerDAO = DAOFactory.getInstance().getPlayerDAO();
//        Player player = playerDAO.findById(1);

        ClubDAO clubDAO = DAOFactory.getInstance().getClubDAO();
//        Club club = clubDAO.findById(2);

//        Club club2 = new Club();
//        club2.setName("Chelsea");
//        clubDAO.insert(club2);
//
//        Player player2 = new Player();
//        player2.setName("Lampard");
//        player2.setCurrentClub(club2);
//        playerDAO.insert(player2);

        Club club = clubDAO.findById(2);
//        clubDAO.deleteById(1);
//        clubDAO.deleteById(2);
        List<Player> players = playerDAO.getAll();
        List<Club> clubs = clubDAO.getAll();
//        playerDAO.deleteById(1);

        ConnectionHandler.closeConnection(connection);
    }

}
