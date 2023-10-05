package com.nhnacademy.main.exercise1;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * https://math.hws.edu/javanotes/c8/exercises.html
 * Returns the larger of the two roots of the quadratic equation
 * A*x*x + B*x + C = 0, provided it has any roots.  If A == 0 or
 * if the discriminant, B*B - 4*A*C, is negative, then an exception
 * of type IllegalArgumentException is thrown.
 */
public class Exercise8_1 {
    // yes 또는 no라는 대답이 들어왔을 때 예외처리하기
    private static String userAnswer = "";
    private static QuadraticEquation quadraticEquation;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (!userAnswer.equals("no")) {
            try {
                System.out.println("계수를 입력하세요(이차항 계수 순서부터)");
                quadraticEquation = new QuadraticEquation(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
                System.out.println(quadraticEquation.root());
                userAnswer = inputUserAnswer(scanner);
            } catch (InputMismatchException e) {
                System.out.println("정수 또는 실수 아닌 값을 입력했습니다. 다시 입력해주세요");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("프로그램 종료");
        scanner.close();
    }


    public static String inputUserAnswer(Scanner scanner) {
        while (true) {
            try {
                System.out.println("다른 방정식을 입력하시겠습니까?(yes or no)");
                userAnswer = scanner.next().toLowerCase().trim();
                checkUserCorrectAnswer(userAnswer);
                return userAnswer;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void checkUserCorrectAnswer(String userAnswer) {
        if (!userAnswer.equals("yes") && !userAnswer.equals("no")) {
            throw new IllegalArgumentException("답변을 잘못했습니다.");
        }
    }


}
