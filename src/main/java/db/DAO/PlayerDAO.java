package db.DAO;

import db.entities.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dmytry on 10/2/2015.
 */
public class PlayerDAO extends GenericDAOImpl<Player>{

    public PlayerDAO(String tableName) {
        this.tableName = tableName;
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
}
