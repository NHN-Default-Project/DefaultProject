package com.nhnacademy.main;

import java.util.Scanner;

public class Exercise5_4 {
    public static void main(String[] args) {
        Deck deck = new Deck();
        BlackjackHand blackjackHand = new BlackjackHand("User");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("몇 장 뽑으실 건가요?: ");
            String selectCard = scanner.nextLine();
            if (!isNumber(selectCard)) {
                System.out.println("숫자만 입력하세요");
                System.out.println("=====================");
                System.out.println();
            } else if (!verifyInputNumber(selectCard)) {
                System.out.println("2이상 6이하의 숫자만 입력하세요");
                System.out.println("=====================");
                System.out.println();
            } else {
                deck.shuffle();
                for (int i = 0; i < Integer.parseInt(selectCard); i++) {
                    blackjackHand.addCard(deck.dealCard());
                }
                blackjackHand.printCard();

                System.out.println("총 카드의 vlalue: " + blackjackHand.getBlackjackValue());
                break;
            }
        }
    }

    public static boolean verifyInputNumber(String inNum) {
        return 2 <= Integer.parseInt(inNum) && Integer.parseInt(inNum) <= 6;
    }

    public static boolean isNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
            return true;
        } catch (NumberFormatException num) {
            return false;
        }
    }
}
