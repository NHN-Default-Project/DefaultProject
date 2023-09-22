package com.nhnacademy.yunhwa.Exercise3_3;

public class Multiply /*<T extends Number> */ implements BinaryOperator/*<T> */ {

    // @Override
    // public T apply(T a, T b) {
        
    //     throw new UnsupportedOperationException("Unimplemented method 'apply'");
    // }

    @Override
    public double apply(double a, double b) {
        return a * b;
    }

}
