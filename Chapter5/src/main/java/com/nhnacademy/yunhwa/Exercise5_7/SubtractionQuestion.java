package com.nhnacademy.yunhwa.Exercise5_7;

public class SubtractionQuestion implements IntQuestion {

    private int a, b;  // The numbers in the problem.

    public SubtractionQuestion() { // constructor
        
        do {
            a = (int)(Math.random() * 50 + 1);
            b = (int)(Math.random() * 50);
        } while (a - b < 0);
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