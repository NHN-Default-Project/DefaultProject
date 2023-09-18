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
            System.out.println("---------------------------------------------");
            System.out.print("\n주사위의 총 눈의 수를 입력해주세요 :      "); // 6
            int totalEyesNum = sc.nextInt();
            System.out.println("---------------------------------------------");

            System.out.print("돌리려는 주사위의 개수를 입력해주세요 :   "); // 2
            int dicesCount = sc.nextInt();
            System.out.println("---------------------------------------------");

            System.out.print("주사위의 합 목표값을 입력해주세요 :       ");
            int targetSum = sc.nextInt();
            System.out.println("---------------------------------------------");

            Range validRange = SumOfDiceEyesActions.validTargetSumRange(totalEyesNum, dicesCount);
            SumOfDiceEyesActions.checkValidTargetSum(targetSum, validRange);

            int rollCount = SumOfDiceEyesActions.rollCountToGetTargetSum(targetSum, dicesCount, totalEyesNum);

            System.out.println("주사위의 합이 목표값 " + targetSum + " 가 될 때까지\n 돌린 횟수는 총 " + rollCount + " 회 입니다.");
            System.out.println("--------------------------------------------");
            int snakeEyesRollCount = SumOfDiceEyesActions.rollCountToMakeSnakeEyes(totalEyesNum);

            System.out.println(dicesCount + " 개의 " + totalEyesNum + " 면체 " + "주사위를 굴려\n " + "뱀의 눈을 만들기 위해 주사위를 돌린 횟수는\n 총 " + snakeEyesRollCount + " 회 입니다.");
            System.out.println("---------------------------------------------\n");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

}
