package com.elo.cardgame.model;

public class DeckFactory {
    public enum DeckType {
        Normal,
        Small,
        Test
    };

    // method to specify what type of deck to create
    public static Deck makeDeck(DeckType type) {
        switch (type) {
            case Normal: return new NormalDeck();
            case Small: return new SmallDeck();
            case Test: return new TestDeck();
        }
        // fallback
        return new NormalDeck();
    }
}
