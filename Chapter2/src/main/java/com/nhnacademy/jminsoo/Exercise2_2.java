package com.nhnacademy.jminsoo;

public class Exercise2_2 {
    public static void main(String[] args) {
        int dice1 = (int) (Math.random() * 6) + 1;
        int dice2 = (int) (Math.random() * 6) + 1;

        System.out.printf("The First die comes up %d\n", dice1);
        System.out.printf("The First die comes up %d\n", dice2);
        System.out.printf("Your total roll is %d\n", dice1 + dice2);

    }
}
