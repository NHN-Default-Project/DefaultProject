package com.nhnacademy.gaeun.exercise05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackjackGame {
    static Deck deck = new Deck();

    static BlackjackHand user = new BlackjackHand("USER");
    static BlackjackHand dealer = new BlackjackHand("DEALER");

    public static void main(String[] args) {
        if (playBlackjackGame()) {
            System.out.println("======================================================");
            System.out.println("===================== USER WIN!! =====================");
            System.out.println();
            openAllCards();
        } else {
            System.out.println("======================================================");
            System.out.println("==================== DEALER WIN!! ====================");
            System.out.println();
            openAllCards();
        }
    }

    public static boolean playBlackjackGame() {
        deck.shuffle(); //카드 섞기
        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================================");
        System.out.println("\t\t\t\t\t  GAME START  \t\t\t\t\t");
        System.out.println("======================================================");

        initialTurn();
        if (dealer.whoIsWin() >= 0) return dealer.whoIsWin() == 0 ? false : true;
        if (user.whoIsWin() >= 0) return user.whoIsWin() == 0 ? true : false;

        while (true) {
            int userInput = checkInputValue(scanner);
            if (userInput == 1) { //Hit
                System.out.println("[ Hit!! 사용자의 카드 한 장을 추가했습니다. ]");

                user.addCard(deck.dealCard());
                if (user.whoIsWin() >= 0) return user.whoIsWin() == 0 ? true : false;
                openAllCards();

                if (isAddDealer(dealer.getBlackjackValue())) {
                    dealer.addCard(deck.dealCard());
                    openAllCards();
                    if (dealer.whoIsWin() >= 0) return dealer.whoIsWin() == 0 ? false : true;
                }
            } else if (userInput == 2) { //Stand
                System.out.println("[ Stand!! 딜러의 카드를 확인합니다.]");
                if (isAddDealer(dealer.getBlackjackValue())) {
                    dealer.addCard(deck.dealCard());
                    openAllCards();
                    if (dealer.whoIsWin() >= 0) return dealer.whoIsWin() == 0 ? false : true;
                }
                return (dealer.getBlackjackValue() >= user.getBlackjackValue()) ? false : true;
            }
        }


    }

    public static int checkInputValue(Scanner scanner) {
        int userInput;
        while (true) {
            try {
                System.out.println("[ Hit or Stand 여부를 결정해주세요. (1: Hit / 2: Stand) ]");
                userInput = scanner.nextInt();
                if (userInput != 1 && userInput != 2) {
                    System.out.println("[ (1: Hit / 2: Stand) 올바른 숫자를 입력하세요. ]");
                }
            } catch (InputMismatchException e) {
                System.out.println("[ (1: Hit / 2: Stand) 올바른 숫자를 입력하세요. ]");
                scanner.nextLine();
            }
        }
    }

    public static void initialTurn() {
        for (int i = 0; i < 2; i++) {
            user.addCard(deck.dealCard());
            dealer.addCard(deck.dealCard());
        }
        user.openCard();
        System.out.printf("%s, %s\n",
                dealer.getCard(0).getSuitAsString(), dealer.getCard(0).getValueAsString());
    }

    public static boolean isAddDealer(int getBlackjackNum) {
        return getBlackjackNum <= 16;
    }

    public static void openAllCards() {
        user.openCard();
        dealer.openCard();
    }
}
