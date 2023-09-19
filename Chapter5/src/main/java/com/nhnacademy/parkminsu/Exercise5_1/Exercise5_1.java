package com.nhnacademy.parkminsu.Exercise5_1;

public class Exercise5_1 {
    public static void main(String[] args) {
        PairOfDice pairOfDice = new PairOfDice();
        pairOfDice.start();
        System.out.printf("%d %d : %d\n", pairOfDice.getDie1(), pairOfDice.getDie2(), pairOfDice.getRollDiceCount());
    }
}
