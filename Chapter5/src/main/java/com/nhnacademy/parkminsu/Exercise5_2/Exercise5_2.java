package com.nhnacademy.parkminsu.Exercise5_2;

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
        System.out.println(statCalc.getCount());
        System.out.println(statCalc.getSum());
        System.out.println(statCalc.getMean());
        System.out.println(statCalc.getStandardDeviation());
        System.out.println(statCalc.getMax());
        System.out.println(statCalc.getMin());

    }
}
