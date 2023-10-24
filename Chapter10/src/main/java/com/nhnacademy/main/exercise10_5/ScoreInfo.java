package com.nhnacademy.main.exercise10_5;

public class ScoreInfo {
    private final String lastName;
    private final String firstName;
    private final int score;

    public ScoreInfo(String lastName, String firstName, int score) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.score = score;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getScore() {
        return this.score;
    }
}
