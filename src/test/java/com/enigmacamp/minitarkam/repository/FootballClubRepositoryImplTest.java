package com.enigmacamp.minitarkam.repository;

import com.enigmacamp.minitarkam.entity.FootballClub;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FootballClubRepositoryImplTest extends BaseRepoTest {
    @AfterEach
    @BeforeEach
    void clean() {
        cleanTable("minitarkam.m_football_club");
        em.clear();
    }

    @Test
    void whenCreate_FootballClub_Successfully() {
//        Given
        FootballClub dummyFootballClub = new FootballClub();
        dummyFootballClub.setClubCode("LIV");
        dummyFootballClub.setClubName("Liverpool");
        dummyFootballClub.setCity("Gresik");
        dummyFootballClub.setEstablishDate(new Date());
        FootballClubRepository footballClubRepository = new FootballClubRepositoryImpl(em);
        assertDoesNotThrow(() -> footballClubRepository.create(dummyFootballClub));
    }
}