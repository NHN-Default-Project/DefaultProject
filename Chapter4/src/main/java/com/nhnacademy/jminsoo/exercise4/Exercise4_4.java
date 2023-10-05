package com.nhnacademy.jminsoo.exercise4;

public class Exercise4_4 {

    public static final int DICE_COUNT = 2;
    public static final int EYES = 6;

    public static void main(String[] args) {
        DiceApp diceApp = new DiceApp(DICE_COUNT, EYES);

        diceView(diceApp);
    }

    public static void diceView(DiceApp diceApp) {
        System.out.println("주사위의 총합 \t 평균 굴림 횟수");
        System.out.println("----------\t----------");

        for (int i = DICE_COUNT; i <= DICE_COUNT * EYES; i++) {
            System.out.printf("\t%d\t\t\t%.3f\n", i, diceApp.calculateDiceAverage(10000, i));
        }
    }


}

