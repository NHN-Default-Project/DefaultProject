package com.nhnacademy.main;

import com.nhnacademy.yunhwa.Exercise5_3.Range;

public class PairOfDice {

    private int die1;   // Number showing on the first die.
    private int die2;   // Number showing on the second die.
    private int sumValue = 0;

    public int getDie1() {
        return die1;
    }

    public int getDie2() {
        return die2;
    }

    public int getSumValue() {
        return sumValue;
    }

    public PairOfDice() {
        // Constructor.  Rolls the dice, so that they initially
        // show some random values.
        roll();  // Call the roll() method to roll the dice.
    }

    public void roll() {
        // Roll the dice by setting each of the dice to be
        // a random number between 1 and 6.
        die1 = (int) (Math.random() * 6) + 1;
        die2 = (int) (Math.random() * 6) + 1;
        sumValue = getDie1() + getDie2();
    }

    @Override
    public String toString() {
        return "dice 1: " + getDie1() + ", dice 2: " + getDie2();
    }
} // end class PairOfDice