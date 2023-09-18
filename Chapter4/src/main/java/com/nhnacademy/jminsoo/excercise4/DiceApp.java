package com.nhnacademy.jminsoo.excercise4;

public class DiceApp {
    private final int diceCount;
    private final int eyes;

    private final Dice[] dice;

    public DiceApp(int diceCount, int eyes, Dice[] dice) {
        this.diceCount = diceCount;
        this.eyes = eyes;
        this.dice = dice;
    }

    public int correctCount(int number) {

        if (!(number >= this.diceCount && number <= this.diceCount * this.eyes)) {
            throw new IllegalArgumentException("입력 값이 잘못되었습니다.");
        }

        int eyesSum;
        int count = 0;
        boolean isCorrect = false;

        while(!isCorrect) {
            eyesSum = 0;
            count++;
            for (Dice die : dice) {
                die.diceRoll();
                eyesSum += die.getDiceNum();
            }

            if (eyesSum == number){
                isCorrect = true;
            }
        }
        return count;
    }

    public double getDiceAverage(int times, int number) {
        int countSum = 0;
        for (int i = 0; i < times; i++) {
            countSum += correctCount(number);
        }
        return ((double)countSum) / times;
    }
}
