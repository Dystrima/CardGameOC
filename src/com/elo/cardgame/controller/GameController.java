package com.elo.cardgame.controller;

import com.elo.cardgame.games.GameEvaluator;
import com.elo.cardgame.model.*;
import com.elo.cardgame.view.GameViewable;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    // enum for game state
    enum GameState {
        AddingPlayers, CardsDealt, WinnerRevealed;
    }
    Deck deck;
    List<IPlayer> players;
    IPlayer winner;
    GameViewable view;

    // variable to contain game state
    GameState gameState;
    GameEvaluator evaluator;

    // constructor
    public GameController(Deck deck, GameViewable view, GameEvaluator gameEvaluator) {
        super();
        this.deck = deck;
        this.view = view;
        this.players = new ArrayList<IPlayer>();
        this.gameState = GameState.AddingPlayers;
        this.evaluator = gameEvaluator;
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
            for (IPlayer player : players) {
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
        for (IPlayer player : players) {
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

    void evaluateWinner() {
        winner = new WinningPlayer(evaluator.evaluateWinner(players));
    }

    void displayWinner() {
        view.showWinner(winner.getName());
    }

    void rebuildDeck() {
        for (IPlayer player : players) {
            deck.returnCardToDeck(player.removeCard());
        }
    }

    // quit the game
    void exitGame() {
        System.exit(0);
    }

    public void nextAction(String nextChoice) {
        if ("+q".equals(nextChoice)) {
            exitGame();
        } else {
            startGame();
        }
    }
}
