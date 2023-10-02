package com.nhnacademy.gaeun.exercise1;

import java.util.Scanner;

/*
 * https://math.hws.edu/javanotes/c8/exercises.html
 *
 */
public class Exercise8_1 {
    /**
     * Returns the larger of the two roots of the quadratic equation
     * A*x*x + B*x + C = 0, provided it has any roots.  If A == 0 or
     * if the discriminant, B*B - 4*A*C, is negative, then an exception
     * of type IllegalArgumentException is thrown.
     */
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
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                int C = scanner.nextInt();
                System.out.println("answer: " + root(A, B, C));

                System.out.println("Do you want to enter another equation?");
                if(scanner.next().equals("no")) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}
