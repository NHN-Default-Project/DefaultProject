package com.nhnacademy.gaeun.exercise04;

import java.util.Scanner;

// 사용자가 자신의 변경 사항을 계산하는 데 도움이 되는 프로그램을 작성하세요. 
// 프로그램은 사용자가 가지고 있는 쿼터 수, 다임 수, 니켈 수, 페니 수를 질문해야 합니다. 
// 그런 다음 프로그램은 사용자에게 그가 가지고 있는 돈이 얼마인지를 달러로 표시해야 합니다.
//Quarter = 25 / Dime = 10 / Nickel = 5 / Penny = 1 센트
//1달러 = 100센트
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("가지고 있는 잔돈의 수를 입력해주세요.");
        int change = 0;

        System.out.print("Quarter = ");

        Cash[] cashArray = Cash.values();

        int cent = 0;

        for (int i = 0; i < cashArray.length; i++) {
            Cash cash = cashArray[i];
            System.out.printf("잔돈 %s 몇개?", cash.getName());
            cent += cash.calc(scanner.nextInt());
        }

        System.out.println(cent / 100.0);

        // System.out.println(Cash.Quarter.values());
        // change += Cash.valueOf(Cash.Quarter) * scanner.nextInt();

        // System.out.print("Dime= ");
        // change += Cash.valueOf(Cash.Dime) * scanner.nextInt();

        // System.out.print("Nickel = ");
        // change += Cash.valueOf(Cash.Nickel) * scanner.nextInt();

        // System.out.print("Penny = ");
        // change += Cash.valueOf(Cash.Penny) * scanner.nextInt();

        // scanner.close();
        // System.out.printf("사용자가 가지고 있는 잔돈은 %.3f dollar 입니다.", change / 100f);
        // System.out.println();
    }

}
