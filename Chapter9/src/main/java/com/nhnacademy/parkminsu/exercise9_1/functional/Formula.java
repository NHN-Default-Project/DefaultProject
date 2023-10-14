package com.nhnacademy.parkminsu.exercise9_1.functional;

import java.math.BigInteger;
import java.util.Map;

@FunctionalInterface
public interface Formula {
    BigInteger apply(BigInteger bigInteger);


    static BigInteger fibonacci(BigInteger bigInteger, Map<BigInteger, BigInteger> fibonacciValueMap) {
        if (bigInteger.equals(BigInteger.ZERO)) {
            fibonacciValueMap.put(bigInteger, BigInteger.ZERO);
            return BigInteger.ZERO;
        } else if (bigInteger.equals(BigInteger.ONE)) {
            fibonacciValueMap.put(bigInteger, BigInteger.ONE);
            return BigInteger.ONE;
        }
        fibonacciValueMap.computeIfAbsent(bigInteger, i -> fibonacci(i.subtract(BigInteger.ONE), fibonacciValueMap).add(fibonacci(i.subtract(BigInteger.TWO), fibonacciValueMap)));

        return fibonacciValueMap.get(bigInteger);
    } // 피보나치 forans

    static BigInteger factorial(BigInteger bigInteger) {
        if (bigInteger.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        return bigInteger.multiply(factorial(bigInteger.subtract(BigInteger.ONE)));
    }
}
