package com.nhnacademy.Jminsoo.exercise1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuadraticEquation {
    private int inputNumA;
    private int inputNumB;
    private int inputNumC;

    Scanner scanner;

    public QuadraticEquation(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getFormula() {
        return String.format("%dx^2 +%dx + %d = ", this.inputNumA, this.inputNumB, this.inputNumC);
    }

    public void calculate() {
        try {
            String[] str = this.scanner.nextLine().split(" ");
            this.inputNumA = Integer.parseInt(str[0]);
            this.inputNumB = Integer.parseInt(str[1]);
            this.inputNumC = Integer.parseInt(str[2]);
        } catch (IllegalArgumentException | NoSuchElementException | IllegalStateException |
                 ArrayIndexOutOfBoundsException e) {

            System.out.println("올바른 값을 입력해주세요!");
        }

    }

    public double root()
            throws IllegalArgumentException {

        this.calculate();

        if (this.inputNumA == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        } else {
            double disc = this.inputNumB * this.inputNumB - 4 * this.inputNumA * this.inputNumC;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return (-this.inputNumB + Math.sqrt(disc)) / (2 * this.inputNumA);
        }
    }
}
