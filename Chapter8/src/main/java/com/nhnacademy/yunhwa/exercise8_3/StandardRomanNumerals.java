package com.nhnacademy.yunhwa.exercise8_3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StandardRomanNumerals {
    final List<String> romanNumList;
    final List<Integer> arabicNumList;
    final HashMap<String, Integer> ROMAN_NUMERALS;

    public StandardRomanNumerals() {

        // 배열로 만들고
        final String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        final Integer[] arabicNumerals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        // 접근 용이하게 리스트로 변환
        romanNumList = Arrays.asList(romanNumerals);
        arabicNumList = Arrays.asList(arabicNumerals);


        // 로마 숫자와 아라비아 숫자 대응 맵 만들기
        ROMAN_NUMERALS = new HashMap<>();

        for (int i = 0; i < romanNumerals.length; i++) {
            this.ROMAN_NUMERALS.put(romanNumerals[i], arabicNumerals[i]);
        }
    }

}
