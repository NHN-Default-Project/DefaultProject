package com.nhnacademy.yunhwa.Exercise4_3;

import java.util.List;

public class SumOfDiceEyesActions {
    public static Range validTargetSumRange(int totalEyesNum, int dicesCount) {

        int minValidSum = dicesCount;
        int maxValidSum = dicesCount * totalEyesNum;

        return new Range(minValidSum, maxValidSum);
    }


    public static boolean isValidTargetSum(int targetSum, Range validRange) {
        
        int minValidSum = validRange.getMinValue();
        int maxValidSum = validRange.getMaxValue();

        return targetSum >= minValidSum && targetSum <= maxValidSum;
    }

    public static int rollCountToGetTargetSum(int targetSum, RollDices rollDices) {

        int rollCount = 0; // 총 돌린 횟수 (리턴 값)
        int sumEyes = 0; // 주사위 눈들의 합

        while (sumEyes != targetSum) { // 타겟 합과 같아질 때까지

            sumEyes = 0; // 다시 초기화

            rollDices.rollManyDice(); // 주사위를 다 돌리고
            rollCount++; // 돌린 횟수 추가해주고

            // 주사위의 현재 눈들을 다 더한다
            for (Dice dice : rollDices.getDices()) {
                sumEyes += dice
                        .getCurrentEye();
            }

        }
        return rollCount;
    }

    // 4번 문제 관련 메서드 : 돌린 횟수들의 평균 값을 구하기 (doTimes = 10_000으로 설정)
    public static double averageRollCountToGetTargetSum(int doTimes, int targetSum, RollDices rollDices) {
        
        double sumRollCount = 0;
        for (int i = 0; i < doTimes; i++) {
            int rollCount = rollCountToGetTargetSum(targetSum, rollDices);
            sumRollCount += rollCount;
        }

        return sumRollCount / doTimes;
    }

    // 한 마리의 뱀의 눈을 만드는 메서드 (- , -)
    public static int rollCountToMakeSnakeEyes(RollDices rollDices) {

        return rollCountToMakeSnakesEyes(rollDices);
    }

    // 여러 마리의 뱀의 눈을 만드는 메서드
    public static int rollCountToMakeSnakesEyes(RollDices rollDices) {
        
        if (rollDices.getDicesCount() % 2 != 0) {
            throw new IllegalArgumentException("주사위의 개수가 잘못 기입되었습니다. 뱀의 눈을 만들려면 주사위가 쌍으로 존재해야만 합니다. 주사위의 개수를 2의 배수로 다시 입력해주세요");
        }

        int targetSum = rollDices.getDicesCount();

        return rollCountToGetTargetSum(targetSum, rollDices);
    }
}
