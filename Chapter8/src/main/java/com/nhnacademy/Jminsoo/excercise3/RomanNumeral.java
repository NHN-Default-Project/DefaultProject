package com.nhnacademy.Jminsoo.excercise3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class RomanNumeral {
    private String romanNumeral;
    private int arabicNumeral;

    private final String[] ROMAN_NUMERAL = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private final int[] ROMAN_NUMERAL_VALUE = {};

    public RomanNumeral(String romanNumeral) {
        try {
            if (isRomanDuplicateFour(romanNumeral)) {
                throw new NumberFormatException();
            }
            this.romanNumeral = romanNumeral;
            romanToArabic();
        } catch (NumberFormatException e) {
            System.out.println("입력값이 잘못되었습니다!");
            throw new NumberFormatException();
        }
    }

    public RomanNumeral(int arabicNumeral) {
        try {
            if (arabicNumeral > 3999 || 1 > arabicNumeral) {
                throw new NumberFormatException();
            }
            this.arabicNumeral = arabicNumeral;
            arabicToRoman();
        } catch (NumberFormatException e) {
            System.out.println("입력값이 잘못되었습니다!");
            throw new NumberFormatException();
        }

    }

    private boolean isRomanDuplicateFour(String roman) {
        String regex = "(\\w)\\1\\1\\1";

        if (Pattern.compile(regex).matcher(roman).find()) {
            return true;
        } else {
            return false;
        }
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

        int arabicNum = this.arabicNumeral;

        for (ERomanNumeral eRomanNumeral : ERomanNumeral.values()) {
            while (arabicNum >= eRomanNumeral.getValue()) {
                result.append(eRomanNumeral.name());
                arabicNum -= eRomanNumeral.getValue();
            }
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
