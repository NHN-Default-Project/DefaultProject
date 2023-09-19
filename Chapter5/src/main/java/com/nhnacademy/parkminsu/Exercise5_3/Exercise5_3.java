package com.nhnacademy.parkminsu.Exercise5_3;

import com.nhnacademy.parkminsu.Exercise5_1.PairOfDice;
import com.nhnacademy.parkminsu.Exercise5_2.StatCalc;

public class Exercise5_3 {
    private static int ARANGE = 10000;
    private static final int beginDiceSumRange = 2;
    private static final int endRDiceSumnange = 12;

    private static final int arraySize = endRDiceSumnange - beginDiceSumRange + 1;

    public static void main(String[] args) {

        StatCalc[] statCalc = new StatCalc[arraySize];
        StatCalc standardDeviation = new StatCalc();
        PairOfDice pairOfDice = new PairOfDice(2);


        for (int i = 0; i < arraySize; i++) {
            statCalc[i] = new StatCalc();
        }

        for (int i = 0; i < ARANGE; i++) {
            pairOfDice.roll();
            for (int j = 0; j < arraySize; j++) {
                if (pairOfDice.sumDice() == beginDiceSumRange + j) {
                    standardDeviation.enter(beginDiceSumRange + j);
                    statCalc[j].enter(beginDiceSumRange + j);
                }
            }
        }
        for (int i = 0; i < arraySize; i++) {
            System.out.println("평균 : " + avageCnt(statCalc[i]));
        }
        System.out.println("표준편차 : " + standardDeviation.getStandardDeviation());
        System.out.println("최대 굴린 횟수 : " + maxRoll(statCalc));
    }

    public static double avageCnt(StatCalc statCalc) {

        return ((double) statCalc.getCount()) / ((double) ARANGE) * 100.0;
    }

    public static int maxRoll(StatCalc[] statCalc) {
        int max = 0;
        for (int i = 0; i < arraySize; i++) {
            if (max < statCalc[i].getCount()) {
                max = statCalc[i].getCount();
            }
        }
        return max;
    }
}
