package com.nhnacademy.Jminsoo.excercise6;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz(10);

        quiz.quizGenerate();
        quiz.quizControl();
        quiz.quizGrading();
    }
}
