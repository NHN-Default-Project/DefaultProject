package com.nhnacademy.Jminsoo.excercise7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Quiz implements SkeletonQuiz {
    private IntQuestion[] quizzes;
    private double correct;

    private int[] answer;

    public Quiz(int count) {
        quizzes = new IntQuestion[count];
        answer = new int[count];
    }

    @Override
    public void quizGenerate() {
        for (int i = 0; i < quizzes.length - 1; i++) {
            if (i > quizzes.length / 2) {
                quizzes[i] = new SubtractionQuestion();
            } else {
                quizzes[i] = new AdditionQuestion();
            }
        }
        quizzes[quizzes.length - 1] = new IntQuestion() {
            @Override
            public String getQuestion() {
                return "만든 사람의 나이는 몇살???";
            }

            @Override
            public int getCorrectAnswer() {
                return 24;
            }
        };
    }

    @Override
    public void quizControl() {
        int answer;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < quizzes.length; i++) {
            System.out.println(quizzes[i].getQuestion());
            try {
                answer = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.close();
                throw new IllegalArgumentException();
            }
            this.answer[i] = answer;
            System.out.println();
        }
        scanner.close();
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

        System.out.printf("정답률 : %.2f %%", (correct / quizzes.length) * 100.0);
    }
}
