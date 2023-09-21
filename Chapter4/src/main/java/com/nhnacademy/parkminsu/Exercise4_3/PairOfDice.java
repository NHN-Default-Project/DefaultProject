package com.nhnacademy.parkminsu.Exercise4_3;

public class Dice {
    private int diceEye;
    private int rollCount;
    private DiceCollection diceCollection = new DiceCollection();

    public void setDiceEye(int diceEye) {
        this.diceEye = diceEye;
    }

    public int getDiceEye() {
        return diceEye;
    }

    public void diceRoll() {
        this.diceEye = (int) (Math.random() * 6) + 1;
    }

}
