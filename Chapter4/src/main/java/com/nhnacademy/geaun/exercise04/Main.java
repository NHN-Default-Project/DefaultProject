package com.nhnacademy.gaeun.exercise04;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Total On Dice    Average Number of Rolls");
        System.out.println("--------------   ------------------------");
        for(int i = 2; i < 13; i++) {
            System.out.printf("      ");
            System.out.printf("%d      ", i);
            System.out.printf("      ");
            System.out.printf("%f      \n",diceAverage(i));
        }
    }
    public static double diceAverage(int goalValue) {
        double sum = 0;
        for(int i = 0; i < 10000; i++) {
            sum += diceRoll(goalValue);
        }
        return sum / 10000;
    }

    public static int diceRoll(int goalValue) {
        int rollingNumber = 0;
        if(goalValue < 2 || goalValue > 12) {
            throw new IllegalArgumentException("가능한 합계가 아닙니다.");
        }
        while(dice() + dice() != goalValue) {
            rollingNumber++;
        }
        return rollingNumber;
    }

    public static int dice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}

