package com.nhnacademy.main.excercise1;

public class SnakeEye {
    private static final int snakeEyeNum = 2;

    private PairOfDice pairOfDice;
    private int rollCount;

    public SnakeEye() {
        this.pairOfDice = new PairOfDice(); // 내부에 roll() 존재
        this.rollCount = 1; // 그래서 1회 추가
    }

    public boolean isSnakeEye() {
        return pairOfDice.sumEyes() == snakeEyeNum;
    }

    public void action() {
        while (!isSnakeEye()) {
            pairOfDice.roll();
            rollCount++;
        }
    }

    public int getRollCount() {
        return this.rollCount;
    }
}
