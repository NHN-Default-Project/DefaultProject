package com.nhnacademy.parkminsu.Exercise4_5;

public class ArrayMax implements ArrayProcessor {
    @Override
    public double apply(double[] array) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
}

