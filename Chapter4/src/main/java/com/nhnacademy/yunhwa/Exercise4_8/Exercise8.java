package com.nhnacademy.yunhwa.Exercise4_8;

import java.util.Scanner;

public class Exercise8 {
    public static final int QUESTIONS_COUNT = 10;
    public static final int MAX_VALID_NUM = 100;

    public static void main(String[] args) {

        // create quiz
        BasicAdditionQuiz basicAdditionQuiz = new BasicAdditionQuiz(QUESTIONS_COUNT, MAX_VALID_NUM);

        // administer quiz
        basicAdditionQuiz.askAllQuestions();
        basicAdditionQuiz.answerAllQuestions();
    
        // grade the quiz
        basicAdditionQuiz.printScore(basicAdditionQuiz.gradeQuiz());

    }
    

}
