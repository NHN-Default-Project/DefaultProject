package com.nhnacademy.yunhwa.exercise10_2;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;

public class SetCalculator {
    private TreeSet<Integer> setA;
    private TreeSet<Integer> setB;
    private char operator;

    public SetCalculator() {
        this.setA = new TreeSet<>();
        this.setB = new TreeSet<>();
    }

    public void run() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                this.setA.clear();
                this.setB.clear();

                ConsoleUserInterface consoleUserInterface = new ConsoleUserInterface();

                consoleUserInterface.beforeInputPrintInformation();
                makeTwoSetAndOperator(sc.nextLine());

                TreeSet<Integer> originA = new TreeSet<>(setA);
                TreeSet<Integer> resultSet = CalculateSet.calculateResult(setA, setB, operator);

                ConsoleUserInterface.printCalculationResult(resultSet, originA, setB, operator);

                if (! consoleUserInterface.isUserWantToBeContinued(sc)) {
                    sc.close();
                    break;
                }
            } catch (NegativeIntegerException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void makeTwoSetAndOperator(String line) throws NegativeIntegerException, IllegalArgumentException {
        char[] lineChr = line.toCharArray();

        boolean openBracket = false;
        boolean isSetBStart = false;

        StringBuilder sb = new StringBuilder();

        for (char c : lineChr) {
            if (c == '[') {
                openBracket = true;

            } else if (c == ']') {
                makeOneNumAndAddToSet(sb, isSetBStart);
                sb.setLength(0);
                openBracket = false;

            } else if (c == '+' || c == '*' || c == '-') {
                if (openBracket) { // 집합 안의 값이 음수인 경우 -> 존재하면 안되는 경우
                    sb.append(c); // 일단 부호 넣어주고 num 만들어지는 부분에서 처리
                } else {
                    this.operator = c;
                    isSetBStart = true;
                }

            } else if (Character.isDigit(c)) {
                if (openBracket) {
                    sb.append(c);
                }

            } else if (c == ',') {
                if (openBracket) {
                    makeOneNumAndAddToSet(sb, isSetBStart);
                    sb.setLength(0);
                }

            } else if (c != ' ') {
                throw new IllegalArgumentException("잘못된 문자가 들어왔습니다. 식을 잘못 적으신 것 같아요. 입력 형식에 맞춰 다시 입력해주세요");
            }
        }
    }

    private void makeOneNumAndAddToSet(StringBuilder sb, boolean isSetBStart) throws NegativeIntegerException {
        int num = Integer.parseInt(sb.toString());

        if (num < 0) {
            throw new NegativeIntegerException("음의 정수가 입력되었습니다. 0 이상의 정수만 처리하는 집합 계산기입니다. 0 이상의 정수로 다시 입력해주세요");
        }

        if (isSetBStart) {
            this.setB.add(num);
        } else {
            this.setA.add(num);
        }
    }

}
