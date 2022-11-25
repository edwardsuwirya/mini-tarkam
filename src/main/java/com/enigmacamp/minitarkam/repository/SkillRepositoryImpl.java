package com.enigmacamp.minitarkam.repository;

import com.enigmacamp.minitarkam.entity.Position;
import com.enigmacamp.minitarkam.entity.Skill;
import jakarta.persistence.EntityManager;

public class SkillRepositoryImpl implements SkillRepository {
    private final EntityManager em;

    public SkillRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Skill skill) {
        try {
            em.getTransaction().begin();
            em.persist(skill);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Skill findOne(String id) {
        Skill skill = em.find(Skill.class, id);
        if (skill != null) {
            return skill;
        }
        throw new RuntimeException("Data not found");
    }
}
