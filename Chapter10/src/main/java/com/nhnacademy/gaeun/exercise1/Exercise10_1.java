package com.nhnacademy.gaeun.exercise1;

public class Exercise10_1 {
    public static void main(String[] args) {
        System.out.println("============ PhoneDirectory Test ============");
        PhoneDirectory kaeunPhoneDirectory = new PhoneDirectory();

        try {
            System.out.println("전화번호 저장하기");
            kaeunPhoneDirectory.putNumber("엄마", "010-4610-0303");
            kaeunPhoneDirectory.putNumber("아빠", "010-2680-8949");
            System.out.println();

            System.out.println("전화번호 가져오기");
            System.out.printf("엄마: %s\n", kaeunPhoneDirectory.getNumber("엄마"));
            System.out.println();

            System.out.println("존재하는 값의 인덱스 가져오기");
            System.out.printf("아빠: %d\n", kaeunPhoneDirectory.find("아빠"));
            System.out.println();

            System.out.println("전화번호 업데이트");
            kaeunPhoneDirectory.putNumber("엄마", "010-9321-0379");
            System.out.printf("엄마: %s\n", kaeunPhoneDirectory.getNumber("엄마"));
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
