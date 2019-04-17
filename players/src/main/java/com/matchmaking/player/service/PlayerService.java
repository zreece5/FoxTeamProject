package com.matchmaking.player.service;


import com.matchmaking.player.model.Player;
import org.springframework.scheduling.annotation.Async;


public interface PlayerService {


    Iterable<Player> listAllPlayers();

    Player getPlayerById(String id);

    Player createPlayer(Player player);


    void deletePlayerById(String playerID);

    void updatePlayer(Player player);

    @Async
    void createPlayerAsync(String queueId, Player player, boolean generateError);
}