package com.elo.cardgame.view;

import com.elo.cardgame.controller.GameController;

public class View {
    public void something() {};
    public void setController(GameController gc) {};

    public void promptForPlayerName() {}
    public void promptForFlip() {}
    public void promptForNewGame() {}
    public void showWinner(String name) {}
    public void showPlayerName(int size, String playerName) {}
    public void showFaceDownCardForPlayer(int i, String name) {}
    public void showCardForPlayer(int i, String name, String rank, String suit) {}
}
