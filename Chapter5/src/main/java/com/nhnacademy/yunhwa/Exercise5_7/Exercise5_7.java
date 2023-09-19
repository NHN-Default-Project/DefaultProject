package com.nhnacademy.yunhwa.Exercise5_7;

import java.util.Scanner;

public class Exercise5_7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        IntQuizGame intQuizGame = new IntQuizGame(10);
        intQuizGame.askAllQuestions();
        intQuizGame.answerAllQuestions(sc);
        intQuizGame.printScore(intQuizGame.gradeQuiz());

        sc.close();
    }
    
}