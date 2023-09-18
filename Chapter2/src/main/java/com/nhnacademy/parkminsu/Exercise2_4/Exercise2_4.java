package com.nhnacademy.parkminsu.Exercise2_4;

import java.util.Scanner;

public class Exercise2_4 {
    public static void main(String[] args) {
        // penny = 1cent, nickel = 5cent, dime = 10cent, quarter = 25cent, dollar =
        // 100cent

        Scanner scanner = new Scanner(System.in);

        System.out.printf("quarter? ");
        int money = scanner.nextInt() * Money.QUATER.getMoney();

        System.out.printf("dime? ");
        money += scanner.nextInt() * Money.DIME.getMoney();

        System.out.printf("nickel? ");
        money += scanner.nextInt() * Money.NICKEL.getMoney();

        System.out.printf("penny? ");
        money += scanner.nextInt() * Money.PENNY.getMoney();

        System.out.println("dollar :" + (money / 100.0));
        scanner.close();
    }
}
