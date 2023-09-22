package com.nhnacademy.main.excercise1;

public class Exercise5_1 {
    public static void main(String[] args) {
        SnakeEye makeSnakeEye = new SnakeEye();

        makeSnakeEye.action();

        int count = makeSnakeEye.getRollCount();
        System.out.println("\n두 주사위의 합이 2 가 될 때까지 주사위 한 쌍을 굴린 횟수는 " + count + " 회 입니다.\n");
    }
}