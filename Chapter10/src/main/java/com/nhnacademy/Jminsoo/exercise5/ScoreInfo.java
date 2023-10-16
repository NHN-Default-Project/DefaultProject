package com.nhnacademy.Jminsoo.exercise5;

public class ScoreInfo {
    private final String lastName;
    private final String firstName;
    private final int score;

    public ScoreInfo(String lastName, String firstName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getScore() {
        return score;
    }
}
