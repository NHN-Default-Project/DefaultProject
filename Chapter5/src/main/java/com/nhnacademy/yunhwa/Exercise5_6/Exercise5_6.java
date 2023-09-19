package com.nhnacademy.yunhwa.Exercise5_6;

import java.util.Scanner;

public class Exercise5_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AdditionQuizGame additionQuizGame = new AdditionQuizGame(10);
        additionQuizGame.askAllQuestions();
        additionQuizGame.answerAllQuestions(sc);
        additionQuizGame.printScore(additionQuizGame.gradeQuiz());
        sc.close();
    }

    
}