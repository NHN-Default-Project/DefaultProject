package com.nhnacademy.Jminsoo.exercise3;

import java.util.Scanner;

public class Exercise8_3 {
    /**
     * 링크 : https://math.hws.edu/javanotes/c8/exercises.html
     * 로마 숫자를 입력 받으면 아라비아 숫자로, 아라비아 숫자로 입력 받으면 로마 숫자로 표현하는 클래스.
     */
    public static void main(String[] args) {
        String input;
        RomanNumeral romanNumeral;

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.print("로마숫자 또는 아라비아 숫자를 입력하시오 : ");
                    input = scanner.nextLine();
                    if (input.isEmpty()) {
                        break;
                    }
                    if (isArabic(input)) {
                        romanNumeral = new RomanNumeral(Integer.parseInt(input));
                        System.out.println(romanNumeral.toRomanString());
                    } else {
                        romanNumeral = new RomanNumeral(input);
                        System.out.println(romanNumeral.toArabicInt());
                    }
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static boolean isArabic(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
