package com.onibiyo.gadsleaderboard.model;

import com.google.gson.annotations.SerializedName;

public class LearnersDetails {
    @SerializedName("name")
    private String name;
    @SerializedName("score")
    private int score;
    @SerializedName("skilliq")
    private String skillIq;
    @SerializedName("country")
    private String country;
    @SerializedName("badgeUrl")
    private String badgeUrl;

    public LearnersDetails(String name, int score, String skillIq, String country, String badgeUrl) {
        this.name = name;
        this.score = score;
        this.skillIq = skillIq;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getSkillIq() {
        return skillIq;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }
}
