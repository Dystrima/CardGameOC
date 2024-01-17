package com.elo.cardgame.controller;

import com.elo.cardgame.model.Deck;
import com.elo.cardgame.model.Player;
import com.elo.cardgame.model.PlayingCard;
import com.elo.cardgame.view.View;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    // enum for game state
    enum GameState {
        AddingPlayers, CardsDealt, WinnerRevealed;
    }
    Deck deck;
    List<Player> players;
    Player winner;
    View view;

    // variable to contain game state
    GameState gameState;

    // constructor
    public GameController(Deck deck, View view) {
        super();
        this.deck = deck;
        this.view = view;
        this.players = new ArrayList<Player>();
        this.gameState = GameState.AddingPlayers;
        view.setController(this);
    }

    // looks at the game state and call view methods
    // loops on AddingPlayers to add as many players as we want
    public void run() {
        while (gameState == GameState.AddingPlayers) {
            view.promptForPlayerName();
        }
        switch (gameState) {
            case CardsDealt:
                view.promptForFlip();
                break;
            case WinnerRevealed:
                view.promptForNewGame();
                break;
        }
    }

    // add a player
    public void addPlayer(String playerName) {
        if (gameState == GameState.AddingPlayers) {
            players.add(new Player(playerName));
            view.showPlayerName(players.size(), playerName);
        }
    }

    // start the game -> shuffle
    public void startGame() {
        if (gameState != GameState.CardsDealt) {
            deck.shuffle();
            int playerIndex = 1;
            for (Player player : players) {
                player.addCardToHand(deck.removeTopCard());
                view.showFaceDownCardForPlayer(playerIndex++, player.getName());
            }
            gameState = GameState.CardsDealt;
        }
        this.run();
    }

    // show cards and start over
    public void flipCards() {
        int playerIndex = 1;
        for (Player player : players) {
            PlayingCard pc = player.getCard(0);
            pc.flip();
            view.showCardForPlayer(playerIndex++, player.getName(), pc.getRank().toString(), pc.getSuit().toString());
        }
        evaluateWinner();
        displayWinner();
        rebuildDeck();
        gameState = GameState.WinnerRevealed;
        this.run();
    }

    // initiate variables look at the card of each player and compare it to the other
    void evaluateWinner() {
        Player bestPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;

        for(Player player : players) {
            boolean newBestPlayer = false;

            if (bestPlayer == null) {
                newBestPlayer = true;
            } else {
                PlayingCard pc = player.getCard(0);
                int thisRank = pc.getRank().value();
                if (thisRank >= bestRank) {
                    if (thisRank > bestRank) {
                        newBestPlayer = true;
                    } else {
                        if (pc.getSuit().value() > bestSuit) {
                            newBestPlayer =  true;
                        }
                    }
                }
            }

            if (newBestPlayer) {
                bestPlayer = player;
                PlayingCard pc = player.getCard(0);
                bestRank = pc.getRank().value();
                bestSuit = pc.getSuit().value();
            }
        }

        winner = bestPlayer;
    }

    void displayWinner() {
        view.showWinner(winner.getName());
    }

    void rebuildDeck() {
        for (Player player : players) {
            deck.returnCardToDeck(player.removeCard());
        }
    }
}
