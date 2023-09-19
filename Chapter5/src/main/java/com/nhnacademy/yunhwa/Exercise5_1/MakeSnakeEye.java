package com.nhnacademy.yunhwa.Exercise5_1;

public class MakeSnakeEye {
    private final static int snakeEyeNum = 2;

    private PairOfDice pairOfDice;
    private int rollCount;

    public MakeSnakeEye() {
        this.pairOfDice = new PairOfDice(); // 내부에 roll() 존재
        this.rollCount = 1; // 그래서 1회 추가
    }

    public boolean isSnakeEye() {
        return pairOfDice.sumEyes() == snakeEyeNum;
    }

    public void action() {
        while(! isSnakeEye()) {
            pairOfDice.roll();
            rollCount++;
        }
    }

    public int getRollCount() {
        return this.rollCount;
    }
}
