package com.nhnacademy.parkminsu.exercise8_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise8_1 {
    // yes 또는 no라는 대답이 들어왔을 때 예외처리하기
    // root라는 메소드를 이차 방정식 객체에 넣어도 되는지 고민
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String userAnswer = "";
            QuadraticEquation quadraticEquation = new QuadraticEquation();
            while (!userAnswer.equals("no")) { // loop문 다듬기
                System.out.println("계수를 입력하세요(이차항 계수 순서부터)");
                quadraticEquation.enterCoefficient(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                System.out.println(root(quadraticEquation.getQuadraticCoefficient(), quadraticEquation.getLinearTermCoefficient(), quadraticEquation.getConstant()));
                System.out.println("다른 방정식을 입력하시겠습니까?(yes or no)");
                userAnswer = scanner.next().toLowerCase();
                if (!userAnswer.equals("yes") || !userAnswer.equals("no")) {
                    throw new IllegalArgumentException("답변을 잘못했습니다.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("개수를 잘못 입력하셨습니다.");
        }

    }

    /**
     * A*x*x + B*x + C = 0 형태의 이차방정식의 해 중에서 큰 해를 반환합니다.
     * 해가 있는 경우에만 작동하며, A == 0 이거나 판별식인 B*B - 4*A*C 가 음수인 경우
     * IllegalArgumentException 예외가 발생합니다.
     */
    public static double root(double A, double B, double C)
            throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A는 0일 수 없습니다.");
        } else {
            double disc = B * B - 4 * A * C;
            if (disc < 0) {
                throw new IllegalArgumentException("판별식 < 0.");
            }
            return (-B + Math.sqrt(disc)) / (2 * A);
        }
    }

}
