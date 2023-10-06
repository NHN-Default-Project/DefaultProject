package com.nhnacademy.gaeun.exercise3;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RomanNumerals {
    private final int[] criteria = {1000, 900, 500, 400, 100, 90, 50, 40, 10 , 9, 5, 4, 1};
    private String[] criteriaNumeral = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private Map<Character, Integer> criterias = new HashMap<>();
    @Getter
    private String romanNumeral;
    @Getter
    private int arabicNumeral;

    public RomanNumerals(int arabicNumeral) {
        if(arabicNumeral > 3999 || arabicNumeral < 1) {
            throw new NumberFormatException("0~3999까지의 숫자만 입력 가능합니다.");
        }
        this.arabicNumeral = arabicNumeral;
        listToMap();
        arabicToRoman(arabicNumeral);
    }
    public RomanNumerals(String romanNumeral) {
        checkRoman(romanNumeral);
        this.romanNumeral = romanNumeral;
        listToMap();
        romanToArabic(romanNumeral);
    }

    private void checkRoman(String romanNumeral) {
        String regex = "(M{3,}|D{3,}|C{3,}|L{3,}|X{3,}|V{3,}|I{3,})";
        if (romanNumeral.matches(regex)) {
            throw new NumberFormatException("동일한 문자가 3번 이상 들어오고 있습니다. ");
        }
    }

    private void listToMap() {
        criterias.put(criteriaNumeral[0].charAt(0), criteria[0]);
        for(int i = 1; i <= 6; i++) {
            criterias.put(criteriaNumeral[2 * i].charAt(0), criteria[2 * i]);
        }
    }
    public void arabicToRoman(int intArabic) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < criteria.length; i++) {
            if(criteria[i] <= intArabic) {
                sb.append(criteriaNumeral[i].repeat(intArabic / criteria[i]));
                intArabic = intArabic % criteria[i];
            }
        }
        this.romanNumeral = sb.toString();
    }

    public int romanToArabic(String roman) {
        int result = 0;
        char prevChar = ' ';
        for(int i = roman.length() -1 ; i >= 0; i--) {//키값을 못 찾으면 NullPointerException 에러 발생
            if(i != 0) {
                prevChar = roman.charAt(i-1);
                if(criterias.get(roman.charAt(i)) > criterias.get(prevChar)) {
                    result += criterias.get(roman.charAt(i)) - criterias.get(prevChar);
                    i--;
                } else {
                    result += criterias.get(roman.charAt(i));
                }
            } else {
                result += criterias.get(roman.charAt(i));
            }

        }
        this.arabicNumeral = result;
        return result;
    }
}
