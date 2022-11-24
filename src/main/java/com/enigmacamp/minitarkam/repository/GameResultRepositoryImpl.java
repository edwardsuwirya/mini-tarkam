package com.enigmacamp.minitarkam.repository;

import com.enigmacamp.minitarkam.entity.GameResult;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class GameResultRepositoryImpl implements GameResultRepository {
    private final EntityManager em;

    public GameResultRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(GameResult gameResult) {
        try {
            em.getTransaction().begin();
            em.persist(gameResult);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public GameResult findOne(long id) {
        GameResult gameResult = em.find(GameResult.class, id);
        if (gameResult != null) {
            return gameResult;
        }
        throw new RuntimeException("Data not found");
    }

    @Override
    public List<GameResult> findByCompetition(long competitionId) {
        TypedQuery<GameResult> gameResultTypedQuery = em.createQuery("SELECT gr FROM GameResult gr where gr.competition.competitionId = :id", GameResult.class);
        gameResultTypedQuery.setParameter("id", competitionId);
        return gameResultTypedQuery.getResultList();
    }
}
