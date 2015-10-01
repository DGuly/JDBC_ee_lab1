package db.DAO;

/**
 * Created by Dmytry on 10/2/2015.
 */
public class DAOFactory {
    private static DAOFactory instance = null;
    private static ClubDAO clubDAO = null;
    private static PlayerDAO playerDAO = null;

    private DAOFactory() {}

    public static synchronized DAOFactory getInstance(){
        if (instance == null){
            instance = new DAOFactory();
        }
        return instance;
    }

    public ClubDAO getClubDAO() {
        if (clubDAO == null) {
            clubDAO = new ClubDAO();
        }
        return clubDAO;
    }

    public PlayerDAO getPlayerDAO() {
        if (playerDAO == null) {
            playerDAO = new PlayerDAO();
        }
        return playerDAO;
    }
}
