package com.nhnacademy.jminsoo.excercise1;

class Dice {
    private int diceNum;

    Dice() {
        this.diceNum = (int) (Math.random() * 6 + 1);
    }

    public void diceRoll() {
        this.diceNum = (int) (Math.random() * 6 + 1);
    }

    @Override
    public String toString() {
        return "Dice Number : " + this.diceNum;
    }

    public int getDiceNum() {
        return diceNum;
    }
}
