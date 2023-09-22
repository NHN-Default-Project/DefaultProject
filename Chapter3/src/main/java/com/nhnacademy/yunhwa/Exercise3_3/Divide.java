package com.nhnacademy.yunhwa.Exercise3_3;

public class Divide/*<T extends Number> */ implements BinaryOperator/*<T> */ {

    // @Override
    // public T apply(T a, T b) {
        
    //     throw new UnsupportedOperationException("Unimplemented method 'apply'");
    // }

    @Override
    public double apply(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("0으로 나눌 수가 없습니다. 두 번째 값을 0 대신 다시 입력해주세요.");
        }
        return a / b;
    }
}
