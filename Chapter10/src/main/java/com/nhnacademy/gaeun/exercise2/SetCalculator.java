package com.nhnacademy.gaeun.exercise2;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SetCalculator {
    private Jibhab A;
    private Jibhab B;
    private char operator;

    public void input(String inputCalculate) {
        try {
            Jibhab[] AandB = getJibhab(inputCalculate.trim());
            this.A = AandB[0];
            this.B = AandB[1];
            this.operator = bringOperator(inputCalculate.trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("식을 잘못입력했습니다!");
        }

    }

    private Jibhab[] getJibhab(String inputCalculate) {
        Jibhab[] result = new Jibhab[2];
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


    private Jibhab contentToJibhab(String content) {
        String validContent = validateContent(content);
        Set<String> newChar = Arrays.stream(validContent.split(",")).sorted()
                .collect(Collectors.toUnmodifiableSet());

        TreeSet<Integer> newSet = new TreeSet<>();
        for (String a : newChar) {
            newSet.add(Integer.parseInt(a));
        }
        return new Jibhab(newSet);
    }

    private String validateContent(String content) {
        Pattern pattern = Pattern.compile("^(\\d+(,\\s*\\d+)*)?$");
        Matcher matcher = pattern.matcher(content.substring(1, content.length() - 1).trim());
        String string = "";
        if (matcher.find()) {
            return matcher.group();
        } else {
            throw new IllegalArgumentException("정수가 아닌 수가 입력되었습니다.");
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
        return operator.charAt(0);
    }

    public void calculateJibhab() {
        switch (this.operator) {
            case '+':
                System.out.println(A.addAll(B).toString());
                return;
            case '-':
                System.out.println(A.removeAll(B).toString());
                return;
            case '*':
                System.out.println(A.retainAll(B).toString());
                return;
            default:
                throw new IllegalArgumentException("+, -, * 연산자를 사용해주세요!");
        }
    }
}
