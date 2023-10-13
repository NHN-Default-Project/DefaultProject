package com.nhnacademy.Jminsoo.exercise1.internalFI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Exercise9_1 {
    public static void main(String[] args) {
        Calculator calc = Calculator.getInstance();
        String inputStr;
        BigInteger factorialResult;
        BigInteger fibonacciResult;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("0 이상의 값을 입력해주세요 : ");
            inputStr = br.readLine();

            factorialResult = calc.factorial(inputStr);
            fibonacciResult = calc.fibonacci(inputStr);

            System.out.printf("팩토리얼 계산 값 : %s%n", factorialResult);
            System.out.printf("피보나치 계산 값 : %s%n", fibonacciResult);

            factorialResult = calc.factorial("10");
            fibonacciResult = calc.fibonacci("10");

            System.out.printf("팩토리얼 계산 값 : %s%n", factorialResult);
            System.out.printf("피보나치 계산 값 : %s%n", fibonacciResult);

        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
