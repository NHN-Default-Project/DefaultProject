package com.nhnacademy.gaeun.exercise07;

import java.util.Scanner;

public class Main {
    private static final int QUIZ_NUM = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntQuestion[] intQuestions = new IntQuestion[QUIZ_NUM];
        int score = 0;

        for (int i = 0; i < QUIZ_NUM - 2; i++) {
            intQuestions[i] = new AdditionQuestion();
        }
        intQuestions[QUIZ_NUM - 2] = new IntQuestion() {
            @Override
            public String getQuestion() {
                return "What is " + 5 + " - " + 3 + " ?";
            }

            @Override
            public int getCorrectAnswer() {
                return 2;
            }
        };
        intQuestions[QUIZ_NUM - 1] = new IntQuestion() {
            @Override
            public String getQuestion() {
                return "What is " + 5 + " * " + 3 + " ?";
            }

            @Override
            public int getCorrectAnswer() {
                return 15;
            }
        };
        //문제 풀이 및 확인
        for (IntQuestion intQ : intQuestions) {
            System.out.println(intQ.getQuestion());
            if (scanner.nextInt() == intQ.getCorrectAnswer()) score += 10;
        }
        System.out.println("Your score : " + score);
        scanner.close();
    }
}
