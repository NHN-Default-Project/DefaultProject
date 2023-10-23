package com.nhnacademy.Jminsoo.exercise2;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySets {

    private static final Pattern numberPattern = Pattern.compile("\\d+");
    private static final Pattern correctSetPattern = Pattern.compile("^((\\[[0-9,]*\\][*+-])*)\\[[0-9,]*\\]$");

    private static final Pattern setFormulaPattern = Pattern.compile("\\[[0-9,\\]]+");
    private static final Pattern expressionPattern = Pattern.compile("[*+-]+");

    public static Set<Integer> stringToSetApply(String inputStr) {
        Set<Integer> result = new HashSet<>();
        Matcher matcher = numberPattern.matcher(inputStr);
        while (matcher.find()) {
            result.add(Integer.valueOf(matcher.group()));
        }

        return result;
    }


    public static SetFormula stringToSetFormulaApply(String inputStr) {
        if (!isExp(inputStr)) {
            throw new IllegalArgumentException("수식에 이상이 있습니다!");
        }

        inputStr = inputStr.replaceAll("\\s", "");
        SetFormula result = new SetFormula();

        Matcher matcher = expressionPattern.matcher(inputStr);
        while (matcher.find()) {
            result.addExp(matcher.group());
        }

        matcher = setFormulaPattern.matcher(inputStr);
        while (matcher.find()) {
            result.addSet(MySets.stringToSetApply(matcher.group()));
        }

        return result;
    }

    private static boolean isExp(String inputStr) {
        Matcher matcher = correctSetPattern.matcher(inputStr);
        return matcher.find();
    }

}
