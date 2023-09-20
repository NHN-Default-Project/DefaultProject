package com.nhnacademy.jminsoo.excercise2;

public class Number {
    public static int hexValue(char hexNum) {
        //check
        int result = 0;

        switch (hexNum) {
            case '0':
                result = 0;
                break;
            case '1':
                result = 1;
                break;
            case '2':
                result = 2;
                break;
            case '3':
                result = 3;
                break;
            case '4':
                result = 4;
                break;
            case '5':
                result = 5;
                break;
            case '6':
                result = 6;
                break;
            case '7':
                result = 7;
                break;
            case '8':
                result = 8;
                break;
            case '9':
                result = 9;
                break;
            case 'A':
            case 'a':
                result = 10;
                break;
            case 'B':
            case 'b':
                result = 11;
                break;
            case 'C':
            case 'c':
                result = 12;
                break;
            case 'D':
            case 'd':
                result = 13;
                break;
            case 'E':
            case 'e':
                result = 14;
                break;
            case 'F':
            case 'f':
                result = 15;
                break;
        }
        return result;
    }

}
