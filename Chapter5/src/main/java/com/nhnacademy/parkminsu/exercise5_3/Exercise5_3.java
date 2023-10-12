package com.nhnacademy.parkminsu.exercise5_3;

import com.nhnacademy.parkminsu.exercise5_1.PairOfDice;
import com.nhnacademy.parkminsu.exercise5_2.StatCalc;

public class Exercise5_3 {
    private static final int ARANGE = 10000;
    private static final int BEGIN_DICESUM_RANGE = 2;
    private static final int END_DICESUM_RANGE = 12;

    private static final int ARRAYSIZE = END_DICESUM_RANGE - BEGIN_DICESUM_RANGE + 1;

    public static void main(String[] args) {

        StatCalc[] statCalc = new StatCalc[ARRAYSIZE];
        PairOfDice[] pairOfDice = new PairOfDice[ARRAYSIZE];


        for (int i = 0; i < ARRAYSIZE; i++) {
            statCalc[i] = new StatCalc();
            pairOfDice[i] = new PairOfDice(BEGIN_DICESUM_RANGE + i);
        }
        statCalc = createStatCalcValue(statCalc, pairOfDice);
        for (int i = 0; i < ARRAYSIZE; i++) {
            System.out.println(BEGIN_DICESUM_RANGE + i + "의 통계");
            System.out.println("평균:\t" + statCalc[i].getMean());
            System.out.println("표준편차:\t" + statCalc[i].getStandardDeviation());
            System.out.println("최대값:\t" + statCalc[i].getMax());
            System.out.println();

        }

    }


    public static StatCalc[] createStatCalcValue(StatCalc[] statCalcsList, PairOfDice[] pairOfDice) {
        for (int i = BEGIN_DICESUM_RANGE; i <= END_DICESUM_RANGE; i++) {
            int count = 0;
            while (true) {
                if (count == ARANGE) {
                    break;
                }
                pairOfDice[i - BEGIN_DICESUM_RANGE].roll();
                if (pairOfDice[i - BEGIN_DICESUM_RANGE].sumDice() == i) {
                    statCalcsList[i - BEGIN_DICESUM_RANGE].enter(pairOfDice[i - BEGIN_DICESUM_RANGE].getRollDiceCount());
                    count++;
                    pairOfDice[i - BEGIN_DICESUM_RANGE].initRollDiceCount();
                }
            }
        }

        return statCalcsList;
    }

}
