package com.nhnacademy.gaeun.exercise05;

public class BlackjackHand extends Hand {
    private String name;
    private int sumBlackjackValues;
    int openCardNum = 0;

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    BlackjackHand(String name) {
        this.name = name;
    }

    /**
     * Computes and returns the value of this hand in the game
     * of Blackjack.
     */
    public int getBlackjackValue() {
        int val;
        boolean ace;
        int cards;

        val = 0;
        ace = false;
        cards = getCardCount();  // (method defined in class Hand.)

        for (int i = 0; i < cards; i++) {
            // Add the value of the i-th card in the hand.
            Card card;    // The i-th card;
            int cardVal;  // The blackjack value of the i-th card.
            card = getCard(i);
            cardVal = card.getValue();  // The normal value, 1 to 13.
            if (cardVal > 10) cardVal = 10;
            if (cardVal == 1) ace = true;
            val = val + cardVal;
        }
        if (ace == true && val + 10 <= 21) {
            val = val + 10;
        }
        return val;
    }  // end getBlackjackValue()

    public void openCard(BlackjackHand blackjackHand) {
        System.out.println("===== " + getName() + " =====");
        for (int i = 0; i < getCardCount(); i++) {
            System.out.printf("%s, %s\n", getCard(i).getSuitAsString(), getCard(i).getValueAsString());
        }
        System.out.println();
        System.out.println("===== " + blackjackHand.getName() + " =====");
        for (int i = 1; i < blackjackHand.getCardCount(); i++) {
            System.out.printf("%s, %s\n",
                    blackjackHand.getCard(i).getSuitAsString(), blackjackHand.getCard(i).getValueAsString());
        }
    }

    public int whoIsWin() {
        if (this.getBlackjackValue() == 21) return 0;
        if (this.getBlackjackValue() > 21) return 1;
        else return -1;
    }

    public String getName() {
        return name;
    }
} // end class BlackjackHand