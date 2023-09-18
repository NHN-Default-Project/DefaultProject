package com.nhnacademy.jminsoo.temp;

import java.util.Scanner;

public class Exercise2_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuffer sbuf = new StringBuffer(str);
        sbuf.replace(0, 1, str.substring(str.length() - 1, str.length()));
        sbuf.replace(str.length() - 1, str.length(), str.substring(0, 1));

        System.out.println(sbuf.toString());
        scanner.close();

    }
}