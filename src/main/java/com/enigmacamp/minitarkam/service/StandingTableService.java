package com.enigmacamp.minitarkam.service;

import com.enigmacamp.minitarkam.model.StandingTable;

import java.util.List;

public interface StandingTableService {
    List<StandingTable> viewTable(long competitionId);
}
