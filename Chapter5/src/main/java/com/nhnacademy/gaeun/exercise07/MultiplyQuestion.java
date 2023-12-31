package com.nhnacademy.gaeun.exercise07;

public class MultiplyQuestion implements IntQuestion {
    private int a, b;  // The numbers in the problem.

    public MultiplyQuestion() { // constructor
        a = (int) (Math.random() * 50 + 1);
        b = (int) (Math.random() * 50);
    }

    public String getQuestion() {
        return "What is " + a + " * " + b + " ?";
    }

    public int getCorrectAnswer() {
        return a * b;
    }
}
