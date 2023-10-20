package com.nhnacademy.parkminsu.exercise10_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetOfFormula {
    private final Queue<Set<String>> setOfFormulaElementQueue;
    private final Queue<String> operationElementQueue;

    public SetOfFormula() {
        this.setOfFormulaElementQueue = new LinkedList<>();
        this.operationElementQueue = new LinkedList<>();
    }

    public void divideSetOfFormula(Expression expression) {
        Set<String> resultSet = new TreeSet<>();
        String op = "";

        Matcher matcher = findDataMatchingRegex(expression.getExpression()); // strig.split("[|]
        while (matcher.find()) { // 수식
            if (isOperation(matcher.group())) {
                this.setOfFormulaElementQueue.add(resultSet);
                op = matcher.group(); // +, - *, String 형태로 나옴
                this.operationElementQueue.add(op);
                resultSet = new TreeSet<>(); // 기존 값 초기화
            } else {
                resultSet.add(matcher.group());
            }
        }
        this.setOfFormulaElementQueue.add(resultSet);
    }

    public boolean isOperation(String op) {
        return op.equals("*") || op.equals("-") || op.equals("+");
    }

    public static Matcher findDataMatchingRegex(String str) {
        Pattern pattern = Pattern.compile("[0-9*+-]+");
        return pattern.matcher(str);
    }

    public Queue<Set<String>> getSetOfFormulaElementQueue() {
        return this.setOfFormulaElementQueue;
    }

    public Queue<String> getOperationElementQueue() {
        return this.operationElementQueue;
    }
}
