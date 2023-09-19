package com.nhnacademy.gaeun.exercise04;

import java.util.Scanner;

public class BlackjackTest {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        BlackjackHand blackjackHand = new BlackjackHand();
        Scanner scanner = new Scanner(System.in);
        System.out.println("2~6개 중에 몇 개의 카드를 받으실 건가요?");
        int cardAmount = scanner.nextInt();

        for(int i = 0; i < cardAmount; i++) {
            blackjackHand.addCard(deck.dealCard());
        }
        System.out.println(blackjackHand.getBlackjackValue());
    }
}
