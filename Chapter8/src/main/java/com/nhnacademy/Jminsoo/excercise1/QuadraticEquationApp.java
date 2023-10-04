package com.nhnacademy.Jminsoo.excercise1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuadraticEquationApp {
    QuadraticEquation quadraticEquation;

    public void start() {
        boolean isContinue = true;
        double result = 0;
        String answer;
        Scanner scanner;
        while (isContinue) {
            try {

                scanner = new Scanner(System.in);
                this.quadraticEquation = new QuadraticEquation();

                this.quadraticEquation.quadraticEquation();
                try {
                    result = this.quadraticEquation.root();
                    System.out.printf("%s의 값 : %f%n", this.quadraticEquation.getFormula(), result);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

                System.out.print("계속 하시겠습니까? (y/n) : ");
                answer = scanner.nextLine();

                if (answer.equals("n")) {
                    break;
                }
            } catch (IllegalStateException | NoSuchElementException e) {
                scanner = new Scanner(System.in);
                continue;
            }
        }

    }
}
