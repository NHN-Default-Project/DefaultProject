package com.nhnacademy.gaeun.exercise02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StatCalc statCalc = new StatCalc();
        Scanner scanner = new Scanner(System.in);

        int inputValue = 1;
        while (true) {
            inputValue = scanner.nextInt();
            if (inputValue == 0) {
                break;
            }
            statCalc.enter(inputValue);
        }
        System.out.println(statCalc);
        scanner.close();
    }
}
