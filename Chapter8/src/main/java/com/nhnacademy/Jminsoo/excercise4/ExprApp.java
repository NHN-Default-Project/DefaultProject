package com.nhnacademy.Jminsoo.excercise4;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExprApp {
    private Scanner scanner;
    private Expr func;

    public ExprApp() {
        this.scanner = new Scanner(System.in);
        this.func = null;
    }


    public void start() {
        double varX;
        double result;
        String expression;
        String answer;
        while (true) {
            try {
                System.out.print("수식을 입력하시오 : ");
                expression = scanner.nextLine();
                this.func = new Expr(expression);
                System.out.print("수식의 값을 입력하시오 : ");
                varX = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자를 입력해주세요!");
                System.out.println(e.getMessage());
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println("올바른 수식을 입력해주세요!");
                System.out.println(e.getMessage());
                continue;
            }
            result = this.func.value(varX);

            if (Double.isNaN(result)) {
                System.out.println("수식에 문제가 있습니다!");
            } else {
                System.out.printf("수식의 값 : %.3f %n", result);
            }
            while (true) {
                try {
                    System.out.printf("계속 하시겠습니까? (y/n) : ");
                    answer = scanner.nextLine();
                    if (answer.equals("n") || answer.equals("y")) {
                        break;
                    } else {
                        System.out.println("다시 입력해주세요!");
                    }
                } catch (IllegalStateException | NoSuchElementException e) {
                    System.out.println("다시 입력해주세요!");
                }
            }
            if (answer.equals("n")) {
                break;
            }
        }
    }
}
