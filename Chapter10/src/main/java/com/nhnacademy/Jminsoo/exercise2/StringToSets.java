package com.nhnacademy.Jminsoo.exercise2;

import java.util.HashSet;
import java.util.Set;

public class StringToSets {
    public static Set<Integer> stringToSetApply(String inputStr) {

        Set<Integer> result = new HashSet<>();

        //괄호를 못찾을 시 StringIndexOutOfBoundsException 발생
        StringBuilder setStringBuilder = new StringBuilder(
                inputStr.substring(
                        inputStr.indexOf("[") + 1,
                        inputStr.indexOf("]")));

        //,을 못찾을 시 PatternSyntaxException 발생
        //숫자가 아닐시 NumberFormatException 발생
        for (String number : setStringBuilder.toString().split(",")) {
            int integerNum = Integer.parseInt(number);
            if (integerNum < 0) {
                throw new NumberFormatException("값이 0보다 작습니다!");
            }
            result.add(integerNum);
        }

        return result;
    }

    public static SetFormula stringToSetFormulaApply(String inputStr) {
        StringBuilder setStr; //[1,2,3]의 형태의 set이 들어가는 변수
        StringBuilder expression; //
        StringBuilder sb = new StringBuilder(inputStr);
        SetFormula result = new SetFormula();

        //초기값 삽입

        setStr = new StringBuilder(sb.substring(0, sb.indexOf("]") + 1));
        result.addSet(stringToSetApply(setStr.toString()));
        sb.delete(0, sb.indexOf("]") + 1);


        while (sb.length() > 0) {
            if (sb.toString().contains("+")) {
                expression = new StringBuilder("+");
            } else if (sb.toString().contains("-")) {
                expression = new StringBuilder("-");
            } else if (sb.toString().contains("*")) {
                expression = new StringBuilder("*");
            } else {
                throw new ArithmeticException("수식이 올바르지 않습니다! 문제 위치 : inputStringToTempFormula");
            }
            result.addExp(expression.toString());
            sb.delete(0, 1);

            setStr = new StringBuilder(sb.substring(0, sb.indexOf("]") + 1));
            result.addSet(stringToSetApply(setStr.toString()));
            sb.delete(0, sb.indexOf("]") + 1);
        }
        return result;
    }

}
