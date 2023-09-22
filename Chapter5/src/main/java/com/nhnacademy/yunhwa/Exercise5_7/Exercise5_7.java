package com.nhnacademy.yunhwa.Exercise5_7;

import java.util.Scanner;

public class Exercise5_7 {

    public static void main(String[] args) {

        IntQuizGame intQuizGame = new IntQuizGame(10);
        intQuizGame.askAllQuestions();
        intQuizGame.answerAllQuestions();
        intQuizGame.printScore(intQuizGame.gradeQuiz());

    }
    
}