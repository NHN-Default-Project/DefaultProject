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
        double varX = 0.0;
        double result;
        String expression;
        do {
            try {
                System.out.print("수식을 입력하시오 : ");
                expression = scanner.nextLine();
                this.func = new Expr(expression);
                System.out.print("수식의 값을 입력하시오 : ");
                result = this.func.value(varX);
                varX = Double.parseDouble(scanner.nextLine());
                System.out.printf("수식의 값 : %.3f %n", result);
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자를 입력해주세요!");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("올바른 수식을 입력해주세요!");
                System.out.println(e.getMessage());
            }
        } while (isContinue());
    }

    private boolean isContinue() {
        System.out.printf("계속 하시겠습니까? (y/n) : ");
        try {
            String answer = scanner.nextLine();
            return answer.equals("y") || answer.equals("Y");
        } catch (IllegalStateException | NoSuchElementException e) {
            System.out.println("다시 입력해주세요!");
            return true;
        }
    }

}
