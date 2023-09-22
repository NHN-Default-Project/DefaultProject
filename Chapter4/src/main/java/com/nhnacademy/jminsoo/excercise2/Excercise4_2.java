package com.nhnacademy.jminsoo.excercise2;

import java.util.Scanner;

public class Excercise4_2 {
    private static final int HEX = 16;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("16진수 값을 입력해주세요 : ");

        String hexNum = scanner.next();
        int result = 0;
        try {
            for (int i = 0; i < hexNum.length(); i++) {
                result = result * HEX + Number.hexValue(hexNum.charAt(i));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("10진수 변환 값 : " + result);
    }


}
