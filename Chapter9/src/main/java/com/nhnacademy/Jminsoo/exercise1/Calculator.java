package com.nhnacademy.Jminsoo.exercise1;

import java.math.BigInteger;

public class Calculator {
    private static Calculator instance;
    Factorial factorial;
    Fibonacci fibonacci;

    private Calculator() {
        factorial = Factorial.getInstance();
        fibonacci = Fibonacci.getInstance();
    }

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    public BigInteger factorial(String inputStr) {
        factorial.precondition(inputStr);
        BigInteger value = new BigInteger(inputStr);
        return this.factorial.apply(value);
    }

    public BigInteger fibonacci(String inputStr) {
        this.fibonacci.precondition(inputStr);
        BigInteger value = new BigInteger(inputStr);
        return this.fibonacci.apply(value);

    }
}
