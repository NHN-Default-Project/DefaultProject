package com.nhnacademy.parkminsu.exercise8_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // LL = c 인걸 알려주는 걸 추가 해야할 듯
        // 메소드 분리
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String userInput = scanner.nextLine();
                if (userInput.isEmpty()) {
                    System.out.println("프로그램 종료");
                    break;
                }
                if (userInput.charAt(0) >= '0' && userInput.charAt(0) <= '9') { // 아라비아 숫자로 입력
                    RomanNumeral romanNumeral = new RomanNumeral(Integer.parseInt(userInput));
                    romanNumeral.convertArabicToRoman();
                    System.out.println(romanNumeral.getRomanNumeral());
                } else {
                    RomanNumeral romanNumeral = new RomanNumeral(userInput);
                    romanNumeral.convertRomanToArabic();
                    System.out.println(romanNumeral.getArabicNumeral());
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                
            }
        }
        scanner.close();
    }

    public static RomanNumeral identifyingArabicNumAndRomanNum(String userInput) {
        if (userInput.charAt(0) >= '0' || userInput.charAt(0) <= '9') { // 아라비아 숫자로 입력
            return new RomanNumeral(Integer.parseInt(userInput));
        } else {
            return new RomanNumeral(userInput);
        }
    }
}
