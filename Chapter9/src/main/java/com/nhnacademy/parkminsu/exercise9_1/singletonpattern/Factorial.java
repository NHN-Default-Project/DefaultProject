package com.nhnacademy.parkminsu.exercise9_1.singletonpattern;

import java.math.BigInteger;

public class Factorial extends Num {
    private static Factorial instance;

    private Factorial(String str) {
        super(str);
    }

    public static Factorial getInstance(String str) {
        if (instance == null) {
            instance = new Factorial(str);
        }
        return instance;
    }

    public BigInteger factorial(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.ONE) == 0) {
            return BigInteger.ONE;
        }
        return bigInteger.multiply(factorial(bigInteger.subtract(BigInteger.ONE)));
    }

    @Override
    public BigInteger apply(BigInteger bigInteger) {
        return factorial(bigInteger);
    }
}
