package com.nhnacademy.parkminsu.exercise9_1.singletonpattern;

import java.math.BigInteger;

public abstract class Num {
    private BigInteger num;

    public Num(String str) {
        precondition(str);
        num = new BigInteger(str);

    }

    public boolean isIntegerNegative(int inputData) {
        return inputData < 0;
    }

    public void precondition(String str) {
        if (isIntegerNegative(Integer.parseInt(str))) {
            throw new IllegalArgumentException("입력한 데이터가 음수입니다.");
        }
    }

    public BigInteger getNum() {
        return num;
    }

    abstract public BigInteger apply(BigInteger bigInteger);

}
