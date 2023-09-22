package com.nhnacademy.main.excercise1;

public class PairOfDice {

    private int die1;   // Number showing on the first die.
    private int die2;   // Number showing on the second die.

    public PairOfDice() {
        // Constructor.  Rolls the dice, so that they initially
        // show some random values.
        roll();  // Call the roll() method to roll the dice.
    }

    public PairOfDice(int val1, int val2) {
        // Constructor.  Creates a pair of dice that
        // are initially showing the values val1 and val2.
        this.die1 = val1;  // Assign specified values 
        this.die2 = val2;  // to the instance variables.
    }

    public int getDie1() {
        return this.die1;
    }

    public int getDie2() {
        return this.die2;
    }

    public int sumEyes() {
        return this.die1 + this.die2;
    }

    public void roll() {
        // Roll the dice by setting each of the dice to be
        // a random number between 1 and 6.
        this.die1 = (int) (Math.random() * 6) + 1;
        this.die2 = (int) (Math.random() * 6) + 1;
    }

    public String toString() {
        return "이 주사위 쌍의 눈은 " + die1 + " 와 " + die2 + " 입니다.";
    }

} // end class PairOfDice