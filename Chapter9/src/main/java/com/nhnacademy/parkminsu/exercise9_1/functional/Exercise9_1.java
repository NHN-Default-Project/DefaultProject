package com.nhnacademy.parkminsu.exercise9_1.functional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Exercise9_1 {
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

        } catch (IOException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
