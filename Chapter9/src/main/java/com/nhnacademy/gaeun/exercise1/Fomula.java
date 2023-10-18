package com.nhnacademy.gaeun.exercise1;

import java.math.BigInteger;
import java.util.function.Function;

public class Fomula {
    public static BigInteger factorial(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("N은 0보다 큰 값으로 입력해주세요.");
        }
        return factorial.apply(bigInteger);
    }

    private static Function<BigInteger, BigInteger> factorial = bigInteger -> {
        if (bigInteger.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        BigInteger sum = BigInteger.ONE;
        while (!bigInteger.equals(BigInteger.ZERO)) {
            sum = sum.multiply(bigInteger);
            bigInteger = bigInteger.subtract(BigInteger.ONE);
        }
        return sum;
    };
    private static Function<BigInteger, BigInteger> fibonacci = bigInteger -> {
        if (bigInteger.equals(BigInteger.ZERO) || bigInteger.equals(BigInteger.ONE)) {
            return bigInteger;
        }
        return Fomula.fibonacci.apply(bigInteger.subtract(BigInteger.ONE)).add(Fomula.fibonacci.apply(bigInteger.subtract(BigInteger.TWO)));
    };

    public static BigInteger fibonacci(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해주세요!");
        }
        return fibonacci.apply(bigInteger);
    }

}
