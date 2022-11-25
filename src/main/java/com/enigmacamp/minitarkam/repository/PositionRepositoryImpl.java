package com.enigmacamp.minitarkam.repository;

import com.enigmacamp.minitarkam.entity.Position;
import jakarta.persistence.EntityManager;

public class PositionRepositoryImpl implements PositionRepository {
    private final EntityManager em;

    public PositionRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Position position) {
        try {
            em.getTransaction().begin();
            em.persist(position);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Position findOne(String id) {
        Position position = em.find(Position.class, id);
        if (position != null) {
            return position;
        }
        throw new RuntimeException("Data not found");
    }
}
