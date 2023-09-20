package com.nhnacademy.gaeun.exercise07;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final int ADD_QUIZ_NUM = 5;
    private static final int MINUS_QUIZ_NUM = 5;
    private static final int MULTIPLY_QUIZ_NUM = 5;
    private  static final double SCORE_UNIT = 100 / (ADD_QUIZ_NUM + MINUS_QUIZ_NUM + MULTIPLY_QUIZ_NUM);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntQuestion[] intQuestions = new IntQuestion[ADD_QUIZ_NUM + MINUS_QUIZ_NUM + MULTIPLY_QUIZ_NUM];
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
        //문제 풀이 및 확인
        try {
            for (IntQuestion intQ : intQuestions) {
                System.out.println(intQ.getQuestion());
                if (scanner.nextInt() == intQ.getCorrectAnswer()) score += SCORE_UNIT;
            }
            System.out.println("Your score : " + score);
        } catch (InputMismatchException ime) {
            System.out.println(ime.getMessage());
        }

    }
}
