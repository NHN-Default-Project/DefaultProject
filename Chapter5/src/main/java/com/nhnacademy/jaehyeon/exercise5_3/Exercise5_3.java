package com.nhnacademy.jaehyeon.exercise5_3;

public class Exercise5_3 {

    static final int ROLL_COUNT = 10_000;

    public static void main(String[] args) {


        System.out.println("주사위의 총합        평균 굴림 횟수     표준편차");
        System.out.println("----------        -----------    -------");

        int maxCount = 0;

        for (int i = 2; i <= 12; i++) {
            PairOfDice dices = new PairOfDice();
            StatCalc statCalc = new StatCalc();

            int count = 0;
            while (count != ROLL_COUNT) {
                dices.roll();
                statCalc.enter(dices.getDie1());
                statCalc.enter(dices.getDie2());
                if (dices.getDie1() + dices.getDie2() == i) {
                    count++;
                }
            }

            if (maxCount < statCalc.getCount()) {
                maxCount = statCalc.getCount();
            }
            System.out.println(
                    i + "\t\t\t\t\t" + (statCalc.getCount() / ROLL_COUNT) + "\t\t\t" + statCalc.getStandardDeviation());
        }
        System.out.printf("최대 롤수는 %d 입니다", maxCount);
    }


}


