package com.nhnacademy.parkminsu.exercise8_2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise8_2 {
    // 3.2.2 문제 확장판
    // BigInterger를
    // 홀수 일 경우 3n+1, 짝수 일 경우 n/2
    public static final BigInteger THREE = BigInteger.valueOf(3L);

    public static void main(String[] args) {
        List<BigInteger> bigIntegersList;
        Scanner scanner = new Scanner(System.in);
        String str = "";
        while (true) {
            try {
                System.out.println("숫자를 입력해주세여(빈칸 입력시 프로그램 종료)");
                str = scanner.nextLine();
                if (str.isEmpty()) {
                    System.out.println("프로그램을 종료합니다");
                    break;
                }
                BigInteger bigInteger = new BigInteger(str);
                precondition(bigInteger);
                bigIntegersList = operationSequence(bigInteger);
                printCalculatedSequence(bigIntegersList);
                printNumberOfMeasurementsPerformed(bigIntegersList);
            } catch (NumberFormatException e) {
                System.out.println("type이 맞지 않습니다. 다시 입력 해주세요");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
        }
        scanner.close();
    }

    public static BigInteger calculationSequence(BigInteger bigInteger) {
        if (bigInteger.testBit(0)) {
            bigInteger = bigInteger.multiply(THREE).add(BigInteger.ONE);
        } else {
            bigInteger = bigInteger.divide(BigInteger.TWO);
        }
        return bigInteger;
    }

    public static List<BigInteger> operationSequence(BigInteger bigInteger) {
        List<BigInteger> bigIntegerList = new ArrayList<>();
        bigIntegerList.add(bigInteger);
        while (!bigInteger.equals(BigInteger.ONE)) {
            bigInteger = calculationSequence(bigInteger);
            bigIntegerList.add(bigInteger);
        }
        return bigIntegerList;
    }

    public static void precondition(BigInteger bigInteger) {
        if (bigInteger.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("0을 입력했습니다. 다시 입력해주세요");
        } else if (bigInteger.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("음수를 입력했습니다. 다시 입력해주세");
        }
    }
    
    public static void printNumberOfMeasurementsPerformed(List<BigInteger> bigIntegerList) { // 출력 메소드는 삭제 해도 됩니다!
        System.out.println("연산 횟수: " + bigIntegerList.size());
    }

    public static void printCalculatedSequence(List<BigInteger> bigIntegerList) {
        System.out.println(bigIntegerList.toString());
    }
}
