package com.elo.cardgame.model;

public class Player {

    private String name;
    private Hand hand;

    // constructor for the player, they can only choose their name
    public Player(String name) {
        super();
        this.name = name;
        hand = new Hand();
    }

    // add a card to the player
    public void addCardToHand(PlayingCard pc) {
        hand.addCard(pc);
    }

    // get the card
    public PlayingCard getCard(int index) {
        return hand.getCard(index);
    }

    // remove a card from the player's hand
    public PlayingCard removeCard() {
        return hand.removeCard();
    }

    public String getName() {
        return name;
    }
}
