package com.nhnacademy.yunhwa.exercise8_3;

public class RomanNumeral {
    private String romanNumeral;
    private int arabicNumeral;
    final private StandardRomanNumerals standard;


    // 생성자 1 : String 파라미터
    public RomanNumeral(String romanNumStr) {
        checkValidRoman(romanNumStr);

        this.romanNumeral = romanNumStr;
        this.arabicNumeral = 0;
        standard = new StandardRomanNumerals();
    }

    // 위의 생성자 1 에서 사용되는 로마 문자 체크 메서드
    public void checkValidRoman(String romanNumStr) {
        char[] romanChars = romanNumStr.toCharArray();
        for (char romanChar : romanChars) {
            if (!(romanChar == 'M' || romanChar == 'D' || romanChar == 'C' || romanChar == 'L' ||
                    romanChar == 'X' || romanChar == 'V' || romanChar == 'I')) {
                throw new NumberFormatException("합법적인 로마 숫자가 아닙니다. M, D, C, L, X, V, I 로 구성된 문자열을 입력해주세요");
            }
        }
    }



    // 생성자 2 : int 파라미터
    public RomanNumeral(int romanNumInt) {
        checkValidRomanInt(romanNumInt);

        this.romanNumeral = "";
        this.arabicNumeral = romanNumInt;
        standard = new StandardRomanNumerals();
    }

    // 위의 생성자 2 에서 사용되는 로마 숫자 체크 메서드
    public void checkValidRomanInt(int romanNumInt) {
        if (romanNumInt < 1 || romanNumInt > 3999) {
            throw new NumberFormatException("1 ~ 3999 범위 내에서만 로마 숫자를 생성할 수 있습니다. 범위에 맞게 값을 다시 넣어주세요");
        }
    }





    // int 를 String 으로 변환
    public String toString() {
        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < standard.arabicNumList.size(); i++) {
            roman = subtractAmount(i, roman);
        }

        this.romanNumeral = roman.toString();
        return this.romanNumeral;
    }

    // 위의 toString() 메서드 내에서 활용하는 메서드
    public StringBuilder subtractAmount(int idx, StringBuilder roman) {
        while (this.arabicNumeral >= standard.arabicNumList.get(idx)) {
            roman.append(standard.romanNumList.get(idx));
            this.arabicNumeral -= standard.arabicNumList.get(idx);
        }
        return roman;
    }




    // String 을 int 로 변환
    public int toInt() {

        char[] romanChars = this.romanNumeral.toCharArray();
        boolean isbeforeCombi = false;

        for (int i = 1; i < romanChars.length; i++) {

            int currentValue = standard.ROMAN_NUMERALS.get(String.valueOf(romanChars[i]));
            int previousValue = standard.ROMAN_NUMERALS.get(String.valueOf(romanChars[i - 1]));


            // 이전 값보다 현재 값이 더 크다면 차 값을 더하기
            if (previousValue < currentValue) {
                this.arabicNumeral += currentValue - previousValue;
                isbeforeCombi = true;
            } else { // 내림 차순이 아닌데
                if (!isbeforeCombi) { // 이전에 조합 안되었다면 이전 값을 더하기
                    this.arabicNumeral += previousValue;
                } else {
                    isbeforeCombi = false;
                    // 이전에 조합이 됐다면 이전 값 추가할 필요가 없음. 다음으로.
                }
            }
        }

        // 맨 마지막 값이 처리가 안된 경우 처리 해주기
        if (!isbeforeCombi) {
            this.arabicNumeral += standard.ROMAN_NUMERALS.get(String.valueOf(romanChars[romanChars.length - 1]));
        }

        return this.arabicNumeral;
    }

    public void check
}
