package com.nhnacademy.yunhwa.Exercise2_3;

import java.util.Scanner;

public class Exercise2_3 {
    // 사용자의 이름을 묻고 이름을 부르며 인사하는 프로그램
    // 사용자 이름을 출력하기 전에 대문자로 변환
    // ex ) Fred -> "Hello, FRED, 만나서 반가워요!" 응답
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("사용자의 이름을 입력해주세요 : ");
        String userName = sc.nextLine();
        
        User user = new User(userName);

        System.out.println("Hello, " + user.getUpperName() + ", 만나서 반가워요!");

        sc.close();
    }
}
