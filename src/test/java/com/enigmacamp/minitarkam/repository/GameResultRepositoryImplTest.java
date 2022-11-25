package com.enigmacamp.minitarkam.repository;

import com.enigmacamp.minitarkam.entity.Competition;
import com.enigmacamp.minitarkam.entity.FootballClub;
import com.enigmacamp.minitarkam.entity.GameResult;
import com.enigmacamp.minitarkam.model.StandingTable;
import com.enigmacamp.minitarkam.service.StandingTableService;
import com.enigmacamp.minitarkam.service.StandingTableServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameResultRepositoryImplTest extends BaseRepoTest {
    List<FootballClub> footballClubList = new ArrayList<>();
    CompetitionRepository competitionRepository;
    GameResultRepository gameResultRepository;

    //    @AfterEach
    @BeforeEach
    void clean() {
        cleanTable("minitarkam.m_football_club");
        cleanTable("minitarkam.t_game_result");
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

    Competition competition;

    void initCompetition() {
        competition = new Competition();
        competition.setCompetitionName("Liga Tarkam Tak Berseri");
        competition.setParticipantClub(new HashSet<>(footballClubList));
        competitionRepository = new CompetitionRepositoryImpl(em);
        competitionRepository.create(competition);
    }

    @Test
    void whenCreate_GameResult_Successfully() {
        initFootballClub();
        initCompetition();
        GameResult gameResult = new GameResult();
        gameResult.setFootballClubHome(footballClubList.get(0));
        gameResult.setFootballClubAway(footballClubList.get(1));
        gameResult.setHomeScore(2);
        gameResult.setAwayScore(0);
        gameResult.setCompetition(competition);
        GameResultRepository gameResultRepository = new GameResultRepositoryImpl(em);
        gameResultRepository.create(gameResult);
    }

    @Test
    void whenFind_ByCompeition_Successfully() {
        initFootballClub();
        initCompetition();
        GameResult gameResult = new GameResult();
        gameResult.setFootballClubHome(footballClubList.get(0));
        gameResult.setFootballClubAway(footballClubList.get(1));
        gameResult.setHomeScore(2);
        gameResult.setAwayScore(0);
        gameResult.setCompetition(competition);
        gameResultRepository = new GameResultRepositoryImpl(em);
        gameResultRepository.create(gameResult);

        List<GameResult> actualGameResults = gameResultRepository.findByCompetition(competition.getCompetitionId());
        assertEquals(1, actualGameResults.size());
    }

    void initResult() {
        GameResult gameResult = new GameResult();
        gameResult.setFootballClubHome(footballClubList.get(0));
        gameResult.setFootballClubAway(footballClubList.get(1));
        gameResult.setHomeScore(1);
        gameResult.setAwayScore(1);
        gameResult.setCompetition(competition);

        GameResult gameResult2 = new GameResult();
        gameResult2.setFootballClubHome(footballClubList.get(0));
        gameResult2.setFootballClubAway(footballClubList.get(2));
        gameResult2.setHomeScore(1);
        gameResult2.setAwayScore(0);
        gameResult2.setCompetition(competition);

        GameResult gameResult3 = new GameResult();
        gameResult3.setFootballClubHome(footballClubList.get(0));
        gameResult3.setFootballClubAway(footballClubList.get(3));
        gameResult3.setHomeScore(3);
        gameResult3.setAwayScore(1);
        gameResult3.setCompetition(competition);

        GameResult gameResult4 = new GameResult();
        gameResult4.setFootballClubHome(footballClubList.get(1));
        gameResult4.setFootballClubAway(footballClubList.get(2));
        gameResult4.setHomeScore(2);
        gameResult4.setAwayScore(0);
        gameResult4.setCompetition(competition);

        GameResult gameResult5 = new GameResult();
        gameResult5.setFootballClubHome(footballClubList.get(1));
        gameResult5.setFootballClubAway(footballClubList.get(3));
        gameResult5.setHomeScore(1);
        gameResult5.setAwayScore(0);
        gameResult5.setCompetition(competition);

        GameResult gameResult6 = new GameResult();
        gameResult6.setFootballClubHome(footballClubList.get(2));
        gameResult6.setFootballClubAway(footballClubList.get(3));
        gameResult6.setHomeScore(7);
        gameResult6.setAwayScore(0);
        gameResult6.setCompetition(competition);


        gameResultRepository = new GameResultRepositoryImpl(em);
        gameResultRepository.create(gameResult);
        gameResultRepository.create(gameResult2);
        gameResultRepository.create(gameResult3);
        gameResultRepository.create(gameResult4);
        gameResultRepository.create(gameResult5);
        gameResultRepository.create(gameResult6);
    }

    @Test
    void whenView_Standing_Successfully() {
        initFootballClub();
        initCompetition();
        initResult();
        StandingTableService service = new StandingTableServiceImpl(gameResultRepository, competitionRepository);
        List<StandingTable> result = service.viewTable(14);
        for (StandingTable standingTable : result) {
            System.out.println(standingTable);
        }
    }
}