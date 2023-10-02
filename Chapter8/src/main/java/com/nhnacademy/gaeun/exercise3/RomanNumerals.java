package com.nhnacademy.gaeun.exercise3;

public class RomanNumerals {
    private int[] critical = {1000, 900, 500, 400, 100, 90, 50, 40, 10 , 9, 5, 4, 1};
    private String[] critiNumeral = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private String romanNumeral;
    private int arabicNumeral;

    public RomanNumerals(int arabicNumeral) {
        if(arabicNumeral > 3999 || arabicNumeral < 0) {
            throw new NumberFormatException("0~3999까지의 숫자만 입력 가능합니다.");
        }
        this.arabicNumeral = arabicNumeral;
        arabicToRoman(arabicNumeral);
    }
    public RomanNumerals(String romanNumeral) {
        this.romanNumeral = romanNumeral;
        romanToArabic(romanNumeral);
    }
    public String getRomanNumeral() {
        return romanNumeral;
    }

    public int getArabicNumeral() {
        return arabicNumeral;
    }

    public void arabicToRoman(int intArabic) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < critical.length; i++) {
            if(critical[i] <= intArabic) {
                sb.append(critiNumeral[i].repeat(intArabic / critical[i]));
                intArabic = intArabic % critical[i];
            }
        }
        this.romanNumeral = sb.toString();
    }

    public void romanToArabic(String roman) {
        int result = 0;
        int i = 0;
        while(roman.length() != 0) {
            if(roman.contains(critiNumeral[i])) {
                roman = roman.substring(critiNumeral[i].length());
                result += critical[i];
            } else {
                i++;
            }
            if(i >= critiNumeral.length) {
                throw new NumberFormatException("로마 숫자로 입력해주세요.");
            }
        }
        this.arabicNumeral = result;
    }
}
