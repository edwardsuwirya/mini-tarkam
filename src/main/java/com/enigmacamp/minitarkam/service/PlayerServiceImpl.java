package com.enigmacamp.minitarkam.service;

import com.enigmacamp.minitarkam.entity.*;
import com.enigmacamp.minitarkam.model.PlayerRegistrationRequest;
import com.enigmacamp.minitarkam.model.SkillWeight;
import com.enigmacamp.minitarkam.repository.PlayerRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void registration(PlayerRegistrationRequest playerRegistrationRequest) {
        Player player = new Player();
        Position position = new Position();
        position.setPositionId(playerRegistrationRequest.getPosition());
        player.setPosition(position);
        player.setName(playerRegistrationRequest.getName());
        player.setBirthDate(playerRegistrationRequest.getBirthDate());
        player.setNationality(playerRegistrationRequest.getNationality());
        player.setHeight(playerRegistrationRequest.getHeight());

        FootballClub footballClub = new FootballClub();
        footballClub.setClubCode(playerRegistrationRequest.getClubCode());
        ClubPlayer clubPlayer = new ClubPlayer();
        clubPlayer.setFootballClub(footballClub);
        clubPlayer.setPlayer(player);
        clubPlayer.setActive(true);
        player.setClubs(new HashSet<>(Arrays.asList(clubPlayer)));
        Set<PlayerSkill> playerSkillSet = new HashSet<>();
        for (SkillWeight skillWeight : playerRegistrationRequest.getSkillWeightList()) {
            PlayerSkill playerSkill = new PlayerSkill();
            playerSkill.setPlayer(player);
            playerSkill.setSkillWeight(skillWeight.getSkillWeight());
            Skill skill = new Skill();
            skill.setSkillId(skillWeight.getSkillId());
            playerSkill.setSkill(skill);
            playerSkillSet.add(playerSkill);
        }

        player.setSkillSet(playerSkillSet);
        System.out.println(player);
        playerRepository.create(player);

    }
}
