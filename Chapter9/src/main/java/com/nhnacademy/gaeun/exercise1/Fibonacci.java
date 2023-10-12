package com.nhnacademy.gaeun.exercise1;

import java.math.BigInteger;

public class Fibonacci {
    private Fibonacci() {

    }
    public static BigInteger calculate(BigInteger bigInteger) {
        if(!preCon(bigInteger)) {
            throw new IllegalArgumentException("N은 0보다 큰 값으로 입력해주세요.");
        }
        return fibonacci(bigInteger);
    }
    private static BigInteger fibonacci(BigInteger bigInteger) {
        if (bigInteger.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else if (bigInteger.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        } else {
            return (fibonacci(bigInteger.subtract(BigInteger.ONE))).add(fibonacci(bigInteger.subtract(BigInteger.TWO)));
        }
    }
    private static boolean preCon(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.ZERO) < 0) {
            return false;
        }
        return true;
    }
}
