package com.nhnacademy.gaeun.exercise01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        printCapitalized(userInput);
    }

    public static void printCapitalized(String sentence) {
        char[] checkSentence = sentence.toCharArray();
        String newString = "";
        for (int i = 0; i < sentence.length(); i++) {
            if (Character.isLetter(checkSentence[i])) {
                newString += Character.toUpperCase(checkSentence[i]);
            } else {
                newString += checkSentence[i];
            }
        }
        System.out.println(newString);
    }
}
