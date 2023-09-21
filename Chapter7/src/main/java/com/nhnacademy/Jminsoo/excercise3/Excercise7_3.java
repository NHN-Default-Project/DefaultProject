package com.nhnacademy.Jminsoo.excercise3;

public class Excercise7_3 {
    public static void main(String[] args) {
        String[] strArray = makeArray(100000, 100);
    }

    public static String[] makeArray(int length, int range) {
        String[] resultArray = new String[length];

        for (int i = 0; i < length; i++) {
            resultArray[i] = String.valueOf((Math.random() * range) + 1);
        }

        return resultArray;
    }
}

