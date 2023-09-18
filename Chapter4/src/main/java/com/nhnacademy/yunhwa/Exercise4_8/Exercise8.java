package com.nhnacademy.yunhwa.Exercise4_8;

import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // create quiz
        BasicAdditionQuiz basicAdditionQuiz = new BasicAdditionQuiz(10, 100);

        // administer quiz
        basicAdditionQuiz.askAllQuestions();
        basicAdditionQuiz.answerAllQuestions(sc);
    
        // grade the quiz
        basicAdditionQuiz.printScore(basicAdditionQuiz.gradeQuiz());

    }
    

}
