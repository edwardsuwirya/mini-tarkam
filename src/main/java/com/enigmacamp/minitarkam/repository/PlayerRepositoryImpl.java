package com.enigmacamp.minitarkam.repository;

import com.enigmacamp.minitarkam.entity.Player;
import jakarta.persistence.EntityManager;

public class PlayerRepositoryImpl implements PlayerRepository {
    private final EntityManager em;

    public PlayerRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Player player) {
        try {
            em.getTransaction().begin();
            em.merge(player);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }

    @Override
    public Player findOne(long id) {
        Player player = em.find(Player.class, id);
        if (player != null) {
            return player;
        }
        throw new RuntimeException("Data not found");
    }
}
