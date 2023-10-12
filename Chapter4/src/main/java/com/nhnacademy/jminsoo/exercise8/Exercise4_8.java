package com.nhnacademy.jminsoo.exercise8;

public class Exercise4_8 {
    public static void main(String[] args) {
        AddtionQuiz addtionQuiz = new AddtionQuiz(10);

        addtionQuiz.quizGenerate();
        addtionQuiz.quizControl();
        addtionQuiz.quizGrading();
    }
}
