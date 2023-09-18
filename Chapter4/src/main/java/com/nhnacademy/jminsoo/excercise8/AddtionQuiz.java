package com.nhnacademy.jminsoo.excercise8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddtionQuiz implements SkeletonQuiz {
    private Quiz[] quizzes;
    private double correct;

    public AddtionQuiz(int count) {
        quizzes = new Quiz[count];
    }

    @Override
    public void quizGenerate() {
        for (int i = 0 ; i < quizzes.length; i++) {
            int firstNum = (int)(Math.random()*100);
            int secondNum = (int) (Math.random()*100);
            quizzes[i] = new Quiz(firstNum, secondNum, 0);
        }
    }

    @Override
    public void quizControl() {
        int answer = 0;
        Scanner scanner = new Scanner(System.in);
        for (Quiz quiz : quizzes) {
            System.out.printf("%d + %d = ? 답 : ", quiz.getFirstNum(), quiz.getSecondNum());
            try {
                answer = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.close();

                throw new IllegalArgumentException();

            }
            quiz.setAnswer(answer);
            System.out.println();
        }
        scanner.close();

    }

    @Override
    public void quizGrading() {
        for (Quiz quiz : quizzes) {
            int sum = quiz.getFirstNum() + quiz.getSecondNum();
            System.out.printf("정답 : %d + %d = %d, 입력값 : %d, 정답 유무 : %b\n", quiz.getFirstNum(), quiz.getSecondNum(), sum, quiz.getAnswerNum(),sum ==
                    quiz.getAnswerNum() );
            if (sum == quiz.getAnswerNum()) {
                correct++;
            }
        }

        System.out.printf("최종 점수 : %.2f %%", (correct / quizzes.length) * 100.0);
    }
}
