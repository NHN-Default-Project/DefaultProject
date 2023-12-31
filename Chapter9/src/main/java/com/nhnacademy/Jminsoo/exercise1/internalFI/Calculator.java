package com.nhnacademy.Jminsoo.exercise1.internalFI;

import java.math.BigInteger;
import java.util.function.Function;

public class Calculator {
    private static Calculator instance;

    private Calculator() {
    }

    private void precondition(String inputStr) {
        try {
            if (Integer.parseInt(inputStr) < 0) {
                throw new IllegalArgumentException("0 미만의 값이 들어오면 안됩니다!");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값이 들어오면 안됩니다!");
        }
    }

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    public BigInteger factorial(String inputStr) {
        precondition(inputStr);

        Function<BigInteger, BigInteger> factorial = bigInteger -> {
            BigInteger result = BigInteger.ONE;
            for (BigInteger bi = bigInteger; bi.compareTo(BigInteger.ZERO) > 0; bi = bi.subtract(BigInteger.ONE)) {
                result = result.multiply(bi);
            }
            return result;
        };

        BigInteger value = new BigInteger(inputStr);
        return factorial.apply(value);
    }

    public BigInteger fibonacci(String inputStr) {
        precondition(inputStr);


        Function<BigInteger, BigInteger> fibonacciFomula = bigInteger -> {
            BigInteger result = BigInteger.ZERO;
            BigInteger num1 = BigInteger.ZERO;
            BigInteger num2 = BigInteger.ONE;
            for (BigInteger bi = BigInteger.ZERO; bi.compareTo(bigInteger) < 0; bi = bi.add(BigInteger.ONE)) {

                result = num1.add(num2);
                num2 = num1;
                num1 = result;
            }
            return result;
        };

        BigInteger value = new BigInteger(inputStr);
        return fibonacciFomula.apply(value);
    }

}
