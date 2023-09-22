package com.nhnacademy.parkminsu.Exercise2_3;

import java.util.Scanner;

public class Exercise2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("What you are name? ");
        String userName = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < userName.length(); i++) {
            if (userName.charAt(i) >= 'a' && userName.charAt(i) <= 'z') {
                stringBuilder.append((char) (userName.charAt(i) - ('a' - 'A')));
            }
        }
        System.out.printf("Hello, %s nice to meet you!\n", stringBuilder);
        scanner.close();
    }
}
