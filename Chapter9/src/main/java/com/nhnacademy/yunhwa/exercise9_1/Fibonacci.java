package com.nhnacademy.yunhwa.exercise9_1;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci implements Function<BigInteger> {
    private static Fibonacci fibonacci;
    private static Map<BigInteger, BigInteger> fibonacciMap;

    private Fibonacci() {
        fibonacciMap = new HashMap<>();
    }

    public static Fibonacci getInstance() {
        if (fibonacci == null) {
            fibonacci = new Fibonacci();
        }
        return fibonacci;
    }

    @Override
    public BigInteger apply(BigInteger n) {
        if (n.signum() < 0) {
            throw new IllegalArgumentException("fibonacci 는 1 보다 큰 값들로만 연산 가능합니다. 1 보다 큰 값을 넣어주세요");
        }
        if (fibonacciMap.containsKey(n)) { // factorial 과 동일한 이유로 이 문장을 삽입함.
            System.out.println(n + "이 이미 존재해서 바로 리턴하겠습니다 !!"); /////////////////////////////////
            System.out.println(" fibo(" + n + ") = " + fibonacciMap.get(n) + "\n"); //////////////////
            return fibonacciMap.get(n);
        }

        if (n.equals(BigInteger.ZERO)) {
            System.out.println("0 을 입력해주겠습니다!");
            fibonacciMap.put(BigInteger.ZERO, BigInteger.ZERO);
            return BigInteger.ZERO;
        } else if (n.equals(BigInteger.ONE)) {
            System.out.println("1 을 입력해주겠습니다!");
            fibonacciMap.put(BigInteger.ONE, BigInteger.ONE);
            return BigInteger.ONE;
        }
        BigInteger value = apply(n.subtract(BigInteger.ONE)).add(apply(n.subtract(BigInteger.TWO)));
        fibonacciMap.put(n, value);
        System.out.println(n + "을 넣어주겠습니다! fibo(" + n + ") = " + value + "\n");
        return value;
    }
}
