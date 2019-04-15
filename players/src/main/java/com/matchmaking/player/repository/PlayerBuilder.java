package com.matchmaking.player.repository;

import com.matchmaking.player.model.Player;

public class PlayerBuilder {

    public static Player create(String id, String loses, String rating, String playstyle, double mark, String wins) {
        Player player = new Player();
        player.setId(id);
        player.setLoses(loses);
        player.setRating(rating);
        player.setPlaystyle(playstyle);
        player.setTraceId(mark);
        player.setWins(wins);
        return player;
    }
}