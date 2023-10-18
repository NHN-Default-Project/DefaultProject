package com.nhnacademy.yunhwa.exercise10_2;

import java.util.Scanner;
import java.util.TreeSet;

public class SetCalculator {
    static TreeSet<Integer> setA;
    static TreeSet<Integer> setB;
    static char operator;

    public SetCalculator() {
        setA = new TreeSet<>();
        setB = new TreeSet<>();
    }

    public static void run() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                setA = new TreeSet<>();
                setB = new TreeSet<>();

                beforeInputPrintInformation();
                makeTwoSetAndOperator(sc.nextLine());
                printCaculationResult();

                if (! isUserWantToBeContinued(sc)) {
                    sc.close();
                    break;
                }
            } catch (NegativeIntegerException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static boolean isUserWantToBeContinued(Scanner sc) {
        System.out.println("계속 입력하시겠습니까? NO 입력하시면 종료 아니면 TO BE CONTINUED ");
        String continueFlag = sc.nextLine().trim().toLowerCase();
        if (continueFlag.equals("no")) {
            return false;
        }
        return true;
    }

    public static void printCaculationResult() {

        System.out.println("-------------------------------");
        System.out.println("집합 A : " + setA);
        System.out.println("집합 B : " + setB);
        System.out.println("-------------------------------");

        switch (operator) {
            case '+':
                setA.addAll(setB);
                System.out.println("합집합 : " + setA);
                break;
            case '*':
                setA.retainAll(setB);
                System.out.println("교집합 : " + setA);
                break;
            case '-':
                setA.removeAll(setB);
                System.out.println("차집합 : " + setA);
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

    public static void makeTwoSetAndOperator(String line) throws NegativeIntegerException, IllegalArgumentException {
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
                operator = c;
                isSetBStart = true;

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

    public static void makeOneNumAndAddToSet(StringBuilder sb, boolean isSetBStart) throws NegativeIntegerException {
        int num = Integer.parseInt(sb.toString());

        if (num < 0) {
            throw new NegativeIntegerException("음의 정수가 입력되었습니다. 0 이상의 정수만 처리하는 집합 계산기입니다. 0 이상의 정수로 다시 입력해주세요");
        }

        if (isSetBStart) {
            setB.add(num);
        } else {
            setA.add(num);
        }
    }

}
