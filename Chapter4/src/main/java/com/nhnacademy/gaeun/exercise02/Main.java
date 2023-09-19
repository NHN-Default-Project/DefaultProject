package com.nhnacademy.gaeun.exercise02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hexString = scanner.nextLine();

        System.out.println(calculateDecimal(hexString));
        scanner.close();
    }

    public static int calculateDecimal(String hexString) {
        int decimalNumber = 0;
        for (int i = 0; i < hexString.length(); i++) {
            decimalNumber = decimalNumber * 16 + hexValue(hexString.charAt(i));
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
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
                return character - 55;
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
                return character - 87;
            default:
                return -1;
        }
    }
}
