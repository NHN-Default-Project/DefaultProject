package com.nhnacademy.yunhwa.exercise10_2;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

public class CalculateSet {

    private CalculateSet() {
    }

    public static TreeSet<Integer> calculateResult(TreeSet<Integer> setA, TreeSet<Integer> setB, char operator) {
        switch (operator) {
            case '+':
                setA.addAll(setB);
                return setA;
            case '*':
                setA.retainAll(setB);
                return setA;
            case '-':
                setA.removeAll(setB);
                return setA;
            default:
                throw new NoSuchElementException("계산하는 중 존재해서는 안되는 연산자가 들어왔습니다.");
        }
    }
}
