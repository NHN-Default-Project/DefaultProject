package com.nhnacademy.Jminsoo.excercise3;

import java.util.Arrays;

/*
 *https://math.hws.edu/javanotes/c7/exercises.html
 * Collection.Sort와 다른 sort의 시간 속도를 비교하는 문제
 * */

public class Excercise7_3 {
    static final int LENGTH = 10_000;

    static final int RANGE = 10_000;

    static final double PERCENTAGE = 1_000_000_000.0;

    public static void main(String[] args) {
        String[] firstStrArray = makeArray(LENGTH, RANGE);
        String[] secondStrArray = makeArray(LENGTH, RANGE);

        long firstStartTime = System.nanoTime();

        arraySort(firstStrArray);

        long firstEndTime = System.nanoTime();

        System.out.println("Array.sort 연산 시간 :  " + (firstEndTime - firstStartTime) / PERCENTAGE);

        long secondStartTime = System.nanoTime();

        selectionSort(secondStrArray);

        long secondEndTime = System.nanoTime();

        System.out.println("Selection Sort 연산 시간 :  " + (secondEndTime - secondStartTime) / PERCENTAGE);


    }

    public static String[] makeArray(int length, int range) {
        String[] resultArray = new String[length];

        for (int i = 0; i < length; i++) {
            resultArray[i] = String.valueOf((Math.random() * range) + 1);
        }

        return resultArray;
    }

    public static void arraySort(String[] strArray) {
        Arrays.sort(strArray);
    }

    private static void selectionSort(String[] strArray) {

        for (int lastPlace = strArray.length - 1; lastPlace > 0; lastPlace--) {

            int maxLoc = 0;

            for (int j = 1; j <= lastPlace; j++) {
                if (Double.parseDouble(strArray[j]) > Double.parseDouble(strArray[maxLoc])) {

                    maxLoc = j;
                }
            }

            String temp = strArray[maxLoc];
            strArray[maxLoc] = strArray[lastPlace];
            strArray[lastPlace] = temp;

        }  // end of for loop

    }

}

