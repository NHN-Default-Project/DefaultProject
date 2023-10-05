package com.nhnacademy.parkminsu.exercise8_2;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise8_2 {
    // 3.2.2 문제 확장판
    // BigInterger를
    // 홀수 일 경우 3n+1, 짝수 일 경우 n/2
    public static final BigInteger THREE = BigInteger.valueOf(3L);

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String str = "";
            while (true) {
                System.out.println("숫자를 입력해주세여(빈칸 입력시 프로그램 종료)");
                str = scanner.nextLine();
                if (str.isEmpty()) {
                    System.out.println("프로그램을 종료합니다");
                    break;
                }
                measureTheNumOfSequenceOperations(str);
            }
        }
    }

    public static void measureTheNumOfSequenceOperations(String str) {
        try {
            BigInteger bigInteger = new BigInteger(str);
            precondition(bigInteger);
            System.out.println("연산 횟수: " + operationSequence(bigInteger));
        } catch (NumberFormatException e) {
            System.out.println("type이 맞지 않습니다. 다시 입력 해주세요");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int operationSequence(BigInteger bigInteger) {
        int numCalculation = 0;
        while (!bigInteger.equals(BigInteger.ONE)) {
            if (bigInteger.testBit(0)) {
                bigInteger = bigInteger.multiply(THREE).add(BigInteger.ONE);
            } else {
                bigInteger = bigInteger.divide(BigInteger.TWO);
            }
            System.out.println(bigInteger.toString());
            numCalculation++;
        }
        return numCalculation;
    }

    public static void precondition(BigInteger bigInteger) {
        if (bigInteger.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("0을 입력했습니다.");
        } else if (bigInteger.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("음수를 입력했습니다.");
        }
    }
}
