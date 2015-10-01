package db.DAO;

import db.entities.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytry on 10/2/2015.
 */
public class PlayerDAO extends GenericDAOImpl<Player> {



    public PlayerDAO() {
        tableName = "Player";
    }

    @Override
    public Player map(ResultSet resultSet) {
        Player resultPlayer = new Player();
        int currentClubId = -1;

        try {
            while (resultSet. next()) {
                resultPlayer.setId(resultSet.getInt("ID"));
                currentClubId = Integer.parseInt(resultSet.getString("CLUB_ID"));
                resultPlayer.setName(resultSet.getString("NAME"));
            }
        } catch (SQLException e) {
            System.out.println("Error while mapping user resultset");
            e.printStackTrace();
        }

        if (currentClubId == -1) {
            System.out.println("Error in getting current club id for user : " + resultPlayer.getName());
        } else {
            resultPlayer.setCurrentClub(DAOFactory.getInstance().getClubDAO().findById(currentClubId));
        }

        System.out.println("The result of player getting query is : " + resultPlayer.toString());
        return resultPlayer;
    }

    @Override
    public List<Player> mapAll(ResultSet resultSet) {
        List<Player> resultList = new ArrayList<Player>();
        int currentClubId = -1;
        try {
            while (resultSet.next()) {
                Player tempPlayer = new Player();
                tempPlayer.setId(resultSet.getInt("ID"));
                currentClubId = Integer.parseInt(resultSet.getString("CLUB_ID"));
                tempPlayer.setName(resultSet.getString("NAME"));

                System.out.println(resultList.toString());

                if (currentClubId == -1) {
                    System.out.println("Error in getting current club id for user : " + tempPlayer.getName());
                } else {
                    tempPlayer.setCurrentClub(DAOFactory.getInstance().getClubDAO().findById(currentClubId));
                }

                resultList.add(tempPlayer);
            }
        } catch (SQLException e) {
            System.out.println("Error while mapping all users resultset");
            e.printStackTrace();
        }

        System.out.println("The result of all player getting query is : " + resultList.toString());
        return resultList;
    }


    public void insert(Player player) {
        Statement statement;
        try {
            statement = connection.createStatement();

               int result = statement.executeUpdate(
                    String.format("INSERT INTO Player (CLUB_ID, NAME) VALUES (%s, '%s')", player.getCurrentClub().getId(), player.getName()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Insert in table Player succeed!");
    }


}
