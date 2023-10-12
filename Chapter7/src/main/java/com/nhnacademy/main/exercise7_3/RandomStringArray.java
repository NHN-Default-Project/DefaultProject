package com.nhnacademy.main.exercise7_3;

import java.util.Random;

public class RandomStringArray extends Array {
    private static final int START = 'a';
    private static final int END = 'z';
    private static final int TOTAL_LENGTH = 10;
    private final Random random = new Random();

    private String[] list;

    public RandomStringArray(int inputNum) {
        randomInput(inputNum);
    }

    @Override
    public String[] getList() {
        return list;
    }

    public void randomInput(int inputNum) {
        this.list = new String[inputNum];
        for (int i = 0; i < inputNum; i++) {
            this.list[i] = makeString();
        }
    }

    public String makeString() {
        return random.ints(START, END + 1)
                .limit(TOTAL_LENGTH)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @Override
    public String[] selectionSort() {
        String[] newString = list;
        for (int i = 0; i < newString.length; i++) {
            int min = i;
            for (int j = i + 1; j < newString.length; j++) {
                if (newString[min].compareTo(newString[j]) > 0) {
                    min = j;
                }
            }
            String tmp = newString[i];
            newString[i] = newString[min];
            newString[min] = tmp;
        }
        return newString;
    }
}
