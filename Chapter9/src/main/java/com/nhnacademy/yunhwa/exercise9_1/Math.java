package com.nhnacademy.yunhwa.exercise9_1;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@FunctionalInterface
public interface Math {
    BigInteger calculate(BigInteger bigInteger);

    Map<BigInteger, BigInteger> factorialMap = new HashMap<>();
    Map<BigInteger, BigInteger> fibonacciMap = new HashMap<>();

    static BigInteger factorial(BigInteger n) {
        if (n.signum() < 0) {
            throw new IllegalArgumentException("factorial 은 0보다 큰 값들로만 연산 가능합니다. 0보다 큰 값을 넣어주세요");
        }
        if (factorialMap.containsKey(n)) {
            System.out.println("factorial(" + n + ") 이 이미 존재해서 바로 리턴하겠습니다 !!"); //////////
            return factorialMap.get(n);
        }
        if (n.equals(BigInteger.ZERO)) {
            factorialMap.put(BigInteger.ZERO, BigInteger.ONE);
            return BigInteger.ONE;
        }
        BigInteger value = n.multiply(factorial(n.subtract(BigInteger.ONE)));
        factorialMap.put(n, value);
        return value;
    }

    static BigInteger fibonacci(BigInteger n) {
        if (n.signum() < 0) {
            throw new IllegalArgumentException("fibonacci 는 1보다 큰 값들로만 연산 가능합니다. 1보다 큰 값을 넣어주세요");
        }

        if (fibonacciMap.containsKey(n)) {
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