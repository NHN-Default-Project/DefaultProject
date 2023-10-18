package com.nhnacademy.Jminsoo.exercise1.functionalinterface;

import java.math.BigInteger;

@FunctionalInterface
public interface Formula2 {
    BigInteger apply(BigInteger bi);

    /**
     * 연습용 활용 메서드
     */
    static BigInteger fibonacci(BigInteger number) {
        if (number.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        } else if (number.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }

        return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(BigInteger.TWO)));
    }

}
