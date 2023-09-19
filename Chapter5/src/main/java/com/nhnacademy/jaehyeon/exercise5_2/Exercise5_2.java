package com.nhnacademy.jaehyeon.exercise5_2;

import java.util.Scanner;

public class Exercise5_2 {

    public static void main(String[] args) {
        StatCalc statCalc = new StatCalc();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("숫자를 입력하세요");
            System.out.println("0을 입력하면 입력을 멈춘다는것 입니다.");
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            statCalc.enter(num);
        }
        System.out.println(statCalc.toString());

        scanner.close();
    }
}

