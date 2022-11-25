package com.enigmacamp.minitarkam.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "m_player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id", nullable = false)
    private long playerId;

    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;
    @Column(length = 100, nullable = false)
    private String nationality;
    @Column(nullable = false)
    private int height = 0;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    private Position position;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private Set<ClubPlayer> clubs = new HashSet<>();

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private Set<PlayerSkill> skillSet = new HashSet<>();

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    public Set<ClubPlayer> getClubs() {
        return clubs;
    }

    public void setClubs(Set<ClubPlayer> clubs) {
        this.clubs = clubs;
    }

    public Set<PlayerSkill> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(Set<PlayerSkill> skillSet) {
        this.skillSet = skillSet;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", nationality='" + nationality + '\'' +
                ", height=" + height +
                ", position=" + position +
                ", clubs=" + clubs +
                ", skillSet=" + skillSet +
                '}';
    }
}
