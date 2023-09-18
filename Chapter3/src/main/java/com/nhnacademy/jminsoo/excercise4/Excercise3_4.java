package com.nhnacademy.jminsoo.excercise4;

import com.nhnacademy.jminsoo.textio.TextIO;

public class Excercise3_4 {
    public static void main(String[] args) {
        System.out.println("문자열을 입력해주세요.");
        String getStr = TextIO.getln();
        printString(getStr);
    }

    public static void printString(String getStr) {
        // String[] result = getStr.split(" ");

        // for (int i = 0; i < result.length; i++) {
        // result[i] = result[i].replaceAll("[^A-Za-z0-9]", "");
        // System.out.println(result[i]);
        // }

        for (int i = 0; i < getStr.length(); i++) {
            char ch = getStr.charAt(i);

            if (Character.isLetter(ch)) {
                System.out.print(ch);
            } else if (ch == ' ' || (ch == '\'')) {
                System.out.println();
            }

        }
    }
}
