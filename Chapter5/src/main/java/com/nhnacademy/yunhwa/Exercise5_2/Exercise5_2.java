package com.nhnacademy.yunhwa.Exercise5_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise5_2 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);) {
            StatCalc statCalc = new StatCalc();
            System.out.println();

            while (true) {
                System.out.print("데이터 세트에 double 값을 추가해주세요 (그만 넣고 싶으면 0 을 입력해주세요) : ");
                double inputNum = sc.nextDouble();

                if (inputNum == 0) {
                    System.out.println("\n-- 여기까지 추가하여 데이터 세트를 완성하였습니다! --\n");
                    break;
                }

                statCalc.enter(inputNum);
            }

            System.out.println(statCalc.toString());


        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
}
