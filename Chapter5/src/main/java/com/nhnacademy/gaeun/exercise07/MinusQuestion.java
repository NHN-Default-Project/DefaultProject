package com.nhnacademy.gaeun.exercise07;

public class MinusQuestion implements IntQuestion {

    private int a, b;  // The numbers in the problem.

    public MinusQuestion() { // constructor
        a = (int) (Math.random() * 50 + 1);
        b = (int) (Math.random() * 50);
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
    }

    public String getQuestion() {
        return "What is " + a + " - " + b + " ?";
    }

    public int getCorrectAnswer() {
        return a - b;
    }

}