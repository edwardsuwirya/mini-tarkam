package com.enigmacamp.minitarkam.repository;

import com.enigmacamp.minitarkam.entity.Competition;
import com.enigmacamp.minitarkam.entity.FootballClub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

class CompetitionRepositoryImplTest extends BaseRepoTest {
    Set<FootballClub> footballClubList = new HashSet<>();

    //    @AfterEach
    @BeforeEach
    void clean() {
        cleanTable("minitarkam.m_competition_club");
        cleanTable("minitarkam.m_football_club");
        cleanTable("minitarkam.t_competition");
    }

    void initFootballClub() {
        FootballClub clubA = new FootballClub();
        clubA.setClubCode("LIV");
        clubA.setClubName("Liverpool");
        clubA.setCity("Gresik");
        clubA.setEstablishDate(new Date());

        FootballClub clubB = new FootballClub();
        clubB.setClubCode("MUC");
        clubB.setClubName("Manchester United");
        clubB.setCity("Pekalongan");
        clubB.setEstablishDate(new Date());

        FootballClub clubC = new FootballClub();
        clubC.setClubCode("ARS");
        clubC.setClubName("Arsenal");
        clubC.setCity("Balikpapan");
        clubC.setEstablishDate(new Date());

        FootballClub clubD = new FootballClub();
        clubD.setClubCode("NWC");
        clubD.setClubName("Norwich City");
        clubD.setCity("Bandung");
        clubD.setEstablishDate(new Date());

        FootballClubRepository footballClubRepository = new FootballClubRepositoryImpl(em);
        footballClubRepository.create(clubA);
        footballClubRepository.create(clubB);
        footballClubRepository.create(clubC);
        footballClubRepository.create(clubD);

        footballClubList.add(clubA);
        footballClubList.add(clubB);
        footballClubList.add(clubC);
        footballClubList.add(clubD);
    }

    @Test
    void whenCreate_Competition_Successfully() {
        initFootballClub();
        Competition competition = new Competition();
        competition.setCompetitionName("Liga Tarkam Tak Berseri");
        competition.setParticipantClub(footballClubList);
        CompetitionRepository competitionRepository = new CompetitionRepositoryImpl(em);
        competitionRepository.create(competition);
    }
}