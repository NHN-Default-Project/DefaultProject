package com.nhnacademy.parkminsu.Exercise5_5;


import java.util.Scanner;

import static com.nhnacademy.parkminsu.Exercise5_5.BlackjackCondition.*;
import static com.nhnacademy.parkminsu.Exercise5_5.CardAction.*;

public class Game {
    private BlackjackHand user;
    private BlackjackHand dealer;
    private Deck deck;
    private final int cardNum;
    private final int cardFirstRange = 2;
    private final int cardEndRange = 6;
    private String callSign;

    public Game(int cardNum) {
        if (cardNum < this.cardFirstRange && cardNum > this.cardEndRange) {
            throw new IllegalArgumentException("나눠주는 카드의 장 수 범위가 잘못 입력됐습니다.");
        }
        this.dealer = new BlackjackHand();
        this.user = new BlackjackHand();
        this.deck = new Deck(false);
        this.cardNum = cardNum;
        this.callSign = "";
    }

    public void start(String str) {
        this.deck.shuffle();
        String answer = "YES";
        Scanner scanner = new Scanner(System.in);
        do {

            try { //
                gameFirstStep();
                if (deckCondition(this.dealer)) { // 블랙잭 승리 조건 1
                    showWin("딜러", this.dealer);
                    break;
                }
            } catch (IllegalStateException e) {
                this.deck = new Deck(false);
                this.deck.shuffle();
                System.out.println(e.getMessage());
                System.out.println("card shuffle"); // 카드가 없을 때
            }
            gameSecondStep();
            if (victoryCondition(this.user, this.dealer)) {
                showWin("유저", this.user);
            } else {
                showWin("딜러", this.dealer);
            }
            System.out.println("끝내겠습니까?");
            answer = scanner.nextLine().toUpperCase();
            userAndDealerCardRemove(this.user, this.dealer);
        } while (answer.equals("NO"));
    }

    public void gameFirstStep() {
        for (int i = 0; i < this.cardNum; i++) {
            giveOneCard(this.user, this.deck);
            giveOneCard(this.dealer, this.deck);
        }

        System.out.printf("딜러의 패: %d \n", dealer.getCard(0).getValue());
        System.out.print("유저의 패: ");
        for (int i = 0; i < this.cardNum; i++) {
            System.out.printf("%d ", this.user.getCard(i).getValue());
        }
        System.out.println();
    }


    public void inputCallSign() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Hit or Standard?");
            this.callSign = scanner.nextLine();
            if (!checkCallValue(this.callSign)) {
                System.out.println("잘못 입력하셨습니다");
            } else {
                break;
            }
        }
    }

    public boolean userCall() {
        inputCallSign();
        String call = "HIT";
        return hitOrStandard(this.callSign.toUpperCase(), call); // user hit
    }

    public void gameSecondStep() {
        while (true) {
            if (userCall() == false) {
                break;

            }
            this.user.addCard(this.deck.dealCard());
            showCard(this.user);

            if (!bustCondtion(this.user)) {
                showCard(this.user);
                System.out.println(this.user.getBlackjackValue());
                System.out.println("사용자는 21을 초과했습니다.");
                return; // 사용자가 21이 넘으면
            }
        } // 유저가 standard 입력시 무한루프 나옴
        while (dealerkDeckCheck(this.dealer)) {
            this.dealer.addCard(deck.dealCard());
        }
    }


}
