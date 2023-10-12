package com.nhnacademy.parkminsu.exercise5_4;

import java.util.Scanner;

public class Exercise5_4 {
    private static final int MIN_CARD_COUNT = 2;
    private static final int MAX_CARD_COUNT = 6;

    public static void main(String[] args) {
        while (true) {
            try (Scanner scanner = new Scanner(System.in)) {
                BlackjackHand blackjackHand = new BlackjackHand();
                Deck deck = new Deck(false);
                System.out.print("카드 몇장을 받을건가요? ");
                int num = scanner.nextInt();

                if (num < MIN_CARD_COUNT || num > MAX_CARD_COUNT) {
                    throw new IllegalArgumentException("카드의 갯수 범위가 잘못되었습니다.");
                }
                deck.shuffle();
                for (int i = 0; i < num; i++) {
                    blackjackHand.addCard(deck.dealCard());
                    System.out.println(blackjackHand.getCard(i));
                }

                System.out.println(blackjackHand.getBlackjackValue());
                System.out.println("그만 하실건가요?(0을 입력하면 멈춥니다.");
                int zero = scanner.nextInt();
                if (zero != 0) {
                    System.out.println("계속 진행합니다.");
                } else {
                    System.out.println("프로그램을 종료합니다");
                    break;
                }


            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
