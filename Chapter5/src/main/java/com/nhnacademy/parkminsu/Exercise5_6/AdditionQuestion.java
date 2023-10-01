package com.nhnacademy.parkminsu.Exercise5_6;

import com.nhnacademy.parkminsu.Exercise5_7.IntQuestion;

public class AdditionQuestion implements IntQuestion {

    private final int firstNum;
    private final int secondNum;  // The numbers in the problem.

    public AdditionQuestion() { // constructor
        firstNum = (int) (Math.random() * 50 + 1);
        secondNum = (int) (Math.random() * 50);
    }

    @Override
    public String getQuestion() {
        return "What is " + firstNum + " + " + secondNum + " ?";
    }

    @Override
    public int getCorrectAnswer() {
        return firstNum + secondNum;
    }

}
