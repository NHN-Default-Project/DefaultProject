package com.nhnacademy.jminsoo;

import java.util.Scanner;

public class Exercise2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] coins = new double[3];

        System.out.println("가진 돈을 천원 단위로 표기하겠습니다.");

        System.out.print("10을 몇개 갖고 있습니까? : ");
        coins[0] = Double.parseDouble(scanner.nextLine());

        System.out.print("100원을 몇개 갖고 있습니까? : ");
        coins[1] = Double.parseDouble(scanner.nextLine());

        System.out.print("500원을 몇개 갖고 있습니까? : ");
        coins[2] = Double.parseDouble(scanner.nextLine());

        System.out.printf("천원 단위로 환산할 경우, %.2f 천원입니다.",
                (coins[0] * 10.0 + coins[1] * 100.0 + coins[2] * 500.0) / 1000.0);
    }
}
