package com.nhnacademy.Jminsoo.excercise7;

public class Main {
    public static void main(String[] args) {
        Quiz addtionQuiz = new Quiz(10);

        addtionQuiz.quizGenerate();
        addtionQuiz.quizControl();
        addtionQuiz.quizGrading();
    }
}
