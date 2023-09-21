package com.nhnacademy.yunhwa.Exercise5_3;

//import Chapter4.src.main.java.com.nhnacademy.yunhwa.Exercise4_3.Range;
import com.nhnacademy.yunhwa.Exercise5_1.PairOfDice;
import com.nhnacademy.yunhwa.Exercise5_2.StatCalc;
import java.util.ArrayList;
import java.util.List;

public class Exercise5_3 {
    // 주어진 총 합이 나올 때까지 한 쌍의 주사위를 몇 번 굴렸는지 계산하는 실험 
    // 10_000번 반복 후 평균 돌린 횟수, 표준 편차, 최대 돌린 횟수를 보고하는 프로그램
    // 가능한 각 합계 즉, 2(1 + 1) ~ 12(6 + 6) 까지 수행

    static final int doCount = 10_000;
    

    public static void main(String[] args) {
        List<StatCalc> rollCountsList = new ArrayList<>();

        doExperimentAboutAllValidNum(rollCountsList);
        printAllData(rollCountsList);
    }

    public static int rollCountToGetTargetNum(int targetNum) {
        PairOfDice pairOfDice = new PairOfDice();
        int rollCount = 1;

        while (! (pairOfDice.sumEyes() == targetNum)) {
            pairOfDice.roll();
            rollCount++;
        }
        return rollCount;
    }


    public static StatCalc rollExperiment(int targetNum, StatCalc rollCounts) {

        for (int i = 0; i < doCount; i++) {
            rollCounts.enter(rollCountToGetTargetNum(targetNum));
        }

        return rollCounts;
    }

    public static void doExperimentAboutAllValidNum(List<StatCalc> rollCountsList) {
        Range range = new Range(2, 12);
        int min = range.getMinValue();
        int max = range.getMaxValue();

        for (int targetNum = min; targetNum <= max; targetNum++) {
            StatCalc rollCounts = rollExperiment(targetNum, new StatCalc());
            rollCountsList.add(rollCounts);
        }

    }

    public static void printAllData(List<StatCalc> rollCountsList) {
        Range range = new Range(2, 12);

        System.out.println("\n   -------------     -----------------------   ---------------------------   -------------------");
        System.out.println("   Total On Dice     Average Number of Rolls   StandardDeviation of Rolls     Max Number of Rolls");
        System.out.println("   -------------     -----------------------   ---------------------------   -------------------");
        for (int i = 0; i < rollCountsList.size(); i++) {
            StatCalc rollCounts = rollCountsList.get(i);
            int targetSum = i + range.getMinValue();

            System.out.format("     %5d            ", targetSum);
            System.out.format("     %9f             ", rollCounts.getMean());
            System.out.format("     %9f             ", rollCounts.getStandardDeviation());
            System.out.format("     %9f          ", rollCounts.getMax());
            System.out.println();
        }

        System.out.println("   -------------     -----------------------   ---------------------------   -------------------\n");
    }

}
