package com.nhnacademy.Jminsoo.exceercise1;


public class DiceApp {
    private final int diceCount;
    private final int eyes;
    private Dice[] dices;

    public DiceApp(int diceCount, int eyes) {
        this.diceCount = diceCount;
        this.eyes = eyes;
        DiceGenerater(diceCount, eyes);
    }

    public Dice[] getDices() {
        return this.dices;
    }

    private void DiceGenerater(int diceCount, int eyes) {
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
            System.out.println("현재 카운트 수 : " + count);

            for (int i = 0; i < dices.length; i++) {

                dices[i].diceRoll();
                System.out.printf("%d 번째 주사위 넘버 : %d\n", i + 1, dices[i].getDiceNum());

                eyesSum += dices[i].getDiceNum();
            }

            isCorrect = eyesSum == number;

        }

        return count;
    }

    public double calculateDiceAverage(int times, int number) {
        int countSum = 0;
        for (int i = 0; i < times; i++) {
            countSum += countCorrectNumber(number);
        }
        return ((double) countSum) / times;
    }
}
