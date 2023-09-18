package com.nhnacademy.gaeun.exercise02;

public class Main {

    public static void main(String[] args) {
        int first = dice();
        int second = dice();
        System.out.println("첫 번째 주사위가 " + first + " 나왔습니다.");
        System.out.println("두 번째 주사위가 " + second + " 나왔습니다.");

        System.out.println("총 주사위 값은 " + (first + second) + "입니다.");

    }

    public static int dice() {
        return (int) (Math.random() * 6) + 1;
    }

}
