package edu.ksu.matchmaking.helper;


import edu.ksu.matchmaking.model.Match;
import edu.ksu.matchmaking.model.Player;

import java.util.List;

public abstract class AbstractTeamBuilder implements TeamBuilder {

    public Match splitPlayersIntoMatch(List<Player> players) {
        if (null == players || players.size() == 0 || players.size() % 2 == 1) {
            return null;
        }
        return buildMatch(players);
    }

    protected abstract Match buildMatch(List<Player> players);

}
