package com.nhnacademy.parkminsu.Exercise5_7;

public class SubstractQuestion implements IntQuestion {
    private int a;
    private int b;

    public SubstractQuestion() {
        this.a = (int) (Math.random() * 50) + 1;
        this.b = (int) (Math.random() * 50);
    }

    @Override
    public String getQuestion() {
        return "What is " + a + " - " + b + " ?";
    }

    @Override
    public int getCorrectAnswer() {
        return a - b;
    }
}
