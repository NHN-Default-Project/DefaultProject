package com.nhnacademy.gaeun.exercise06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int QUIZNUM = 10;
        int score = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < QUIZNUM; i++) {
            AdditionQuestion additionQuestion = new AdditionQuestion();
            System.out.println(additionQuestion.getQuestion());
            if (additionQuestion.getCorrectAnswer() == scanner.nextInt()) {
                score += 10;
            }
        }
        System.out.println("Your score : " + score);
    }
}
