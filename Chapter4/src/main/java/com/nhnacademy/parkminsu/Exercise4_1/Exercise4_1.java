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
        boolean upperCheck = false;
        for (int idx = 0; idx < str.length(); idx++) {
            if (Character.isLetter(str.charAt(idx))) {
                if (!upperCheck) {
                    upperCheck = true;
                    resultString.append(Character.toUpperCase(str.charAt(idx)));
                } else {
                    resultString.append(str.charAt(idx));
                }
            } else {
                resultString.append(str.charAt(idx));
                upperCheck = false;
            }

        }
        return resultString;
    }

}
