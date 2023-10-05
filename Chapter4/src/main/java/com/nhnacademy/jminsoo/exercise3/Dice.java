package com.nhnacademy.jminsoo.exercise3;

class Dice {
    private int diceNum;
    private final int eyes;

    public Dice(int eyes) {
        this.eyes = eyes;
        this.rollDice();
    }

    public void rollDice() {
        this.diceNum = (int) (Math.random() * eyes) + 1;
    }

    @Override
    public String toString() {
        return "Dice Number : " + this.diceNum;
    }

    public int getDiceNum() {
        return diceNum;
    }
}
