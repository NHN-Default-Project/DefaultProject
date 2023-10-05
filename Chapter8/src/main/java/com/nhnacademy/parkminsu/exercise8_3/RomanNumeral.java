package com.nhnacademy.parkminsu.exercise8_3;

import java.util.regex.Pattern;

public class RomanNumeral {
    // 문자열에서 로마 숫자를 생성, 법적인 로마 숫자가 아닌 경우 Exception 던져야함
    // 다른 생성자는 1 ~ 3999인 로마 숫자 생성
    //
    private RomanNumeralNotion romanNumeralNotation;
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

    private void preconditonArabicNumeral(int arabicNumeral) {
        final int arabicNumeralStartNum = 1;
        final int arabicNumeralEndNum = 3999;
        if (arabicNumeral < arabicNumeralStartNum || arabicNumeral > arabicNumeralEndNum) {
            throw new NumberFormatException("범위 내의 숫자를 입력해주세요");
        }
    }

    private void preconditionRomanNumeral(String romanNumeral) {
        int sameNumberOfCharacters = 0;
        for (char romanNumChar : romanNumeral.toCharArray()) {
            for (RomanNumeralNotion ro : RomanNumeralNotion.values()) {
                if (ro.name().equals(String.valueOf(romanNumChar))) {
                    System.out.println(ro.name());
                    sameNumberOfCharacters++;
                }
            }
        }
        if (sameNumberOfCharacters != romanNumeral.length()) {
            throw new NumberFormatException("잘못된 문자열을 입력하셨습니다.");
        }
    }

    private void preconditionDuplicateCount(String romanNumeral) {
        String regex = "(\\w)\\1\\1\\1"; // 중복 문자 확인
        if (Pattern.compile(regex).matcher(romanNumeral).find()) {
            throw new IllegalArgumentException("중복된 문자가 4개이상 입력하셨습니다.");
        }
    }

    public boolean isCheckLastIndexOfCharacter(int currentIndex, char[] arrayChar) {
        if (currentIndex < arrayChar.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public int calculateArabicNum(int currentArabicNum, char currentChar, char nextChar) {
        if (RomanNumeralNotion.valueOf(String.valueOf(currentChar)).compareTo(RomanNumeralNotion.valueOf(String.valueOf(nextChar))) > 0) {
            currentArabicNum -= RomanNumeralNotion.valueOf(String.valueOf(currentChar)).getRomanNum();
        } else {
            currentArabicNum += RomanNumeralNotion.valueOf(String.valueOf(currentChar)).getRomanNum();
        }
        return currentArabicNum;
    }

    public void convertRomanToArabic() { // 로마 숫자 -> 아라비아 숫자 3999
        char[] romanNumChar = this.romanNumeral.toCharArray();
        int arabicNum = 0;
        for (int i = 0; i < romanNumChar.length; i++) {
            if (isCheckLastIndexOfCharacter(i, romanNumChar)) {
                arabicNum = calculateArabicNum(arabicNum, romanNumChar[i], romanNumChar[i + 1]);
            } else {
                arabicNum = calculateArabicNum(arabicNum, romanNumChar[i], romanNumChar[i]);
            }
        }
        this.arabicNumeral = arabicNum;
    }

    public void convertArabicToRoman() { // 아라비아 숫자 -> 로마 숫자
        StringBuilder stringBuilder = new StringBuilder();
        for (RomanNumeralNotion ro : RomanNumeralNotion.values()) {
            convertArabicNumToEquivalentRomanNum(stringBuilder, ro, ro.getRomanNum());
        }

        // 로마 숫자를 변환하기 전 조건에 충족이 되는지 precondition으로 한번 확인
        preconditionRomanNumeral(stringBuilder.toString());
        preconditionDuplicateCount(stringBuilder.toString());
        this.romanNumeral = stringBuilder.toString();
    }

    public void convertArabicNumToEquivalentRomanNum(StringBuilder stringBuilder, RomanNumeralNotion romanNumeralNotion, int romanValueIdx) {
        int loppCnt = 0;
        while (this.arabicNumeral >= romanValueIdx && loppCnt < 3) {
            stringBuilder.append(romanNumeralNotion.name());
            this.arabicNumeral -= romanValueIdx;
            loppCnt++;
        }
    }

    public String getRomanNumeral() { // toString
        return this.romanNumeral;
    }

    public int getArabicNumeral() { // toInt메소드
        return this.arabicNumeral;
    }

}