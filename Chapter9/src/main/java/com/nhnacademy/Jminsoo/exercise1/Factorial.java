package com.nhnacademy.Jminsoo.exercise1;

import java.math.BigInteger;

public class Factorial implements Formula {
    private static Factorial instance;

    private Factorial() {
    }

    public static Factorial getInstance() {
        if (instance == null) {
            instance = new Factorial();
        }
        return instance;
    }

    @Override
    public void precondition(String input) {
        try {
            if (Integer.parseInt(input) < 0) {
                throw new IllegalArgumentException("0 미만의 값이 들어오면 안됩니다!");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값이 들어오면 안됩니다!");
        }
    }

    @Override
    public BigInteger apply(BigInteger bi) {
        return factorial(bi);
    }

    private BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }

}
