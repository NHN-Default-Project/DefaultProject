package com.nhnacademy.yunhwa.exercise9_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FactorialFibonacciProgram {

    public static void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String sequenceType = inputSequenceType(br);
                BigInteger n;

                n = inputIndex(br, sequenceType);
                if (n.equals(new BigInteger("-1"))) {
                    break;
                }

                if (sequenceType.equals("factorial")) {
                    printResult(sequenceType, Math::factorial, n);
                } else if (sequenceType.equals("fibonacci")) {
                    printResult(sequenceType, Math::fibonacci, n);
                }
                System.out.print("----------------------------------------------");
                System.out.println("--------------------------------------------");
            }
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String inputSequenceType(BufferedReader br) {
        String sequenceType;
        while (true) {
            try {
                System.out.print(" 어떤 수열의 값이 궁금하신가요? ");
                System.out.print("수열의 종류를 입력해주세요 ( 종료 원하면 0 입력 ) : ");
                sequenceType = br.readLine().trim().toLowerCase();

                if (isValidSequenceType(sequenceType)) {
                    break;
                }
            } catch (IllegalArgumentException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return sequenceType;
    }

    public static boolean isValidSequenceType(String sequenceType) throws IllegalArgumentException {
        if (sequenceType.equals("0")) {
            System.exit(0);
        } else if (sequenceType.isBlank()) {
            throw new IllegalArgumentException("String 이 입력되지 않았습니다. 다시 입력해주세요");
        } else if (!sequenceType.equals("factorial") && !sequenceType.equals("fibonacci")) {
            throw new IllegalArgumentException("수열의 종류는 factorial , fibonacci 중 1개로 입력이 되어야 합니다. 다시 입력해주세요");
        }
        return true;
    }



    public static BigInteger inputIndex(BufferedReader br, String sequenceType) {
        BigInteger n;
        while (true) {
            try {
                System.out.print(sequenceType + " 수열의 몇 번째 항의 값이 궁금하신가요? ");
                System.out.print("항의 번호 n 을 입력해주세요 ( 종료 원하면 엔터 입력 ) : ");
                String N = br.readLine().trim();

                if (isValidIndex(N)) {
                    n = new BigInteger(N);
                    break;
                }
            } catch (NegativeNumberException | NumberFormatException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return n;
    }

    public static boolean isValidIndex(String N) throws NegativeNumberException, NumberFormatException {
        if (N.isBlank()) {
            System.exit(0);
        } else if (Integer.parseInt(N) < 0) {
            throw new NegativeNumberException("항의 번호는 음수일 수 없습니다. 0 이상의 값으로 넣어주세요");
        }
        try {
            new BigInteger(N);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("bigInteger 로 변환될 수 없는 값이 입력되었습니다. 다시 입력해주세요");
        }
        return true;
    }

    public static void printResult(String sequenceType, Math math, BigInteger n) {
        System.out.printf("%s(%s) = %s%n", sequenceType, n, math.calculate(n));
    }
}