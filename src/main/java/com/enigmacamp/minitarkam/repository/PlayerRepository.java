package com.enigmacamp.minitarkam.repository;

import com.enigmacamp.minitarkam.entity.Competition;
import com.enigmacamp.minitarkam.entity.Player;

public interface PlayerRepository {
    void create(Player player);

    Player findOne(long id);
}
