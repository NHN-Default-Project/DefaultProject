package com.nhnacademy.Jminsoo.exercise2;

import java.util.Set;

public class TreeSets {

    private SetFormula setFormula; //Set형이 담기는 클래스

    public TreeSets() {
        this.setFormula = new SetFormula();
    }

    //입력 받고 수식을 만들어주는 메서드
    public void stringToSet(String input) {
        this.setFormula = new SetFormula();
        try {
            this.setFormula = MySets.stringToSetFormulaApply(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void calculate() {
        Set<Integer> result = setFormula.calculate();

        System.out.printf("결과 값 : %s%n", result);
    }
}
