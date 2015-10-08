package db.entities;

import java.util.List;

/**
 * Created by Dmytry on 10/1/2015.
 */
public class Coach {
    private int id;
    private Club currentClub;
    private String name;
    private List<Club> clubList;

    public Coach(String name, Club currentClub) {
        this.name = name;
        this.currentClub = currentClub;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", currentClub=" + currentClub +
                ", name='" + name + '\'' +
                ", clubList=" + clubList +
                '}';
    }
}
