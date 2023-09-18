package com.nhnacademy.jminsoo;

import java.util.Scanner;

public class Exercise2_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("계란의 개수를 입력해주세요 : ");
        int eggs = Integer.parseInt(scanner.nextLine());

        int grossEggs = eggs / 144;
        eggs -= (grossEggs * 144);
        int dozenEggs = eggs / 12;
        eggs -= (dozenEggs * 12);

        System.out.printf("계란의 수는 총 %d gross Of Eggs, %d Dozen of eggs, %d개입니다.", grossEggs, dozenEggs, eggs);
    }

}
