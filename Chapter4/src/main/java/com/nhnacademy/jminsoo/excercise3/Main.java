package com.nhnacademy.jminsoo.excercise3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final int DICE_COUNT = 2;
    public static final int EYES = 6;

    public static void main(String[] args) {
        Dice[] dice = new Dice[DICE_COUNT];

        for (int i = 0; i < DICE_COUNT; i++) {
            dice[i] = new Dice(EYES);
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("주사위의 합계를 입력해주세요 : ");
            int number = scanner.nextInt();
            System.out.printf("모두 %d 이(가) 나올 때까지 주사위를 굴린 횟수 : %d\n", number, correctCount(number, dice));
        } catch (InputMismatchException e) {
            System.out.println("숫자 입력값이 아닙니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int correctCount(int number, Dice[] dice) {
        if (!(number >= DICE_COUNT && number <= DICE_COUNT * EYES)) {
            throw new IllegalArgumentException("입력 값이 잘못되었습니다.");
        }

        int eyesSum;
        int count = 0;
        boolean isCorrect = false;

        while (!isCorrect) {
            eyesSum = 0;
            count++;
            System.out.println("현재 카운트 수 : " + count);

            for (int i = 0; i < dice.length; i++) {

                dice[i].rollDice();
                System.out.printf("%d 번째 주사위 넘버 : %d\n", i + 1, dice[i].getDiceNum());

                eyesSum += dice[i].getDiceNum();
            }

            isCorrect = eyesSum == number;

        }

        return count;

    }
}

