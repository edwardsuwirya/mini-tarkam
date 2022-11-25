package com.enigmacamp.minitarkam.repository;

import com.enigmacamp.minitarkam.entity.Player;
import com.enigmacamp.minitarkam.entity.Position;

public interface PositionRepository {
    void create(Position position);

    Position findOne(String id);
}
