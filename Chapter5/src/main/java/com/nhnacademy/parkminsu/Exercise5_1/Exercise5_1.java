package com.nhnacademy.parkminsu.Exercise5_1;

public class Exercise5_1 {
    private static final int DICESUM = 2;

    public static void main(String[] args) {
        PairOfDice pairOfDice = new PairOfDice(DICESUM);
        pairOfDice.start(DICESUM);
        System.out.printf("%d %d : %d\n", pairOfDice.getDie1(), pairOfDice.getDie2(), pairOfDice.getRollDiceCount());
    }
}
