package com.nhnacademy.Jminsoo.exercise2;

import java.util.*;
import java.util.regex.PatternSyntaxException;

public class TreeSetApp {

    SetFormula setFormula; //Set형이 담기는 클래스
    TempSetFormulas tempSetFormulas; //[1,2,3]의 형태의 수식을 받는 임시 클래스

    public TreeSetApp() {
        this.tempSetFormulas = new TempSetFormulas();
        this.setFormula = new SetFormula();
    }

    //입력 받고 수식을 만들어주는 메서드
    public void readUserInputForMakeSet(String input) {
        Set<Integer> set;
        String expression = "";

        //공백 제거 (\t, \n 포함)
        String str = input.replaceAll("\\s", "");

        try {
            //
            inputStringToTempFormula(str);

            set = stringToSet(Objects.requireNonNull(this.tempSetFormulas.setStrList.poll())); //@Objects.requireNonNull :poll값이 null이 아니도록 해줌
            this.setFormula.addSet(set);

            while (!this.tempSetFormulas.setStrList.isEmpty()) {
                expression = this.tempSetFormulas.expressionStrList.poll();

                set = stringToSet(Objects.requireNonNull(this.tempSetFormulas.setStrList.poll()));

                this.setFormula.addExp(expression);
                this.setFormula.addSet(set);
            }
        } catch (StringIndexOutOfBoundsException | PatternSyntaxException | NumberFormatException
                 | ArithmeticException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void calculate() {
        if (this.setFormula == null) {
            throw new ArithmeticException("수식이 비어있습니다! 위치 : calculate");
        }

        Set<Integer> result = setFormula.calculate();

        System.out.printf("결과 값 : %s%n", result);
    }


    //String을 입력받아 Set으로 만들어주는 메서드
    private Set<Integer> stringToSet(String input) throws StringIndexOutOfBoundsException,
            PatternSyntaxException, NumberFormatException {
        Set<Integer> result = new HashSet<>();

        //괄호를 못찾을 시 StringIndexOutOfBoundsException 발생
        StringBuilder setStringBuilder = new StringBuilder(
                input.substring(
                        input.indexOf("[") + 1,
                        input.indexOf("]")));

        //,을 못찾을 시 PatternSyntaxException 발생
        //숫자가 아닐시 NumberFormatException 발생
        for (String number : setStringBuilder.toString().split(",")) {
            int integerNum = Integer.parseInt(number);
            if (integerNum < 0) {
                throw new NumberFormatException("값이 0보다 작습니다!");
            }
            result.add(integerNum);
        }

        return result;
    }

    //String으로 만들어진 임시 수식을 만들어주는 메서드
    private void inputStringToTempFormula(String input) {
        StringBuilder setStr; //[1,2,3]의 형태의 set이 들어가는 변수
        StringBuilder expression; //
        StringBuilder sb = new StringBuilder(input);

        //초기값 삽입

        setStr = new StringBuilder(sb.substring(0, sb.indexOf("]") + 1));
        this.tempSetFormulas.addSet(setStr.toString());

        while (sb.length() > 0) {
            if (sb.toString().contains("+")) {
                expression = new StringBuilder("+");
            } else if (sb.toString().contains("-")) {
                expression = new StringBuilder("-");
            } else if (sb.toString().contains("*")) {
                expression = new StringBuilder("*");
            } else {
                throw new ArithmeticException("수식이 올바르지 않습니다! 문제 위치 : inputStringToTempFormula");
            }
            this.tempSetFormulas.addExp(expression.toString());
            sb.delete(0, 1);

            setStr = new StringBuilder(sb.substring(0, sb.indexOf("]") + 1));
            sb.delete(0, sb.indexOf("]") + 1);
            this.tempSetFormulas.addSet(setStr.toString());
        }
    }

    //임시용 Set수식
    private static class TempSetFormulas {

        //[1,2,3] 의 형태로 저장되는 큐
        Queue<String> setStrList;
        //수식만 저장되는 큐
        Queue<String> expressionStrList;

        public TempSetFormulas() {
            this.setStrList = new LinkedList<>();
            this.expressionStrList = new LinkedList<>();
        }

        public void addExp(String exp) {
            this.expressionStrList.add(exp);
        }

        public void addSet(String set) {
            this.setStrList.add(set);
        }
    }

}
