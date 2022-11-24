package com.enigmacamp.minitarkam.service;

import com.enigmacamp.minitarkam.entity.Competition;
import com.enigmacamp.minitarkam.entity.FootballClub;
import com.enigmacamp.minitarkam.entity.GameResult;
import com.enigmacamp.minitarkam.model.StandingTable;
import com.enigmacamp.minitarkam.repository.CompetitionRepository;
import com.enigmacamp.minitarkam.repository.GameResultRepository;

import java.util.*;

public class StandingTableServiceImpl implements StandingTableService {
    private final GameResultRepository gameResultRepository;
    private final CompetitionRepository competitionRepository;

    public StandingTableServiceImpl(GameResultRepository gameResultRepository, CompetitionRepository competitionRepository) {
        this.gameResultRepository = gameResultRepository;
        this.competitionRepository = competitionRepository;
    }

    @Override
    public List<StandingTable> viewTable(long competitionId) {
        Competition competitions = competitionRepository.findOne(competitionId);
        List<GameResult> gameResults = gameResultRepository.findByCompetition(competitionId);

        if (competitions.getParticipantClub().size() == 0) {
            throw new RuntimeException("No data club found");
        }
        Map<String, StandingTable> tim = new HashMap<>();
        for (FootballClub footballClub : competitions.getParticipantClub()) {
            tim.put(footballClub.getClubCode(), new StandingTable());
        }

        for (GameResult game : gameResults) {
            if (game.getHomeScore() > game.getAwayScore()) {
                StandingTable winResult = tim.get(game.getFootballClubHome().getClubCode());
                winResult.setWin(winResult.getWin() + 1);
                winResult.setPoint();
                winResult.setGoalFor(winResult.getGoalFor() + game.getHomeScore());
                winResult.setGoalAgainst(winResult.getGoalAgainst() + game.getAwayScore());
                winResult.setGolDiff();

                StandingTable loseResult = tim.get(game.getFootballClubAway().getClubCode());
                loseResult.setLose(loseResult.getLose() + 1);
                loseResult.setPoint();
                loseResult.setGoalFor(loseResult.getGoalFor() + game.getAwayScore());
                loseResult.setGoalAgainst(loseResult.getGoalAgainst() + game.getHomeScore());
                loseResult.setGolDiff();
            } else if (game.getHomeScore() == game.getAwayScore()) {
                StandingTable homeDraw = tim.get(game.getFootballClubHome().getClubCode());
                homeDraw.setDraw(homeDraw.getDraw() + 1);
                homeDraw.setPoint();
                homeDraw.setGoalFor(homeDraw.getGoalFor() + game.getHomeScore());
                homeDraw.setGoalAgainst(homeDraw.getGoalAgainst() + game.getAwayScore());
                homeDraw.setGolDiff();
                StandingTable awayDraw = tim.get(game.getFootballClubAway().getClubCode());
                awayDraw.setDraw(awayDraw.getDraw() + 1);
                awayDraw.setPoint();
                awayDraw.setGoalFor(awayDraw.getGoalFor() + game.getAwayScore());
                awayDraw.setGoalAgainst(awayDraw.getGoalAgainst() + game.getHomeScore());
                awayDraw.setGolDiff();
            } else {
                StandingTable winResult = tim.get(game.getFootballClubAway().getClubCode());
                winResult.setWin(winResult.getWin() + 1);
                winResult.setPoint();
                winResult.setGoalFor(winResult.getGoalFor() + game.getAwayScore());
                winResult.setGoalAgainst(winResult.getGoalAgainst() + game.getHomeScore());
                winResult.setGolDiff();
                StandingTable loseResult = tim.get(game.getFootballClubHome().getClubCode());
                loseResult.setLose(loseResult.getLose() + 1);
                loseResult.setPoint();
                loseResult.setGoalFor(loseResult.getGoalFor() + game.getHomeScore());
                loseResult.setGoalAgainst(loseResult.getGoalAgainst() + game.getAwayScore());
                loseResult.setGolDiff();
            }
        }
        tim.entrySet().forEach((v) -> v.getValue().setClubCode(v.getKey()));
        List<StandingTable> timValues = new ArrayList<>(tim.values());
        timValues.sort(((Comparator<StandingTable>) (o1, o2) -> o2.getPoint() - o1.getPoint())
                .thenComparing((o1, o2) -> o2.getGolDifference() - o1.getGolDifference()));

        return timValues;
    }
}
