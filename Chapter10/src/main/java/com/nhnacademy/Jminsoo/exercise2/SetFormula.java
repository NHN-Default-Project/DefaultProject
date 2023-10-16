package com.nhnacademy.Jminsoo.exercise2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SetFormula {
    private Queue<Set<Integer>> setQueue;
    private Queue<String> expressionQueue;

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
            switch (this.expressionQueue.poll()) {
                case "+":
                    result.addAll(this.setQueue.poll());
                    break;
                case "-":
                    result.removeAll(this.setQueue.poll());
                    break;

                case "*":
                    result.retainAll(this.setQueue.poll());
                    break;

                default:
                    throw new ArithmeticException("잘못된 수식입니다!");
            }
        }

        return result;
    }

}
