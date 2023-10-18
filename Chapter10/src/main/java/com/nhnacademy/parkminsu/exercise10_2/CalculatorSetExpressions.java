package com.nhnacademy.parkminsu.exercise10_2;

import java.util.Queue;
import java.util.Set;

public class CalculatorSetExpressions {
    // 두 집합이 아닌 집합의 계산
    // 제네릭으로 타입 상관없이 집합계산
    // 공백 제거된 수식 들어옴
    //TODO setSplit 활용


    public Set<String> calculate(Expression expression) { // 계산하는 메소드
        SetOfFormula set = new SetOfFormula();
        set.divideSetOfFormula(expression); // Queue 형태 수식
        Queue<Set> queue = set.getSetOfFormulaElement();
        Queue<String> operation = set.getOperationElementQueue();

        Set<String> resultSet = queue.poll();
        while (!queue.isEmpty()) {
            String op = operation.poll();
            Set<String> newSet = queue.poll();
            resultSet = calculatorSet(resultSet, newSet, op);
        }

        return resultSet; // return type set
    }

    public Set calculatorSet(Set resultSet, Set calculateSet, String op) {
        switch (op) {
            case "+":
                resultSet.addAll(calculateSet);
                return resultSet;
            case "*":
                resultSet.retainAll(calculateSet);
                return resultSet;
            case "-":
                resultSet.removeAll(calculateSet);
                return resultSet;
            default:
                System.out.println(op);
                throw new IllegalArgumentException("연산이 되지않았습니다");
        }
    }

}
