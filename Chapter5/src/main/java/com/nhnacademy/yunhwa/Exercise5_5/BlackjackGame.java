package com.nhnacademy.yunhwa.Exercise5_5;

import java.util.Scanner;


import com.nhnacademy.yunhwa.Exercise5_4.BlackjackHand;
import com.nhnacademy.yunhwa.Exercise5_4.Deck;

public class BlackjackGame {

    Deck deck;
    BlackjackHand dealerHand;
    BlackjackHand userHand;
    boolean isUserWin;
    boolean isGameEnd;
    boolean isUserFirstPick;
    
    public BlackjackGame() {

        this.deck = new Deck();
        this.dealerHand = new BlackjackHand();
        this.userHand = new BlackjackHand();
        this.isGameEnd = false;
        this.isUserWin = false;
        this.isUserFirstPick = true;
    }

    // 1. 먼저 사용자가 한 게임을 플레이하는 메서드를 작성하기
    //    사용자가 게임에서 승리했는지 여부를 나타내는 boolean 값을 리턴
    //    사용자가 이기면 true, 딜러(컴퓨터)가 이기면 false 리턴
    public boolean playGameByUser(Scanner sc) {

        deck.shuffle();

        // 각 플레이어의 손에 두 장의 카드가 분배된다
        this.distributeTwoCardsToPlayers();
        checkGameEnd();

        // 게임이 종료되는지 조건을 체크한다
        while (! this.isGameEnd) {

            // 게임이 아직 종료되지 않은 경우
            // 사용자는 자신의 손에 몇 장의 카드를 추가할 수 있는 기회를 얻는다.
            // 이 단게에서 사용자는 자신의 카드를 보고, 딜러의 두 카드 중 하나를 본다.
            // 카지노에서는 딜러가 한 장을 앞면으로 돌리고 다른 한 장은 뒷면으로 둔 채로 보여준다.
            

            // 사용자는 Hit or Stand를 할지 말지 정할 수 있다 
            // Hit : 또 다른 카드를 손에 추가
            // Stand : 카드 받기를 중단
            this.chooseHitOrStand(sc);
        }

        if (this.isUserWin) {
            return true;
        } else {
            return false;
        }

    }

    public void distributeTwoCardsToPlayers() {
        // 각 플레이어의 손에 두 장의 카드가 분배된다
        for (int i = 0; i < 2; i++) {
            dealerHand.addCard(deck.dealCard());
            userHand.addCard(deck.dealCard());
        }
    }



    public void checkGameEnd() {
        // 게임이 종료되는지 조건을 체크한다
        this.isGameEnd = true;

        int dealerValue = dealerHand.getBlackjackValue();
        int userValue = userHand.getBlackjackValue();

        if (dealerValue == 21) {
            this.isUserWin = false;
        } else if (userValue == 21) {
            this.isUserWin = true;
        } else if (dealerValue == userValue) {
            this.isUserWin = false;
        } else {
            this.isGameEnd = false;
        }
    }



    public boolean isGameEnd() {
        return this.isGameEnd;
    }



    public void viewUserHand() {
        // 사용자는 자신의 모든 카드를 본다
        System.out.println("--------------------------------------");
        for (int i = 0; i < userHand.getCardCount(); i++) {
            System.out.println("User 의 " + (i + 1) + " 번째 카드 : " + userHand.getCard(i));
        }
        System.out.println("--------------------------------------");
    }



    public void viewOneCardOfDealer() {
        // 사용자는 딜러의 두 카드 중 하나를 본다
        int dealerCardCount = dealerHand.getCardCount();
        int randomCardIndex = (int) (dealerCardCount * Math.random());
        System.out.println("Dealer 의 " + (randomCardIndex + 1) + " 번째 카드 : " + dealerHand.getCard(randomCardIndex));
        System.out.println("Dealer 의 다른 한 장은 비밀입니다 ! ");
    }

    public void viewDealerHand() {
        // 사용자는 딜러의 모든 카드를 본다
        System.out.println("-------------------------------------");
        for (int i = 0; i < dealerHand.getCardCount(); i++) {
            System.out.println("Dealer 의 " + (i + 1) + " 번째 카드 : " + dealerHand.getCard(i));
        }
    }

    // 사용자가 Hit 하면 사용자는 21 초과될 가능성이 있다.
    //       이런 경우 게임이 끝나고 사용자가 패배한다.
    // 그렇지 않은 경우 사용자가 Hit 또는 Stand 여부를 다시 결정하게 된다. (프로세스 계속되는 것)
    public void hit() {
        if (this.isUserFirstPick) {
            userHand.addCard(deck.dealCard());

            if (userHand.getBlackjackValue() > 21) {
                isUserWin = false;
                this.isGameEnd = true;
            }
        } else {
            System.out.println("Dealer 의 hit 차례!!");
            dealerHand.addCard(deck.dealCard());

            // 이 시점에서 사용자는 딜러의 모든 카드를 볼 수 있다.
            viewDealerHand();

            if (dealerHand.getBlackjackValue() > 21) {
                this.isUserWin = true;
            } else if (dealerHand.getBlackjackValue() >= userHand.getBlackjackValue()) {
                this.isUserWin = false;
            } else {
                this.isUserWin = true;
            }

            this.isGameEnd = true;
        }
        checkGameEnd();
    }

    // 사용자가 Stand 하면 게임이 종료되지만, 먼저 딜러가 카드를 뽑을 기회를 얻는다.
    // 딜러는 선택의 여지 없이 규칙만을 뜨른다.
    // 규칙은 딜러의 패값이 16 이하인 한, 딜러는 Hit (다른 카드를 가져옴) 한다는 것
    public void stand() {
        this.isUserFirstPick = false; // 딜러 차례

        if (dealerHand.getBlackjackValue() <= 16) {
            hit(); // 딜러 hit -> 승자 결정까지 여기서 다 함
        }

        this.isGameEnd = true;
    }


    public void chooseHitOrStand(Scanner sc) {

        do {
            this.viewUserHand();
            this.viewOneCardOfDealer();
            System.out.println("-----------------------------------------------------");

            System.out.print("User 님! hit 과 stand 중 택1 하여 여기에 적어주세요 : ");
            String choosen = sc.nextLine().trim().toLowerCase();

            if (choosen.equals("hit")) {
                hit();
                if (isGameEnd()) {
                    break;
                }
            } else if (choosen.equals("stand")) {
                stand();
                if (isGameEnd()) {
                    break;
                }
            } else {
                System.out.println("잘못된 문자를 입력해주셨습니다. 다시 시도하러 가주세요!");
            }

        } while (! isGameEnd());

    }

    public void printGameResult(boolean isUserWin) {
        if(isUserWin) {
            System.out.println("당신이 딜러(컴퓨터)를 이겼습니다! 축하드립니다!!! (짝짝짝)");
        } else {
            System.out.println("딜러가 승리하고, 당신이 졌습니다...! 아쉽지만 다음 기회를 노려보세요!!");
            System.out.println("할 수 있습니다!!!");
        }
    }


}
