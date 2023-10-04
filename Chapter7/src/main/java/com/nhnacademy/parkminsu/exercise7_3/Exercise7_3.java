package com.nhnacademy.parkminsu.exercise7_3;

import java.util.Arrays;
import java.util.Random;

public class Exercise7_3 {
    private static final int ARRAYSIZE = 100000;

    public static void main(String[] args) {
        double[] selectionSortArray = new double[ARRAYSIZE];
        double[] sortArray = new double[ARRAYSIZE];
        long startTime;
        long endTime;
        String[] selectionSortStringArray = new String[ARRAYSIZE];
        String[] sortStringArray = new String[ARRAYSIZE];
        selectionSortArray = createArrayValue(selectionSortArray, ARRAYSIZE);
        sortArray = createArrayValue(sortArray, ARRAYSIZE);
        selectionSortStringArray = createStringArrayValue(selectionSortStringArray);
        sortStringArray = createStringArrayValue(sortStringArray);

        startTime = System.nanoTime();
        selectionSortArray = selectionSort(selectionSortArray);
        endTime = System.nanoTime();
        System.out.println("선택정렬 시간: " + ((endTime - startTime) / 1000000000.0));

        startTime = System.nanoTime();
        Arrays.sort(sortArray);
        endTime = System.nanoTime();
        System.out.println("퀵 정렬 시간: " + ((endTime - startTime) / 1000000000.0));

        startTime = System.nanoTime();
        selectionSortStringArray = selectionSortStringArray(selectionSortStringArray);
        endTime = System.nanoTime();
        System.out.println("선택정렬 시간: " + ((endTime - startTime) / 1000000000.0));

        startTime = System.nanoTime();
        Arrays.sort(sortStringArray);
        endTime = System.nanoTime();
        System.out.println("퀵 정렬 시간: " + ((endTime - startTime) / 1000000000.0));
    }

    public static double[] createArrayValue(double[] array, int size) {
        for (int i = 0; i < size; i++) {
            array[i] = Math.random() * size;
        }
        return array;
    }

    public static double[] selectionSort(double[] selectionSortArray) {
        double min;
        int tmpIndex = 0;

        for (int i = 0; i < selectionSortArray.length; i++) {
            min = selectionSortArray[i];
            for (int j = i; j < selectionSortArray.length; j++) {
                if (min > selectionSortArray[j]) {
                    min = selectionSortArray[j];
                    tmpIndex = j;
                }
            }
            double tmpNum = selectionSortArray[tmpIndex];

            selectionSortArray[tmpIndex] = selectionSortArray[i];
            selectionSortArray[i] = tmpNum;
        }
        return selectionSortArray;
    }

    public static void printArray(double... array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void printArray(String... array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static String[] createStringArrayValue(String[] strings) {
        int leftLimit = 97;
        int rightLimit = 122;
        int randomStringLength = 10;
        Random random = new Random();
        for (int i = 0; i < strings.length; i++) {
            strings[i] = random.ints(leftLimit, rightLimit + 1)
                    .limit(randomStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString(); // 랜덤한 문자열 생성
        }
        return strings;
    }

    public static String[] selectionSortStringArray(String[] selectionSortArray) {
        String str;
        int idxWithSmallValue = 0;
        for (int i = 0; i < selectionSortArray.length; i++) {
            str = selectionSortArray[i];
            for (int j = i; j < selectionSortArray.length; j++) {
                if (str.compareTo(selectionSortArray[j]) > 0) {
                    str = selectionSortArray[j];
                    idxWithSmallValue = j;
                }
            }
            String tmpStr = selectionSortArray[idxWithSmallValue];
            selectionSortArray[idxWithSmallValue] = selectionSortArray[i];
            selectionSortArray[i] = tmpStr;
        }
        return selectionSortArray;
    }
}
