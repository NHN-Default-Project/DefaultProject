package com.nhnacademy.Jminsoo.exercise3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class RomanNumeral {
    private String romanNumeral;
    private int arabicNumeral;

    //출력 검증을 위한 변수
    private boolean isArabic;

    public RomanNumeral(String romanNumeral) {
        try {
            preconditionOfRoman(romanNumeral);
            this.isArabic = false;

            this.romanNumeral = romanNumeral;
            romanToArabic();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("입력값이 잘못되었습니다!");
        }
    }

    public RomanNumeral(int arabicNumeral) {
        try {
            preconditionOfArabic(arabicNumeral);
            this.isArabic = true;

            this.arabicNumeral = arabicNumeral;
            arabicToRoman();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("입력값이 잘못되었습니다!");
        }

    }

    private void preconditionOfArabic(int number) {
        if (number > 3999 || 1 > number) {
            throw new NumberFormatException();
        }
    }

    private void preconditionOfRoman(String roman) {
        String regex = "(\\w)\\1\\1\\1";

        if (Pattern.compile(regex).matcher(roman).find()) {
            throw new NumberFormatException();
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

        } catch (NumberFormatException | NullPointerException e) {
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

    @Override
    public String toString() {
        if (isArabic) {
            return String.valueOf(this.arabicNumeral);
        } else {
            return this.romanNumeral;
        }
    }

    public int getValue(Character roman) {
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
