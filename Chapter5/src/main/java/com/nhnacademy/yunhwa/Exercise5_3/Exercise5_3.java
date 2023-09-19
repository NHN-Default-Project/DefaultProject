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
    
        // Scanner sc = new Scanner(System.in);
        // System.out.print("\n두 개의 주사위의 눈의 합으로 만들고 싶은 숫자를 입력해주세요 : ");
        // int targetNum = sc.nextInt();
        // if (targetNum < 2 || targetNum > 12) {
        //     throw new IllegalArgumentException("두 개의 주사위의 합으로 만들 수 없는 값 " + targetNum + " 이 들어왔습니다. 2 ~ 12 까지의 숫자로 다시 입력해주세요.");
        // }
        
        List<StatCalc> rollCountsList = new ArrayList<>();

        doExperimentAboutAllValidNum(rollCountsList);
        printAllData(rollCountsList);
    }

    public static int rollCountToGetTargetNum(int targetNum) {
        PairOfDice pairOfDice = new PairOfDice();
        int rollCount = 1;

        while(! (pairOfDice.sumEyes() == targetNum)) {
            pairOfDice.roll();
            rollCount++;
        }
        return rollCount;
    }


    public static StatCalc rollExperiment(int targetNum, StatCalc rollCounts) {

        for (int i = 0; i < doCount; i++) {
            rollCounts.enter(rollCountToGetTargetNum(targetNum));
        }

        // double mean = rollCounts.getMean();
        // double standardDeviation = rollCounts.getStandardDeviation();
        // double max = rollCounts.getMax();

        // System.out.println("--------------------------------------");
        // System.out.println("\n주어진 총합" + targetNum  + "이 나올 때까지 한 쌍의 주사위를 몇 번 굴렸는지 " + doCount + "번 수행해본 결과\n");
        // System.out.println("--------------------------------------");
        // System.out.format("돌린 평균 횟수는 %.2f 이고, \n", mean);
        // System.out.format("돌린 횟수들의 표준 편차는 %.3f 이며, \n",standardDeviation);
        // System.out.format("돌린 최대 횟수는 %.2f 입니다.\n\n", max);
        // System.out.println("--------------------------------------");

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
