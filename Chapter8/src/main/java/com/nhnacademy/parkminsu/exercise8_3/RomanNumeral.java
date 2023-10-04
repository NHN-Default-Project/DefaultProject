package com.nhnacademy.parkminsu.exercise8_3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumeral {
    // 문자열에서 로마 숫자를 생성, 법적인 로마 숫자가 아닌 경우 Exception 던져야함
    // 다른 생성자는 1 ~ 3999인 로마 숫자 생성
    //
    private final String[] romanNumeralNotation = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private final int[] romanNumeralValue = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private int arabicNumeral;
    private String romanNumeral;

    public RomanNumeral(int arabicNumerals) {
        preconditonArabicNumeral(arabicNumerals);

        this.arabicNumeral = arabicNumerals;
    }

    public RomanNumeral(String romanNumeral) {
        this.romanNumeral = romanNumeral.toUpperCase().trim();
        preconditionRomanNumeral(this.romanNumeral);
        preconditionDuplicateCount(this.romanNumeral);

    }

    public void preconditonArabicNumeral(int arabicNumeral) {
        int arabicNumeralStartNum = 1;
        int arabicNumeralEndNum = 3999;
        if (arabicNumeral < arabicNumeralStartNum || arabicNumeral > arabicNumeralEndNum) {
            throw new NumberFormatException("범위 내의 숫자를 입력해주세요");
        }
    }

    public void preconditionRomanNumeral(String romanNumeral) {
        int sameNumberOfCharacters = 0;
        for (char romanNumChar : romanNumeral.toCharArray()) {
            for (int i = 0; i < this.romanNumeralNotation.length; i++) {
                if (this.romanNumeralNotation[i].equals(String.valueOf(romanNumChar))) {
                    sameNumberOfCharacters++;
                }
            }
        }
        if (sameNumberOfCharacters != romanNumeral.length()) {
            throw new NumberFormatException("잘못된 문자열을 입력하셨습니다.");
        }
    }

    public void preconditionDuplicateCount(String romanNumeral) {
        int sameNumberOfCharactersCount = 0;
        char[] romanNumChar = romanNumeral.toCharArray();

        String regex = "(\\w)\\1\\1\\1";
        Matcher m;
        m = Pattern.compile(regex).matcher(romanNumeral);
        if (m.find()) {
            throw new IllegalArgumentException("중복된 문자가 4개이상 입력하셨습니다.");
        }


    }


    public int findSameRomanNumeralIdx(char romanNumeral) {
        int sameIdx = 0;
        for (int j = 0; j < this.romanNumeralNotation.length; j++) {
            if (this.romanNumeralNotation[j].equals(String.valueOf(romanNumeral))) {
                sameIdx = j;
            }
        }
        return sameIdx;
    }

    public void convertRomanToArabic() { // 로마 숫자 -> 아라비아 숫자
        char[] romanNumChar = this.romanNumeral.toCharArray();
        int arabicNum = 0;
        for (int i = 0; i < romanNumChar.length; i++) {
            int idx = findSameRomanNumeralIdx(romanNumChar[i]);
            int nextCharIdx = idx;
            if (i < romanNumChar.length - 1) {
                nextCharIdx = findSameRomanNumeralIdx(romanNumChar[i + 1]);
                // 다음 문자가 클경우 빼는 경우
                // ==========
            }
            if (this.romanNumeralValue[idx] < romanNumeralValue[nextCharIdx]) {
                arabicNum -= this.romanNumeralValue[idx];
            } else {
                arabicNum += this.romanNumeralValue[idx];
            }
        }
        // 로마 숫자에서 아라비아 숫자로 변환 할 때 3999값을 넘기면 안되므로
        // 아라비아 숫자의 precondition으로 사용했던 메소드를 로마 숫자 -> 아라비아 숫자 변환 했을 때의 postcondition으로 사용함

        this.arabicNumeral = arabicNum;
    }

    public void convertArabicToRoman() { // 아라비아 숫자 -> 로마 숫자
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.romanNumeralNotation.length; i++) {
            convertArabicNumToEquivalentRomanNum(stringBuilder, i);
        }
        // 로마 숫자를 변환하기 전 조건에 충족이 되는지 precondition으로 한번 확인
        preconditionRomanNumeral(stringBuilder.toString());
        preconditionDuplicateCount(stringBuilder.toString());
        this.romanNumeral = stringBuilder.toString();
    }

    public void convertArabicNumToEquivalentRomanNum(StringBuilder stringBuilder, int romanValueIdx) {
        int cnt = 0;
        while (this.arabicNumeral >= this.romanNumeralValue[romanValueIdx] && cnt < 3) {
            System.out.println(cnt);
            stringBuilder.append(this.romanNumeralNotation[romanValueIdx]);
            this.arabicNumeral -= this.romanNumeralValue[romanValueIdx];
            cnt++;
        }
    }

    public String getRomanNumeral() { // toString
        return this.romanNumeral;
    }

    public int getArabicNumeral() { // toInt메소드
        return this.arabicNumeral;
    }

}