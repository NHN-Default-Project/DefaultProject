package com.nhnacademy.Jminsoo.exercise2;

import java.util.Set;
import java.util.regex.PatternSyntaxException;

public class TreeSets {

    private SetFormula setFormula; //Set형이 담기는 클래스

    public TreeSets() {
        this.setFormula = new SetFormula();
    }

    //입력 받고 수식을 만들어주는 메서드
    public void stringToSet(String input) {
        this.setFormula = new SetFormula();

        //공백 제거 (\t, \n 포함)
        String inputStr = input.replaceAll("\\s", "");
        try {
            this.setFormula = MySets.stringToSetFormulaApply(inputStr);
        } catch (StringIndexOutOfBoundsException | PatternSyntaxException | NumberFormatException
                 | ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public void calculate() {
        if (this.setFormula == null) {
            throw new ArithmeticException("수식이 비어있습니다! 위치 : calculate");
        }

        Set<Integer> result = setFormula.calculate();
        System.out.printf("결과 값 : %s%n", result);
    }
}
