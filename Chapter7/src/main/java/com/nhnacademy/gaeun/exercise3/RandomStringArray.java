package com.nhnacademy.gaeun.exercise3;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class RandomStringArray {
    private static final int START = 'a';
    private static final int END = 'z';
    private static final int TOTAL_LENGTH = 10;
    private final Random random = new Random();

    private String[] list;

    public String[] getList() {
        return list;
    }

    public RandomStringArray(int inputNum) {
        randomInput(inputNum);
    }

    public void randomInput(int inputNum) {
        list = new String[inputNum];
        for(int i = 0; i < inputNum; i++) {
            list[i] = makeString();
        }
    }

    public String makeString() {
        return random.ints(START, END + 1)
                .limit(TOTAL_LENGTH)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public void selectionSort() {
        for(int i = 0; i < list.length; i++) {
            int min = i;
            for(int j = i+1; j < list.length; j++) {
                if(list[min].compareTo(list[j]) > 0) {
                    min = j;
                }
            }
            String tmp = list[i];
            list[i] = list[min];
            list[min] = tmp;
        }
    }
}
