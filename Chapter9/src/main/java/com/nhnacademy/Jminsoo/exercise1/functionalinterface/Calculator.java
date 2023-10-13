package com.nhnacademy.Jminsoo.exercise1.functionalinterface;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static Calculator instance;

    private Calculator() {
    }

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }


    public BigInteger fibonacci(String inputStr) {
        /** 람다표현식으로 구현*/
        try {
            if (Integer.parseInt(inputStr) < 0) {
                throw new IllegalArgumentException("0 미만의 값이 들어오면 안됩니다!");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값이 들어오면 안됩니다!");
        }

        Formula fibonacci = (n, memory1) -> Formula.fibonacci(n, memory1);
        Formula fibonacci2 = new Formula() {
            @Override
            public BigInteger apply(BigInteger bi, Map<BigInteger, BigInteger> memory) {
                return null;
            }
        };

        BigInteger value = new BigInteger(inputStr);
        Map<BigInteger, BigInteger> memory = new HashMap<>();
        return fibonacci.apply(value, memory);

    }

    public BigInteger fibonacci2(String inputStr) {
        try {
            if (Integer.parseInt(inputStr) < 0) {
                throw new IllegalArgumentException("0 미만의 값이 들어오면 안됩니다!");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값이 들어오면 안됩니다!");
        }

        Formula2 fibonacci = Formula2::fibonacci;
        BigInteger value = new BigInteger(inputStr);
        return fibonacci.apply(value);

    }

}
