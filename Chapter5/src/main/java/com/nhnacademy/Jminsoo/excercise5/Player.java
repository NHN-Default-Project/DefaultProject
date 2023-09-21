package com.nhnacademy.Jminsoo.excercise5;

public class Player implements BlackjackPlayer {
    private String name;
    private BlackjackHand hand;


    public Player(String name, BlackjackHand hand) {
        this.name = name;
        this.hand = hand;
    }

    public BlackjackHand getHand() {
        return this.hand;
    }

    public String getName() {
        return this.name;
    }

    public int getHandValue() {
        return this.hand.getBlackjackValue();
    }


}
