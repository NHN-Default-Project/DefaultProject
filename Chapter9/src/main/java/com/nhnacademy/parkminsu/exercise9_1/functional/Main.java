package com.nhnacademy.parkminsu.exercise9_1.functional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Formula factorial = bigInteger -> {
            BigInteger bigInteger1 = BigInteger.ONE;
            for (BigInteger i = bigInteger; i.compareTo(BigInteger.ZERO) > 0; i = i.subtract(BigInteger.ONE)) {
                bigInteger1 = bigInteger1.multiply(i);
            }
            return bigInteger1;
        };

        Precondition precondition = str -> {
            if (Integer.parseInt(str) < 0) {
                throw new IllegalArgumentException("음수를 입력했습니다");
            }
        };

        Formula fibonacci = bigInteger -> {
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

//        Formula fi = bigInteger -> {
//            return Formula.fibonacci(bigInteger);
//
//        };
// 효율적인 재귀(memorization)
        Map<BigInteger, BigInteger> bigIntegerBigIntegerMap = new HashMap<>();
        Formula fibonacci2 = bigInteger -> Formula.fibonacci(bigInteger, bigIntegerBigIntegerMap);

        Formula fibonacci3 = Formula::fibonacci2;


        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("계산할 값을 넣으시오");
            String str = br.readLine();
            precondition.precondition(str);
            System.out.println(factorial.apply(new BigInteger(str)));

            long start;
            long end;
            start = System.nanoTime();
            System.out.println(fibonacci2.apply(new BigInteger(str)));
            end = System.nanoTime();
            System.out.println(end - start);

            start = System.nanoTime();
            System.out.println(fibonacci3.apply(new BigInteger(str)));
            end = System.nanoTime();
            System.out.println(end - start);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
