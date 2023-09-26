package com.nhnacademy.parkminsu.exercise5_5;

public class BlackjackCondition {
    // static : c의 함수
    // 싱글턴
    // 데이터 동작이 1개만 있을 때

    public boolean deckCondition(BlackjackHand userOrDealer) {
        return userOrDealer.getBlackjackValue() == 21;
    }

    public boolean notBustCondtion(BlackjackHand userOrDealer) {
        return userOrDealer.getBlackjackValue() <= 21;
    }

    public boolean hitOrStandard(String callSign, String compareStr) {
        return callSign.equals(compareStr);
    }


    public boolean dealerDeckCheck(BlackjackHand dealer) { // 딜러가 카드를 받을지 안받을지의 조건
        return dealer.getBlackjackValue() <= 16; // true면 카드를 받음, false면 카드 x
    }

    public boolean victoryCondition(BlackjackHand user, BlackjackHand dealer) {
        if (notBustCondtion(user) && notBustCondtion(dealer)) {
            return user.getBlackjackValue() > dealer.getBlackjackValue();
        } else if (notBustCondtion(user) && !notBustCondtion(dealer)) { // dealer bust
            return true;
        } else if (!notBustCondtion(user) && notBustCondtion(dealer)) { // user bust
            return false;
        }
        return false;
    }


    public boolean checkCallValue(String callSign) {
        if (callSign.isEmpty()) {
            throw new IllegalArgumentException("빈 칸을 입력하셨습니다.");
        }
        callSign = callSign.toUpperCase();
        return hitOrStandard(callSign, "STAND") || hitOrStandard(callSign, "HIT");

    }

}
