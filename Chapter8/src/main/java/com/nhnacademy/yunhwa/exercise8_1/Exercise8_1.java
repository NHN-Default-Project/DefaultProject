package com.nhnacademy.yunhwa.exercise8_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise8_1 {
    public static void main(String[] args) {

        boolean isContinued = true;

        while (isContinued) {
            System.out.print(" (Ax^2 + Bx + C = 0) 이차 방정식의 계수인, 실수 A, B, C를 순차적으로 입력해주세요 : ");
            double a;
            double b;
            double c;

            Scanner sc = new Scanner(System.in);
            // (참고) BufferedReader .flush()로도 처리 가능

            try {
                a = sc.nextDouble();
                b = sc.nextDouble();
                c = sc.nextDouble();
                System.out.printf("%.2f%n", root(a, b, c));

                while (true) { // no  아니면 yes 입력받을 때까지 돌기
                    System.out.print("다른 방정식을 추가로 입력하시겠습니까? (Yes/No) : ");
                    String userAnswer = sc.next().toLowerCase();
                    if (userAnswer.equals("no")) {
                        isContinued = false;
                        break;
                    } else if (userAnswer.equals("yes")) {
                        break;
                    } else {
                        System.out.println("다시 정확하게 Yes or No 중 1개로 입력 시도해주세요");
                    }
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("double 이 될 수 없는 값이 입력되었습니다. 다시 입력해주세요");
            }
        }

    }


    /**
     * Returns the larger of the two roots of the quadratic equation
     * A*x*x + B*x + C = 0, provided it has any roots.  If A == 0 or
     * if the discriminant, B*B - 4*A*C, is negative, then an exception
     * of type IllegalArgumentException is thrown.
     */
    static public double root(double a, double b, double c)
            throws IllegalArgumentException {
        if (a == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        } else {
            double disc = b * b - 4 * a * c;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return (-b + Math.sqrt(disc)) / (2 * a);
        }
    }
}
