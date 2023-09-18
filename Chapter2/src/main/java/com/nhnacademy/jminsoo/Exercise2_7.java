package com.nhnacademy.jminsoo;

import com.nhnacademy.jminsoo.textio.TextIO;

public class Exercise2_7 {
    public static void main(String[] args) {
        TextIO.readFile("JeongMinsoo/week1/Chapter 2/testdata.txt");

        String name = TextIO.getln();
        int[] grades = { TextIO.getInt(), TextIO.getInt(),
                TextIO.getInt() };
        System.out.printf("학생 이름 : %s\n", name);
        System.out.printf("1번쨰 점수 : %d\n", grades[0]);
        System.out.printf("2번쨰 점수 : %d\n", grades[1]);
        System.out.printf("3번쨰 점수 : %d\n", grades[2]);
    }

}
