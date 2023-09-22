package com.nhnacademy.main.exercise5_5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackjackGame {
    static Deck deck = new Deck();

    static BlackjackHand user = new BlackjackHand("USER");
    static BlackjackHand dealer = new BlackjackHand("DEALER");
    static boolean isStandCall = false;

    public static final String LINE = "======================================================";

    public static void main(String[] args) {

        playBlackjackGame();
    }

    public static void playBlackjackGame() {
        deck.shuffle(); //카드 섞기
        Scanner scanner = new Scanner(System.in);

        JudgeThread thread = new JudgeThread();
        thread.start();

        System.out.println(LINE);
        System.out.println("\t\t\t\t\t  GAME START  \t\t\t\t\t");
        System.out.println(LINE);

        initialTurn(); //카드를 2장씩 나누어 준다.

        while (true) {
            int userInput = checkInputValue(scanner);
            if (userInput == 1) { //Hit
                hitUserSelect();
            } else if (userInput == 2) { //Stand
                standUserSelect();
                break;
            }
        }


    }

    public static void openDealerOneCard() {
        user.openCard();
        System.out.println();
        System.out.println("===== " + dealer.getName() + " =====");
        System.out.printf("%s, %s%n", dealer.getCard(0).getSuitAsString(), dealer.getCard(0).getValueAsString());
    }

    public static void standUserSelect() {
        System.out.println("[ Stand!! 딜러의 카드를 확인합니다.]");
        if (isAddDealer(dealer.getBlackjackValue())) {
            dealer.addCard(deck.dealCard());
            openDealerOneCard();
            isStandCall = true;
        } else {
            System.out.println("딜러의 카드의 합이 17이상이므로 추가하지 않습니다. ");
            isStandCall = true;
        }
    }

    public static void hitUserSelect() {
        System.out.println("[ Hit!! 사용자의 카드 한 장을 추가했습니다. ]");

        user.addCard(deck.dealCard());
        openDealerOneCard();
    }

    public static void printGameResult(String name) {
        System.out.println(LINE);
        System.out.printf("===================== %s WIN!! =====================%n", name);
        System.out.println();
        openAllCards();
    }

    public static int judgeGame() { //-1: dealer승, 0: 게임 안 끝남, 1: user승
        if (dealer.whoIsWin() >= 0) {
            return dealer.whoIsWin() == 0 ? -1 : 1;
        }
        if (user.whoIsWin() >= 0) {
            return user.whoIsWin() == 0 ? 1 : -1;
        }
        if (isStandCall) {
            return dealer.getBlackjackValue() >= user.getBlackjackValue() ? -1 : 1;
        }
        return 0;
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
                return userInput;
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
        openDealerOneCard();
    }

    public static boolean isAddDealer(int getBlackjackNum) {
        return getBlackjackNum <= 16;
    }

    public static void openAllCards() {
        user.openCard();
        dealer.openCard();
    }
}
