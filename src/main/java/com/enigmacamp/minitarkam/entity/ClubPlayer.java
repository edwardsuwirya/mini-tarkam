package com.enigmacamp.minitarkam.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "m_club_player")
public class ClubPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_player_id")
    private long clubPlayerId;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "club_code")
    private FootballClub footballClub;

    @Column(name = "is_active")
    boolean isActive = true;

    public long getClubPlayerId() {
        return clubPlayerId;
    }

    public void setClubPlayerId(long clubPlayerId) {
        this.clubPlayerId = clubPlayerId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public FootballClub getFootballClub() {
        return footballClub;
    }

    public void setFootballClub(FootballClub footballClub) {
        this.footballClub = footballClub;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
