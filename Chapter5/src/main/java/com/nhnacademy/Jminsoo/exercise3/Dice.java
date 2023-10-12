package com.nhnacademy.Jminsoo.exercise3;

import java.util.Random;

class Dice {
    private int diceNum;
    private final int eyes;
    private Random random;

    public Dice(int eyes) {
        this.eyes = eyes;
        this.random = new Random();
    }

    public void diceRoll() {
        this.diceNum = random.nextInt(eyes) + 1;
    }

    @Override
    public String toString() {
        return "Dice Number : " + this.diceNum;
    }

    public int getDiceNum() {
        return diceNum;
    }
}
