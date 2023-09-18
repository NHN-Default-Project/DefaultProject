package com.nhnacademy.gaeun.exercise05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("달걀이 몇 개 있나요?");
        int eggBucket = scanner.nextInt();
        scanner.close();
        System.out.println("Your number of eggs is " + eggBucket / 144 + " gross, " +
                (eggBucket % 144) / 12 + " dozen, and " + (eggBucket % 144) / 12);
    }
}
