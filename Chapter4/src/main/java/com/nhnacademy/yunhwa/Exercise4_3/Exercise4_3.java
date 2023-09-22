package com.nhnacademy.yunhwa.Exercise4_3;

import java.util.Scanner;

public class Exercise4_3 {
    // 주사위 2개를 굴려서 두 주사위 눈의 합이 주어진 숫자가 될 때까지 주사위 굴리기 시뮬레이션 함수 작성하기
    // parameter 로 2(1+1) ~ 12(6+6)가 들어오지 않으면 IlligalArgumentExecption 발생
    // return value는 총 돌린 횟수

    // 해당 function을 활용해 눈 1과 1을 얻기 위해 돌려야 하는 횟수를 계산하고 출력하는 함수를 만들기
    // 즉 주사위 2개를 던져서 두 눈의 합이 2가 되도록 하는 횟수를 출력하는 함수를 작성하기

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);) {
            boolean isError;

            int totalEyesNum;
            int dicesCount;
            int targetSum;

            do {
                isError = false;

                System.out.println("---------------------------------------------");
                System.out.print("\n주사위의 총 눈의 수를 입력해주세요 :      "); // 6
                totalEyesNum = sc.nextInt();
                if (totalEyesNum <= 0) {
                    isError = true;
                    System.out.println("0 이하의 면체 및 0 이하의 눈의 수는 존재할 수 없습니다. 다시 입력 시도해주세요.");
                }
                System.out.println("---------------------------------------------");
            } while (isError);

            do {
                isError = false;

                System.out.print("돌리려는 주사위의 개수를 입력해주세요 :   "); // 2
                dicesCount = sc.nextInt();
                if (dicesCount <= 0) {
                    isError = true;
                    System.out.println("주사위를 돌리지 않겠다는 의미로 해석이 됩니다. 다시 입력 시도해주세요.");
                }
                System.out.println("---------------------------------------------");
            } while (isError);

            do {
                isError = false;

                System.out.print("주사위의 합 목표값을 입력해주세요 :       ");
                targetSum = sc.nextInt();

                Range validRange = SumOfDiceEyesActions.validTargetSumRange(totalEyesNum, dicesCount);

                System.out.println("체크 결과 : ");
                if (SumOfDiceEyesActions.isValidTargetSum(targetSum, validRange)) {
                    System.out.print("가능한 최소 합 : " + validRange.getMinValue() + "   ~  ");
                    System.out.println("가능한 최대 합 : " + validRange.getMaxValue());

                    System.out.println("주사위 합 목표값 정상!\n ~ 이제 주사위를 돌려볼 차례 ~");
                } else {
                    isError = true;
                    System.out.println("주사위 합 목표값을 " + targetSum + " 으로, 잘못 입력하였습니다. 다른 목표값을 입력해주세요");
                }
                System.out.println("---------------------------------------------");

            } while (isError);



            RollDices rollDices = new RollDices(dicesCount, totalEyesNum);
            int rollCount = SumOfDiceEyesActions.rollCountToGetTargetSum(targetSum, rollDices);

            System.out.println("주사위의 합이 목표값 " + targetSum + " 가 될 때까지\n 돌린 횟수는 총 " + rollCount + " 회 입니다.");
            System.out.println("--------------------------------------------");
            int snakeEyesRollCount = SumOfDiceEyesActions.rollCountToMakeSnakeEyes(rollDices);

            System.out.println(dicesCount + " 개의 " + totalEyesNum + " 면체 " + "주사위를 굴려\n " + "뱀의 눈을 만들기 위해 주사위를 돌린 횟수는\n 총 " + snakeEyesRollCount + " 회 입니다.");
            System.out.println("---------------------------------------------\n");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

}
