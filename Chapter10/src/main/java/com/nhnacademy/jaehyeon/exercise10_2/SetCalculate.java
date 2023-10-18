package com.nhnacademy.jaehyeon.exercise10_2;

import java.util.Set;

public class SetCalculate {
    private final ExpressionProcessing expressionProcessing;
    private Set<Integer> result;

    public SetCalculate(ExpressionProcessing expressionProcessing) {
        this.expressionProcessing = expressionProcessing;
        operationSet(this.expressionProcessing);
    }

    public void operationSet(ExpressionProcessing expressionProcessing) {

        switch (expressionProcessing.getOperator()) {
            case "+":
                calculateUnion(expressionProcessing.getFirstNumberSet(),
                        expressionProcessing.getSecondNumberSet());
                break;
            case "*":
                calculateIntersection(expressionProcessing.getFirstNumberSet(),
                        expressionProcessing.getSecondNumberSet());
                break;
            case "-":
                calculateDifference(expressionProcessing.getFirstNumberSet(),
                        expressionProcessing.getSecondNumberSet());
                break;
        }

    }

    private void calculateUnion(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result;
        result = first;
        result.addAll(second);
        this.result = result;
    }

    private void calculateIntersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result;
        result = first;
        result.retainAll(second);
        this.result = result;
    }

    private void calculateDifference(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result;
        result = first;
        result.removeAll(second);
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(operationName()).append(" 계산결과 : ").append(result.toString());
        return sb.toString();
    }

    public String operationName() {
        String result = "";
        switch (this.expressionProcessing.getOperator()) {
            case "*":
                result = "교집합";
                break;
            case "+":
                result = "합집합";
                break;
            case "-":
                result = "차집합";
                break;
        }

        return result;
    }
}
