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

                beforeInputPrintInformation();
                makeTwoSetAndOperator(sc.nextLine());
                printCalculationResult(calculateResult());

                if (! isUserWantToBeContinued(sc)) {
                    sc.close();
                    break;
                }
            } catch (NegativeIntegerException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean isUserWantToBeContinued(Scanner sc) {
        System.out.println("계속 입력하시겠습니까? NO 입력하시면 종료 아니면 TO BE CONTINUED ");
        String continueFlag = sc.nextLine().trim().toLowerCase();
        if (continueFlag.equals("no")) {
            return false;
        }
        return true;
    }

    public TreeSet<Integer> calculateResult() {
        switch (this.operator) {
            case '+':
                this.setA.addAll(this.setB);
                return this.setA;
            case '*':
                this.setA.retainAll(this.setB);
                return this.setA;
            case '-':
                this.setA.removeAll(this.setB);
                return this.setA;
            default:
                throw new NoSuchElementException("(여기 들어오지 않게 미리 처리했지만 혹시 모르니) 계산하는 중 존재해서는 안되는 연산자가 들어왔습니다.");
        }
    }

    public void printCalculationResult(TreeSet<Integer> resultSet) {

        System.out.println("-------------------------------");
        System.out.println("집합 A : " + this.setA);
        System.out.println("집합 B : " + this.setB);
        System.out.println("-------------------------------");

        switch (this.operator) {
            case '+':
                System.out.println("합집합 : " + resultSet);
                break;
            case '*':
                System.out.println("교집합 : " + resultSet);
                break;
            case '-':
                System.out.println("차집합 : " + resultSet);
                break;
        }

        System.out.println("-------------------------------");
    }

    public static void beforeInputPrintInformation() {
        System.out.println();
        System.out.println("0 이상의 정수 집합 2개를 만들고 두 개의 합집합, 교집합, 차집합을 구하려고 합니다.");
        System.out.println("0 이상의 정수 집합 2개와 연산자를 아래의 형식에 맞게 입력해주세요 \n");
        System.out.println("------------------------------------------------------------");
        System.out.println("      [입 력 형 식 : 쉼표는 필수, 공백은 선택적]                  \n");
        System.out.println(" 집합 입력 형식 :  [1,2,3]   or   [17, 42, 9, 53, 108]        \n");
        System.out.println(" 전체 입력 형식 :  [1, 2, 3] * [3,  5,  7]                    \n");
        System.out.println("------------------------------------------------------------");
        System.out.println("위의 전체 입력 형식에 맞게 입력해주세요 [ 연산자 : + - * ]");
    }

    public void makeTwoSetAndOperator(String line) throws NegativeIntegerException, IllegalArgumentException {
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

    public void makeOneNumAndAddToSet(StringBuilder sb, boolean isSetBStart) throws NegativeIntegerException {
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
