package com.nhnacademy.parkminsu.Exercise5_6;

import java.util.Scanner;

public class Exercise5_6 {
    private static final int questionCount = 10;

    public static void main(String[] args) {
        AdditionQuestion[] additionQuestion = new AdditionQuestion[questionCount];
        int[] answer = new int[questionCount];
        solution(additionQuestion, answer);
        answerCheck(additionQuestion, answer);

    }

    public static void answerCheck(AdditionQuestion[] additionQuestion, int[] answer) {
        for (int i = 0; i < questionCount; i++) {
            if (additionQuestion[i].getCorrectAnswer() == answer[i]) {
                System.out.println(i + 1 + "번은 정답입니다.");
            } else {
                System.out.println(i + 1 + "번은 틀렸습니다. 정답은 : " + additionQuestion[i].getCorrectAnswer());
            }
        }

    }

    public static int[] solution(AdditionQuestion[] additionQuestion, int[] answer) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < questionCount; i++) {
            additionQuestion[i] = new AdditionQuestion();
            System.out.println(additionQuestion[i].getQuestion());
            answer[i] = scanner.nextInt();
        }
        scanner.close();
        return answer;
    }
}
