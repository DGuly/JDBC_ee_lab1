package launch;

import db.ConnectionHandler;
import db.DAO.*;
import db.entities.Club;
import db.entities.Coach;
import db.entities.Match;
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
        CoachDAO coachDAO = DAOFactory.getInstance().getCoachDAO();
        ClubDAO clubDAO = DAOFactory.getInstance().getClubDAO();
        MatchDAO matchDAO = DAOFactory.getInstance().getMatchDAO();

        // Chelsea - John Terry, Sesc Fabregas, Diego Costa \\ Jose Mourinho
        // Liverpool - Emre Djan, James Milner, Mamadu Saco \\ Jurgen Klopp
        // Arsenal - Teo Walcott, Santi Casorla, Petr Chech \\ Arsene Wenger

        Club club1 = new Club("Chelsea");
        Club club2 = new Club("Liverpool");
        Club club3 = new Club("Arsenal");

        Player player1 = new Player("John Terry", club1);
        Player player2 = new Player("Sesc Fabregas", club1);
        Player player3 = new Player("Diego Costa", club1);
        Player player4 = new Player("Emre Djan", club2);
        Player player5 = new Player("James Milner", club2);
        Player player6 = new Player("Mamadu Saco", club2);
        Player player7 = new Player("Teo Walcott", club3);
        Player player8 = new Player("Santi Casorla", club3);
        Player player9 = new Player("Petr Chech", club3);

        Coach coach1 = new Coach("Jose Mourinho", club1);
        Coach coach2 = new Coach("Jurgen Klopp", club2);
        Coach coach3 = new Coach("Arsene Wenger", club3);

        Match match1 = new Match(club1, club2);
        Match match2 = new Match(club2, club3);
//-------------------------------------- INSERT ------------------------------------------------------------------------
//        coachDAO.insert(coach1);
//        coachDAO.insert(coach2);
//        coachDAO.insert(coach3);
//
//        clubDAO.insert(club1);
//        clubDAO.insert(club2);
//        clubDAO.insert(club3);
//
//        playerDAO.insert(player1);
//        playerDAO.insert(player2);
//        playerDAO.insert(player3);
//        playerDAO.insert(player4);
//        playerDAO.insert(player5);
//        playerDAO.insert(player6);
//        playerDAO.insert(player7);
//        playerDAO.insert(player8);
//        playerDAO.insert(player9);



//--------------------------------------- INSERT -----------------------------------------------------------------------

        player1 = playerDAO.findById(1);
        player2 = playerDAO.findById(2);
        player3 = playerDAO.findById(3);
        player4 = playerDAO.findById(4);
        player5 = playerDAO.findById(5);
        player6 = playerDAO.findById(6);
        player7 = playerDAO.findById(7);
        player8 = playerDAO.findById(8);
        player9 = playerDAO.findById(9);

        club1 = clubDAO.findById(1);
        club2 = clubDAO.findById(2);
        club3 = clubDAO.findById(3);

        player1.setCurrentClub(club1);
        player2.setCurrentClub(club1);
        player3.setCurrentClub(club1);
        player4.setCurrentClub(club2);
        player5.setCurrentClub(club2);
        player6.setCurrentClub(club2);
        player7.setCurrentClub(club3);
        player8.setCurrentClub(club3);
        player9.setCurrentClub(club3);

        coach1 = coachDAO.findById(1);
        coach2 = coachDAO.findById(2);
        coach3 = coachDAO.findById(3);

        coach1.setCurrentClub(club1);
        coach2.setCurrentClub(club2);
        coach3.setCurrentClub(club3);

        match1.setHomeClub(club1);
        match1.setGuestClub(club2);
        match2.setHomeClub(club2);
        match2.setGuestClub(club3);


//--------------------------------------- UPDATE -----------------------------------------------------------------------
//        playerDAO.update(player1);
//        playerDAO.update(player2);
//        playerDAO.update(player3);
//        playerDAO.update(player4);
//        playerDAO.update(player5);
//        playerDAO.update(player6);
//        playerDAO.update(player7);
//        playerDAO.update(player8);
//        playerDAO.update(player9);
//
//        coachDAO.update(coach1);
//        coachDAO.update(coach2);
//        coachDAO.update(coach3);

//        matchDAO.update(match1);
//        matchDAO.update(match2);
//--------------------------------------- UPDATE -----------------------------------------------------------------------
//        Coach coach = new Coach();
//        coach.setName("Fergusson");
//        coach.setCurrentClub(clubDAO.findById(2));
//        coachDAO.insert(coach);
//        coachDAO.findById(1);
//        coachDAO.getAll();
//        coach = coachDAO.findById(1);
//        coach.setName("FergussonUPDATED");
//        coachDAO.update(coach);
//        coachDAO.getAll();
//        coachDAO.deleteById(1);
//        coachDAO.getAll();
//        Player player = playerDAO.findById(1);

//        ClubDAO clubDAO = DAOFactory.getInstance().getClubDAO();
//        Club club2 = clubDAO.findById(2);
//
////        Club club2 = new Club();
//        club2.setName("ChelseaUPDATED");
//        clubDAO.update(club2);
//
//        Club club3 = clubDAO.findById(1);
//        Player player2 = playerDAO.findById(1);
//        player2.setName("Shevchenko");
//        player2.setCurrentClub(club3);
//        playerDAO.update(player2);

        //Club club = clubDAO.findById(2);
//        clubDAO.deleteById(1);
//        clubDAO.deleteById(2);

//        List<Player> players = playerDAO.getAll();
//        List<Club> clubs = clubDAO.getAll();
//        playerDAO.deleteById(1);

        ConnectionHandler.closeConnection(connection);
    }

}
