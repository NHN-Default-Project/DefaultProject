package com.nhnacademy.gaeun.exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise10_2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                StringBuilder inputLine = new StringBuilder();
                inputUser(br, inputLine);
                if(!isCalculateJibhab(inputLine)) {
                    continue;
                }

                if(isFinish(br)) {
                    break;
                }
            }
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isFinish(BufferedReader br) throws IOException {
        System.out.println("다시 입력 하실 건가요? 맞으면 yes를, 아니면 아무 키나 누르고 종료됩니다.");
        if(br.readLine().trim().toLowerCase().equals("yes")) {
            return false;
        }
        return true;
    }

    public static void inputUser(BufferedReader br, StringBuilder inputLine) {
        while (true) {
            try {
                System.out.println();
                System.out.println("집합 A와 B의 연산식을 입력해주세요.");
                System.out.println("ex. [1, 2, 4] + [2, 3, 4]");
                System.out.println("연산은 합집합(+), 교집합(*), 차집합(-)을 사용할 수 있습니다.");
                inputLine.replace(0, inputLine.length(), br.readLine());
                break;
            } catch (IOException | ArrayIndexOutOfBoundsException e) {
                System.out.println("잘못 입력되었습니다. 다시 입력해주세요!");
            }
        }
    }

    private static boolean isCalculateJibhab(StringBuilder inputLine) {
        try {
            SetCalculator setCalculator = new SetCalculator();
            setCalculator.input(inputLine.toString());
            setCalculator.calculateJibhab();
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
