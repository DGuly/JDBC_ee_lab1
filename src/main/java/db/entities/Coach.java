package db.entities;

import java.util.List;

/**
 * Created by Dmytry on 10/1/2015.
 */
public class Coach {
    private int id;
    private Club currentClub;
    private List<Club> clubList;

    public Coach() {}

    public Coach(int id, List<Club> clubList) {
        this.id = id;
        this.clubList = clubList;
    }

    public List<Club> getClubList() {
        return clubList;
    }

    public void addClub(Club club) {
        clubList.add(club);
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Club getCurrentClub() {
        return currentClub;
    }

    public void setCurrentClub(Club currentClub) {
        this.currentClub = currentClub;
    }
}
