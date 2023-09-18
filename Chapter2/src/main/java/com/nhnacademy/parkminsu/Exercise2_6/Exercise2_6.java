package com.nhnacademy.parkminsu.Exercise2_6;

import com.nhnacademy.parkminsu.textio.TextIO;
import java.util.Scanner;

public class Exercise2_6 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your first name and last name, separaterd by a space.");
            System.out.printf("? ");
            Name str = new Name(TextIO.getlnString());
            // str.indexOf(" ")를 하면 공백까지 문자열이 포함이 되므로 +- 1를 해주었음
            System.out.printf("Your first is name is %s, which has %s characters\n", str.getFirst(),
                    str.getFirst().length());
            System.out.printf("Your last is name is %s, which has %s characters", str.getSecond(),
                    str.getSecond().length());
            System.out.printf("Your initials are %s\n", str.initials());

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("빈값을 입력했습니다.");
        }
    }
}