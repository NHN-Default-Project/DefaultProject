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


        Formula fibonacci = Formula::fibonacci;

        BigInteger value = new BigInteger(inputStr);
        Map<BigInteger, BigInteger> memory = new HashMap<>();
        return fibonacci.apply(value, memory);

    }

    public BigInteger fibonacci2(String inputStr) {
        Formula2 fibonacci = Formula2::fibonacci;
        BigInteger value = new BigInteger(inputStr);
        return fibonacci.apply(value);

    }

}
