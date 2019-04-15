package com.matchmaking.player.repository;

import com.matchmaking.player.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;


@RepositoryRestResource
public interface PlayerRepository extends CrudRepository<Player, String> {

    Optional<Player> findById(String id);

    void deleteById(String id);

}