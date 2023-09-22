package com.nhnacademy.main.excercise6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Quiz implements SkeletonQuiz {
    private final AdditionQuestion[] quizzes;
    private double correct;
    private static final double PERCENTAGE = 100.0;
    private final int[] answers;

    public Quiz(int count) {
        this.quizzes = new AdditionQuestion[count];
        this.answers = new int[count];
    }

    @Override
    public void quizGenerate() {
        for (int i = 0; i < quizzes.length; i++) {
            quizzes[i] = new AdditionQuestion();
        }
    }

    @Override
    public void quizControl() {
        int answer = 0;

        for (int i = 0; i < quizzes.length; i++) {
            System.out.println(quizzes[i].getQuestion());
            Scanner scanner = new Scanner(System.in);
            try {
                answer = scanner.nextInt();
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException();
            }
            this.answers[i] = answer;
            System.out.println();
        }
    }

    @Override
    public void quizGrading() {
        for (int i = 0; i < quizzes.length; i++) {
            int sum = quizzes[i].getCorrectAnswer();
            System.out.printf("%s, 정답 : %d, 입력값 : %d, 정답 유무 : %b%n",
                    quizzes[i].getQuestion(),
                    sum,
                    answers[i],
                    sum == answers[i]);
            if (sum == answers[i]) {
                correct++;
            }
        }

        System.out.printf("정답률 : %.2f %%", (correct / quizzes.length) * PERCENTAGE);
    }
}
