package com.matchmaking.player.service;

import com.matchmaking.player.model.Player;
import com.matchmaking.player.model.Queue;
import com.matchmaking.player.model.QueueStatus;
import com.matchmaking.player.repository.PlayerBuilder;
import com.matchmaking.player.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private PlayerRepository playerRepository;
    private QueueService queueService;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, QueueService queueService) {
        this.playerRepository = playerRepository;
        this.queueService = queueService;

        playerRepository.save(
                PlayerBuilder.create("MK1", "103",
                        "10", "Angry", 27, "123"));

        playerRepository.save(
                PlayerBuilder.create("MK2", "190", "9", "Angry", 27, "135")
        );

        playerRepository.save(
                PlayerBuilder.create("MK4", "129", "8", "Soft", 40, "126")
        );

    }

    @Override
    public Iterable<Player> listAllPlayers() {
        logger.debug("listAllPlayers called");
        return playerRepository.findAll();
    }


    @Override
    public Player getPlayerById(String id) {
        logger.debug("getPlayerById called");
        return playerRepository.findById(id).orElse(null);
    }

    @Override
    public Player createPlayer(Player player) {
        logger.debug("createPlayer called");
        try {
            Player playerById = getPlayerById(player.getId());
            if (playerById == null) {
                return playerRepository.save(player);
            } else {
                throw new HttpClientErrorException(HttpStatus.CONFLICT, "Player with id "+player.getId()+" already exists");
            }
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Failed to save Player");
        }
    }

    @Override
    @Async
    public void createPlayerAsync(String queueId, Player player, boolean generateError) {
        logger.debug("createPlayer async called");
        Queue queue = queueService.get(queueId);
        queue.setStatus(QueueStatus.PROCESSING);
        try {
            logger.info("Sleeping 30 seconds for demonstration purposes");
            Thread.sleep(30 * 1000);

            if (generateError) {
                throw new RuntimeException("Induced error for demo purposes");
            }

            Player playerById = getPlayerById(player.getId());
            if (playerById == null) {
                playerRepository.save(player);
            } else {
                throw new HttpClientErrorException(HttpStatus.CONFLICT, "Player with id "+player.getId()+" already exists");
            }
            queue.setStatus(QueueStatus.DONE);
            queue.setLocation("/matchmaking/players/v1/players/"+player.getId());
            logger.info("createPlayer async done");
        } catch (Exception e) {
            logger.error("Failed to create player  async", e);

            queue.setStatus(QueueStatus.ERROR);
            queue.setErrorMessage(e.getMessage());
        }
    }

    @Override
    public void updatePlayer(Player player) {
        logger.debug("Update player {}", player.getId());
        playerRepository.save(player);
    }

    @Override
    public void deletePlayerById(String playerID) {
        logger.debug("deletePlayerById called");
        Player player = playerRepository.findById(playerID).orElse(null);
        if (player == null) {
            throw new RuntimeException("Failed to delete");
        }
        playerRepository.delete(player);
    }


}
//    findOne(Integer.valueOf(String.valueOf(id)))
