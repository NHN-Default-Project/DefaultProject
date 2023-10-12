package com.nhnacademy.jminsoo.exercise8;

public class Quiz {
    private int[] problemArr = new int[3];

    public Quiz(int firstNum, int secondNum, int answer) {
        problemArr[0] = firstNum;
        problemArr[1] = secondNum;
        problemArr[2] = answer;
    }

    public void setAnswer(int answer) {
        problemArr[2] = answer;
    }

    public int getFirstNum() {
        return problemArr[0];
    }

    public int getSecondNum() {
        return problemArr[1];
    }

    public int getAnswerNum() {
        return problemArr[2];
    }
}
