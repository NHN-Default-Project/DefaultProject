package com.nhnacademy.parkminsu.exercise9_1.internalFI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.function.Consumer;
import java.util.function.Function;

public class Exercise9_1 {
    // 자바에서 제공하는 Functional Interface를 사용하여 피보나치 수열 및 팩토리얼 구현
    public static void main(String[] args) {
        Function<BigInteger, BigInteger> factorial = bigInteger -> {
            BigInteger bigInteger1 = BigInteger.ONE;
            for (BigInteger i = bigInteger; i.compareTo(BigInteger.ZERO) > 0; i = i.subtract(BigInteger.ONE)) {
                bigInteger1 = bigInteger1.multiply(i);
            }
            return bigInteger1;
        };

        Function<BigInteger, BigInteger> fibonacci = bigInteger -> {
            BigInteger bigInteger1 = BigInteger.ZERO;
            BigInteger bigInteger2 = BigInteger.ONE;
            BigInteger result = BigInteger.ZERO;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(bigInteger) < 0; i = i.add(BigInteger.ONE)) {
                result = bigInteger1.add(bigInteger2);
                bigInteger2 = bigInteger1;
                bigInteger1 = result;
            }
            return result;
        };
        Consumer<String> precondition = new Consumer<String>() {
            @Override
            public void accept(String string) {
                if (Integer.parseInt(string) < 0) {
                    throw new IllegalArgumentException("음수를 넣었습니다.");
                }
            }
        };
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            precondition.accept(str);
            BigInteger bigInteger = new BigInteger(str);
            System.out.println(factorial.apply(bigInteger));
            System.out.println(fibonacci.apply(bigInteger));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
