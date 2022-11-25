package com.enigmacamp.minitarkam.repository;

import com.enigmacamp.minitarkam.entity.Skill;

public interface SkillRepository {
    void create(Skill skill);

    Skill findOne(String id);
}
