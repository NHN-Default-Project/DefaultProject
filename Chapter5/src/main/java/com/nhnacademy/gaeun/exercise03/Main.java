package com.nhnacademy.gaeun.exercise03;

public class Main {
    public static void main(String[] args) {
        System.out.println("Total On Dice    Average    Standard Deviation    Max");
        System.out.println("--------------   --------    -------------------    -----");
        for (int i = 2; i < 13; i++) {
            PairOfDice pairOfDice = new PairOfDice();
            StatCalc statCalc = new StatCalc();
            rollNumber(pairOfDice, statCalc, 10000, i);
            System.out.printf("      ");
            System.out.printf("%d      ", i);
            System.out.printf("      ");
            System.out.printf("%.4f      ", statCalc.getMean());
            System.out.printf("      ");
            System.out.printf("%.4f      ", statCalc.getStandardDeviation());
            System.out.printf("      ");
            System.out.printf("%d      \n", (int) statCalc.getMax());
        }
    }

    public static void rollNumber(PairOfDice pairOfDice, StatCalc statCalc, int rollNumber, int goalValue) {
        for (int i = 0; i < rollNumber; i++) {
            pairOfDice.roll();
            statCalc.enter(pairOfDice.diceRoll(goalValue));
        }
    }
}