package com.enigmacamp.minitarkam.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "m_player_skill")
public class PlayerSkill {

    @EmbeddedId
    private PlayerSkillKey id;

    public PlayerSkill() {
        this.id = new PlayerSkillKey();
    }

    @ManyToOne
    @MapsId("playerId")
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @ManyToOne
    @MapsId("skillId")
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @Column(name = "skill_weight")
    int skillWeight;

    public PlayerSkillKey getId() {
        return id;
    }

    public void setId(PlayerSkillKey id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getSkillWeight() {
        return skillWeight;
    }

    public void setSkillWeight(int skillWeight) {
        this.skillWeight = skillWeight;
    }

    @Override
    public String toString() {
        return "PlayerSkill{" +
                "id=" + id +
                ", skill=" + skill +
                ", skillWeight=" + skillWeight +
                '}';
    }
}
