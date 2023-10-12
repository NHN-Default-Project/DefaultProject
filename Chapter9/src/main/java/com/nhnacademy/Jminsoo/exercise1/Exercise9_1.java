package com.nhnacademy.Jminsoo.exercise1;

import java.math.BigInteger;

public class Exercise9_1 {
    public static void main(String[] args) {
        factorialTest();
        fibonacciTest();
    }


    public static void factorialTest() {
        int num = 5;
        BigInteger bigInteger = BigInteger.valueOf(num);
        System.out.println(factorial(bigInteger));
    }

    public static void fibonacciTest() {
        int num = 5;
        BigInteger bigInteger = BigInteger.valueOf(num);
        System.out.println(fibonacci(bigInteger));
    }

    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }

    public static BigInteger fibonacci(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else if (n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        return fibonacci(n.subtract(BigInteger.ONE)).add(n.subtract(BigInteger.TWO));
    }
}
