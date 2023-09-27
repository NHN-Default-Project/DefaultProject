package com.nhnacademy.jaehyeon;

import java.util.ArrayList;
import java.util.List;

public class Exercise7_1 {


    public static void main(String[] args) {
        for (int i : list(30, 1000)) {
            System.out.println(i);
        }
    }

    public static List<Integer> list(int intNumber, int max) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < intNumber; i++) {
            list.add(getRandomNumber(max));
        }

        return list;
    }

    public static int getRandomNumber(int max) {
        return (int) (Math.random() * max) + 1;
    }
}

