package com.enigmacamp.minitarkam.repository;

import com.enigmacamp.minitarkam.entity.Competition;

public interface CompetitionRepository {
    void create(Competition gameResult);

    Competition findOne(long id);
}
