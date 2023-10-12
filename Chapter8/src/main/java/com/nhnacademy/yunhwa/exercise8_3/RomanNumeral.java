package com.nhnacademy.yunhwa.exercise8_3;

import java.util.Map;
import java.util.regex.Pattern;

public class RomanNumeral {
    private String romanNumeral;
    private int arabicNumeral;


    // 생성자 1 : String 파라미터
    public RomanNumeral(String romanNumStr) {
        checkLegalRoman(romanNumStr);
        checkExcessiveRepeatingChar(romanNumStr);

        this.romanNumeral = romanNumStr;
        this.arabicNumeral = 0;
    }

    // 위의 생성자 1 에서 사용되는
    // 합법적인 로마 문자 체크 메서드
    public void checkLegalRoman(String romanNumStr) {
        char[] romanChars = romanNumStr.toCharArray();
        for (char romanChar : romanChars) {
            if (! StandardRomanNumerals.BASIC_ROMAN.contains(String.valueOf(romanChar))) {
                throw new NumberFormatException(romanChar + " 은 합법적인 로마 숫자가 아닙니다. M, D, C, L, X, V, I 로 구성된 문자열을 입력해주세요");
            }
        }
    }

    // 위의 생성자 1 에서 사용되는
    // 동일한 문자의 반복이 4번 이상인지 체크하는 메서드
    public void checkExcessiveRepeatingChar(String romanStr) {
        // 방법 1. 정규표현식 활용해 find 로 한 번에 찾는 방법
        String regex = "(M{4,}|D{4,}|C{4,}|L{4,}|X{4,}|V{4,}|I{4,})";
        if (Pattern.compile(regex).matcher(romanStr).find()) {
            throw new NumberFormatException("동일한 문자의 반복이 4번 이상인 것은 표준 로마 숫자에서 허용되지 않습니다. 다시 입력해주세요.");
        }

        // 방법 2. 방법 1과 같은 정규표현식 활용해, for 문으로 matches() 로 하나하나 비교하는 방법
//        char[] romanChars = romanStr.toCharArray();
//        for (int i = 0; i < romanChars.length - 3; i++) {
//            if (Pattern.compile(regex).matcher(romanStr.substring(i, i+4)).matches()) {
//                throw new NumberFormatException("동일한 문자의 반복이 4번 이상인 것은 표준 로마 숫자에서 허용되지 않습니다. 다시 입력해주세요.");
//            }
//        }

        // 방법 3. 범용 정규표현식 활용해 find 로 한 번에 찾는 방법
//        String regex2 = "(\\w)\\1\\1\\1";
//        if (Pattern.compile(regex2).matcher(romanStr).find()) {
//            throw new NumberFormatException("동일한 문자의 반복이 4번 이상인 것은 표준 로마 숫자에서 허용되지 않습니다. 다시 입력해주세요.");
//        }

        // ============== 참고 ===================
        // 동일한 문자의 반복은 최대 3번까지만 사용할 수 있고,
        // 4번 이상의  반복된 문자를 나타내기 위해서는 작은 값을 큰 값 앞에 놓고 그 차이만큼 큰 값을 더해야 한다.
        // 예를 들어, "IV"는 4를 나타내며, "IX"는 9를 나타낸다.
        // ======================================
    }




    // 생성자 2 : int 파라미터
    public RomanNumeral(int romanNumInt) {
        checkValidRomanInt(romanNumInt);

        this.romanNumeral = "";
        this.arabicNumeral = romanNumInt;
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

        for (int arabicNum : StandardRomanNumerals.ROMAN_NUMERALS.values()) {
            roman = subtractAmount(arabicNum, roman);
        }

        this.romanNumeral = roman.toString();
        return this.romanNumeral;
    }


    // 위의 toString() 메서드 내에서 활용하는 메서드
    public StringBuilder subtractAmount(int arabicNum, StringBuilder roman) {
        while (this.arabicNumeral >= arabicNum) {
            for (Map.Entry<String, Integer> entry : StandardRomanNumerals.ROMAN_NUMERALS.entrySet()) {
                if (entry.getValue().equals(arabicNum)) {
                    roman.append(entry.getKey());
                }
            }
            this.arabicNumeral -= arabicNum;
        }
        return roman;
    }





    // String 을 int 로 변환
    public int toInt() {

        char[] romanChars = this.romanNumeral.toCharArray();
        boolean isbeforeCombi = false;

        for (int i = 1; i < romanChars.length; i++) {

            int currentValue = StandardRomanNumerals.ROMAN_NUMERALS.get(String.valueOf(romanChars[i]));
            int previousValue = StandardRomanNumerals.ROMAN_NUMERALS.get(String.valueOf(romanChars[i - 1]));


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
            this.arabicNumeral += StandardRomanNumerals.ROMAN_NUMERALS.get(String.valueOf(romanChars[romanChars.length - 1]));
        }

        return this.arabicNumeral;
    }


}
