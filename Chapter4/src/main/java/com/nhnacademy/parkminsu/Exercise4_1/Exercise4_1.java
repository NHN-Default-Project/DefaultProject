package com.nhnacademy.parkminsu.Exercise4_1;

import java.util.Scanner;

public class Exercise4_1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(printCapialized(scanner.nextLine()));
        }

    }

    public static StringBuilder printCapialized(String str) {
        StringBuilder resultString = new StringBuilder();
        int count = 0;
        for (int idx = 0; idx < str.length(); idx++) {
            if (Character.isLetter(str.charAt(idx))) {
                if (checkUpper(str.charAt(idx), count)) {
                    resultString.append(Character.toUpperCase(str.charAt(idx)));
                    count++;
                } else {
                    resultString.append(str.charAt(idx));
                }
            } else {
                count = 0;
                resultString.append(str.charAt(idx));
            }

        }
        return resultString;
    }

    public static boolean checkUpper(char letter, int count) {
        return ('a' <= letter || letter <= 'z') && count == 0;
    }
}
