package com.nhnacademy.Jminsoo.exercise2;

import java.util.*;

public class SetFormula {
    private final Queue<Set<Integer>> setQueue;
    private final Queue<String> expressionQueue;

    public SetFormula() {
        this.setQueue = new LinkedList<>();
        this.expressionQueue = new LinkedList<>();
    }

    public void addSet(Set<Integer> set) {
        this.setQueue.add(set);
    }

    public void addExp(String exp) {
        this.expressionQueue.add(exp);
    }

    public Set<Integer> calculate() {
        Set<Integer> result;
        result = this.setQueue.poll();
        while (!this.setQueue.isEmpty()) {
            switch (Objects.requireNonNull(this.expressionQueue.poll())) {
                case "+":
                    Objects.requireNonNull(result).addAll(Objects.requireNonNull(this.setQueue.poll()));
                    break;
                case "-":
                    Objects.requireNonNull(result).removeAll(Objects.requireNonNull(this.setQueue.poll()));
                    break;
                case "*":
                    Objects.requireNonNull(result).retainAll(Objects.requireNonNull(this.setQueue.poll()));
                    break;
                default:
                    throw new ArithmeticException("잘못된 수식입니다!");
            }
        }
        
        return Objects.requireNonNullElseGet(result, HashSet::new);
    }

}
