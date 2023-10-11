package com.nhnacademy.Jminsoo.exercise1.functionalinterface;

import java.math.BigInteger;
import java.util.Map;

@FunctionalInterface
public interface Formula {
    BigInteger apply(BigInteger bi, Map<BigInteger, BigInteger> memory);

    /**
     * 연습용 활용 메서드
     */
    static BigInteger fibonacci(BigInteger n, Map<BigInteger, BigInteger> memory) {

        if (n.equals(BigInteger.ZERO)) {
            memory.put(n, BigInteger.ZERO);
            return BigInteger.ZERO;
        } else if (n.equals(BigInteger.ONE)) {
            memory.put(n, BigInteger.ONE);

            return BigInteger.ONE;
        }

        BigInteger result;
        if (memory.get(n) == null) {
            result = fibonacci(n.subtract(BigInteger.ONE), memory).add(fibonacci(n.subtract(BigInteger.TWO), memory));
            memory.put(n, result);
        } else {
            return memory.get(n);
        }

        return fibonacci(n.subtract(BigInteger.ONE), memory)
                .add(fibonacci(n.subtract(BigInteger.TWO), memory));
    }

}
