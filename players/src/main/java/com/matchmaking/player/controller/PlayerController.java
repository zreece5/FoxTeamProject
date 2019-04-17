
package com.matchmaking.player.controller;

import com.matchmaking.player.model.Player;
import com.matchmaking.player.service.PlayerService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
@RequestMapping({"/matchmaking/players", "/players", "/matchmaking/players/v1/players"})
@SwaggerDefinition(tags = { @Tag(name = "Kennesaw State University", description = "Player CRUD Operations") })
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public void setplayerService(PlayerService playerService) {
        this.playerService = playerService;
    }

    //----------Get All Players-----------

    @ApiOperation(value = "Display a list of all Players available", response = Player.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Displaying the list of all Players in the inventory"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value = "")
    public Iterable<Player> list(
            @ApiParam(type = "loses", value = "Search for loses", example = "300") @RequestParam(value = "loses", required = false) Double loses,
            @ApiParam(type = "wins", value = "Search for wins", example = "300") @RequestParam(value = "wins", required = false) String wins) {
        Iterable<Player> playerList = playerService.listAllPlayers();

        ArrayList<Player> arrayList = new ArrayList<>((Collection<? extends Player>) playerList);
        Stream<Player> stream = arrayList.stream();
        if (loses != null) {
            stream = stream.filter(c->c.getTraceId()> loses);
        }
        if (wins != null) {
            stream = stream.filter(c->c.getWins().contains(wins));
        }
        return stream.collect(Collectors.toList());
    }

    //----------Get a Player by ID-----------
    @ApiOperation(value = "Display information of Player corresponding to a specific ID", response = Player.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Displaying the Player Information for the requested ID"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("{id}")
    public ResponseEntity<Player> showPlayer(@PathVariable("id") String id) {
        Player player = playerService.getPlayerById(id);
        if (player == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No player found for ID " + id);
        }
        return ResponseEntity.ok(player);
    }

    //----------Add a new  Player to the Inventory-----------
    @ApiOperation(value = "Add a new Player to the inventory")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Added a new Player "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PostMapping("")
    public ResponseEntity createPlayer(@RequestBody Player player) throws URISyntaxException {
        Player createdPlayer = playerService.createPlayer(player);
        return ResponseEntity.created(new URI("/matchmaking/players/"+createdPlayer.getId())).build();
    }


    //----------Update an existing Player -----------------------------
    @ApiOperation(value = "Update a Player", response = Player.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated an existing Player"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PutMapping(value = "{id}")
    public ResponseEntity updatePlayer(@PathVariable String id, @RequestBody Player player) {

        Player currentPlayer = playerService.getPlayerById(id);
        if (currentPlayer == null) {
            return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
        }
        currentPlayer.setRating(player.getRating());
        currentPlayer.setWins(player.getWins());
        currentPlayer.setPlaystyle(player.getPlaystyle());
        currentPlayer.setTraceId(player.getTraceId());
        currentPlayer.setLoses(player.getLoses());

        playerService.updatePlayer(currentPlayer);

        return ResponseEntity.ok("Player information updated successfully");
    }

    @ApiOperation(value = "Update a Player with patch. Replace some fields.", response = Player.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated an existing Player"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PatchMapping(value = "{id}")
    public Player patchPlayer(@PathVariable("id") String id, @RequestBody Player player) {
        Player currentPlayer = playerService.getPlayerById(id);
        if (currentPlayer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (player.getWins() != null) {
            currentPlayer.setWins(player.getWins());
        }
        if (player.getTraceId() != 0) {
            currentPlayer.setTraceId(player.getTraceId());
        }
        if (player.getPlaystyle() != null) {
            currentPlayer.setPlaystyle(player.getPlaystyle());
        }
        if (player.getLoses() != null) {
            currentPlayer.setLoses(player.getLoses());
        }
        if (player.getRating() != null) {
            currentPlayer.setRating(player.getRating());
        }
        return currentPlayer;
    }

    //----------Delete a Player-----------------------------
    @ApiOperation(value = "Delete a Player", response = Player.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @DeleteMapping("{id}")
    public ResponseEntity deletePlayer(@PathVariable String id) {
        playerService.deletePlayerById(id);
        return ResponseEntity.ok("Player deleted successfully");
    }
}