package com.nhnacademy.gaeun.exercise3;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class RandomStringArray {
    int start = 'a';
    int end = 'z';
    int totalLength = 10;
    Random random = new Random();

    String newString;
    String[] list;

    RandomStringArray(int inputNum) {
        randomInput(inputNum);
    }

    public void randomInput(int inputNum) {
        list = new String[inputNum];
        for(int i = 0; i < inputNum; i++) {
            list[i] = makeString();
        }
    }

    public String makeString() {
        newString = random.ints(start, end + 1)
                .limit(totalLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return newString;
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
