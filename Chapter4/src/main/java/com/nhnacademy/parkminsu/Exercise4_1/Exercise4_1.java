package com.nhnacademy.parkminsu.Exercise4_1;

import java.util.Scanner;

public class Exercise4_1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Exercise4_1 main = new Exercise4_1();
            System.out.println(main.pringCapialized(scanner.nextLine()));
        }

    }

    public StringBuilder pringCapialized(String str) {
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
            }

        }
        return resultString;
    }

}
