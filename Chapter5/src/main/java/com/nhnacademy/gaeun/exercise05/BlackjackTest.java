package com.nhnacademy.gaeun.exercise05;

import java.util.Scanner;

public class BlackjackTest {
    static Deck deck = new Deck();

    static BlackjackHand user = new BlackjackHand("USER");
    static BlackjackHand dealer = new BlackjackHand("DEALER");

    public static void main(String[] args) {
        if (playBlackjackGame()) {
            System.out.println("======================================================");
            System.out.println("===================== USER WIN!! =====================");
            System.out.println();
            openAllCanrds();
        } else {
            System.out.println("======================================================");
            System.out.println("==================== DEALER WIN!! ====================");
            System.out.println();
            openAllCanrds();
        }
    }

    public static boolean playBlackjackGame() {
        deck.shuffle(); //카드 섞기
        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================================");
        System.out.println("                      GAME START                      ");
        System.out.println("======================================================");

        user.addCard(deck.dealCard());
        user.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        user.openCard(dealer);
        if (user.whoIsWin() >= 0) return user.whoIsWin() == 0 ? true : false;
        if (dealer.whoIsWin() >= 0) return dealer.whoIsWin() == 0 ? false : true;

        while (true) {
            System.out.println("[ Hit or Stand 여부를 결정해주세요. (1: Hit / 2: Stand) ]");
            int userInput = scanner.nextInt();
            if (userInput < 1 || userInput > 2) {
                System.out.println(("[ (1: Hit / 2: Stand) 올바른 숫자를 입력하세요. ]"));
                continue;
            }
            if (userInput == 1) { //Hit
                System.out.println("[ Hit!! 사용자의 카드 한 장을 추가했습니다. ]");

                user.addCard(deck.dealCard());
                if (user.whoIsWin() >= 0) return user.whoIsWin() == 0 ? true : false;
                user.openCard(dealer);

                if (isAddDealer(dealer.getBlackjackValue())) {
                    dealer.addCard(deck.dealCard());
                    user.openCard(dealer);
                    if (dealer.whoIsWin() >= 0) return dealer.whoIsWin() == 0 ? false : true;
                }
                continue;
            }
            if (userInput == 2) { //Stand
                System.out.println("[ Stand!! 딜러의 카드를 확인합니다.]");
                if (isAddDealer(dealer.getBlackjackValue())) {
                    dealer.addCard(deck.dealCard());
                    user.openCard(dealer);
                    if (dealer.whoIsWin() >= 0) return dealer.whoIsWin() == 0 ? false : true;
                }
                return (dealer.getBlackjackValue() >= user.getBlackjackValue()) ? false : true;
            }
            scanner.close();
        }


    }
    public static boolean isAddDealer(int getBlackjackNum) {
        return getBlackjackNum <= 16;
    }
    public static void openAllCanrds() {
        System.out.println("===== " + user.getName() + " =====");
        for (int i = 0; i < user.getCardCount(); i++) {
            System.out.printf("%s, %s\n", user.getCard(i).getSuitAsString(), user.getCard(i).getValueAsString());
        }
        System.out.println();
        System.out.println("===== " + dealer.getName() + " =====");
        for (int i = 0; i < dealer.getCardCount(); i++) {
            System.out.printf("%s, %s\n", dealer.getCard(i).getSuitAsString(), dealer.getCard(i).getValueAsString());
        }
    }
}
