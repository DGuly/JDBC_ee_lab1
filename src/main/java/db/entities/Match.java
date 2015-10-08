package db.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytry on 10/1/2015.
 */
public class Match {
    private int id;
    private Club homeClub;
    private Club guestClub;
    private List<Goal> goalsScored;

    public Match(){}

    public Match(final Club homeClub, final Club guestClub) {
        this.homeClub = homeClub;
        this.guestClub = guestClub;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Club getHomeClub() {
        return homeClub;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", homeClub=" + homeClub +
                ", guestClub=" + guestClub +
                ", goalsScored=" + goalsScored +
                '}';
    }

    public void setHomeClub(Club homeClub) {
        this.homeClub = homeClub;
    }

    public Club getGuestClub() {
        return guestClub;
    }

    public void setGuestClub(Club guestClub) {
        this.guestClub = guestClub;
    }

    public List<Goal> getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(List<Goal> goalsScored) {
        this.goalsScored = goalsScored;
    }

    public void addGoalScored(Goal goal) {
        goalsScored.add(goal);
    }

}
