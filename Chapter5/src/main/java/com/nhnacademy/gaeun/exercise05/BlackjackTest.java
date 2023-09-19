package com.nhnacademy.gaeun.exercise05;

import java.util.Scanner;

public class BlackjackTest {
    static BlackjackHand user = new BlackjackHand("USER");
    static BlackjackHand dealer = new BlackjackHand("DEALER");

    public static void main(String[] args) {
        if (playBlackjackGame()) {
            System.out.println("user Win!!");
        } else {
            System.out.println("dealer win!!");
        }
    }

    public static boolean playBlackjackGame() {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle(); //카드 섞기

        System.out.println("======================================================");
        System.out.println("                      GAME START                      ");
        System.out.println("======================================================");

        user.addCard(deck.dealCard());
        user.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        user.openCard(dealer);
        if (dealer.isWin()) {
            return true;
        }
        if (user.isWin()) {
            return false;
        }

        while (true) {
            System.out.println("Hit or Stand 여부를 결정해주세요. (1: Hit / 2: Stand)");
            int userInput = scanner.nextInt();
            if(userInput < 1 || userInput > 2) throw new IllegalArgumentException("(1: Hit / 2: Stand) 올바른 숫자를 입력하세요.");
            if (userInput == 1) {
                user.addCard(deck.dealCard());
                user.openCard(dealer);
                if (user.isWin()) {
                    return true;
                }
                if (user.getBlackjackValue() > 21) {
                    return false;
                }
                if (isAddDealer(dealer.getBlackjackValue())) {
                    dealer.addCard(deck.dealCard());
                    dealer.openCard(user);
                    if (dealer.getBlackjackValue() > 21) {
                        return true;
                    }
                }
            }
            if (userInput == 2) {
                if (isAddDealer(dealer.getBlackjackValue())) {
                    dealer.addCard(deck.dealCard());
                    if (dealer.getBlackjackValue() > 21) {
                        dealer.openCard(user);
                        return true;
                    }
                }
                user.openCard(dealer);
                if (dealer.getBlackjackValue() >= user.getBlackjackValue()) {
                    return false;
                } else {
                    return true;
                }
            }
        }


    }

    public static boolean isAddDealer(int getBlackjackNum) {
        return getBlackjackNum <= 16;
    }

}
