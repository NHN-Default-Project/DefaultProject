package com.nhnacademy.main;

class Dice {
    private static final int DICE_EYE = 6;
    private int diceNum;
    public Dice() {
        this.rollDice();
    }

    public void rollDice() {
        this.diceNum = (int) (Math.random() * DICE_EYE) + 1;
    }

    @Override
    public String toString() {
        return "Dice Number : " + this.diceNum;
    }

    public int getDiceNum() {
        return diceNum;
    }
}