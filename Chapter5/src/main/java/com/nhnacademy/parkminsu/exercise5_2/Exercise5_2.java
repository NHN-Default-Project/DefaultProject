package com.nhnacademy.parkminsu.exercise5_2;

import java.util.Scanner;

public class Exercise5_2 {
    public static void main(String[] args) {
        StatCalc statCalc = new StatCalc();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                statCalc.enter(scanner.nextInt());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(statCalc.toString());

    }
}
