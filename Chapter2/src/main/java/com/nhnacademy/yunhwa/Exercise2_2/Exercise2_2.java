package com.nhnacademy.yunhwa.Exercise2_2;

public class Exercise2_2 {
    // 주사위 굴리기 시뮬레이션 프로그램

    public static void main(String[] args) {
        int size = 2;

        int[] dice = new int[size];
        int sum = 0;
        for (int i = 0; i < dice.length; i++) {
            dice[i] = (int) (Math.random() * 6) + 1;
            sum += dice[i];
        }

        for (int i = 0; i < dice.length; i++) {
            System.out.println((i+1) + "번째 주사위가 " + dice[i] + "개 나옵니다.");
        }
        System.out.println("총 롤은 " + sum + "입니다.");

    }
}
