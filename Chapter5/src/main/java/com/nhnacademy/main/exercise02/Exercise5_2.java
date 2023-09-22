package com.nhnacademy.main.exercise02;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
* https://math.hws.edu/javanotes/c5/exercises.html
* 실수값으로 입력받은 배열을 처리하는 StatCalc클래스를 작성합니다.
* 사용자가 0을 입력하면 배열 입력을 마칩니다.
* 입력값의 개수, 합계, 제곱수의 합, 최솟값, 최댓값, 표준편차를 출력합니다.
*/


public class Exercise5_2 {

    public static void main(String[] args) {
        StatCalc statCalc = new StatCalc();
        Scanner scanner = new Scanner(System.in);

        System.out.println("실수값을 입력해주세요. 입력값의 개수, 합계, 제곱수의 합, 최솟값, 최댓값, 표준편차를 출력합니다.");
        System.out.println("입력을 종료하고 싶다면 0을 입력해주세요!");
        double inputValue = 1;
        while (true) {
            try {
                inputValue = scanner.nextDouble();
                if (inputValue == 0) {
                    break;
                }
                statCalc.enter(inputValue);
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("실수값을 입력해주세요!");
            }
        }
        System.out.println(statCalc);
    }
}
