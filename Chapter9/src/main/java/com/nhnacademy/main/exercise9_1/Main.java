package com.nhnacademy.main.exercise9_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Main {
    /**
     * 팩토리얼과 피보나치를 재귀 함수로 구현하는 프로그램
     */
    public static void main(String[] args) {
        // 효율적인 재귀(memorization)
        Map<BigInteger, BigInteger> memorizationMap = new HashMap<>();
        Formula factorial = Formula::factorial;
        Formula fibonacci = bigInteger -> Formula.fibonacci(bigInteger, memorizationMap);
        Precondition<BigInteger> precondition = data -> {
            if (data.signum() < 0) {
                throw new IllegalArgumentException("음수를 입력했습니다");
            }
        };

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("계산할 값을 넣으시오");
            String str = br.readLine();
            BigInteger bigInteger = new BigInteger(str);
            precondition.precondition(bigInteger);
            System.out.println("Factorial: " + factorial.apply(bigInteger));

            System.out.println("Fibonacci: " + fibonacci.apply(bigInteger));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
