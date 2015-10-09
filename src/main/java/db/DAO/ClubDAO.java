package db.DAO;

import db.entities.Club;
import db.entities.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytry on 10/2/2015.
 */
public class ClubDAO extends GenericDAOImpl<Club> {

    public ClubDAO() {
        tableName = "Club";
    }

    @Override
    public Club map(ResultSet resultSet) {
        Club resultClub = new Club();

        try {
            while (resultSet.next()) {
                resultClub.setId(resultSet.getInt("ID"));
                resultClub.setName(resultSet.getString("NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("The result of player getting query is : " + resultClub.toString());
        return resultClub;
    }

    @Override
    public List<Club> mapAll(ResultSet resultSet) {
        List<Club> resultList = new ArrayList<Club>();
        try {
            while (resultSet.next()) {
                Club tempClub = new Club();
                tempClub.setId(resultSet.getInt("ID"));
                tempClub.setName(resultSet.getString("NAME"));

                resultList.add(tempClub);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("The result of all player getting query is : " + resultList.toString());
        return resultList;
    }

    public void insert(Club Club) {
        Statement statement;
        try {
            statement = connection.createStatement();

            int result = statement.executeUpdate(
                    String.format("INSERT INTO Club (NAME) VALUES ('%s')", Club.getName()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Club club) {
        // first getting player to check if it exists. If no, inserting it, if yes, updating.
        ClubDAO clubDAO = DAOFactory.getInstance().getClubDAO();
        Club clubToUpdate = clubDAO.findById(club.getId());
        if (clubToUpdate.getId() == 0) {
            clubDAO.insert(club);
            System.out.println("Club " + clubToUpdate.getName() + " was inserted as it is not existing.");
            return;
        }
        Statement statement;
        try {
            statement = connection.createStatement();

            int result = statement.executeUpdate(
                    String.format("UPDATE Club SET NAME = '%s' WHERE ID = '%s';",
                            club.getName(), club.getId()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Update in table Player succeed!");
    }

    public List<Player> getPlayers(Club club) {
        ResultSet resultSet = null;
        try {
            System.out.println(String.format("SELECT * from %s WHERE %s.CLUB_ID = %s;", "Player", "Player", club.getId()));
            String query = String.format("SELECT * from %s WHERE %s.CLUB_ID = ?;", "Player", "Player");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, club.getId());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Player> resultList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Player player = new Player();

                player.setId(resultSet.getInt("ID"));
                player.setName(resultSet.getString("NAME"));
                Club playerClub = DAOFactory.getInstance().getClubDAO().findById(resultSet.getInt("CLUB_ID"));
                player.setCurrentClub(playerClub);

                resultList.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("The result of all player getting query is : " + resultList.toString());
        return resultList;
    }
}
