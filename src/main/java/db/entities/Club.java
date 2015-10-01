package db.entities;

import java.util.List;

/**
 * Created by Dmytry on 10/1/2015.
 */
public class Club {
    private int id;
    private List<Player> players;

    public Club() {}

    public Club(int id, List<Player> players, List<Coach> coaches) {
        this.id = id;
        this.players = players;
        this.coaches = coaches;
    }

    private List<Coach> coaches;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void removeCoaches(Coach coach) {
        coaches.remove(coach);
    }

    public void addCoache(Coach coach) {
        coaches.add(coach);
    }
}
