package com.nhnacademy.parkminsu.exercise10_5;

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
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return
                "lastName='" + lastName + '\'' +
                        ", firstName='" + firstName + '\'' +
                        ", score=" + score + '\n';
    }
}
