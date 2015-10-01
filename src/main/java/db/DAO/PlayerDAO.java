package db.DAO;

import db.entities.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        int currentClubId;

        try {
            while (resultSet. next()) {
                resultPlayer.setId(resultSet.getInt("ID"));
                currentClubId = Integer.parseInt(resultSet.getString("CLUB_ID"));
                resultPlayer.setName(resultSet.getString("NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // TODO not forget initialize it
        //resultPlayer.setCurrentClub();

        System.out.println("The result of player getting query is : " + resultPlayer.toString());
        return resultPlayer;
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