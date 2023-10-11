package com.nhnacademy.Jminsoo.exercise1;

import java.math.BigInteger;

public class Fibonacci implements Formula {
    private static Fibonacci instance;

    private Fibonacci() {
    }

    public static Fibonacci getInstance() {
        if (instance == null) {
            instance = new Fibonacci();
        }
        return instance;
    }

    @Override
    public void precondition(String input) {
        try {
            if (Integer.parseInt(input) < 0) {
                throw new NumberFormatException("0 미만의 값이 들어오면 안됩니다!");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("정수가 아닌 값이 들어오면 안됩니다!");
        }
    }

    private BigInteger fibonacci(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        } else if (n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        return fibonacci(n.subtract(BigInteger.ONE)).add(fibonacci(n.subtract(BigInteger.TWO)));
    }

    @Override
    public BigInteger apply(BigInteger bi) {
        return this.fibonacci(bi);
    }
}
