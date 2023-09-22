package com.nhnacademy.yunhwa.Exercise2_4;

import java.util.Scanner;

public class Exercise2_4 {
    // 잔돈 계산하는 프로그램
    // 사용자가 가지고 있는 quarters, dimes, nickels, pennies 질문하기
    // 사용자에게 그가 가지고 있는 돈이 얼마인지를 dollars로 표시

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your quarters, dimes, nickels, pennies with each a space : ");

        int quarters = sc.nextInt();
        int dimes = sc.nextInt();
        int nickels = sc.nextInt();
        int pennies = sc.nextInt();

        double dollars = (quarters * 25 + dimes * 10 + nickels * 5 + pennies) / 100.0;

        System.out.println("your dollars is " + dollars);

        sc.close();
    }
}
