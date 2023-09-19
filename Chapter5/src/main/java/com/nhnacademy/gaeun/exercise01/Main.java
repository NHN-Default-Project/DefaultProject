package com.nhnacademy.gaeun.exercise01;

public class Main {
    public static void main(String[] args) {
        System.out.println(diceToSum(2));
    }
    public static int diceToSum (int sumValue) {
        PairOfDice pairOfDice = new PairOfDice();
        int tmpSum = 0;
        int countToSum = 0;
        while(tmpSum != sumValue) {
            pairOfDice.roll();
            tmpSum = pairOfDice.getSumValue();
            countToSum++;
        }
        System.out.println(pairOfDice);
        return countToSum;
    }
}
