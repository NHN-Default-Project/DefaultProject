package com.nhnacademy.Jminsoo.exercise1.functionalinterface;

import java.math.BigInteger;

public class Exercise9_1 {
    public static void main(String[] args) {
        Calculator calc = Calculator.getInstance();

        BigInteger fibo1;
        BigInteger fibo2;

        long startTime1 = System.currentTimeMillis();
        fibo1 = calc.fibonacci("50");
        long endTime1 = System.currentTimeMillis();

        System.out.printf("피보나치 계산 값 : %s%n", fibo1);
        System.out.printf("메모라이즈 측정시간 : %d%n", (endTime1 - startTime1));

        long startTime2 = System.currentTimeMillis();
        fibo2 = calc.fibonacci2("50");
        long endTime2 = System.currentTimeMillis();


        System.out.printf("피보나치 계산 값 : %s%n", fibo2);
        System.out.printf("측정시간 : %d%n", (endTime2 - startTime2));


    }
}
