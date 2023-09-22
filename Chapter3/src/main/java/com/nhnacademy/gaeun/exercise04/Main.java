package com.nhnacademy.gaeun.exercise04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("문장을 입력해주세요.");
        String sentence = scanner.nextLine();
        checkLetter(sentence);


    }

    public static void checkLetter(String sentence) {
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (Character.isLetter(sentence.charAt(i)) || sentence.charAt(i) == 39) {
                if (count > 0) {
                    count = 0;
                    System.out.println();
                }
                System.out.print(sentence.charAt(i));
            } else {
                count++;
            }
        }
        System.out.println();
    }

}
