package com.nhnacademy.jminsoo.excercise4;

public class Main {

    public static final int DICE_COUNT = 2;
    public static final int EYES = 6;

    public static void main(String[] args) {
        Dice[] dice = new Dice[DICE_COUNT];
        DiceApp diceApp = new DiceApp(DICE_COUNT, EYES, dice);

        for (int i = 0; i < DICE_COUNT; i++) {
            dice[i] = new Dice(EYES);
        }

        System.out.println("주사위의 총합 \t 평균 굴림 횟수");
        System.out.println("----------\t----------");

        for (int i = DICE_COUNT; i <= DICE_COUNT * EYES; i++) {
            System.out.printf("\t%d\t\t\t%.3f\n", i, diceApp.getDiceAverage(10000, i));
        }
    }


}

