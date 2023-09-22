package com.nhnacademy.main;

import java.util.InputMismatchException;
import java.util.Scanner;

class DiceGamePlay {
    public DiceGamePlay() {
    }

    public static final int DICE_SUM_MIN = 2;
    public static final int DICE_SUM_MAX = 12;

    public void playDiceGame() {
        Dice dice = new Dice();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("주사위의 합계를 입력해주세요 : ");
            int number = scanner.nextInt();
            verifySumRange(number);
            countDiceGame(number, dice);
        } catch (InputMismatchException e) {
            System.out.printf("%d 이상 %d 이하의 숫자만 입력해 주세요%n", DICE_SUM_MIN, DICE_SUM_MAX);
        }

    }

    private void countDiceGame(int inNum, Dice dice) {
        int count = 0;
        int sum;

        while (true) {
            sum = 0;
            sum += dice.getDiceNum();
            count++;
            dice.rollDice();
            sum += dice.getDiceNum();

            if (isCorrect(inNum, sum)) {
                break;
            }
        }
        System.out.printf("입력한 값 %d가 나올때까지 걸린 횟수 : %d회", inNum, count);
    }


    private void verifySumRange(int sum) {
        if (DICE_SUM_MIN > sum || sum > DICE_SUM_MAX) {
            throw new IllegalArgumentException("숫자가 잘못 되었습니다.");
        }
    }

    private boolean isCorrect(int inNum, int diceNumberSum) {
        return inNum == diceNumberSum;
    }


}


