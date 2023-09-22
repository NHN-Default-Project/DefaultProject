package com.nhnacademy.parkminsu.Exercise7_3;

import java.util.Arrays;

public class Exercise7_3 {
    private static final int ARRAYSIZE = 100000;

    public static void main(String[] args) {
        double[] selectionSortArray = new double[ARRAYSIZE];
        double[] sortArray = new double[ARRAYSIZE];
        long startTime;
        long endTime;
        selectionSortArray = createArrayValue(selectionSortArray, ARRAYSIZE);
        sortArray = createArrayValue(sortArray, ARRAYSIZE);
        startTime = System.nanoTime();

        selectionSortArray = selctionSort(selectionSortArray);
        endTime = System.nanoTime();
        System.out.println("선택정렬 시간: " + ((endTime - startTime) / 1000000000.0));
        printArray(selectionSortArray);

        startTime = System.nanoTime();
        Arrays.sort(sortArray);
        endTime = System.nanoTime();
        System.out.println("퀵 정렬 시간: " + ((endTime - startTime) / 1000000000.0));
        printArray(sortArray);
    }

    public static double[] createArrayValue(double[] array, int size) {
        for (int i = 0; i < size; i++) {
            array[i] = Math.random() * ARRAYSIZE;
        }
        return array;
    }

    public static double[] selctionSort(double[] selectionSortArray) {
        double min = 0.0;
        int tmpIndex = 0;

        for (int i = 0; i < ARRAYSIZE; i++) {
            double tmpNum = Double.MAX_VALUE;
            min = selectionSortArray[i];
            for (int j = i; j < ARRAYSIZE; j++) {
                if (min > selectionSortArray[j]) {
                    min = selectionSortArray[j];
                    tmpIndex = j;
                }
            }
            tmpNum = selectionSortArray[tmpIndex];
            selectionSortArray[tmpIndex] = selectionSortArray[i];
            selectionSortArray[i] = tmpNum;
        }
        return selectionSortArray;
    }

    public static void printArray(double[] array) {
        for (int i = 0; i < ARRAYSIZE; i++) {
            System.out.println(array[i]);
        }
    }
}
