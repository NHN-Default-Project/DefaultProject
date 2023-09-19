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

        int val;      // The value computed for the hand.
        boolean ace;  // This will be set to true if the
        //   hand contains an ace.
        int cards;    // Number of cards in the hand.


        val = 0;
        ace = false;
        cards = getCardCount();  // (method defined in class Hand.)

        for (int i = 0; i < cards; i++) {
            // Add the value of the i-th card in the hand.
            Card card;    // The i-th card;
            int cardVal;  // The blackjack value of the i-th card.
            card = getCard(i);
            cardVal = card.getValue();  // The normal value, 1 to 13.
            if (cardVal > 10) {
                cardVal = 10;   // For a Jack, Queen, or King.
            }
            if (cardVal == 1) {
                ace = true;     // There is at least one ace.
            }
            val = val + cardVal;
        }

        // Now, val is the value of the hand, counting any ace as 1.
        // If there is an ace, and if changing its value from 1 to
        // 11 would leave the score less than or equal to 21,
        // then do so by adding the extra 10 points to val.

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