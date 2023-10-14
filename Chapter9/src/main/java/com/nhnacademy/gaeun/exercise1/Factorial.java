package com.nhnacademy.gaeun.exercise1;

import java.math.BigInteger;

public class Factorial {
    private Factorial() {
    }

    public static BigInteger calculate(BigInteger bigInteger) throws NegativeNumberException {
        if (bigInteger.compareTo(BigInteger.ZERO) <= 0) {
            throw new NegativeNumberException();
        }
        return factorialCal(bigInteger);
    }

    private static BigInteger factorialCal(BigInteger bigInteger) {
        if (bigInteger.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        } else {
            return bigInteger.multiply(factorialCal(bigInteger.subtract(BigInteger.ONE)));
        }
    }
}
