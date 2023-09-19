package com.nhnacademy.jaehyeon.exercise5_4and5;

import java.util.Scanner;

public class Exercise5_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("몇 장 뽑으실 건가요?: ");
        int selectCard = scanner.nextInt();

        Deck deck = new Deck();
        BlackjackHand blackjackHand = new BlackjackHand();
        deck.shuffle();

        for (int i = 0; i < selectCard; i++) {
            blackjackHand.addCard(deck.dealCard());
        }

        blackjackHand.printCard();

        System.out.println("총 카드의 vlalue: " + blackjackHand.getBlackjackValue());

        scanner.close();

    }
}

