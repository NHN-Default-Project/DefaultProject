package com.nhnacademy.yunhwa.exercise10_2;

import java.util.List;

public class CheckingStandards {

    private CheckingStandards() {
    }

    public static void checkNegativeIntegerBySetCount(String line, List<String> tmpSets) throws NegativeIntegerException {
        int count = 0;
        for (char c : line.toCharArray()) {
            if (c == '[') {
                count++;
            }
        }

        if (tmpSets.size() != count) {
            throw new NegativeIntegerException("음의 정수가 입력되었습니다. "
                    + "0 이상의 정수만 처리하는 집합 계산기입니다. 0 이상의 정수로 다시 입력해주세요");
        }
    }

    public static void checkValidInput(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                throw new IllegalArgumentException("0 이상의 정수 집합 연산에 맞지 않게 알파벳이나 한글이 들어왔습니다. 다시 입력해주세요");
            }
        }
        if (!input.contains("[") || !input.contains("]")) {
            throw new IllegalArgumentException("집합을 의미하는 대괄호가 존재하지 않습니다. 연산이 불가능한 표현식이니 다시 입력해주세요");
        }
    }

    public static void checkNegativeInteger(int num) throws NegativeIntegerException {
        if (num < 0) {
            throw new NegativeIntegerException("음의 정수가 입력되었습니다. "
                    + "0 이상의 정수만 처리하는 집합 계산기입니다. 0 이상의 정수로 다시 입력해주세요");
        }
    }
}
