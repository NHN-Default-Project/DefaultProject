package com.nhnacademy.gaeun.exercise1;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private Fibonacci() {

    }

    public static BigInteger calculate(BigInteger bigInteger) throws NegativeNumberException {
        if (bigInteger.compareTo(BigInteger.ZERO) < 0) {
            throw new NegativeNumberException();
        }
        Map<BigInteger, BigInteger> saveFibonacciVal = new HashMap<>();
        return fibonacci(bigInteger, saveFibonacciVal);
    }

    private static BigInteger fibonacci(BigInteger bigInteger, Map<BigInteger, BigInteger> saveFibonacciVal) {
        if (bigInteger.equals(BigInteger.ZERO) || bigInteger.equals(BigInteger.ONE)) {
            saveFibonacciVal.put(bigInteger, bigInteger);
            return bigInteger;
        }
        if (saveFibonacciVal.containsKey(bigInteger)) {
            return saveFibonacciVal.get(bigInteger);
        }
        return fibonacci(bigInteger.subtract(BigInteger.ONE), saveFibonacciVal)
                .add(fibonacci(bigInteger.subtract(BigInteger.TWO), saveFibonacciVal));
    }
}
