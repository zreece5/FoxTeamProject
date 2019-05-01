package matchmaking.model;


import matchmaking.ExampleData;

/**
 * <p>
 * Representation of a player.
 * </p>
 * <p>
 * As indicated in the challenge description, feel free to augment the Player
 * class in any way that you feel will improve your final matchmaking solution.
 * <strong>Do NOT remove the name, wins, or losses fields.</strong> Also note
 * that if you make any of these changes, you are responsible for updating the
 * {@link ExampleData} such that it provides a useful data set to exercise your
 * solution.
 * </p>
 * <p>
 * A new field "rating" is added. Rating will be calculated based on the result of each individual match.
 * The RatingHelper class provides an interface of such functionality and WinningRatioBasedRatingHelper provides a simple implementation of it.
 * </p>
 */
public class Player {

    private final String name;
    private long wins;
    private long losses;
    private double rating;
    private PlayStyle playStyle;

    public Player(String name, long wins, long losses, double rating) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.rating = rating;
        this.playStyle = PlayStyle.Normal;
    }

    public Player(String name, long wins, long losses) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
    }

    public Player(String name, long wins, long losses, double rating, PlayStyle playStyle) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.rating = rating;
        this.playStyle = playStyle;
    }

    public String getName() {
        return name;
    }

    public long getWins() {
        return wins;
    }

    public long getLosses() {
        return losses;
    }

    public double getRating() {
        return rating;
    }

    public void increaseWins() {
        this.wins++;
    }

    public void increaseLosses() {
        this.losses++;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public PlayStyle getPlayStyle() {
        return playStyle;
    }

    public void setPlayStyle(PlayStyle playStyle) {
        this.playStyle = playStyle;
    }

    @Override
    public String toString() {
        return "Player "+name+"\n" + "Wins: "+wins+", Losses: "+losses+"\nRating: "+rating;
    }
}
