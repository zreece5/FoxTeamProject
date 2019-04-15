package edu.ksu.matchmaking.helper;

import edu.ksu.matchmaking.model.Match;
import edu.ksu.matchmaking.model.Player;

public interface RatingHelper {

    /**
     * <p>
     * This method initializes the rating of each player.
     * </p>
     */
    void initRating(Player player);

    /**
     * <p>
     * This method should be called after each match.
     * It updates each player's rating based on their match result.
     * </p>
     */
    void updateRatingAfterMatch(Match match);

}