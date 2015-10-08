package db.entities;

import java.util.List;

/**
 * Created by Dmytry on 10/1/2015.
 */
public class Player {
    private int id;
    private String name;
    private Club currentClub;
    private List<Goal> scoredGoals;
    private List<Match> matchesPlayed;
    public PlayerType playerType;

    public Player() {}

    public Player(String name, Club currentClub) {
        this.name = name;
        this.currentClub = currentClub;
    }

    public Player(int id, String name, Club currentClub, List<Goal> scoredGoals, List<Match> matchesPlayed, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.currentClub = currentClub;
        this.scoredGoals = scoredGoals;
        this.matchesPlayed = matchesPlayed;
        this.playerType = playerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Club getCurrentClub() {
        return currentClub;
    }

    public void setCurrentClub(Club currentClub) {
        this.currentClub = currentClub;
    }

    public List<Goal> getScoredGoals() {
        return scoredGoals;
    }

    public void addScoredGoal(Goal goal) {
        scoredGoals.add(goal);
    }

    public List<Match> getMatchesPlayed() {
        return matchesPlayed;
    }

    public void addMatchePlayed(Match match) {
        matchesPlayed.add(match);
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentClub=" + currentClub +
                ", scoredGoals=" + scoredGoals +
                ", matchesPlayed=" + matchesPlayed +
                ", playerType=" + playerType +
                '}';
    }
}
