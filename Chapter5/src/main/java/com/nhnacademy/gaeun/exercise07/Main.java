package com.nhnacademy.gaeun.exercise07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int QUIZNUM = 12;
        Scanner scanner = new Scanner(System.in);
        IntQuestion[] intQuestions = new IntQuestion[QUIZNUM];
        int score = 0;

        for (int i = 0; i < QUIZNUM - 2; i++) {
            intQuestions[i] = new AdditionQuestion();
        }
        intQuestions[QUIZNUM - 2] = new IntQuestion() {
            @Override
            public String getQuestion() {
                return "What is " + 5 + " - " + 3 + " ?";
            }

            @Override
            public int getCorrectAnswer() {
                return 2;
            }
        };
        intQuestions[QUIZNUM - 1] = new IntQuestion() {
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
    }
}
