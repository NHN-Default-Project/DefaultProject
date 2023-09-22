package com.nhnacademy.yunhwa.Exercise2_6;

import java.util.Scanner;

public class Exercise2_6 {
    // String 클래스의 서브루틴 일부 테스트 프로그램
    // 프로그램은 사용자에게 이름과 성을 공백으로 구분하여 입력하도록 요청
    // TextIO.getIn() 을 사용하여 사용자의 응답을 읽기
    // 입력 문자열을 두 개의 문자열로 나누기 : 하나는 이름을 포함하고 다른 하나는 성을 포함
    // indexOf() 활용하여 공백의 위치를 찾고 substring()을 사용하여 두 이름을 각각 추출
    // 각 이름의 문자 수와 사용자의 이니셜도 출력 - 이니셜 : 이름의 첫 글자 + 성의 첫 글자

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter your first name and last name, separated by a space.");
        System.out.print("? ");
        String tmpStr = sc.nextLine();

        int spaceIndex = tmpStr.indexOf(" ");
        String firstName = tmpStr.substring(0, spaceIndex);
        String lastName = tmpStr.substring(spaceIndex + 1);
        String initialName = firstName.substring(0, 1) + lastName.substring(0, 1);

        System.out.println("Your first name is " + firstName + ", which has " + firstName.length() + " characters");
        System.out.println("Your last name is " + lastName + ", which has " + lastName.length() + " characters");
        System.out.println("Your initials are " + initialName);

        sc.close();
    }
}
