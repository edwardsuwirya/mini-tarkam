package com.enigmacamp.minitarkam.model;

public class StandingTable {
    private String clubCode;
    private int win;
    private int draw;
    private int lose;

    private int point;

    private int goalFor;
    private int goalAgainst;
    private int golDifference;

    public String getClubCode() {
        return clubCode;
    }

    public void setClubCode(String clubCode) {
        this.clubCode = clubCode;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getGoalFor() {
        return goalFor;
    }

    public void setGoalFor(int goalFor) {
        this.goalFor = goalFor;
    }

    public int getGoalAgainst() {
        return goalAgainst;
    }

    public void setGoalAgainst(int goalAgainst) {
        this.goalAgainst = goalAgainst;
    }

    public int getGolDifference() {
        return golDifference;
    }

    public void setGolDifference(int golDifference) {
        this.golDifference = golDifference;
    }

    public void setPoint() {
        this.point = (this.win * 3) + this.draw;
    }

    public void setGolDiff() {
        this.golDifference = this.goalFor - goalAgainst;
    }

    @Override
    public String toString() {
        return "StandingTable{" +
                "clubCode='" + clubCode + '\'' +
                ", win=" + win +
                ", draw=" + draw +
                ", lose=" + lose +
                ", point=" + point +
                ", goalFor=" + goalFor +
                ", goalAgainst=" + goalAgainst +
                ", golDifference=" + golDifference +
                '}';
    }
}
