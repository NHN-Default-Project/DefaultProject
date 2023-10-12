package com.nhnacademy.jminsoo.exercise4;

public class DiceApp {
    private final int diceCount;
    private final int eyes;

    private final Dice[] dice;

    public DiceApp(int diceCount, int eyes) {
        this.diceCount = diceCount;
        this.eyes = eyes;
        this.dice = new Dice[this.diceCount];
        for (int i = 0; i < this.diceCount; i++) {
            this.dice[i] = new Dice(this.eyes);
        }
    }

    public int countCorrect(int number) {

        if (!(number >= this.diceCount && number <= this.diceCount * this.eyes)) {
            throw new IllegalArgumentException("입력 값이 잘못되었습니다.");
        }

        int eyesSum;
        int count = 0;
        boolean isCorrect = false;

        while (!isCorrect) {
            eyesSum = 0;
            count++;
            for (Dice die : dice) {
                die.diceRoll();
                eyesSum += die.getDiceNum();
            }

            if (eyesSum == number) {
                isCorrect = true;
            }
        }
        return count;
    }

    public double calculateDiceAverage(int times, int number) {
        int sumCount = 0;
        for (int i = 0; i < times; i++) {
            sumCount += countCorrect(number);
        }
        return ((double) sumCount) / times;
    }
}
