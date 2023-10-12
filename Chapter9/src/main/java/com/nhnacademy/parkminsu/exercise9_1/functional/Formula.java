package com.nhnacademy.parkminsu.exercise9_1.functional;

import java.math.BigInteger;
import java.util.Map;

@FunctionalInterface
public interface Formula {
    BigInteger apply(BigInteger bigInteger);


    static BigInteger fibonacci(BigInteger bigInteger, Map<BigInteger, BigInteger> bigIntegerBigIntegerMap) {
        if (bigInteger.compareTo(BigInteger.ZERO) == 0) {
            bigIntegerBigIntegerMap.put(bigInteger, BigInteger.ZERO);
            return BigInteger.ZERO;
        } else if (bigInteger.compareTo(BigInteger.ONE) == 0) {
            bigIntegerBigIntegerMap.put(bigInteger, BigInteger.ONE);
            return BigInteger.ONE;
        }
        if (bigIntegerBigIntegerMap.get(bigInteger) == null) {
            bigIntegerBigIntegerMap.put(bigInteger, fibonacci(bigInteger.subtract(BigInteger.ONE), bigIntegerBigIntegerMap).add(fibonacci(bigInteger.subtract(BigInteger.TWO), bigIntegerBigIntegerMap)));
        }
        return bigIntegerBigIntegerMap.get(bigInteger);
    } // 피보나치 forans

    static BigInteger fibonacci2(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ZERO;
        } else if (bigInteger.compareTo(BigInteger.ONE) == 0) {
            return BigInteger.ONE;
        }
        return fibonacci2(bigInteger.subtract(BigInteger.ONE)).add(fibonacci2(bigInteger.subtract(BigInteger.TWO)));
    } // 피보나치 재귀
}
