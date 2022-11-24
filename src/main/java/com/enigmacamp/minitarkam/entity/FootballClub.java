package com.enigmacamp.minitarkam.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "m_football_club")
public class FootballClub {
    @Id
    @Column(name = "club_code")
    private String clubCode;

    @Column(name = "club_name", nullable = false)
    private String clubName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false)
    private Date establishDate;

    @Column(length = 100, nullable = false)
    private String city;

//    @OneToMany(mappedBy = "footballClub")
//    private List<ClubPlayer> players = new ArrayList<>();

    @ManyToMany(mappedBy = "participantClub")
    private Set<Competition> competitions = new HashSet<>();

    public String getClubCode() {
        return clubCode;
    }

    public void setClubCode(String clubCode) {
        this.clubCode = clubCode;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public Date getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(Date establishDate) {
        this.establishDate = establishDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

//    public List<ClubPlayer> getPlayers() {
//        return players;
//    }
//
//    public void setPlayers(List<ClubPlayer> players) {
//        this.players = players;
//    }

    public Set<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Set<Competition> competitions) {
        this.competitions = competitions;
    }
}
