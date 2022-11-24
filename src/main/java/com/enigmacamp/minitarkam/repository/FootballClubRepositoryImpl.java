package com.enigmacamp.minitarkam.repository;

import com.enigmacamp.minitarkam.entity.FootballClub;
import com.enigmacamp.minitarkam.entity.GameResult;
import jakarta.persistence.EntityManager;

public class FootballClubRepositoryImpl implements FootballClubRepository {
    private final EntityManager em;

    public FootballClubRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(FootballClub footballClub) {
        try {
            em.getTransaction().begin();
            em.persist(footballClub);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }
}
