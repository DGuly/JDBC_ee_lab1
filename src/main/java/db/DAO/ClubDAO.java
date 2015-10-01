package db.DAO;

import db.entities.Club;
import db.entities.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            while (resultSet. next()) {
                resultClub.setId(resultSet.getInt("ID"));
                resultClub.setName(resultSet.getString("NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



        System.out.println("The result of player getting query is : " + resultClub.toString());
        return resultClub;
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
    }
}
