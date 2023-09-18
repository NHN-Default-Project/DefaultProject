package com.nhnacademy.gaeun.exercise08;

import java.util.Scanner;

public class Main {
    //사용자에게 덧셈 퀴즈 제공
    //무작위의 숫자를 넣고 사용자에게 제공
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quiz Start");
        QuizGame quizGame = new QuizGame();
        String[] questions = quizGame.administerQuiz();
        int[] inputAnswer = new int[10];
        int totalPoints = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print(questions[i]);
            inputAnswer[i] = scanner.nextInt();
        }
        totalPoints = quizGame.gradQuiz(inputAnswer);

        System.out.printf("Total points: %d", totalPoints);
    }


}
