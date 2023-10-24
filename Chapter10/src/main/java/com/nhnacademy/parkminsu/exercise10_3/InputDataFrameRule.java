package com.nhnacademy.parkminsu.exercise10_3;

import com.nhnacademy.parkminsu.exercise10_3.exception.DataEntryFormatException;
import com.nhnacademy.parkminsu.exercise10_3.exception.NegativeNumException;

import java.util.regex.Pattern;

public class InputDataFrameRule {
    private InputDataFrameRule() {
    }

    public static boolean isCheckHashTableDataFrame(String string) {
        Pattern pattern = Pattern.compile("^[a-zA-Z가-힣0-9]* [a-zA-z가-힣0-9]*$");
        return pattern.matcher(string).find();
    }

    public static void isCheckNegativeNum(String string) throws NegativeNumException {
        if (isNegativeNum(string)) {
            throw new NegativeNumException("음수를 입력하셨습니다.");
        }

    }

    public static void isCheckStringDataFrame(String string) throws DataEntryFormatException {
        if (!isStringDataFrame(string)) {
            throw new DataEntryFormatException("데이터를 잘못 입력하셨습니다");
        }
    }

    private static boolean isStringDataFrame(String string) {
        Pattern pattern = Pattern.compile("^[a-zA-Z가-힣0-9]*");
        return pattern.matcher(string).find();
    }

    private static boolean isNegativeNum(String inputData) {
        return Integer.parseInt(inputData) < 0;
    } // size입력 시 음수이면 안되므로

}
