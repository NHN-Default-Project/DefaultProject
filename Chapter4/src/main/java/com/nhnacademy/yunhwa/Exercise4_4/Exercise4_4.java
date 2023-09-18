package com.nhnacademy.yunhwa.Exercise4_4;

import com.nhnacademy.yunhwa.Exercise4_3.Range;
import com.nhnacademy.yunhwa.Exercise4_3.SumOfDiceEyesActions;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise4_4 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);) {
            System.out.println("---------------------------------------------");
            System.out.print("\n주사위의 총 눈의 수를 입력해주세요 :      "); // 6
            int totalEyesNum = sc.nextInt();
            System.out.println("---------------------------------------------");

            System.out.print("돌리려는 주사위의 개수를 입력해주세요 :   "); // 2
            int dicesCount = sc.nextInt();
            System.out.println("---------------------------------------------");

            System.out.print("각각의 합 목표값마다\n 반복해서 시도해볼 횟수를 입력해주세요 : "); // 10_000
            int doTimes = sc.nextInt();

            Range validRange = SumOfDiceEyesActions.validTargetSumRange(totalEyesNum, dicesCount);

            int minValue = validRange.getMinValue();
            int maxValue = validRange.getMaxValue();
            int targetSumsSize = maxValue - minValue + 1;

            List<Integer> targetSums = new ArrayList<>(targetSumsSize);
            List<Double> averageRollCounts = new ArrayList<>(targetSumsSize);
            
            for (int targetSum = minValue; targetSum <= maxValue; targetSum++) {
                targetSums.add(targetSum);

                double averageRollCount = SumOfDiceEyesActions.averageRollCountToGetTargetSum(doTimes, targetSum, dicesCount, totalEyesNum);
                averageRollCounts.add(averageRollCount);
            }

            System.out.println("   Total On Dice     Average Number of Rolls  ");
            System.out.println("   -------------     -----------------------  ");
            for (int i = 0; i < targetSumsSize; i++) {
                int targetSum = targetSums.get(i);

                StringBuilder middleSpace = new StringBuilder("               ");

                while (targetSum / 10 != 0) {
                    targetSum /= 10;
                    middleSpace.deleteCharAt(middleSpace.length() - 1);
                }

                System.out.print("        " + targetSums.get(i));
                System.out.print(middleSpace);
                System.out.println("        " + averageRollCounts.get(i));
            }

            System.out.println("---------------------------------------------");
        }
    }
}
