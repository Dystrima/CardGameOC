package com.elo.cardgame.model;

public class PlayingCard {
    private Rank rank;
    private Suit suit;
    private boolean faceUp; // knowing if the card is up or not

    // constructor using the value (rank) and the color (suit) of the card
    public PlayingCard(Rank rank, Suit suit) {
        super();
        this.rank = rank;
        this.suit = suit;
    }

    // only getters because we don't want the users to be able to cheat by setting a value
    public Rank getRank() {
        return rank;
    }
    public Suit getSuit() {
        return suit;
    }
    public boolean isFaceUp() {
        return faceUp;
    }
    // method to invert faceUp and flip the card
    public boolean flip() {
        faceUp = !faceUp;
        return faceUp;
    }
}
