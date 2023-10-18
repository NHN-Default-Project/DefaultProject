package com.nhnacademy.jaehyeon.exercise10_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String regex = "\\[" + //    \\[ , \\] : [와 ] 를 나타낸다
                "\\s*" +       //     \\s* : 공백문자의 0 회 이상의 발생을 나타냄
                "\\d+" +       //      \\d : 하나 이상의 숫자 (0-9) 를 나타냄
                "\\s*" +       //       \\s* : 공백문자의 0 회 이상의 발생을 나타냄
                "(,\\s*\\d+\\s*)*]";    // , 쉼표로 구분된 숫자를 나타낸다.
        //  쉼표로 구분된 숫자가 0 회 이상 반복되는 것을 나타낸다 따라서 숫자와 쉼표의 반복되는 패턴을 나타냄

        String a = "[1,23 ,43, 54,211,     224343 , 1231242    ]";


        String regex1 = "\\[\\s*\\d+\\s*(,\\s*\\d+\\s*)*\\]\\s*[+*-]\\s*\\[\\s*\\d+\\s*(,\\s*\\d+\\s*)*\\]";
        ;


        String ah = "[1,23 ,43, 54,211,     224343 , 1231242    ] + [132,4123, 53,12]";
        String c = "[1, 2, 3] + [3, 5, 7]";

        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher1 = pattern.matcher(c);
        System.out.println(matcher1.matches());


    }
}