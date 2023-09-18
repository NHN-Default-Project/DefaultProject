package com.nhnacademy.parkminsu.Exercise4_8;

import java.util.Scanner;

public class QuizShow {
    private Quiz quiz;
    private QuizUser user;

    public QuizShow() {
        this.quiz = new Quiz();
        this.user = new QuizUser();
    }

    public void start() {
        System.out.println("문제를 생성합니다.");
        quiz.createQuestion();
        write();
        System.out.printf("점수는 %d입니다.", questionMark());

    }

    public void write() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= quiz.getQuestionNum(); i++) {
            System.out.printf("%d + %d= ", quiz.getProblemList().get(i).get(0).getFirstNum(), quiz.getProblemList().get(i).get(0).getSecondNum());
            user.writeAnswer(i, scanner.nextInt());
        }
        scanner.close();
    }

    public int questionMark() {
        int answerCheck = 0;
        for (int i = 1; i <= quiz.getQuestionNum(); i++) {
            if (user.getAnswerList().get(i).intValue() == quiz.getAnswerList().get(i).intValue()) {
                System.out.printf("%d번 문제 정답입니다.\n", i);
                answerCheck++;
            } else {
                System.out.printf("틀렸습니다. \n%d문제의 사용자 답: %d\n 정답 : %d\n", i,
                        user.getAnswerList().get(i).intValue(), quiz.getAnswerList().get(i).intValue());
            }
        }


        return answerCheck;
    }

}
