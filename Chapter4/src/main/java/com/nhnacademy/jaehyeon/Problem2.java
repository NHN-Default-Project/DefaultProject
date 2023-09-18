package com.nhnacademy.jaehyeon;

public class Problem2 {


    public static void main(String[] args) {
        String str = "34A7";
        System.out.println(hexValue(str));
    }

    public static int hexValue(String str) {
        int value = 0;
        for (int i = 0; i < str.length(); i++) {
            int num = 0;

            System.out.println(str.charAt(i));
            if (('0' <= str.charAt(i) && str.charAt(i) <= '9')) {
                num = str.charAt(i) - '0';
                System.out.println(num);
            } else {
                switch (str.charAt(i)) {
                    case 'A':
                        num = 10;
                        break;
                    case 'B':
                        num = 11;
                        break;
                    case 'C':
                        num = 12;
                        break;
                    case 'D':
                        num = 13;
                        break;
                    case 'E':
                        num = 14;
                        break;
                    case 'F':
                        num = 15;
                        break;
                }

            }

            value += calculateDigit(str.length() - 1 - i, num);
        }
        return value;
    }

    public static double calculateDigit(int i, int num) {
        return num * Math.pow(16, i);
    }


}


