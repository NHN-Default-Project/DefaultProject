package com.nhnacademy.gaeun.exercise4;

import java.util.InputMismatchException;
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
                if(!isFinish(scanner)) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a real number");
            }
        }
    }
    public static boolean isFinish(Scanner scanner) {
        while(true) {
            System.out.println("Do you want to enter another equation? (yes or no)");
            String yesOrNo = scanner.nextLine();
            if(yesOrNo.equals("no")) {
                System.out.println("exit.");
                return false;
            } else if(!yesOrNo.equals("yes")){
                System.out.println("Please enter a valid value");
            } else {
                break;
            }
        }
        return true;
    }
}
