package com.nhnacademy.parkminsu.exercise8_4;

import java.util.Scanner;

public class Exercise8_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Expr expration;
        double val;
        String userInputNum;
        while (true) {
            try {
                System.out.println("표현식 입력(빈 칸 입력시 종료)");
                String inputExpr = scanner.nextLine().trim();
                if (inputExpr.isEmpty()) {
                    System.out.println("프로그램 종료");
                    break;
                }
                expration = new Expr(inputExpr);
                while (true) {
                    try {
                        System.out.println("숫자를 입력하시오(빈 칸 입력 시 종료)");
                        userInputNum = scanner.nextLine();
                        if (userInputNum.isEmpty()) {
                            break;
                        }
                        val = expration.value(Double.parseDouble(userInputNum));
                        if (Double.isNaN(val)) {
                            System.out.println("val은 Nan");
                        } else {
                            System.out.println("입력한 값: " + userInputNum);
                            System.out.println("수식: " + expration.toString() + "= " + val);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }

                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
