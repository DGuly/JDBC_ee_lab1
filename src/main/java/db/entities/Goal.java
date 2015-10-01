package db.entities;

/**
 * Created by Dmytry on 10/1/2015.
 */
public class Goal {

    private int id;
    private Player playerScored;
    private Player keeperSkipped;

    public Goal() {}

    public Goal(int id, Player playerScored, Player keeperSkipped) {
        this.id = id;
        this.playerScored = playerScored;
        this.keeperSkipped = keeperSkipped;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayerScored() {
        return playerScored;
    }

    public void setPlayerScored(Player playerScored) {
        this.playerScored = playerScored;
    }

    public Player getKeeperSkipped() {
        return keeperSkipped;
    }

    public void setKeeperSkipped(Player keeperSkipped) {
        this.keeperSkipped = keeperSkipped;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", playerScored=" + playerScored +
                ", keeperSkipped=" + keeperSkipped +
                '}';
    }
}
