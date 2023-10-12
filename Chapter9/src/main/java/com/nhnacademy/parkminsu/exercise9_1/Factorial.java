package com.nhnacademy.parkminsu.exercise9_1;

import java.math.BigInteger;

public class Factorial {
    private Factorial() {
    }

    public static BigInteger calculate(BigInteger bigInteger) {
        if (!preCon(bigInteger)) {
            throw new IllegalArgumentException("N은 0보다 큰 값으로 입력해주세요.");
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

    private static boolean preCon(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.ZERO) <= 0) {
            return false;
        }
        return true;
    }
}

