package com.nhnacademy.gaeun.exercise04;

import java.util.Scanner;

public class BlackjackGame {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        BlackjackHand blackjackHand = new BlackjackHand();
        Scanner scanner = new Scanner(System.in);
        int cardAmount;
        while (true) {
            System.out.println("2~6개 중에 몇 개의 카드를 받으실 건가요?");
            cardAmount = scanner.nextInt();
            if (cardAmount < 2 || cardAmount > 6) {
                System.out.println("2부터 6까지의 숫자를 입력해주세요!");
            } else break;
        }

        for (int i = 0; i < cardAmount; i++) {
            blackjackHand.addCard(deck.dealCard());
        }
        blackjackHand.openCard();
        System.out.println(blackjackHand.getBlackjackValue());
        scanner.close();
    }

}
