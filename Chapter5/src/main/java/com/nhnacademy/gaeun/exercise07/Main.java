package com.nhnacademy.gaeun.exercise07;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final int ADD_QUIZ_NUM = 5;
    private static final int MINUS_QUIZ_NUM = 5;
    private static final int MULTIPLY_QUIZ_NUM = 5;
    private static final double SCORE_UNIT = 100 / (ADD_QUIZ_NUM + MINUS_QUIZ_NUM + MULTIPLY_QUIZ_NUM + 1);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntQuestion[] intQuestions = new IntQuestion[ADD_QUIZ_NUM + MINUS_QUIZ_NUM + MULTIPLY_QUIZ_NUM + 1];
        double score = 0;

        for (int i = 0; i < ADD_QUIZ_NUM; i++) {
            intQuestions[i] = new AddQuestion();
        }
        for (int i = ADD_QUIZ_NUM; i < ADD_QUIZ_NUM + MINUS_QUIZ_NUM; i++) {
            intQuestions[i] = new MinusQuestion();
        }
        for (int i = ADD_QUIZ_NUM + MINUS_QUIZ_NUM; i < ADD_QUIZ_NUM + MINUS_QUIZ_NUM + MULTIPLY_QUIZ_NUM; i++) {
            intQuestions[i] = new MultiplyQuestion();
        }
        intQuestions[ADD_QUIZ_NUM + MINUS_QUIZ_NUM + MULTIPLY_QUIZ_NUM] = new IntQuestion() {
            @Override
            public String getQuestion() {
                return "60 / 3";
            }

            @Override
            public int getCorrectAnswer() {
                return 20;
            }
        };


        //문제 풀이 및 확인
        for (int i = 0; i < intQuestions.length; i++) {
            while (true) {
                try {
                    System.out.println(intQuestions[i].getQuestion());
                    if (scanner.nextInt() == intQuestions[i].getCorrectAnswer()) {
                        score += SCORE_UNIT;
                        break;
                    } else break;
                } catch (InputMismatchException ime) {
                    System.out.println("정수값을 입력해주세요!");
                    scanner.nextLine();
                }
            }
        }
        System.out.println("Your score : " + score);

    }
}
