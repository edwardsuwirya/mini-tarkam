package com.enigmacamp.minitarkam.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_game_result")
public class GameResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id", nullable = false)
    private long resultId;

    @OneToOne
    @JoinColumn(name = "football_club_home")
    private FootballClub footballClubHome;

    @OneToOne
    @JoinColumn(name = "football_club_away")
    private FootballClub footballClubAway;

    @OneToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @Column(name = "home_score")
    private Integer homeScore;


    @Column(name = "away_score")
    private Integer awayScore;

    public long getResultId() {
        return resultId;
    }

    public void setResultId(long resultId) {
        this.resultId = resultId;
    }

    public FootballClub getFootballClubHome() {
        return footballClubHome;
    }

    public void setFootballClubHome(FootballClub footballClubHome) {
        this.footballClubHome = footballClubHome;
    }

    public FootballClub getFootballClubAway() {
        return footballClubAway;
    }

    public void setFootballClubAway(FootballClub footballClubAway) {
        this.footballClubAway = footballClubAway;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
