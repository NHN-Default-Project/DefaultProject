package com.nhnacademy.jminsoo.exercise8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddtionQuiz implements SkeletonQuiz {
    private Quiz[] quizzes;
    private double correctCount;

    static final int QUIZ_RANGE = 100;

    public AddtionQuiz(int count) {
        quizzes = new Quiz[count];
    }

    @Override
    public void quizGenerate() {
        for (int i = 0; i < quizzes.length; i++) {
            int firstNum = (int) (Math.random() * QUIZ_RANGE);
            int secondNum = (int) (Math.random() * QUIZ_RANGE);
            quizzes[i] = new Quiz(firstNum, secondNum, 0);
        }
    }

    @Override
    public void quizControl() {
        int answer = 0;
        for (Quiz quiz : quizzes) {
            System.out.printf("%d + %d = ? 답 : ", quiz.getFirstNum(), quiz.getSecondNum());

            try (Scanner scanner = new Scanner(System.in)) {
                answer = scanner.nextInt();
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException();
            }
            quiz.setAnswer(answer);
            System.out.println();
        }

    }

    @Override
    public void quizGrading() {
        boolean isEqual;
        for (Quiz quiz : quizzes) {

            int sum = quiz.getFirstNum() + quiz.getSecondNum();
            isEqual = sum == quiz.getAnswerNum();
            System.out.printf("정답 : %d + %d = %d, 입력값 : %d, 정답 유무 : %b\n", quiz.getFirstNum(), quiz.getSecondNum(), sum, quiz.getAnswerNum(), isEqual);
            if (isEqual) {
                correctCount++;
            }
        }

        System.out.printf("최종 정답률 : %.2f %%", (correctCount / quizzes.length) * QUIZ_RANGE);
    }
}
