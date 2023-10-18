package com.nhnacademy.gaeun.exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise10_2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder inputLine = new StringBuilder();
            while (true) {
                if (inputUser(br, inputLine)) {
                    if (calculateJibhab(inputLine)) {
                        break;
                    }
                }
            }
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean inputUser(BufferedReader br, StringBuilder inputLine) {
        try {
            System.out.println();
            System.out.println("집합 A와 B의 연산식을 입력해주세요.");
            System.out.println("ex. [1, 2, 4] + [2, 3, 4]");
            System.out.println("연산은 합집합(+), 교집합(*), 차집합(-)을 사용할 수 있습니다.");

            inputLine.replace(0, inputLine.length(), br.readLine());
        } catch (IOException e) {
            System.out.println("잘못 입력되었습니다. 다시 입력해주세요!");
            return false;
        }
        return true;
    }

    private static boolean calculateJibhab(StringBuilder inputLine) {
        try {
            SetCalculator setCalculator = new SetCalculator();
            setCalculator.input(inputLine.toString());
            setCalculator.calculateJibhab();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
