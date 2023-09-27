package com.nhnacademy.jaehyeon;

public class Exercise7_5 {

    public static void main(String[] args) {
        int[] array = {2, 31, 1, 3, 4, 5, 6, 1, 2, 3, 4};

        for (int number : sortBubble(array)) {
            System.out.println(number);
        }
    }

    public static int[] sortBubble(int[] arrays) {

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length - 1; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int swap = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = swap;
                }
            }
        }
        return arrays;
    }

}