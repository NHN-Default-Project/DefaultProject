package com.nhnacademy.parkminsu.Exercise3_4;

import java.util.Scanner;

public class Exercise3_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = change(scanner.nextLine());
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
        scanner.close();

    }

    public static String[] change(String str) {
        String[] methodStr = str.split(" |'");
        for (int i = 0; i < methodStr.length; i++) {
            String tmp = "";
            for (int j = 0; j < methodStr[i].length(); j++) {
                if (Character.isLetter(methodStr[i].charAt(j)) && methodStr[i].charAt(j) == '\'') { // && 연산자 사용해서 한줄로
                    // 표현하고 싶었으나 에러가 남;;
                    tmp += methodStr[i].charAt(j);
                }
            }
            methodStr[i] = tmp;
        }
        return methodStr;
    }
}
