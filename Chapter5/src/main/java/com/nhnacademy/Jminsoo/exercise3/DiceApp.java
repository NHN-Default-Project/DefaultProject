package com.nhnacademy.Jminsoo.exercise3;

public class DiceApp {
    private final int diceCount;
    private final int eyes;
    private Dice[] dices;

    public DiceApp(int diceCount, int eyes) {
        this.diceCount = diceCount;
        this.eyes = eyes;
        diceGenerater(diceCount, eyes);
    }

    private void diceGenerater(int diceCount, int eyes) {
        Dice[] dices = new Dice[diceCount];
        for (int i = 0; i < diceCount; i++) {
            dices[i] = new Dice(eyes);
        }
        this.dices = dices;
    }

    public int countCorrectNumber(int number) {

        if (!(number >= diceCount && number <= diceCount * eyes)) {
            throw new IllegalArgumentException("입력 값이 잘못되었습니다.");
        }

        int eyesSum;
        int count = 0;
        boolean isCorrect = false;

        while (!isCorrect) {
            eyesSum = 0;
            count++;

            for (int i = 0; i < dices.length; i++) {
                dices[i].diceRoll();
                eyesSum += dices[i].getDiceNum();
            }

            isCorrect = eyesSum == number;

        }
        return count;
    }

    public StatCalc getDiceStatCalc(int times, int number) {
        StatCalc statCalc = new StatCalc();
        for (int i = 0; i < times; i++) {
            statCalc.enter(countCorrectNumber(number));
        }
        return statCalc;
    }

}
