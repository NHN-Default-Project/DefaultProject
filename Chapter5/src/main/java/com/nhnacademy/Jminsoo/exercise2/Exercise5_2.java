package com.nhnacademy.Jminsoo.exercise2;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise5_2 {
    public static void main(String[] args) {
        StatCalc calc = new StatCalc();
        calcApp(calc);
    }

    public static void calcApp(StatCalc calc) {
        try (Scanner scanner = new Scanner(System.in)) {
            double inputNum = 0;
            while (true) {
                System.out.print("값을 입력해주세요 ! (0을 넣으면 종료됩니다.): ");
                inputNum = scanner.nextDouble();
                if (inputNum == 0) {
                    break;
                }
                calc.enter(inputNum);
            }

        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("잘못된 값이 들어갔습니다 ! 오류 메세지 : " + e.getMessage());
        }
        System.out.println(calc);

    }
}
