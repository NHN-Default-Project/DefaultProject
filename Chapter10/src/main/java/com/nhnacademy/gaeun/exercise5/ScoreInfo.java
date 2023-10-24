package com.nhnacademy.gaeun.exercise5;

import lombok.Getter;

public class ScoreInfo {

    @Getter
    private final String lastName;
    @Getter
    private final String firstName;
    @Getter
    private final int score;

    public ScoreInfo(String lastName, String firstName, int score) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.score = score;
    }


    @Override
    public String toString() {
        return "ScoreInfo{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", score=" + score +
                '}';
    }
}

