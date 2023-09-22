package com.nhnacademy.main.exercise07;

/*
* https://math.hws.edu/javanotes/c5/exercises.html
* 여러 종류의 질문이 포함된 퀴즈를 관리하도록 프로그램을 작성합니다.
* 5.6문제에 더하여 덧셈, 뺄셈 문제를 생성하는 클래스를 작성합니다.
* 이 때, interface로 생성한 intQuestion유형을 사용합니다.
* 익명 클래스로 생성하여 수학 이외의 질문도 추가할 수 있습니다.
 */

public class Exercise5_7 {
    static final int QUIZ_NUM = 10;

    public static void main(String[] args) {
        Quiz addtionQuiz = new Quiz(QUIZ_NUM);

        addtionQuiz.quizGenerate();
        addtionQuiz.quizControl();
        addtionQuiz.quizGrading();
    }
}