package com.nhnacademy.gaeun.exercise1;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * https://math.hws.edu/javanotes/c8/exercises.html
 * Returns the larger of the two roots of the quadratic equation
 * A*x*x + B*x + C = 0, provided it has any roots.  If A == 0 or
 * if the discriminant, B*B - 4*A*C, is negative, then an exception
 * of type IllegalArgumentException is thrown.
 */

public class Exercise8_1 {
    public static double root(double A, double B, double C) throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        } else {
            double disc = B * B - 4 * A * C;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return (-B + Math.sqrt(disc)) / (2 * A);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("Input values of A, B, C");
                double A = scanner.nextDouble();
                double B = scanner.nextDouble();
                double C = scanner.nextDouble();
                System.out.println("answer: " + root(A, B, C));

                scanner.nextLine();
                if(!isFinish(scanner)) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("실수값을 입력해주세요!");
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
