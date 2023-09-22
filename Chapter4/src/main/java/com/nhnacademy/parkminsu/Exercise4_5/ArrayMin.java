package com.nhnacademy.parkminsu.Exercise4_5;

public class ArrayMin implements ArrayProcessor {
    @Override
    public double apply(double[] array) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
}

