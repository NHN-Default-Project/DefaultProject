package com.nhnacademy.parkminsu.Exercise5_5;

import java.util.Scanner;

public class Exercise5_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("블랙잭 게임을 시작하겠습니까?(yes or no)");
            String start = scanner.nextLine().toUpperCase();
            if (!start.equals("YES")) {
                throw new IllegalArgumentException("잘못 입력하셨습니다");
            }
            Game game = new Game();
            game.start(start);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

}
