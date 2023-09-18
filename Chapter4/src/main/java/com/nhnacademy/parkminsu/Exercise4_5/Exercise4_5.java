package com.nhnacademy.parkminsu.Exercise4_5;

import java.util.stream.DoubleStream;

public class Exercise4_5 {
    public static final ArrayProcessor ARRAYMIN = array -> DoubleStream.of(array).min().getAsDouble();
    public static final ArrayProcessor ARRAYMAX = array -> DoubleStream.of(array).max().getAsDouble();
    public static final ArrayProcessor ARRAYSUM = array -> DoubleStream.of(array).sum();
    public static final ArrayProcessor ARRAYAVERAGE = array -> DoubleStream.of(array).average().getAsDouble();

    //    public static final ArrayProcessor ARRAYMIN = new ArrayMin();
//    public static  final ArrayProcessor ARRAYMAX = new ArrayMax();
//    public static final ArrayProcessor ARRAYSUM = new ArraySum();
//    public static final ArrayProcessor ARRAYAVERAGE = new ArrayAverage();
    public static void main(String[] args) {
        double[] arrNum = {10.0, 20.0, 30.0, 40.0};
        System.out.println(counter(10.0).apply(arrNum));
        System.out.println(ARRAYSUM.apply(arrNum));
        System.out.println(ARRAYMIN.apply(arrNum));
        System.out.println(ARRAYMAX.apply(arrNum));
        System.out.println(ARRAYAVERAGE.apply(arrNum));
    }

    public static ArrayProcessor counter(double value) {
        return new ArrayProcessor() {
            @Override
            public double apply(double[] array) {
                double cnt = 0.0;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == value) {
                        cnt++;
                    }
                }
                return cnt;
            }
        };

    }

}

