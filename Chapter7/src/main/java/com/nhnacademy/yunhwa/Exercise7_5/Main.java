package com.nhnacademy.yunhwa.Exercise7_5;

public class Main {
    public static void main(String[] args) {
        SortingPositiveRealNumbersByAsc sortPositiveRealNumbersByAsc = new SortingPositiveRealNumbersByAsc();
        double[] doubleArr = sortPositiveRealNumbersByAsc.returnDoubleArrayFromuserInputBeforeAction();
        sortPositiveRealNumbersByAsc.printSortedArray(sortPositiveRealNumbersByAsc.action(doubleArr));
    }
}