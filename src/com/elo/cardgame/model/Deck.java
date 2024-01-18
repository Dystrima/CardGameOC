package com.elo.cardgame.model;

import java.util.*;

public abstract class Deck {
    protected List<PlayingCard> cards; // a list to store all the cards

    // constructor to create all 52 unique cards with 2 loops to get all ranks in all suits
    public Deck() {
        cards = new ArrayList<PlayingCard>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                System.out.println("Creating card [" + rank + "][" + suit + "]");
                cards.add(new PlayingCard(rank, suit));
            }
        }
        shuffle();
    }

    // shuffle the cards
    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < cards.size(); ++i) {
            Collections.swap(cards, i, random.nextInt(cards.size()));
        }
    }

    // drawing the first card of the deck
    public PlayingCard removeTopCard() {
        return cards.remove(0);
    }

    // getting a card back into the deck
    public void returnCardToDeck(PlayingCard pc) {
        cards.add(pc);
    }

    // the getter for the deck
    public List<PlayingCard> getCards() {
        return cards;
    }
}
