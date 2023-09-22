package com.nhnacademy.gaeun.exercise01;

public class Main {
    public static void main(String[] args) {
        System.out.println(diceToSum(2));
    }

    public static int diceToSum(int sumValue) {
        PairOfDice pairOfDice = new PairOfDice();
        int countToSum = 0;
        while (pairOfDice.getSumValue() != sumValue) {
            pairOfDice.roll();
            countToSum++;
        }
        System.out.println(pairOfDice);
        return countToSum;
    }
}
