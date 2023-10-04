package com.nhnacademy.gaeun.exercise4;

import java.util.Scanner;

/*
* https://math.hws.edu/javanotes/c8/exercises.html
* you should write a program that lets the user enter an expression.
* If the expression contains an error, print an error message.
 */

public class Exercise8_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Please enter the expression you desire");
                String func = scanner.nextLine();
                Expr expr = new Expr(func);

                System.out.println("Please enter the value for x.");
                double value = scanner.nextDouble();
                System.out.println(expr.value(value));
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
