package com.nhnacademy.jaehyeon.exercise5_4and5;

import java.util.Scanner;

public class Exercise5_5 {

    private Exercise5_5() {
    }

    static final int START_CARD_NUMBER = 2;

    public static void main(String[] args) {
        try {
            Deck deck = new Deck();
            BlackjackHand user = new BlackjackHand();
            BlackjackHand dealer = new BlackjackHand();

            startGame(deck);
            System.out.println("user 카드 나눠 주겠습니다. 확인하세요");
            giveCard(user, deck, START_CARD_NUMBER);
            System.out.println("user 카드 목록");
            printValue(user);
            System.out.println("dealer 카드 나눠 주겠습니다. 확인하고 한장 오픈하세요");
            giveCard(dealer, deck, START_CARD_NUMBER);
            printDealerOneCard(dealer);


            while (!isQuitGame(user) && !isQuitGame(dealer)) {
                selectDealerCard(dealer, deck);
                int selectStandOrHit = selectUserStandOrHit();
                if (selectStandOrHit == 1) {
                    break;
                } else {
                    giveUserOneCard(user, deck);
                    printValue(user);
                }
            }
            judgementGameWinner(user, dealer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private static void startGame(Deck deck) {
        System.out.println("게임을 시작합니다");
        System.out.println("각자 카드를 나눠 주겠습니다.");
        deck.shuffle();
    }

    private static void giveCard(BlackjackHand blackjackHand, Deck deck, int number) {
        for (int i = 0; i < number; i++) {
            blackjackHand.addCard(deck.dealCard());
        }
    }

    private static void printValue(BlackjackHand blackjackHand) {
        blackjackHand.printCard();
        System.out.println("현재 당신 카드의 총 value: " + blackjackHand.getBlackjackValue());
    }

    private static void selectDealerCard(BlackjackHand dealer, Deck deck) {
        if (dealer.getBlackjackValue() <= 16) {
            System.out.println("dealer 에게 카드 한장을 주겠습니다.");
            dealer.addCard(deck.dealCard());
        }
    }

    private static void printDealerOneCard(BlackjackHand dealer) {
        dealer.printOneCard();
    }

    private static boolean isQuitGame(BlackjackHand blackjackHand) {
        if (blackjackHand.getBlackjackValue() > 21) {
            return true;
        } else if (blackjackHand.getBlackjackValue() == 21) {
            return true;
        }
        return false;
    }

    private static int selectUserStandOrHit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("stand 하실건가요 hit 하실건가요?");
        System.out.println("stand : 1 || hit : 2 입니다 눌러주세요");
        int num = scanner.nextInt();
        verifyInputNumber(num);

        return num;
    }

    private static void verifyInputNumber(int num) {
        if (num != 1 && num != 2) {
            throw new IllegalArgumentException("1 또는 2를 선택 해주세요");
        }
    }

    private static void giveUserOneCard(BlackjackHand user, Deck deck) {
        user.addCard(deck.dealCard());
    }

    private static void judgementGameWinner(BlackjackHand user, BlackjackHand dealer) {
        if (dealer.getBlackjackValue() == 21) {
            System.out.println("딜러 블랙잭");
            System.out.println("=========게임 종료=========");
            System.out.println("딜러 승리");

        } else if (user.getBlackjackValue() == 21) {
            System.out.println("유저 블랙잭");
            System.out.println("=========게임 종료=========");
            System.out.println("user 승리");

        } else if (dealer.getBlackjackValue() > 21) {
            System.out.println("딜러 버스트");
            System.out.println("=========게임 종료=========");
            System.out.println("user 승리");

        } else if (user.getBlackjackValue() > 21) {
            System.out.println("유저 버스트");
            System.out.println("=========게임 종료=========");
            System.out.println("dealer 승리");

        } else if (user.getBlackjackValue() == dealer.getBlackjackValue()) {
            System.out.println("=========게임 종료=========");
            System.out.println("dealer 승리");

        } else if (user.getBlackjackValue() > dealer.getBlackjackValue()) {
            System.out.println("=========게임 종료=========");
            System.out.println("user 승리");

        } else if (dealer.getBlackjackValue() > user.getBlackjackValue()) {
            System.out.println("=========게임 종료=========");
            System.out.println("dealer 승리");
        }
    }

    // 게임을 시작해

    // 딜러랑 유저한테 카드를 2장 나눠줘

    // 딜러는 카드를 하나 오픈해

    // 딜러는 16이하 이면 카드를 하나 뽑아

    // 유저하는 stand hit 결정하기

    // hit 했는데 21 넘어가면 끝

    // 안넘어가면 결정

    //stand 하면 비교하고 게임 끝
}


