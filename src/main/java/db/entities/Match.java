package db.entities;

import java.util.List;

/**
 * Created by Dmytry on 10/1/2015.
 */
public class Match {
    private int id;
    private List<Club> clubsPlaying;
    private List<Goal> goalsScored;

    public Match(){}

    public Match(int id, List<Club> clubsPlaying, List<Goal> goalsScored) {
        this.id = id;
        this.clubsPlaying = clubsPlaying;
        this.goalsScored = goalsScored;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Club> getClubsPlaying() {
        return clubsPlaying;
    }

    public void setClubsPlaying(List<Club> clubsPlaying) {
        this.clubsPlaying = clubsPlaying;
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

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", clubsPlaying=" + clubsPlaying +
                ", goalsScored=" + goalsScored +
                '}';
    }
}
