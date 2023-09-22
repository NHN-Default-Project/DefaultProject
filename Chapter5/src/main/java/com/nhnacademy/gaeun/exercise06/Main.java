package com.nhnacademy.gaeun.exercise06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static final int QUIZ_NUM = 10;

    public static void main(String[] args) {

        int score = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < QUIZ_NUM; i++) {
            AdditionQuestion additionQuestion = new AdditionQuestion();

            while (true) {
                try {
                    System.out.println(additionQuestion.getQuestion());
                    if (additionQuestion.getCorrectAnswer() == scanner.nextInt()) {
                        score += 10;
                        break;
                    }
                } catch (InputMismatchException ime) {
                    System.out.println("정수값을 입력해주세요!");
                    scanner.nextLine();
                }
            }

        }
        System.out.println("Your score : " + score);
        scanner.close();
    }
}
