package com.nhnacademy.main.exercise10_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetOfFormula {
    private final Queue<Set<String>> setOfFormulaElementQueue;
    private final Queue<String> operationElementQueue;
    private static final Pattern pattern = Pattern.compile("[0-9*+-]+");

    public SetOfFormula() {
        this.setOfFormulaElementQueue = new LinkedList<>();
        this.operationElementQueue = new LinkedList<>();
    }

    /**
     * expression 문자열을 연산자에 따라 문자열 분리
     * 집합만 저장하는 queue와 연산자만 저장하는 queue를 사용하여 데이터 분리
     */
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

    /**
     * 들어온 문자열이 *, -, + 연산자인지 판별
     * <p>
     * return 해당하는 연산자가 맞으면 true, 아니면 false반환
     */
    private boolean isOperation(String op) {
        return op.equals("*") || op.equals("-") || op.equals("+");
    }

    private Matcher findDataMatchingRegex(String str) {
        return pattern.matcher(str);
    }

    public Queue<Set<String>> getSetOfFormulaElementQueue() {
        return this.setOfFormulaElementQueue;
    }

    public Queue<String> getOperationElementQueue() {
        return this.operationElementQueue;
    }
}
