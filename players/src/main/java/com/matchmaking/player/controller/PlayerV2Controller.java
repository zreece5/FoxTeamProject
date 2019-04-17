package com.matchmaking.player.controller;

import com.matchmaking.player.service.QueueService;
import com.matchmaking.player.model.Player;
import com.matchmaking.player.model.Queue;
import com.matchmaking.player.service.PlayerService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping({"/matchmaking/players/v2/players"})
@SwaggerDefinition(tags = { @Tag(name = "Kennesaw State University", description = "Player CRUD Operations") })
public class PlayerV2Controller {

    private PlayerService playerService;
    private QueueService queueService;

    @Autowired
    PlayerV2Controller(PlayerService playerService, QueueService queueService) {
        this.playerService = playerService;
        this.queueService = queueService;
    }

    //----------Add a new  Player to the Pool-----------
    @ApiOperation(value = "Add a new Player to the inventory")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Added a new Player"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PostMapping("")
    public ResponseEntity createPlayer(@RequestBody Player player,
                                            boolean generateError) throws URISyntaxException {
        Queue queue = new Queue();
        queueService.put(queue);
        Player existingPlayer = playerService.getPlayerById(player.getId());
        if (existingPlayer != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Player with Id " + player.getId()+" already exists.");
        }
        playerService.createPlayerAsync(queue.getId(), player, generateError);
        return ResponseEntity.created(new URI("/matchmaking/players/v2/queues/"+queue.getId())).build();
    }
}