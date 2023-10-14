package com.nhnacademy.yunhwa.exercise9_1;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise9_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                BigInteger n;

                n = inputIndex(sc, "factorial");
                if (n.equals(new BigInteger("-1"))) {
                    break;
                }

                Factorial factorial = Factorial.getInstance();
                printResult(factorial, n);
                System.out.println("--------------------------------------------------");


                n = inputIndex(sc, "fibonacci");
                if (n.equals(new BigInteger("-1"))) {
                    break;
                }

                Fibonacci fibonacci = Fibonacci.getInstance();
                printResult(fibonacci, n);
                System.out.println("--------------------------------------------------");

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }

    public static BigInteger inputIndex(Scanner sc, String sequenceType) {
        BigInteger n;
        while (true) {
            try {
                System.out.print(sequenceType + " 수열의 몇 번째 항의 값이 궁금하신가요? 항의 번호 n 을 입력해주세요 ( 종료 원하면 엔터 입력 ) : ");
                String tmp = sc.nextLine();
                if (tmp.isBlank()) {
                    return new BigInteger("-1");
                }

                String N = tmp.trim();
                if (Integer.parseInt(N) < 0) {
                    throw new NegativeNumberException(sequenceType + " 의 항의 번호는 음수일 수 없습니다. 0 이상의 값으로 넣어주세요");
                }

                n = new BigInteger(N);
                break;
            } catch (NumberFormatException e) {
                System.out.println("bigInteger 로 변환될 수 없는 값이 입력되었습니다. 다시 입력해주세요");
            } catch (NegativeNumberException e) {
                System.out.println(e.getMessage());
            }
        }
        return n;
    }

    public static void printResult(Function function, BigInteger n) { // 함수 파라미터 미완 미사용
        System.out.printf("%s(%s) = %s%n", function.getClass().getSimpleName().toLowerCase(), n, function.apply(n));
    }
}