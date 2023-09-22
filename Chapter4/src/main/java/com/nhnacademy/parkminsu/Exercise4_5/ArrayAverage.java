package com.nhnacademy.parkminsu.Exercise4_5;

public class ArrayAverage implements ArrayProcessor {
    @Override
    public double apply(double[] array) {
        double result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result / array.length;
    }
}
