package com.nhnacademy.jaehyeon.exercise10_1;

public class Exercise10_1 {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.addNumber("010-9417-3268", "정재현");
        phoneDirectory.addNumber("010-1234-5678", "홍길동");
        phoneDirectory.addNumber("010-8765-4321", "누구냐");
        phoneDirectory.addNumber("010-1111-1111", "스우");


        System.out.println(phoneDirectory.lookUpName("010-9417-3268"));
        System.out.println(phoneDirectory.lookUpNumber("정재현"));
    }
}
