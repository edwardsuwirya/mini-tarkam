package com.enigmacamp.minitarkam.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_competition")
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "competition_id", nullable = false)
    private long competitionId;

    @Column(name = "competition_name")
    private String competitionName;

    @ManyToMany
    @JoinTable(
            name = "t_competition_club",
            joinColumns = @JoinColumn(name = "competition_id"),
            inverseJoinColumns = @JoinColumn(name = "club_code"))
    private Set<FootballClub> participantClub = new HashSet<>();

    public long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(long competitionId) {
        this.competitionId = competitionId;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public Set<FootballClub> getParticipantClub() {
        return participantClub;
    }

    public void setParticipantClub(Set<FootballClub> participantClub) {
        this.participantClub = participantClub;
    }
}
