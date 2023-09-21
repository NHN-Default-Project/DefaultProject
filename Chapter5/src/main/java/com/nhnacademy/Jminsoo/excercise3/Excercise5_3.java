package com.nhnacademy.Jminsoo.excercise3;


import com.nhnacademy.Jminsoo.excercise2.StatCalc;

public class Excercise5_3 {
    /**
     * PairOfDice는 기능과 역할은 DiceApp에 통합시켰습니다.
     */
    public static final int DICE_COUNT = 2;
    public static final int EYES = 6;

    public static final int COUNT = 10_000;

    public static void main(String[] args) {
        DiceApp diceApp = new DiceApp(DICE_COUNT, EYES);
        StatCalc statCalc;

        System.out.println("주사위의 총합 \t 평균 굴림 횟수\t 표준 편차 \t\t 최대 롤 수");
        System.out.println("----------\t----------\t\t----------\t\t----------\t");

        for (int i = DICE_COUNT; i <= DICE_COUNT * EYES; i++) {
            statCalc = diceApp.getDiceStatCalc(COUNT, i);

            System.out.printf("\t" +
                            "%d\t\t\t" +
                            "%.2f\t\t\t" +
                            "%.2f\t\t\t" +
                            "%.2f\n",
                    i,
                    statCalc.getMean(),
                    statCalc.getStandardDeviation(),
                    statCalc.getMax());
        }

    }
}
