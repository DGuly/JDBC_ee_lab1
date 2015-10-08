package db.DAO;

import db.entities.Club;
import db.entities.Coach;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmytryguly on 10/8/15.
 */
public class CoachDAO extends GenericDAOImpl<Coach> {
    public CoachDAO() {
        tableName = "Coach";
    }

    @Override
    public Coach map(ResultSet resultSet) {
        Coach resultCoach = new Coach();
        int currentClubId = -1;

        try {
            while (resultSet. next()) {
                resultCoach.setId(resultSet.getInt("ID"));
                currentClubId = Integer.parseInt(resultSet.getString("CLUB_ID"));
                resultCoach.setName(resultSet.getString("NAME"));
            }
        } catch (SQLException e) {
            System.out.println("Error while mapping user resultset");
            e.printStackTrace();
        }

        if (currentClubId == -1) {
            System.out.println("Error in getting current club id for user : " + resultCoach.getName());
        } else {
            resultCoach.setCurrentClub(DAOFactory.getInstance().getClubDAO().findById(currentClubId));
        }

        System.out.println("The result of coach getting query is : " + resultCoach.toString());
        return resultCoach;
    }

    @Override
    public List<Coach> mapAll(ResultSet resultSet) {
        List<Coach> resultList = new ArrayList<Coach>();
        int currentClubId = -1;
        try {
            while (resultSet.next()) {
                Coach tempPlayer = new Coach();
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

    public void insert(Coach coach) {
        Statement statement;
        try {
            statement = connection.createStatement();

            int result = statement.executeUpdate(
                    String.format("INSERT INTO Coach (CLUB_ID, NAME) VALUES ('%s', '%s')", coach.getCurrentClub().getId(), coach.getName()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Coach coach) {
        // first getting coach to check if it exists. If no, inserting it, if yes, updating.
        CoachDAO coachDAO = DAOFactory.getInstance().getCoachDAO();
        Coach coachToUpdate = coachDAO.findById(coach.getId());
        if (coachToUpdate.getId() == 0) {
            coachDAO.insert(coach);
            System.out.println("Coach " + coachToUpdate.getName() + " was inserted as it is not existing.");
            return;
        }
        Statement statement;
        try {
            statement = connection.createStatement();

            int result = statement.executeUpdate(
                    String.format("UPDATE Coach SET NAME = '%s', CLUB_ID = '%s' WHERE ID = '%s';",
                            coach.getName(), coach.getCurrentClub().getId(), coach.getId()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Update in table Coach succeed!");
    }
}
