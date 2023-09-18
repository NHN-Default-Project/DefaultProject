package com.nhnacademy.gaeun.exercise02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hexString = scanner.nextLine();

        System.out.println(calculateDecimal(hexString));
    }

    public static int calculateDecimal(String hexString) {
        int decimalNumber = 0;
        for(int i = 0; i < hexString.length(); i++) {
            decimalNumber = decimalNumber*16 + hexValue(hexString.charAt(i));
        }
        return decimalNumber;
    }

    public static int hexValue(char character) {
        switch (character) {
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return character - '0';
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            default:
                return 0;
        }
    }
}
