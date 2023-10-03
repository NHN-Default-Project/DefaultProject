package com.nhnacademy.gaeun.exercise3;

import java.util.Arrays;

public class Exercise7_3 {
    private static long startTime;
    private static long endTime;
    private static long compTime;

    public static void main(String[] args) {
        System.out.println("=========== 무작위 Integer 배열 ===========");
        RandomArray randomIntArray = new RandomArray(200);
        selectionSortTime(randomIntArray);
        arraySortTime(randomIntArray);

        System.out.println("=========== 무작위 String 배열 ===========");
        RandomStringArray randomStringArray = new RandomStringArray(100);
        selectionSortTime(randomStringArray);
        arraySortTime(randomStringArray);

    }

    public static void selectionSortTime(Array array) {
        startTime = System.nanoTime();
        array.selectionSort();
        endTime = System.nanoTime();
        compTime = endTime - startTime;
        System.out.println("SelectionSort Time is: " + compTime);
    }

    public static void arraySortTime(Array array) {
        startTime = System.nanoTime();
        Arrays.sort(array.getList());
        endTime = System.nanoTime();
        compTime = endTime - startTime;
        System.out.println("Arrays.sort Time is: " + compTime);
    }

}
