package com.nhnacademy.parkminsu.Exercise5_5;


import java.util.Scanner;

public class Game {
    private final int cardNum;
    private final int cardFirstRange = 2;
    private final int cardEndRange = 6;
    private final BlackjackCondition blackjackCondition = new BlackjackCondition();
    private final CardAction cardAction = new CardAction();

    public Game() {
        this.cardNum = 2;
    }

    public void start(boolean str) {
        BlackjackHand user = new BlackjackHand();
        BlackjackHand dealer = new BlackjackHand();
        Deck deck = new Deck(false);
        deck.shuffle();
        String answer = "";
        Scanner scanner = new Scanner(System.in);
        do {

            try { //
                gameFirstStep(user, dealer, deck);
                if (blackjackCondition.deckCondition(dealer)) { // 블랙잭 승리 조건 1
                    cardAction.showWin("딜러", dealer);
                    break;
                }
            } catch (IllegalStateException e) {
                deck = new Deck(false);
                deck.shuffle();
                System.out.println(e.getMessage());
                System.out.println("card shuffle"); // 카드가 없을 때
            }
            gameSecondStep(user, dealer, deck);
            if (blackjackCondition.victoryCondition(user, dealer)) {
                cardAction.showWin("유저", user);
            } else {
                cardAction.showWin("딜러", dealer);
            }
            System.out.println("끝내겠습니까?");
            answer = scanner.nextLine().toUpperCase();
            cardAction.userAndDealerCardRemove(user, dealer);
        } while (answer.equals("NO"));
    }

    public void gameFirstStep(BlackjackHand user, BlackjackHand dealer, Deck deck) {
        for (int i = 0; i < this.cardNum; i++) {
            cardAction.giveOneCard(user, deck);
            cardAction.giveOneCard(dealer, deck);
        }

        System.out.println(dealer.getCard(0));
        System.out.print("유저의 패: \n");
        for (int i = 0; i < this.cardNum; i++) {
            System.out.println(user.getCard(i));
        }
        System.out.println();
    }


    public String inputCallSign() {
        Scanner scanner = new Scanner(System.in);
        String callSign;
        while (true) {
            System.out.printf("Hit or Stand? ");
            callSign = scanner.nextLine();
            if (!blackjackCondition.checkCallValue(callSign)) {
                System.out.println("잘못 입력하셨습니다");
            } else {
                break;
            }
        }
        return callSign;
    }

    public boolean userCall() {
        String call = "HIT";
        return blackjackCondition.hitOrStandard(inputCallSign().toUpperCase(), call); // user hit
    }

    public void gameSecondStep(BlackjackHand user, BlackjackHand dealer, Deck deck) {
        while (true) {
            if (!userCall()) {
                break;

            }
            user.addCard(deck.dealCard());
            cardAction.showCard(user);

            if (!blackjackCondition.notBustCondition(user)) {
                cardAction.showCard(user);
                System.out.println(user.getBlackjackValue());
                System.out.println("사용자는 21을 초과했습니다.");
                return; // 사용자가 21이 넘으면
            }
        } // 유저가 standard 입력시 무한루프 나옴
        while (blackjackCondition.dealerDeckCheck(dealer)) {
            dealer.addCard(deck.dealCard());
        }
    }


}
