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

        Connection connection = ConnectionHandler.getConnectionToDb(DatabaseProperties.DB_HOST, DatabaseProperties.DB_PORT, DatabaseProperties.DB_NAME);

        PlayerDAO playerDAO = DAOFactory.getInstance().getPlayerDAO();
//        Player player = playerDAO.findById(1);

        ClubDAO clubDAO = DAOFactory.getInstance().getClubDAO();
        Club club2 = clubDAO.findById(2);

//        Club club2 = new Club();
        club2.setName("ChelseaUPDATED");
        clubDAO.update(club2);
//
//        Club club3 = clubDAO.findById(1);
//        Player player2 = playerDAO.findById(1);
//        player2.setName("Shevchenko");
//        player2.setCurrentClub(club3);
//        playerDAO.update(player2);

        //Club club = clubDAO.findById(2);
//        clubDAO.deleteById(1);
//        clubDAO.deleteById(2);

        List<Player> players = playerDAO.getAll();
        List<Club> clubs = clubDAO.getAll();
//        playerDAO.deleteById(1);

        ConnectionHandler.closeConnection(connection);
    }

}
