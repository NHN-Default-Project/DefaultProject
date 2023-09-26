package com.nhnacademy.gaeun.exercise3;

import java.util.Arrays;

public class Exercise7_3 {

    public static void main(String[] args) {
        RandomArrayList random1 = new RandomArrayList(200);
        RandomArrayList random2 = new RandomArrayList(200);
        RandomStringArray random3 = new RandomStringArray(100);
        RandomStringArray random4 = new RandomStringArray(100);
        long startTime;
        long endTime;
        long compTime;
        double seconds;

        startTime = System.nanoTime();
        random1.selectionSort();
        endTime = System.nanoTime();
        compTime = endTime - startTime;
        System.out.println();
        System.out.println("SelectionSort Time is: " + compTime);

        startTime = System.nanoTime();
        Arrays.sort(random2.getList());
        endTime = System.nanoTime();
        compTime = endTime - startTime;
        System.out.println("Arrays.sort Time is: " + compTime);
        System.out.println();

        System.out.println("=========== 무작위 String 배열 ===========");
        startTime = System.nanoTime();
        random3.selectionSort();
        endTime = System.nanoTime();
        compTime = endTime - startTime;
        System.out.println();
        System.out.println("SelectionSort Time is: " + compTime);

        startTime = System.nanoTime();
        Arrays.sort(random4.list);
        endTime = System.nanoTime();
        compTime = endTime - startTime;
        System.out.println("Arrays.sort Time is: " + compTime);
        System.out.println();
    }
}
