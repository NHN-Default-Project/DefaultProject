package com.nhnacademy.yunhwa.exercise8_3;

import java.util.Scanner;

public class Exercise8_3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("(1 ~ 3999 범위의 아라비아 숫자) 또는 (M, D, C, L, X, V, I 를 활용한 로마 숫자) 를 입력해주세요 (공백 또는 빈칸 입력시 종료) : ");
                String userInput = sc.nextLine().trim();

                if (userInput.isBlank()) {
                    break;
                }

                if (userInput.charAt(0) >= '0' && userInput.charAt(0) <= '9') {
                    int arabicNum = Integer.parseInt(userInput);
                    RomanNumeral romanNumeral = new RomanNumeral(arabicNum);
                    System.out.println(romanNumeral.toString());

                } else {
                    String romanNum = userInput;
                    RomanNumeral romanNumeral = new RomanNumeral(romanNum);
                    System.out.println(romanNumeral.toInt());
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

