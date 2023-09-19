package com.nhnacademy.parkminsu.Exercise5_5;

public class BlackjackCondition {

    public static boolean deckCondition(BlackjackHand userOrDealer) {
        return userOrDealer.getBlackjackValue() == 21;
    }

    public static boolean bustCondtion(BlackjackHand userOrDealer) {
        return userOrDealer.getBlackjackValue() <= 21;
    }

    public static boolean hitOrStandard(String callSign, String compareStr) {
        return callSign.equals(compareStr);
    }


    public static boolean dealerkDeckCheck(BlackjackHand dealer) { // 딜러가 카드를 받을지 안받을지의 조건
        return dealer.getBlackjackValue() <= 16; // true면 카드를 받음, false면 카드 x
    }

    public static boolean victoryCondition(BlackjackHand user, BlackjackHand dealer) {
        if (bustCondtion(user) && bustCondtion(dealer)) {
            return user.getBlackjackValue() > dealer.getBlackjackValue();
        } else if (bustCondtion(user) && !bustCondtion(dealer)) { // dealer bust
            return true;
        } else if (!bustCondtion(user) && bustCondtion(dealer)) { // user bust
            return false;
        } else { // 둘다 bust
            return user.getBlackjackValue() < dealer.getBlackjackValue();
        }
    }


    public static boolean checkCallValue(String callSign) {
        if (callSign.isEmpty()) {
            throw new IllegalArgumentException("빈 칸을 입력하셨습니다.");
        }
        callSign = callSign.toUpperCase();
        return hitOrStandard(callSign, "STANDARD") || hitOrStandard(callSign, "HIT");

    }

}
