package com.enigmacamp.minitarkam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PlayerSkillKey implements Serializable {
    @Column(name = "player_id")
    private long playerId;

    @Column(name = "skill_id")
    private String skillId;

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

}
