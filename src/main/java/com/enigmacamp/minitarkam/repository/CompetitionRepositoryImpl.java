package com.enigmacamp.minitarkam.repository;

import com.enigmacamp.minitarkam.entity.Competition;
import com.enigmacamp.minitarkam.entity.GameResult;
import jakarta.persistence.EntityManager;

public class CompetitionRepositoryImpl implements CompetitionRepository {
    private final EntityManager em;

    public CompetitionRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Competition competition) {
        try {
            em.getTransaction().begin();
            em.persist(competition);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }

    @Override
    public Competition findOne(long id) {
        Competition competition = em.find(Competition.class, id);
        if (competition != null) {
            return competition;
        }
        throw new RuntimeException("Data not found");
    }
}
