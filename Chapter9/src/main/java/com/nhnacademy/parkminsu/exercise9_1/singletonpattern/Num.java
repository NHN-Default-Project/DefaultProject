package com.nhnacademy.parkminsu.exercise9_1.singletonpattern;

import java.math.BigInteger;

public abstract class Num {
    private BigInteger num;

    Num(String str) {

        this.num = new BigInteger(str);
        precondition(str);


    }


    public void precondition(String str) {
        if (str.charAt(0) == '-') { // Integer.parser로 구현 할 시 입력값을 Int범위를 넘으면 안됨
            throw new IllegalArgumentException("입력한 데이터가 음수입니다.");
        }
    }

    public BigInteger getNum() {
        return num;
    }

    abstract public BigInteger apply(BigInteger bigInteger);

}
