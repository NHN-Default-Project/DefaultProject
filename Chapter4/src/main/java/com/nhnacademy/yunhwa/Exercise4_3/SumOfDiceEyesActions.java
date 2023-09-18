package com.nhnacademy.yunhwa.Exercise4_3;

import java.util.List;

public class SumOfDiceEyesActions {
    public static Range validTargetSumRange(int totalEyesNum, int dicesCount) {

        int minValidSum = 0;
        for (int i = 0; i < dicesCount; i++) {
            minValidSum += 1;
        }

        int maxValidSum = 0;
        for (int i = 0; i < dicesCount; i++) {
            maxValidSum += totalEyesNum;
        }

        Range range = new Range(minValidSum, maxValidSum);
        return range;
    }


    public static void checkValidTargetSum(int targetSum, Range validRange) {
        
        int minValidSum = validRange.getMinValue();
        int maxValidSum = validRange.getMaxValue();

        System.out.print("가능한 최소 합 : " + minValidSum + "   ~  ");
        System.out.println("가능한 최대 합 : " + maxValidSum);

        System.out.println("체크 결과 : ");
        if (!(targetSum >= minValidSum && targetSum <= maxValidSum)) {
            throw new IllegalArgumentException("주사위 합 목표값을 " + targetSum + " 으로, 잘못 입력하였습니다. 다른 목표값을 입력해주세요");
        }

        System.out.println("주사위 합 목표값 정상!\n ~ 이제 주사위를 돌려볼 차례 ~");
        System.out.println("---------------------------------------------");
    }

    public static int rollCountToGetTargetSum(int targetSum, int dicesCount, int totalEyesNum) {

        int rollCount = 0; // 총 돌린 횟수 (리턴 값)
        int sumEyes = 0; // 주사위 눈들의 합

        while (sumEyes != targetSum) { // 타겟 합과 같아질 때까지
            RollDices rollDices = new RollDices(dicesCount);
            sumEyes = 0; // 다시 초기화

            rollDices.rollManyDice(dicesCount, totalEyesNum); // 주사위를 다 돌리고
            rollCount++; // 돌린 횟수 추가해주고

            // 주사위의 현재 눈들을 다 더한다
            List<Dice> dices = rollDices.getDices();

            for (int i = 0; i < dices.size(); i++) {
                sumEyes += dices.get(i).getCurrentEye();
            }
        }

        return rollCount;
    }

    // 4번 문제 관련 메서드 : 돌린 횟수들의 평균 값을 구하기 (doTimes = 10_000으로 설정)
    public static double averageRollCountToGetTargetSum(int doTimes, int targetSum, int dicesCount, int totalEyesNum) {
        
        double sumRollCount = 0;
        for (int i = 0; i < doTimes; i++) {
            int rollCount = rollCountToGetTargetSum(targetSum, dicesCount, totalEyesNum);
            sumRollCount += rollCount;
        }

        double averageRollCount = sumRollCount / doTimes;
        return averageRollCount;
    }

    // 한 마리의 뱀의 눈을 만드는 메서드 (- , -)
    public static int rollCountToMakeSnakeEyes(int totalEyesNum) {
        
        int rollCount = rollCountToMakeSnakesEyes(2, totalEyesNum);
        return rollCount;
    }

    // 여러 마리의 뱀의 눈을 만드는 메서드
    public static int rollCountToMakeSnakesEyes(int dicesCount, int totalEyesNum) {
        
        if (dicesCount % 2 != 0) {
            throw new IllegalArgumentException("주사위의 개수가 잘못 기입되었습니다. 뱀의 눈을 만들려면 주사위가 쌍으로 존재해야만 합니다. 주사위의 개수를 2의 배수로 다시 입력해주세요");
        }

        int targetSum = 1 * dicesCount;

        return rollCountToGetTargetSum(targetSum, dicesCount, totalEyesNum);
    }
}
