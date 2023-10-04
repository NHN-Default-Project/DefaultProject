package com.nhnacademy.parkminsu.exercise5_1;


public class PairOfDice {

    private int die1;   // Number showing on the first die.
    private int die2;   // Number showing on the second die.
    private int rollDiceCount;

    private final int diceSum;

    public PairOfDice(int diceSum) {
        this.diceSum = diceSum;
    }

    public void roll() {
        // Roll the dice by setting each of the dice to be
        // a random number between 1 and 6.
        this.die1 = (int) (Math.random() * 6) + 1;
        this.die2 = (int) (Math.random() * 6) + 1;
        this.rollDiceCount++;

    }

    public int sumDice() {
        return this.die1 + this.die2;
    }

    public int getDie1() {
        return die1;
    }

    public int getDie2() {
        return die2;
    }

    public int getRollDiceCount() {
        return rollDiceCount;
    }

    public void start(int num) {
        while (true) {
            roll();
            if (sumDice() == this.diceSum) {
                break;
            }
        }
    }

    public void initRollDiceCount() {
        this.rollDiceCount = 0;
    }

} // end class PairOfDice