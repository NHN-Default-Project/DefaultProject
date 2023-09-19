package com.nhnacademy.Jminsoo.excercise2;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StatCalc calc = new StatCalc();
        calcApp(calc);
    }

    public static void calcApp(StatCalc calc) {
        try (Scanner scanner = new Scanner(System.in)) {
            int inputNum = 0;
            while (true) {
                System.out.print("값을 입력해주세요 ! (0을 넣으면 종료됩니다.): ");
                inputNum = scanner.nextInt();
                if (inputNum == 0) {
                    break;
                }
                calc.enter(inputNum);
            }

        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("잘못된 값이 들어갔습니다 ! 오류 메세지 : " + e.getMessage());
        }
        System.out.printf("넣은 개수 : %d\n", calc.getCount());
        System.out.printf("평균 : %.2f\n", calc.getMean());
        System.out.printf("합계 : %.2f\n", calc.getSum());
        System.out.printf("표준편차 : %.2f\n", calc.getStandardDeviation());
        System.out.printf("최대값 : %.2f\n", calc.getMax());
        System.out.printf("최소값 : %.2f\n", calc.getMin());

    }
}
