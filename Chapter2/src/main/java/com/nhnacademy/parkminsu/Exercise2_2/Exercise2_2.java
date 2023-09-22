package com.nhnacademy.parkminsu.Exercise2_2;

public class Exercise2_2 {
    public static void main(String[] args) {
        int firstNum = randNum();
        int secondNum = randNum();
        System.out.println("첫 번째 주사위가 " + firstNum + "이 나왔습니다.");
        System.out.println("두 번째 주사위가 " + secondNum + "이 나왔습니다.");
        System.out.println("첫 번째 주사위가 " + (firstNum + secondNum) + "이 나왔습니다.");
    }

    public static int randNum() {
        return (int) (Math.random() * 6) + 1;
    }
}
