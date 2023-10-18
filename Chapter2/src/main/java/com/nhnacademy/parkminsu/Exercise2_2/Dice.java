package com.nhnacademy.parkminsu.Exercise2_2;

import java.util.Random;

public class Dice {
    private int diceEye;
    private int rolledNum;

    public Dice(int diceEye) {
        this.diceEye = diceEye;
    }

    public void roll() {
        Random random = new Random();
        rolledNum = random.nextInt(getDiceEye()) + 1;
    }

    public int getRolledNum() {
        return rolledNum;
    }

    public int getDiceEye() {
        return diceEye;
    }

}
