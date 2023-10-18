package com.nhnacademy.parkminsu.exercise9_1.singletonpattern;

import java.math.BigInteger;

public class Fibonacci extends Num {
    private static Fibonacci instance;

    private Fibonacci(String str) {
        super(str);

    }

    public static Fibonacci getInstance(String str) {
        if (instance == null) {
            instance = new Fibonacci(str);
        }
        return instance;
    }

    public BigInteger fibonacci(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ZERO;
        } else if (bigInteger.compareTo(BigInteger.ONE) == 0) {
            return BigInteger.ONE;
        }
        return fibonacci(bigInteger.subtract(BigInteger.ONE)).add(fibonacci(bigInteger.subtract(BigInteger.TWO)));
    }

    @Override
    public BigInteger apply(BigInteger bigInteger) {
        return fibonacci(bigInteger);
    }
}
