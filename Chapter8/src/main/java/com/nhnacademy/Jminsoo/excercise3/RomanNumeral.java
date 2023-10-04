package com.nhnacademy.Jminsoo.excercise3;

import java.util.LinkedList;
import java.util.Queue;

public class RomanNumeral {
    private String romanNumeral;
    private int arabicNumeral;

    public RomanNumeral(String romanNumeral) {
        try {
            this.romanNumeral = romanNumeral;
            romanToArabic();
        } catch (NumberFormatException e) {
            System.out.println("입력값이 잘못되었습니다!");
        }
    }

    public RomanNumeral(int arabicNumeral) {
        if (arabicNumeral > 3999 || 1 > arabicNumeral) {
            throw new NumberFormatException();
        }
        this.arabicNumeral = arabicNumeral;
        arabicToRoman();
    }

    private void romanToArabic() {
        Queue<Character> romanArray = new LinkedList<>();

        int result = 0;

        for (char number : this.romanNumeral.toCharArray()) {
            romanArray.add(number);
        }

        try {
            while (romanArray.size() > 1) {
                int firstNumber = getValue(romanArray.poll());
                int peekNumber = getValue(romanArray.peek());

                if (firstNumber >= peekNumber) {
                    result += firstNumber;
                } else {
                    result += peekNumber - firstNumber;
                    romanArray.poll();
                }

            }
            if (!romanArray.isEmpty()) {
                int number = getValue(romanArray.poll());
                result += number;
            }

            this.arabicNumeral = result;

        } catch (NumberFormatException e) {
            throw new NumberFormatException(e.getMessage());
        }

    }

    private void arabicToRoman() {
        StringBuilder result = new StringBuilder();

        int N = this.arabicNumeral;

        while (N >= 1000) {
            result.append("M");
            N -= 1000;
        }
        while (N >= 900) {
            result.append("CM");
            N -= 900;
        }
        while (N >= 500) {
            result.append("D");
            N -= 500;
        }
        while (N >= 400) {
            result.append("CD");
            N -= 400;
        }
        while (N >= 100) {
            result.append("C");
            N -= 100;
        }
        while (N >= 90) {
            result.append("XC");
            N -= 90;
        }
        while (N >= 50) {
            result.append("L");
            N -= 50;

        }
        while (N >= 40) {
            result.append("XL");
            N -= 40;

        }
        while (N >= 10) {
            result.append("X");
            N -= 10;

        }
        while (N >= 9) {
            result.append("IX");
            N -= 9;

        }
        while (N >= 5) {
            result.append("V");
            N -= 5;

        }
        while (N >= 4) {
            result.append("IV");
            N -= 4;

        }
        while (N >= 1) {
            result.append("I");
            N -= 1;
        }
        this.romanNumeral = result.toString();
    }

    public String toRomanString() {
        return this.romanNumeral;
    }

    public int toArabicInt() {
        return this.arabicNumeral;
    }

    public int getValue(char roman) {
        switch (roman) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new NumberFormatException("값이 맞지 않습니다!");
        }
    }
}
