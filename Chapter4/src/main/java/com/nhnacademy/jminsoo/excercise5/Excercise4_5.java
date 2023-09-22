package com.nhnacademy.jminsoo.excercise5;

import java.util.Arrays;

public class Excercise4_5 {
    public static void main(String[] args) {
        double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
        System.out.println("sum : " + sum.apply(arr));
        System.out.println("max : " + max.apply(arr));
        System.out.println("min : " + min.apply(arr));
        System.out.println("평균 : " + average.apply(arr));
        System.out.println("5가 나온 횟수 : " + counter(5.0).apply(arr));
    }

    public static ArrayProcessor counter(double value) {
        return (arr) -> {
            double count = 0;
            for (double v : arr) {
                if (v == value) {
                    count += 1;
                }
            }

            return count;
        };
    }

    public static ArrayProcessor sum = (x) -> Arrays.stream(x).sum();

    public static ArrayProcessor max = (x) -> Arrays.stream(x).max().orElse(0.0);

    public static ArrayProcessor min = (x) -> Arrays.stream(x).min().orElse(0.0);

    public static ArrayProcessor average = (x) -> Arrays.stream(x).average().orElse(0.0);
}
