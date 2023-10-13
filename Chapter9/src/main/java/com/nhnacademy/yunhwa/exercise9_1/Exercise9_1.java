package com.nhnacademy.yunhwa.exercise9_1;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise9_1 {

    static Map<BigInteger, BigInteger> factorialMap;
    static Map<BigInteger, BigInteger> fibonacciMap;

    public static void main(String[] args) {
        factorialMap = new HashMap<>();
        fibonacciMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        BigInteger n;

        n = inputIndex(sc, "factorial");
        System.out.printf("factorial(%s) = %s%n", n, factorial(n).toString());

        n = inputIndex(sc, "fibonacci");
        System.out.printf("fibonacci(%s) = %s%n", n, fibonacci(n).toString());

        sc.close();
    }

    public static BigInteger inputIndex(Scanner sc, String sequenceType) {
        BigInteger n;
        while (true) {
            try {
                System.out.print(sequenceType + " 수열의 몇 번째 항의 값이 궁금하신가요? 항의 번호 n 을 입력해주세요 : ");
                String N = sc.nextLine().trim();
                n = new BigInteger(N);
                break;
            } catch (NumberFormatException e) {
                System.out.println("정수로 변환될 수 없는 값이 입력되었습니다. 다시 입력해주세요");
                sc.nextLine();
            }
        }
        return n;
    }

    public static void printResult(String sequenceType, BigInteger n) { // 함수 파라미터 미완 미사용
        System.out.printf("%s(%s) = %s", sequenceType, n, factorial(n).toString());
    }

    public static BigInteger factorial(BigInteger n) {
        if (n.signum() < 0) {
            throw new IllegalArgumentException("factorial 은 0 보다 큰 값들로만 연산 가능합니다. 0 보다 큰 값을 넣어주세요");
        }
        if (factorialMap.containsKey(n)) { // 이미 값이 저장된 것들 접근이 필요할 때만 사용.
            return factorialMap.get(n); // 값을 딱 한 번만 넣어서 연산할 거면 이거 필요 없는데, 사용자로부터 입력을 받든지 해서 연산을 할 거라면
            // factorial(n) 값은 어떤 값이 들어오든 항상 동일하기 때문에 이 문장이 유의미 해짐. - 따라서 한 값 넣는 예제에서는 무의미할 수 있음.
        }
        if (n.equals(BigInteger.ZERO)) {
            factorialMap.put(BigInteger.ZERO, BigInteger.ONE);
            return BigInteger.ONE;
        }
        BigInteger value = n.multiply(factorial(n.subtract(BigInteger.ONE)));
        factorialMap.put(n, value);
        return value;
    }

    public static BigInteger fibonacci(BigInteger n) {
        if (n.signum() < 0) {
            throw new IllegalArgumentException("fibonacci 는 1 보다 큰 값들로만 연산 가능합니다. 1 보다 큰 값을 넣어주세요");
        }
        if (fibonacciMap.containsKey(n)) { // 위의 factorial 과 동일한 이유로 이 문장을 삽입함.
            return fibonacciMap.get(n);
        }

        if (n.equals(BigInteger.ZERO)) {
            fibonacciMap.put(BigInteger.ZERO, BigInteger.ZERO);
            return BigInteger.ZERO;
        } else if (n.equals(BigInteger.ONE)) {
            fibonacciMap.put(BigInteger.ONE, BigInteger.ONE);
            return BigInteger.ONE;
        }
        BigInteger value = fibonacci(n.subtract(BigInteger.ONE)).add(fibonacci(n.subtract(BigInteger.TWO)));
        fibonacciMap.put(n, value);
        return value;
    }
}