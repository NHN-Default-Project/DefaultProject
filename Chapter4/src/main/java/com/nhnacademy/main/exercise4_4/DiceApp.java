package com.nhnacademy.main.exercise4_4;


public class DiceApp {
    private final int diceCount;
    private final int eyes;

    private final Dice[] dices;

    public DiceApp(int diceCount, int eyes) {
        this.diceCount = diceCount;
        this.eyes = eyes;
        this.dices = new Dice[this.diceCount];
        for (int i = 0; i < this.diceCount; i++) {
            this.dices[i] = new Dice(this.eyes);
        }
    }

    public int countEyesSum(int number) {

        if (!(number >= this.diceCount && number <= this.diceCount * this.eyes)) {
            throw new IllegalArgumentException("입력 값이 잘못되었습니다." + this.eyes + " 눈 짜리 주사위로는 만들 수 없는 눈 합계 값입니다.");
        }

        int eyesSum = 0;
        int count = 0;

        while (eyesSum == number) {
            count++;
            for (Dice dice : dices) {
                dice.rollDice();
                eyesSum += dice.getDiceNum();
            }
        }
        return count;
    }

    public double calculateDiceAverage(int times, int number) {
        int sumCount = 0;
        for (int i = 0; i < times; i++) {
            sumCount += countEyesSum(number);
        }
        return ((double) sumCount) / times;
    }
}