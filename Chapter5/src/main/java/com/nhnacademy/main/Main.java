package com.nhnacademy.gaeun.exercise02;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        StatCalc statCalc = new StatCalc();
        Scanner scanner = new Scanner(System.in);

        double inputValue = 1;
        while (true) {
            try {
                inputValue = scanner.nextInt();
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
