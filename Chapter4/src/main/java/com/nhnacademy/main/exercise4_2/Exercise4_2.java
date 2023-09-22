package com.nhnacademy.main.exercise4_2;

import java.util.Scanner;

public class Exercise4_2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);) {
            System.out.print("16진수 값을 입력해주세요 : ");

            String str = sc.nextLine().trim();

            System.out.println("16진수 -> 10진수 변환 결과 : " + hexdecimalToDecimal(str));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int hexdecimalToDecimal(String str) {
        int decimal = 0;

        for (int i = 0; i < str.length(); i++) {
            int hexValue = hexValue(str.charAt(i));
            if (hexValue == -1) {
                throw new IllegalArgumentException("16진수 값이 아닌 값" + str.charAt(i) + "이 들어왔습니다. 다시 기입해주세요.");
            }
            decimal = decimal * 16 + hexValue;
        }
        return decimal;
    }

    public static int hexValue(char character) {
        switch (character) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'A':
            case 'a':
                return 10;
            case 'B':
            case 'b':
                return 11;
            case 'C':
            case 'c':
                return 12;
            case 'D':
            case 'd':
                return 13;
            case 'E':
            case 'e':
                return 14;
            case 'F':
            case 'f':
                return 15;
            default:
                return -1;
        }
    }
}

