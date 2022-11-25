package com.enigmacamp.minitarkam.repository;

import com.enigmacamp.minitarkam.entity.FootballClub;
import com.enigmacamp.minitarkam.entity.Position;
import com.enigmacamp.minitarkam.entity.Skill;
import com.enigmacamp.minitarkam.model.PlayerRegistrationRequest;
import com.enigmacamp.minitarkam.model.SkillWeight;
import com.enigmacamp.minitarkam.service.PlayerService;
import com.enigmacamp.minitarkam.service.PlayerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayerRepositoryImplTest extends BaseRepoTest {
    @BeforeEach
    void clean() {
        cleanTable("minitarkam.m_player");
        cleanTable("minitarkam.m_player_skill");
        cleanTable("minitarkam.m_individual_skill");
        cleanTable("minitarkam.m_position");
        cleanTable("minitarkam.m_football_club");
        cleanTable("minitarkam.m_club_player");
    }

    void initPosition() {
        PositionRepository positionRepository = new PositionRepositoryImpl(em);
        Position position = new Position();
        position.setPositionId("ST");
        position.setPositionName("Striker");

        Position position2 = new Position();
        position2.setPositionId("GK");
        position2.setPositionName("Goalkeeper");

        positionRepository.create(position);
        positionRepository.create(position2);
    }

    void initSkill() {
        SkillRepository skillRepository = new SkillRepositoryImpl(em);
        Skill skill1 = new Skill();
        skill1.setSkillId("SPD");
        skill1.setDescription("Speed");
        skillRepository.create(skill1);

        Skill skill2 = new Skill();
        skill2.setSkillId("PWR");
        skill2.setDescription("Power");
        skillRepository.create(skill2);
    }

    void initClub() {
        FootballClubRepository footballClubRepository = new FootballClubRepositoryImpl(em);
        FootballClub footballClub = new FootballClub();
        footballClub.setClubCode("LIV");
        footballClub.setClubName("Liverpool");
        footballClub.setCity("Gresik");
        footballClub.setEstablishDate(new Date());
        footballClubRepository.create(footballClub);
    }

    @Test
    void whenCreate_Player_Successfully() {
        initPosition();
        initSkill();
        initClub();
        PlayerRepository playerRepository = new PlayerRepositoryImpl(em);
        PlayerService playerService = new PlayerServiceImpl(playerRepository);
        PlayerRegistrationRequest playerRegistrationRequest = new PlayerRegistrationRequest();
        playerRegistrationRequest.setName("Donadoni");
        playerRegistrationRequest.setPosition("GK");
        playerRegistrationRequest.setNationality("Italia");
        playerRegistrationRequest.setBirthDate(new Date());
        List<SkillWeight> skillWeights = new ArrayList<>();

        SkillWeight skillWeight1 = new SkillWeight();
        skillWeight1.setSkillId("SPD");
        skillWeight1.setSkillWeight(80);
        skillWeights.add(skillWeight1);

        SkillWeight skillWeight2 = new SkillWeight();
        skillWeight2.setSkillId("PWR");
        skillWeight2.setSkillWeight(70);
        skillWeights.add(skillWeight2);

        playerRegistrationRequest.setSkillWeightList(skillWeights);

        playerRegistrationRequest.setClubCode("LIV");
        playerService.registration(playerRegistrationRequest);
    }
}
