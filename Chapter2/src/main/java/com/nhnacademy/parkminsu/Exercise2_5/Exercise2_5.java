package com.nhnacademy.parkminsu.Exercise2_5;

import java.util.Scanner;

public class Exercise2_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Egg egg = new Egg(scanner.nextInt());
        System.out.printf("Your number of egg is %d gross, %d dozen, and %d", egg.getGross(), egg.getDozen(),
                egg.getNum());
        scanner.close();
    }
}