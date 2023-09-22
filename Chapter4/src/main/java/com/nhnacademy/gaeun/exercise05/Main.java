package com.nhnacademy.gaeun.exercise05;

public class Main {
    static final ArrayProcessor max = (x) -> {
        double maxValue = x[0];
        for (int i = 0; i < x.length; i++) {
            if (x[i] > maxValue) {
                maxValue = x[i];
            }
        }
        return maxValue;
    };
    static final ArrayProcessor min = (x) -> {
        double minValue = x[0];
        for (double element : x) {
            if (element < minValue) {
                minValue = element;
            }
        }
        return minValue;
    };
    static final ArrayProcessor sum = (x) -> {
        double sumValue = 0;
        for (double element : x) {
            sumValue += element;
        }
        return sumValue;
    };
    static final ArrayProcessor average = (x) -> sum.apply(x) / x.length;

    public static final ArrayProcessor counter(double value) {
        return array -> {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == value) {
                    count += 1;
                }
            }
            return count;
        };
    }

    public static void main(String[] args) {
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        System.out.println(max.apply(array));
        System.out.println(min.apply(array));
        System.out.println(sum.apply(array));
        System.out.println(average.apply(array));
        System.out.println(counter(5.0).apply(array));
    }

}
