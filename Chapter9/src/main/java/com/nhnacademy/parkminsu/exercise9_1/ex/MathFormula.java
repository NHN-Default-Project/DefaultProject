package com.nhnacademy.parkminsu.exercise9_1.ex;

import java.math.BigInteger;

public class MathFormula implements Formula {
    BigInteger number;


    @Override
    public BigInteger factorial(BigInteger number) {
        if (number.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        return number.multiply(factorial(number.subtract(BigInteger.ONE)));
    }

    @Override
    public BigInteger fibonacci(BigInteger number) {
        BigInteger result = BigInteger.ZERO;
        if (number.equals(BigInteger.ONE)) {
            result = BigInteger.ONE;
        } else if (number.equals(BigInteger.TWO)) {
            result = BigInteger.TWO;
        } else if (number.compareTo(BigInteger.valueOf(3)) == 1 || number.compareTo(BigInteger.valueOf(3)) == 0) {
            result = fibonacci(number.subtract(BigInteger.TWO))
                    .add(fibonacci(number.subtract(BigInteger.ONE)));
        }
        return result;
    }
}
