package com.nhnacademy.Jminsoo.exercise1.functionalinterface;

import java.math.BigInteger;

@FunctionalInterface
public interface Formula2 {
    BigInteger apply(BigInteger bi);

    /**
     * 연습용 활용 메서드
     */
    static BigInteger fibonacci(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        } else if (n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }

        return fibonacci(n.subtract(BigInteger.ONE)).add(fibonacci(n.subtract(BigInteger.TWO)));
    }

    static BigInteger fibonacci2(BigInteger n, BigInteger A) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        } else if (n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }

        return fibonacci(n.subtract(BigInteger.ONE)).add(fibonacci(n.subtract(BigInteger.TWO)));
    }

}
