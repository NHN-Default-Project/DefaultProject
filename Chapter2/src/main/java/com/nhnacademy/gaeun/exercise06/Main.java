package com.nhnacademy.gaeun.exercise06;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("성과 이름을 공백으로 구분하여 입력하세요.");
        String firstName = scanner.next();
        String lastName = scanner.next();
        scanner.close();

        System.out.println("귀하의 이름은 " + firstName + "(" + firstName.length() + "자) 입니다.");
        System.out.println("성은 " + lastName + "(" + lastName.length() + "자) 입니다.");
        System.out.println("이니셜은 " + firstName.substring(0, 1) + lastName.substring(0, 1) + " 입니다.");

    }
}
