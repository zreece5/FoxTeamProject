package edu.ksu.matchmaking.helper;

import edu.ksu.matchmaking.model.Player;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class NearestNeighbourPlayerFinder implements PlayerFinder {

    /**
     * <p>
     * Find the players who have the closest ratings with the current player.
     * </p>
     */
    public List<Player> findSimilarPlayers(Player currentPlayer, List<Player> playerPool, int numberOfPlayers) {
        if (playerPool.size() < numberOfPlayers) {
            return null;
        }

//        Comparator.comparing(player -> playStyle(currentPlayer, player)).thenComparing(playerDistance());
//
//        playerPool.sort();
//
//        playerPool
//                .sort(Comparator.comparing(Comparator.comparing(Comparator.comparingInt(player -> playStyle(currentPlayer, player)))
//                .thenComparing());

        List<Player> similarPlayers = playerPool.stream()
                .sorted(Comparator.comparingDouble(player -> playerDistance(currentPlayer, player)))
                .limit(numberOfPlayers)
                .collect(Collectors.toList());
        return similarPlayers;
    }

    private int playStyle(Player player1, Player player2) {
        return abs(player1.getPlayStyle().ordinal() - player2.getPlayStyle().ordinal());
    }

    private double playerDistance(Player player1, Player player2) {
        return abs(player1.getRating() - player2.getRating());
    }

}
