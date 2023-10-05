package com.nhnacademy.Jminsoo.exercise6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Quiz implements SkeletonQuiz {
    private AdditionQuestion[] quizzes;
    private double correct;

    private int[] answer;

    public Quiz(int count) {
        this.quizzes = new AdditionQuestion[count];
        this.answer = new int[count];
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
            try (Scanner scanner = new Scanner(System.in)) {
                answer = scanner.nextInt();
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException();
            }
            this.answer[i] = answer;
            System.out.println();
        }
    }

    @Override
    public void quizGrading() {
        for (int i = 0; i < quizzes.length; i++) {
            int sum = quizzes[i].getCorrectAnswer();
            System.out.printf("%s, 정답 : %d, 입력값 : %d, 정답 유무 : %b\n",
                    quizzes[i].getQuestion(),
                    sum,
                    answer[i],
                    sum == answer[i]);
            if (sum == answer[i]) {
                correct++;
            }
        }

        System.out.printf("최종 점수 : %.2f %%", (correct / quizzes.length) * 100.0);
    }
}
