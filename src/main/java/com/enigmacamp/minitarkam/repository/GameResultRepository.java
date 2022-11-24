package com.enigmacamp.minitarkam.repository;

import com.enigmacamp.minitarkam.entity.GameResult;

import java.util.List;

public interface GameResultRepository {
    void create(GameResult gameResult);

    GameResult findOne(long id);

    List<GameResult> findByCompetition(long competitionId);


}
