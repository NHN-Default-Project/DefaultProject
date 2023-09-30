package com.nhnacademy.parkminsu.exercise5_7;

public class SubstractQuestion implements IntQuestion {
    private final int firstNum;
    private final int secondnum;

    public SubstractQuestion() {
        this.firstNum = (int) (Math.random() * 50) + 1;
        this.secondnum = (int) (Math.random() * 50);
    }

    @Override
    public String getQuestion() {
        return "What is " + firstNum + " - " + secondnum + " ?";
    }

    @Override
    public int getCorrectAnswer() {
        return firstNum - secondnum;
    }
}
