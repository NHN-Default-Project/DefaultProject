package com.nhnacademy.main.exercise9_1;

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
        if (fibonacciValueMap.get(bigInteger) == null) {
            fibonacciValueMap.put(bigInteger, fibonacci(bigInteger.subtract(BigInteger.ONE), fibonacciValueMap).add(fibonacci(bigInteger.subtract(BigInteger.TWO), fibonacciValueMap)));
        }
        return fibonacciValueMap.get(bigInteger);
    } // 피보나치 forans

    static BigInteger factorial(BigInteger bigInteger) {
        if (bigInteger.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        return bigInteger.multiply(factorial(bigInteger.subtract(BigInteger.ONE)));
    }
}
