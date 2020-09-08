package com.onibiyo.gadsleaderboard.model;

public class SkillLeader {
    private String name;
    private int score;
    private String country;

    public SkillLeader(String name, int score, String country) {
        this.name = name;
        this.score = score;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getCountry() {
        return country;
    }
}
