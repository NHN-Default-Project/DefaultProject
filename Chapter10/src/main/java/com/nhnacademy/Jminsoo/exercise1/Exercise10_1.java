package com.nhnacademy.Jminsoo.exercise1;

public class Exercise10_1 {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.putNumber("JMS", "010-0000-1234");
        phoneDirectory.putNumber("PMS", "010-0000-1235");
        phoneDirectory.putNumber("JJH", "010-0000-1236");
        phoneDirectory.putNumber("CYH", "010-0000-1237");
        phoneDirectory.putNumber("LGE", "010-0000-1238");

        System.out.println(phoneDirectory.getNumber("JMS"));
        System.out.println(phoneDirectory.getNumber("PMS"));
        System.out.println(phoneDirectory.getNumber("JJH"));
        System.out.println(phoneDirectory.getNumber("CYH"));
        System.out.println(phoneDirectory.getNumber("LGE"));
        System.out.println(phoneDirectory.getNumber("EMPTY"));
    }
}
