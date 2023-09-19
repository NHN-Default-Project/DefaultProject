package com.nhnacademy.gaeun.exercise04;

import java.util.Random;

@SuppressWarnings("java:S106")
public class Main {
    static final int ROLL_NUM = 10000;

    public static void main(String[] args) {
        System.out.println("Total On Dice    Average Number of Rolls");
        System.out.println("--------------   ------------------------");
        for (int i = 2; i < 13; i++) {
            System.out.printf("      ");
            System.out.printf("%d      ", i);
            System.out.printf("      ");
            System.out.printf("%f      \n", diceAverage(i));
        }
    }

    public static double diceAverage(int goalValue) {
        double sum = 0;
        for (int i = 0; i < ROLL_NUM; i++) {
            sum += diceRoll(goalValue);
        }
        return sum / ROLL_NUM;
    }

    public static int diceRoll(int goalValue) {
        int rollingNumber = 0;
        if (goalValue < 2 || goalValue > 12) {
            throw new IllegalArgumentException("가능한 합계가 아닙니다.");
        }
        while (dice() + dice() != goalValue) {
            rollingNumber++;
        }
        return rollingNumber;
    }

    public static int dice() {
        return new Random().nextInt(6) + 1;
    }
}

