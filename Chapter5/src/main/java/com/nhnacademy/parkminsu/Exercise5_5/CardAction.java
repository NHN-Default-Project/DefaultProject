package com.nhnacademy.parkminsu.Exercise5_5;

public class CardAction {

    public static void giveOneCard(BlackjackHand userOrDealer, Deck deck) {
        userOrDealer.addCard(deck.dealCard());
    }

    public static void showCard(BlackjackHand blackjackHand) {
        for (int i = 0; i < blackjackHand.getCardCount(); i++) {
            System.out.printf("%d ", blackjackHand.getCard(i).getValue());
        }
        System.out.println();
    }

    public static void showWin(String str, BlackjackHand blackjackHand) {
        System.out.println(str + "가 이겼습니다");
        System.out.println(str + " 패: ");
        showCard(blackjackHand);
    }


    public static void userAndDealerCardRemove(BlackjackHand user, BlackjackHand dealer) {
        user.clear();
        dealer.clear();
    }
}
