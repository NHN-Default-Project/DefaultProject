package com.nhnacademy.Jminsoo.excercise1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuadraticEquation {
    private int A;
    private int B;
    private int C;

    public String getFormula() {
        return String.format("%dx^2 +%dx + %d = ", this.A, this.B, this.C);
    }

    public void quadraticEquation() {
        System.out.print("2차 방정식의 수식을 적으시오 (Ax^2 + Bx + C) 중 A, B, C  : ");

        try {
            Scanner scanner = new Scanner(System.in);
            String[] str = scanner.nextLine().split(" ");
            this.A = Integer.parseInt(str[0]);
            this.B = Integer.parseInt(str[1]);
            this.C = Integer.parseInt(str[2]);
        } catch (NumberFormatException | NoSuchElementException | IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("올바른 값을 입력해주세요!");
        }


    }

    public double root()
            throws IllegalArgumentException {
        if (this.A == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        } else {
            double disc = this.B * this.B - 4 * this.A * this.C;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return (-this.B + Math.sqrt(disc)) / (2 * this.A);
        }
    }
}
