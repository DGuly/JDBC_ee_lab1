package db.DAO;

import db.entities.Match;
import db.entities.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmytryguly on 10/8/15.
 */
public class MatchDAO extends GenericDAOImpl<Match>{

    public MatchDAO() {
        tableName = "Match";
    }

    @Override
    public void insert(Match match) {
        Statement statement;
        try {
            statement = connection.createStatement();

            int result = statement.executeUpdate(
                    String.format("INSERT INTO Match (HOME_CLUB_ID, GUEST_CLUB_ID) VALUES (%s, '%s')",
                            match.getHomeClub().getId(), match.getGuestClub().getId()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Insert in table Match succeed!");
    }

    @Override
    public void update(Match match) {
        // first getting player to check if it exists. If no, inserting it, if yes, updating.
        MatchDAO matchDAO = DAOFactory.getInstance().getMatchDAO();
        Match matchToUpdate = matchDAO.findById(match.getId());
        if (matchToUpdate.getId() == 0) {
            matchDAO.insert(match);
            System.out.println("Match " + match.getId() + " was inserted as it is not existing.");
            return;
        }
        Statement statement;
        try {
            statement = connection.createStatement();

            int result = statement.executeUpdate(
                    String.format("UPDATE Match SET HOME_CLUB_ID = '%s', GUEST_CLUB_ID = '%s' WHERE ID = '%s';",
                            match.getHomeClub(), match.getGuestClub(), match.getId()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Update in table Match succeed!");
    }

    @Override
    public Match map(ResultSet resultSet) {
        Match resultMatch = new Match();
        int homeClubId = -1;
        int guestClubId = -1;

        try {
            while (resultSet. next()) {
                resultMatch.setId(resultSet.getInt("ID"));
                homeClubId = Integer.parseInt(resultSet.getString("HOME_CLUB_ID"));
                guestClubId = Integer.parseInt(resultSet.getString("GUEST_CLUB_ID"));
            }
        } catch (SQLException e) {
            System.out.println("Error while mapping match resultset");
            e.printStackTrace();
        }

        if (homeClubId == -1) {
            System.out.println("Error in getting home club id for match id : " + resultMatch.getId());
        } else {
            resultMatch.setHomeClub(DAOFactory.getInstance().getClubDAO().findById(homeClubId));
        }
        if (guestClubId == -1) {
            System.out.println("Error in getting guest club id for match id : " + resultMatch.getId());
        } else {
            resultMatch.setHomeClub(DAOFactory.getInstance().getClubDAO().findById(guestClubId));
        }


        System.out.println("The result of player getting query is : " + resultMatch.toString());
        return resultMatch;
    }

    @Override
    public List<Match> mapAll(ResultSet resultSet) {
        List<Match> resultList = new ArrayList<Match>();
        int homeClubId = -1;
        int guestClubId = -1;
        try {
            while (resultSet.next()) {
                Match tempMatch = new Match();
                tempMatch.setId(resultSet.getInt("ID"));
                homeClubId = Integer.parseInt(resultSet.getString("HOME_CLUB_ID"));
                guestClubId = Integer.parseInt(resultSet.getString("GUEST_CLUB_ID"));

                System.out.println(resultList.toString());

                if (homeClubId == -1) {
                    System.out.println("Error in getting home club id for match id : " + tempMatch.getId());
                } else {
                    tempMatch.setHomeClub(DAOFactory.getInstance().getClubDAO().findById(homeClubId));
                }
                if (guestClubId == -1) {
                    System.out.println("Error in getting guest club id for match id : " + tempMatch.getId());
                } else {
                    tempMatch.setHomeClub(DAOFactory.getInstance().getClubDAO().findById(guestClubId));
                }

                resultList.add(tempMatch);
            }
        } catch (SQLException e) {
            System.out.println("Error while mapping all users resultset");
            e.printStackTrace();
        }

        System.out.println("The result of all player getting query is : " + resultList.toString());
        return resultList;
    }
}
