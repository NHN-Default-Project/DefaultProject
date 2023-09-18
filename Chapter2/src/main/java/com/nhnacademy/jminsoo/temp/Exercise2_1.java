package com.nhnacademy.jminsoo.temp;

public class Exercise2_1 {
    public static void main(String[] args) {
        String name = new String("Jeong min soo");
        String[] names = name.split(" ");

        System.out.println(names[0] + " " + names[2]);
    }
}