package com.enigmacamp.minitarkam.model;

import java.util.Date;
import java.util.List;

public class PlayerRegistrationRequest {
    private String name;
    private Date birthDate;
    private String nationality;
    private int height;
    private String position;

    private String clubCode;
    private List<SkillWeight> skillWeightList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<SkillWeight> getSkillWeightList() {
        return skillWeightList;
    }

    public void setSkillWeightList(List<SkillWeight> skillWeightList) {
        this.skillWeightList = skillWeightList;
    }

    public String getClubCode() {
        return clubCode;
    }

    public void setClubCode(String clubCode) {
        this.clubCode = clubCode;
    }
}
