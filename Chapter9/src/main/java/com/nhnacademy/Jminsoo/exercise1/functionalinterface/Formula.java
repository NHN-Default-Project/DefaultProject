package com.nhnacademy.Jminsoo.exercise1.functionalinterface;

import java.math.BigInteger;
import java.util.Map;

@FunctionalInterface
public interface Formula {
    BigInteger apply(BigInteger bi, Map<BigInteger, BigInteger> memory);

    /**
     * 연습용 활용 메서드
     */
    static BigInteger fibonacci(BigInteger number, Map<BigInteger, BigInteger> memoryMap) {

        if (number.equals(BigInteger.ZERO)) {
            memoryMap.put(number, BigInteger.ZERO);
            return BigInteger.ZERO;
        } else if (number.equals(BigInteger.ONE)) {
            memoryMap.put(number, BigInteger.ONE);

            return BigInteger.ONE;
        }

        BigInteger result;
        if (memoryMap.get(number) == null) {
            result = fibonacci(number.subtract(BigInteger.ONE), memoryMap).add(fibonacci(number.subtract(BigInteger.TWO), memoryMap));
            memoryMap.put(number, result);
        } else {
            return memoryMap.get(number);
        }

        return fibonacci(number.subtract(BigInteger.ONE), memoryMap)
                .add(fibonacci(number.subtract(BigInteger.TWO), memoryMap));
    }
}
