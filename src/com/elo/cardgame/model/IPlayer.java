package com.elo.cardgame.model;

public interface IPlayer {
    // add a card to the player
    public void addCardToHand(PlayingCard pc);

    // get the card
    public PlayingCard getCard(int index);

    // remove a card from the player's hand
    public PlayingCard removeCard();

    public String getName();
}
