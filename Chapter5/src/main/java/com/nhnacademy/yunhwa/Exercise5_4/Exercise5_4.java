package com.nhnacademy.yunhwa.Exercise5_4;

import java.util.Scanner;

//import Chapter4.src.main.java.com.nhnacademy.yunhwa.Exercise4_3.Range;
import com.nhnacademy.yunhwa.Exercise5_3.Range;

public class Exercise5_4 {
    // BlackjackHand : Hand 클래스를 extends 한 것 -> getBlackjackValue() 메서드 추가됨
    // 블랙잭 핸드에는 일반적으로 2 ~ 6 장의 카드가 포함됨.

    // BlackjackHand 클래스를 테스트하는 프로그램 작성하기

    // 1. BlackjackHand Object 와 Deck Object 만들기
    // 2. 2 ~ 6 사이의 랜덤 숫자 선택하기
    // 3. deck 에서 많은 카드를 처리하고 그 카드들을 손에 추가하기
    // 4. 손에 있는 모든 카드를 인쇄한 다음
    // 5. getBlackjackValue() 가 손의 카드들에 대해 블랙잭 게임의 패 값을 계산해 반환하여
    // 6. 얻은 블랙잭 패 값을 인쇄하기
    // 사용자가 계속하기를 원하는 동안 이 작업을 계속 반복하기

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in);) {
            System.out.println("\n\n---- 이제부터 블랙잭 게임 시작! ----");
            System.out.println("------------------------------------");
            // 나는 이제부터 블랙잭 게임을 할 거야!
            boolean isContinued = true;

            while (isContinued) {
                // 블랙잭을 하는 손과 블랙잭을 할 덱을 생성하기
                BlackjackHand blackjackHand = new BlackjackHand();
                Deck deck = new Deck(false);

                // 2부터 6까지의 범위 내에서 랜덤 숫자 택하기
                Range range = new Range(2, 6);
                int cardCount = getRandomNum(range);
                System.out.println("이번에 내가 가질 카드의 개수 : " + cardCount + " 개!\n");

                // 카드 개수만큼 덱에서 카드를 가져와 손에 추가하기
                for (int i = 0; i < cardCount; i++) {
                    Card newCard = deck.dealCard();
                    blackjackHand.addCard(newCard);
                }

                // 손에 있는 모든 카드들 인쇄하기
                for (int i = 0; i < blackjackHand.getCardCount(); i++) {
                    Card blackjackCard = blackjackHand.getCard(i);
                    System.out.println("손에 있는 " + (i+1) + " 번째 카드 : " + blackjackCard);
                }

                // 블랙잭 패 값 계산한 값 받아서 출력하기
                int blackjackValue = blackjackHand.getBlackjackValue();
                System.out.println("------------------------------------");
                System.out.println(" >>>이번 게임의 블랙잭 패값 : " + blackjackValue + "<<< ");
                System.out.println("------------------------------------");
                System.out.println("------- 이번 블랙잭 게임 끝! -------\n\n");


                // 사용자가 계속하기를 원하는지를 입력받아 isContinued 갱신하기
                boolean notyetEnterValidInput = true;
                while (notyetEnterValidInput) {
                    System.out.print("-> 게임을 계속 하기를 원하시나요? Yes or No 로 입력해주세요 : ");
                    String tmpIsContinued = sc.nextLine();
                    tmpIsContinued = tmpIsContinued.trim().toUpperCase();

                    if(tmpIsContinued.equals("YES")) {
                        isContinued = true;
                        notyetEnterValidInput = false;
                    } else if (tmpIsContinued.equals("NO")) {
                        isContinued = false;
                        notyetEnterValidInput = false;
                    } else {
                        System.out.println("\n잘못된 문자열 " + tmpIsContinued + " 이 들어왔습니다. 다시 질문드리겠습니다!\n");
                    }
                }
            }
        }
    }

    public static int getRandomNum(Range range) {
        int randomNum = (int) (Math.random() * range.getMaxValue() + 1 - range.getMinValue())+ range.getMinValue();
        return randomNum;
    }
    
}