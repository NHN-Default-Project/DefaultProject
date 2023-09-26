package com.nhnacademy.parkminsu.exercise7_1;

import java.util.ArrayList;

public class Exercise7_1 {
    public static void main(String[] args) {
        int num = 3;
        int maxValue = Integer.MAX_VALUE;
        ArrayList arrayList = createArrayList(num, maxValue);
        System.out.println(arrayList);
    }

    public static ArrayList<Integer> createArrayList(int countNum, int maxIntegerValue) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < countNum; i++) {
            result.add((int) (Math.random() * maxIntegerValue));
        }
        return result;
    }
}