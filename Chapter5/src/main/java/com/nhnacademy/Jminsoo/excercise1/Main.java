package com.nhnacademy.Jminsoo.excercise1;

public class Main {

    public static final int DICE_COUNT = 2;
    public static final int EYES = 6;

    public static final int SNAKE_EYES = 2;

    public static void main(String[] args) {
        DiceApp diceApp = new DiceApp(DICE_COUNT, EYES);

        System.out.printf("모두 %d 이(가) 나올 때까지 주사위를 굴린 횟수 : %d\n", SNAKE_EYES, diceApp.countCorrectNumber(SNAKE_EYES));
    }
}

