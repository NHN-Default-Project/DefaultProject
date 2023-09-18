package com.nhnacademy.jaehyeon;

import java.util.Scanner;

public class Problem8 {

    public static void main(String[] args) {
        System.out.println("=====Start Quiz=====");
        quiz();
    }

    public static void quiz() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < 10; i++) {
            int firstNumber = randomNumber();
            int secondNumber = randomNumber();
            System.out.printf("%d + %d =", firstNumber, secondNumber);
            int userAnswer = scanner.nextInt();
            System.out.println();
            if (verifyAnswer(firstNumber, secondNumber, userAnswer)) {
                count++;
            }
        }

        System.out.printf("총 점수는 %d점 입니다.", count);
    }

    public static boolean verifyAnswer(int firstNum, int secondNum, int userAnswer) {

        if (firstNum + secondNum != userAnswer) {
            System.out.printf("땡! 정답은 %d 입니다\n", firstNum + secondNum);
            return false;
        }

        return true;
    }

    public static int randomNumber() {
        return (int) (Math.random() * 100) + 1;
    }
}


