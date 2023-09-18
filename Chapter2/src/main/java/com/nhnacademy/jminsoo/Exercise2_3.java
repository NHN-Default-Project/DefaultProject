package com.nhnacademy.jminsoo;

import java.util.Scanner;

public class Exercise2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hi. What's you're name? : ");
        String name = scanner.nextLine();

        System.out.printf("Hello %s, Nice to meet you\n", name.toUpperCase());
    }
}
