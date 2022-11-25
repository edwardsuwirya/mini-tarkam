package com.enigmacamp.minitarkam.service;

import com.enigmacamp.minitarkam.entity.Player;
import com.enigmacamp.minitarkam.model.PlayerRegistrationRequest;
import com.enigmacamp.minitarkam.model.StandingTable;

import java.util.List;

public interface PlayerService {
    void registration(PlayerRegistrationRequest playerRegistrationRequest);
}
