package com.nhnacademy.main;

import com.nhnacademy.yunhwa.Exercise5_3.Range;

public class Exercise5_3 {

    public static final int ROLL_NUMBER = 10_000;

    public static void main(String[] args) {
        printBeforeCalculation();
        calculate();
    }

    public static void calculate() {

        Range validRange = new Range(2, 12);

        for (int i = validRange.getMinValue(); i < validRange.getMaxValue(); i++) {
            PairOfDice pairOfDice = new PairOfDice();
            RollAPairOfDice rollAPairOfDice = new RollAPairOfDice(pairOfDice, ROLL_NUMBER);
            StatCalc statCalc = new StatCalc();
            rollAPairOfDice.rollNumber(statCalc, i);
            printResult(statCalc, i);
        }
    }

    public static void printBeforeCalculation() {
        System.out.println("Total On Dice\tAverage\t\t\tStandard Deviation\t\tMax");
        System.out.println("--------------\t--------\t\t-------------------\t\t-----");
    }

    public static void printResult(StatCalc statCalc, int goalValue) {
        System.out.printf("\t%d\t\t", goalValue);
        System.out.printf("\t%.4f\t\t", statCalc.getMean());
        System.out.printf("\t\t%.4f\t\t\t", statCalc.getStandardDeviation());
        System.out.printf("\t%d\t\t", (int) statCalc.getMax());
        System.out.println();
    }
}