package com.elo.cardgame.model;

public enum Suit {
//    NONE (0), // joker
    DIAMONDS (1),
    HEARTS (2),
    SPADES (3),
    CLUBS (4);

    int suit;

    private Suit(int value) {
        suit = value;
    }

    public int value() {
        return suit;
    }
}
