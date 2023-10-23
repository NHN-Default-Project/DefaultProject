package com.nhnacademy.yunhwa.exercise10_5;

/**
 * Data for one student about a score on a test.
 */
public class ScoreInfo {
    private String lastName;
    private String firstName;
    private int score;

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

