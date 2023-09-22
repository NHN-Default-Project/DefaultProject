package com.nhnacademy.Jminsoo.excercise1;

public class Excercise7_1 {
    public static void main(String[] args) {
        printArray(makeArray(10, 100));
    }

    public static int[] makeArray(int number, int range) {
        int[] resultList = new int[number];

        for (int i = 0; i < number; i++) {
            resultList[i] = ((int) (Math.random() * range) + 1);
        }

        return resultList;
    }

    public static void printArray(int[] list) {
        for (int value : list) {
            System.out.println(value);
        }

    }

}
