package com.nhnacademy.gaeun.exercise01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();
        printCapitalized(userInput);
        scanner.close();
    }

    public static void printCapitalized(String sentence) {
        StringBuilder newString = new StringBuilder("");
        while (true) {
            int index = sentence.indexOf(" ");

            newString.append(Character.toUpperCase(sentence.charAt(0)));
            if (index == -1) {
                for (int i = 1; i < sentence.length(); i++) {
                    newString.append(sentence.charAt(i));
                }
                break;
            }
            for (int i = 1; i < index; i++) {
                newString.append(sentence.charAt(i));
            }
            newString.append(" ");
            sentence = sentence.substring(sentence.indexOf(" ") + 1);
        }
        System.out.println(newString);
    }
}