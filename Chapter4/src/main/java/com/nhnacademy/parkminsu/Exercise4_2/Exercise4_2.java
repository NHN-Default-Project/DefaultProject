package com.nhnacademy.parkminsu.Exercise4_2;

import java.util.Scanner;

public class Exercise4_2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String str = scanner.nextLine();
            System.out.println(calculator(str));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean checkHexValue(String str) {
        int cnt = 0;
        for (int idx = 0; idx < str.length(); idx++) {
            if ((str.charAt(idx) >= '0' && str.charAt(idx) <= '9') || (str.charAt(idx) >= 'A' && str.charAt(idx) <= 'F')
                    || (str.charAt(idx) >= 'a' && str.charAt(idx) <= 'f')) {
                cnt++;
            }

        }
        if (cnt == str.length()) {
            return true;
        } else if (cnt < str.length() - 1) {
            throw new IllegalArgumentException("데이터를 잘못 입력하셨습니다");
        } else {
            return false;
        }

    }

    public static int hexValue(char num) {
        if (Character.isLetter(num)) {
            return num - 87;
        } else {
            return num - '0'; // char형이므로 숫자 1이 반환이 되는것이 아니라 아스키 코드의 숫자값이 입력되서 '0'을
        }
    }

    public static int calculator(String str) {
        if (!checkHexValue(str)) {
            return -1;
        }
        int value = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            value = value * 16 + hexValue(str.charAt(i));

        }
        return value;
    }
}

