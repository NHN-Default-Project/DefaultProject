package com.nhnacademy.parkminsu.Exercise5_3;

import com.nhnacademy.parkminsu.Exercise5_1.PairOfDice;
import com.nhnacademy.parkminsu.Exercise5_2.StatCalc;

public class Exercise5_3 {
    private static final int ARANGE = 10000;
    private static final int BEGIN_DiceSum_Range = 2;
    private static final int END_DiceSum_Range = 12;

    private static final int ARRAYSize = END_DiceSum_Range - BEGIN_DiceSum_Range + 1;

    public static void main(String[] args) {

        StatCalc[] statCalc = new StatCalc[ARRAYSize];
        PairOfDice[] pairOfDice = new PairOfDice[ARRAYSize];


        for (int i = 0; i < ARRAYSize; i++) {
            statCalc[i] = new StatCalc();
            pairOfDice[i] = new PairOfDice(BEGIN_DiceSum_Range + i);
        }
        statCalc = createStatCalcValue(statCalc, pairOfDice);
        for (int i = 0; i < ARRAYSize; i++) {
            System.out.println(BEGIN_DiceSum_Range + i + "의 통계");
            System.out.println("평균:\t" + statCalc[i].getMean());
            System.out.println("표준편차:\t" + statCalc[i].getStandardDeviation());
            System.out.println("최대값:\t" + statCalc[i].getMax());
            System.out.println();

        }

    }


    public static StatCalc[] createStatCalcValue(StatCalc[] statCalcsList, PairOfDice[] pairOfDice) {
        for (int i = BEGIN_DiceSum_Range; i <= END_DiceSum_Range; i++) {
            int count = 0;
            while (true) {
                if (count == ARANGE) {
                    System.out.println("break");
                    break;
                }
                pairOfDice[i - BEGIN_DiceSum_Range].roll();
                if (pairOfDice[i - BEGIN_DiceSum_Range].sumDice() == i) {
                    statCalcsList[i - BEGIN_DiceSum_Range].enter(pairOfDice[i - BEGIN_DiceSum_Range].getRollDiceCount());
                    count++;
                    pairOfDice[i - BEGIN_DiceSum_Range].initRollDiceCount();
                }
            }
        }

        return statCalcsList;
    }

}
