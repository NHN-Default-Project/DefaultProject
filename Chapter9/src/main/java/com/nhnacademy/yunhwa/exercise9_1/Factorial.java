package com.nhnacademy.yunhwa.exercise9_1;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Factorial implements Function<BigInteger> {
    private static Factorial factorial;

    private static Map<BigInteger, BigInteger> factorialMap;

    private Factorial() {
        factorialMap = new HashMap<>();

        factorialMap.put(BigInteger.ZERO, BigInteger.ONE);

        for (int i = 1; i < 10560; i++) { // 스택 오버 플로우 안나게 미리 계산해두는 부분
            BigInteger key = BigInteger.valueOf(i);
            BigInteger value = key.multiply(factorialMap.get(key.subtract(BigInteger.ONE)));
            factorialMap.put(key, value);
        }
    }

    public static Factorial getInstance() {
        if (factorial == null) {
            factorial = new Factorial();
        }
        return factorial;
    }

    @Override
    public BigInteger apply(BigInteger n) {
        if (n.signum() < 0) {
            throw new IllegalArgumentException("factorial 은 0 보다 큰 값들로만 연산 가능합니다. 0 보다 큰 값을 넣어주세요");
        }
        if (factorialMap.containsKey(n)) { // 이미 값이 저장된 것들 접근이 필요할 때만 사용.
            System.out.println("factorial(" + n + ") 이 이미 존재해서 바로 리턴하겠습니다 !!"); //////////////////////
            return factorialMap.get(n); // 값을 딱 한 번만 넣어서 연산할 거면 이거 필요 없는데, 사용자로부터 입력을 받든지 해서 연산을 할 거라면
            // factorial(n) 값은 어떤 값이 들어오든 항상 동일하기 때문에 이 문장이 유의미 해짐. - 따라서 한 값 넣는 예제에서는 무의미할 수 있음.
        }
        if (n.equals(BigInteger.ZERO)) {
            factorialMap.put(BigInteger.ZERO, BigInteger.ONE);
            return BigInteger.ONE;
        }
        BigInteger value = n.multiply(apply(n.subtract(BigInteger.ONE)));
        factorialMap.put(n, value);
        return value;
    }
}
