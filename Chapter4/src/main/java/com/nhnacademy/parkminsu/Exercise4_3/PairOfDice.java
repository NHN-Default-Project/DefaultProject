package com.nhnacademy.parkminsu.Exercise4_3;

public class PairOfDice {
    private int diceEye1;
    private int diceEye2;
    private int rollCount;

    public void diceRoll() {
        this.diceEye1 = (int) (Math.random() * 6) + 1;
        this.diceEye2 = (int) (Math.random() * 6) + 1;
        this.rollCount++;
    }

    public int getRollCount() {
        return this.rollCount;
    }

    public void clearRollCount() {
        this.rollCount = 0;
    }

    public int getDiceEye1() {
        return this.diceEye1;
    }

    public int getDiceEye2() {
        return this.diceEye2;
    }
}
