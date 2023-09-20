package com.nhnacademy.parkminsu.Exercise5_7;

import com.nhnacademy.parkminsu.Exercise5_6.AdditionQuestion;

import java.util.Scanner;

public class Exercise5_7 {
    private static final int RANGE = 10;

    public static void main(String[] args) {
        IntQuestion[] substract = new IntQuestion[RANGE];
        int[] answer = new int[RANGE];
        substract = createArrayIntQuestion(substract);
        answer = writeAnswer(substract, answer);
        checkAnswerList(substract, answer);

    }


    public static IntQuestion[] createArrayIntQuestion(IntQuestion[] intQuestions) {
        for (int i = 0; i < RANGE; i++) {
            if (i % 2 == 0) {
                intQuestions[i] = new SubstractQuestion();
            } else {
                intQuestions[i] = new AdditionQuestion();
            }
        }
        return intQuestions;
    }

    public static int[] writeAnswer(IntQuestion[] intQuestions, int[] answer) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < RANGE; i++) {
            if (i % 2 == 0) {
                System.out.println(intQuestions[i].getQuestion());
            } else {
                System.out.println(intQuestions[i].getQuestion());
            }

            answer[i] = scanner.nextInt();
        }
        scanner.close();
        return answer;
    }

    public static void checkAnswerList(IntQuestion[] intQuestions, int[] answer) {
        for (int i = 0; i < RANGE; i++) {
            if (checkAnswer(intQuestions[i].getCorrectAnswer(), answer[i])) {
                System.out.println(i + 1 + "번은 정답입니다.");
            } else {
                System.out.println(i + 1 + "번은 틀렸습니다. 정답은 : " + intQuestions[i].getCorrectAnswer());
            }
        }
    }

    public static boolean checkAnswer(int question, int answer) {
        return question == answer;
    }

}
