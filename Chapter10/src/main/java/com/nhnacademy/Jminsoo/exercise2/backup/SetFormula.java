package com.nhnacademy.Jminsoo.exercise2.backup;

import java.util.HashSet;
import java.util.Set;

public class SetFormula {
    private Set<Integer> firstSet;
    private String expression;
    private Set<Integer> secondSet;

    private SetFormula() {

    }

    public SetFormula(Set<Integer> firstSet, String expression, Set<Integer> secondSet) {
        this.firstSet = firstSet;
        this.expression = expression;
        this.secondSet = secondSet;
    }

    public Set<Integer> calculate() {
        Set<Integer> result = new HashSet<>(firstSet);

        switch (expression) {
            case "+":
                result.addAll(secondSet);
                break;
            case "-":
                result.removeAll(secondSet);
                break;

            case "*":
                result.retainAll(secondSet);
                break;

            default:
                throw new ArithmeticException("잘못된 수식입니다!");
        }

        return result;
    }

    @Override
    public String toString() {
        return firstSet
                + expression + secondSet;
    }

}
