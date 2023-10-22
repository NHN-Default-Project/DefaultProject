package com.nhnacademy.gaeun.exercise2;

import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SetCalculator {
    private TreeSet<Integer> A;
    private TreeSet<Integer> B;
    private char operator;

    public SetCalculator() {
        A = new TreeSet<>();
        B = new TreeSet<>();
    }

    public boolean input(String inputCalculate) {
        try {
            TreeSet<Integer>[] AandB = bringTwoJibhab(inputCalculate.trim());
            this.A = AandB[0];
            this.B = AandB[1];
            this.operator = bringOperator(inputCalculate.trim());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("식을 잘못입력했습니다!");
            return false;
        }

    }

    private TreeSet<Integer>[] bringTwoJibhab(String inputCalculate) {
        TreeSet<Integer>[] result = new TreeSet[2];
        int index = 0;
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(inputCalculate);
        while (matcher.find()) {
            String content = matcher.group();
            result[index] = contentToJibhab(content.replaceAll("\\s+", ""));
            index++;
        }
        return result;
    }


    private TreeSet<Integer> contentToJibhab(String content) {
        String validContent = validateContent(content);
        Set<String> newChar = Arrays.stream(validContent.split(","))
                .collect(Collectors.toUnmodifiableSet());

        TreeSet<Integer> newSet = new TreeSet<>();
        for (String a : newChar) {
            newSet.add(Integer.parseInt(a));
        }
        return newSet;
    }

    private String validateContent(String content) {
        Pattern pattern = Pattern.compile("^(\\d+(,\\s*\\d+)*)?$");
        Matcher matcher = pattern.matcher(content.substring(1, content.length() - 1).trim());
        if (matcher.find()) {
            return matcher.group();
        } else {
            throw new IllegalArgumentException("양의 정수를 입력해주세요!");
        }
    }

    private char bringOperator(String inputCalculate) {
        Pattern pattern = Pattern.compile("\\](.*?)\\[");
        Matcher matcher = pattern.matcher(inputCalculate);
        String middleValue = "";
        String operator = "";
        if (matcher.find()) {
            middleValue = matcher.group();
        } else {
            throw new IllegalArgumentException("연산자가 아닌 값들이 입력되었습니다.");
        }
        middleValue = middleValue.substring(1, middleValue.length() - 1).trim();
        pattern = Pattern.compile("[+*\\-]");
        matcher = pattern.matcher(middleValue);
        while (matcher.find()) {
            operator = matcher.group();
        }
        System.out.println(operator.charAt(0));
        return operator.charAt(0);
    }

    public void calculateJibhab() {
        if(this.operator == 0){
            return;
        }
        switch (this.operator) {
            case '+':
                A.addAll(B);
                System.out.println(A);
                return;
            case '-':
                A.removeAll(B);
                System.out.println(A);
                return;
            case '*':
                A.retainAll(B);
                System.out.println(A);
                return;
            default:
                throw new IllegalArgumentException("+, -, * 연산자를 사용해주세요!");
        }
    }
}
