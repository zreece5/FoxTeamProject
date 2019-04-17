package com.matchmaking.player;

import com.matchmaking.player.model.Player;
import com.matchmaking.player.service.PlayerService;
import com.google.common.collect.Lists;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("noauth")
public class PlayersServiceTest {

    @Autowired
    PlayerService playerService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createSpringfoxSwaggerJson() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/v2/api-docs?group=v1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        String swaggerJson = response.getContentAsString();

        addExtension(swaggerJson);

        File targetFile = new File("target/swagger.json");
        try (FileWriter fileWriter = new FileWriter(targetFile) )  {
            IOUtils.write(swaggerJson, fileWriter);
        }
    }

    private void addExtension(String swaggerJson) {

    }

    @Test
    public void testCreatePlayer() {
        try {
            Player player = new Player();
            player.setId("-1");
            player.setTraceId(233);
            Player createPlayers = playerService.createPlayer(player);

            assertEquals(233, createPlayers.getTraceId(), 0);
            assertEquals("-1", createPlayers.getId());
        } finally {
            playerService.deletePlayerById("-1");
        }
    }

    @Test
    public void testGetAllEmpty() {
        Iterable<Player> players = playerService.listAllPlayers();
        ArrayList<Player> playersList = Lists.newArrayList(players);

        assertEquals(3, playersList.size());
    }

    @Test
    public void testGetAllOne() {
        try {
            // Create one player
            Player player = new Player();
            player.setId("-2");
            player.setTraceId(233);
            Player createdPlayers = playerService.createPlayer(player);

            Iterable<Player> players = playerService.listAllPlayers();
            ArrayList<Player> playersList = Lists.newArrayList(players);

            assertEquals(4, playersList.size());
        } finally {
            playerService.deletePlayerById("-2");
        }
    }

    @Test
    public void testGetOne() {
        try {
            // Create one player
            Player player = new Player();
            player.setId("-22");
            player.setTraceId(233);
            playerService.createPlayer(player);

            Player playerById = playerService.getPlayerById("-22");
            assertEquals("-22", playerById.getId());
        } finally {
            playerService.deletePlayerById("-22");
        }
    }


    @Test
    public void testDelete() {
        // Create one player
        Player player1 = new Player();
        player1.setId("-1");
        player1.setTraceId(233);
        playerService.createPlayer(player1);

        Player player2 = new Player();
        player2.setId("-2");
        player2.setTraceId(444);
        playerService.createPlayer(player2);


        Iterable<Player> players = playerService.listAllPlayers();
        ArrayList<Player> playerList = Lists.newArrayList(players);

        assertEquals(5, playerList.size());

        playerService.deletePlayerById("-1");

        ArrayList<Player> playersListAfterDelete = Lists.newArrayList(playerService.listAllPlayers());
        assertEquals(4, playersListAfterDelete.size());
        assertNotNull(playersListAfterDelete.stream().filter(c->c.getId().equals("-2")).findFirst().orElse(null));
    }

    @Test
    public void testUpdate() {
        try {
            // Create one player
            Player player1 = new Player();
            player1.setId("-1");
            player1.setTraceId(233);
            playerService.createPlayer(player1);

            // Change value
            player1.setTraceId(234);

            // Verify that the value is still unchanged
            Player playerBeforeUpdate = playerService.getPlayerById("-1");
            assertEquals(233, playerBeforeUpdate.getTraceId(), 0);

            // Save change
            playerService.updatePlayer(player1);

            // Verify the changed value
            Player playerAfterUpdate = playerService.getPlayerById("-1");
            assertEquals(234, playerAfterUpdate.getTraceId(), 0);
        } finally {
            playerService.deletePlayerById("-1");
        }
    }
}
