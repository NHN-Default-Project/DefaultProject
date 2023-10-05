package com.nhnacademy.jminsoo.exercise7;

public class Exercise3_7 {
    public static void main(String[] args) {
        FindEqualBirthday exam1 = new FindEqualBirthday(3);
        System.out.println(exam1);

        FindDifferentBirthday exam2 = new FindDifferentBirthday(365);
        System.out.println(exam2);

        Find365Birthday exam3 = new Find365Birthday();
        System.out.println(exam3);
    }

}
