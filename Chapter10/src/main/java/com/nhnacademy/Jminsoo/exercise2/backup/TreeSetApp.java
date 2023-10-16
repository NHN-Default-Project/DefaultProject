package com.nhnacademy.Jminsoo.exercise2.backup;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

public class TreeSetApp {

    SetFormula setFormula;

    //입력 받고 수식을 만들어주는 메서드
    public void readUserInputForSet(String input) {
        Set<Integer> firstSet;
        Set<Integer> secondSet;
        String expression = "";

        String str = input.replaceAll("\\s", "");

        try {
            TempSetFormula tempSetFormula = inputStringToTempFormula(str);

            firstSet = stringToSet(tempSetFormula.firstSetStr);

            expression = tempSetFormula.expressionStr;

            secondSet = stringToSet(tempSetFormula.secondSetStr);

            this.setFormula = new SetFormula(firstSet, expression, secondSet);

        } catch (StringIndexOutOfBoundsException | PatternSyntaxException | NumberFormatException
                 | ArithmeticException e) {
            throw new IllegalArgumentException("입력 값이 잘못되었습니다!");
        }
    }

    public void calculate() {
        if (this.setFormula == null) {
            throw new ArithmeticException("수식이 비어있습니다! 위치 : calculate");
        }

        Set<Integer> result = setFormula.calculate();

        System.out.printf("결과 값 : %s%n", result);
    }


    //String을 입력받아 Set으로 만들어주는 메서드
    private Set<Integer> stringToSet(String input) throws StringIndexOutOfBoundsException,
            PatternSyntaxException, NumberFormatException {
        Set<Integer> result = new HashSet<>();

        //괄호를 못찾을 시 StringIndexOutOfBoundsException 발생
        StringBuilder setStringBuilder = new StringBuilder(
                input.substring(
                        input.indexOf("[") + 1,
                        input.indexOf("]")));

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

    //String으로 만들어진 임시 수식을 만들어주는 메서드
    private TempSetFormula inputStringToTempFormula(String input) {
        String expression;
        if (input.contains("+")) {
            expression = "+";
        } else if (input.contains("-")) {
            expression = "-";
        } else if (input.contains("*")) {
            expression = "*";
        } else {
            throw new ArithmeticException("수식이 올바르지 않습니다! 문제 위치 : inputStringToTempFormula");
        }

        String firstSetStr = input.substring(0, input.indexOf(expression));
        String secondSetStr = input.substring(input.indexOf(expression) + 1);
        return new TempSetFormula(firstSetStr, expression, secondSetStr);
    }

    //임시용 Set수식
    private static class TempSetFormula {
        String firstSetStr;
        String expressionStr;
        String secondSetStr;

        public TempSetFormula(String firstSetStr, String expression, String secondSetStr) {
            this.firstSetStr = firstSetStr;
            this.expressionStr = expression;
            this.secondSetStr = secondSetStr;
        }

        @Override
        public String toString() {
            return firstSetStr + " " + expressionStr + " " + secondSetStr;
        }
    }

}
