package com.elo.cardgame.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<PlayingCard> cards;

    // controller
    public Hand() {
        cards = new ArrayList<PlayingCard>();
    }

    // add a card to the hand
    public void addCard(PlayingCard pc) {
        cards.add(pc);
    }

    // getter for the card
    public PlayingCard getCard(int index) {
        return cards.get(index);
    }

    // remove a card from the hand
    public PlayingCard removeCard() {
        return cards.remove(0);
    }
}
