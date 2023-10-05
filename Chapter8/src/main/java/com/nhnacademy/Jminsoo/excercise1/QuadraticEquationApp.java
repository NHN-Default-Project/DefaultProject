package com.nhnacademy.Jminsoo.excercise1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuadraticEquationApp {
    QuadraticEquation quadraticEquation;
    Scanner scanner;

    public QuadraticEquationApp() {
        this.scanner = new Scanner(System.in);
        this.quadraticEquation = new QuadraticEquation(scanner);
    }

    public void start() {
        double result = 0;
        do {
            try {
                try {
                    System.out.print("2차 방정식의 수식을 적으시오 (Ax^2 + Bx + C) 중 A, B, C  : ");
                    result = this.quadraticEquation.root();
                    System.out.printf("%s의 값 : %.2f%n", this.quadraticEquation.getFormula(), result);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } catch (IllegalStateException | NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        } while (isRepeat());
        this.scanner.close();
    }

    private boolean isRepeat() {
        System.out.print("계속 하시겠습니까? (y/n) : ");
        String answer = this.scanner.nextLine();
        return !answer.equals("n");
    }

}
