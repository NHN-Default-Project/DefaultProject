package com.nhnacademy.main.exercise10_2;

import java.util.Queue;
import java.util.Set;

public class CalculatorSetExpressions {

    public Set<String> calculate(Expression expression) { // 계산하는 메소드
        SetOfFormula set = new SetOfFormula();
        set.divideSetOfFormula(expression); // Queue 형태 수식
        Queue<Set<String>> queue = set.getSetOfFormulaElementQueue();
        Queue<String> operation = set.getOperationElementQueue();

        Set<String> resultSet = queue.poll();
        while (!queue.isEmpty()) {
            String op = operation.poll();
            Set<String> newSet = queue.poll();
            resultSet = calculatorSet(resultSet, newSet, op);
        }

        return resultSet; // return type set
    }

    /**
     * 해당 Operator에 따른 집합의 계산 구현
     * + * - 제외한 연산자가 들어오면 연산이 되지 않는다는 Throw를 던져줌
     * <p>
     * return : 계산이 끝난 집합을 반환, 만약 해당 연산자가 없어 연산을 못했다면 Throw를 던짐
     */

    private Set<String> calculatorSet(Set<String> resultSet, Set<String> calculateSet, String op) {
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
