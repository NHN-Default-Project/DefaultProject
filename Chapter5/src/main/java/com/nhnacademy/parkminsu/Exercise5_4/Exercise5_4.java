package com.nhnacademy.parkminsu.Exercise5_4;

import java.util.Scanner;

public class Exercise5_4 {
    private static final int MIN_CARD_COUNT = 2;
    private static final int MAX_CARD_COUNT = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BlackjackHand blackjackHand = new BlackjackHand();
        Deck deck = new Deck(false);
        int num = scanner.nextInt();
        if (num < MIN_CARD_COUNT && num > MAX_CARD_COUNT) {
            throw new IllegalArgumentException("카드의 갯수 범위가 잘못되었습니다.");
        }
        deck.shuffle();
        for (int i = 0; i < num; i++) {
            blackjackHand.addCard(deck.dealCard());
        }
        System.out.println(blackjackHand.getBlackjackValue());
    }
}
