package com.nhnacademy.main.exercise10_2;

import com.nhnacademy.main.exercise10_2.exception.ExpressionEntryFormatException;

import java.util.regex.Pattern;

public class Expression {
    // 수식
    // 입력값이 입력 형태로 잘 들어왔는지 판단
    // 해당 수식이 문제가 없는지 판단
    //
    private final String expression;
    private static final Pattern pattern = Pattern.compile("[0-9*+-]+");


    public Expression(String expression) throws ExpressionEntryFormatException {
        isCheckTheEnterFormulaFormat(expression); // 입력한 수식이 수식의 형태에 맞는지 판단
        this.expression = expression;
    }


    private boolean isEnterFormulaFormat(String str) {
        // 해당 정규식에서 음수도 판별
        return pattern.matcher(str).find();
    }

    private void isCheckTheEnterFormulaFormat(String expression) throws ExpressionEntryFormatException {
        if (!isEnterFormulaFormat(expression)) {
            throw new ExpressionEntryFormatException("잘못된 수식을 입력했습니다.");
        }
    }


    public String getExpression() {
        return expression;
    }
}
