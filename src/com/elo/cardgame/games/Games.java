package com.elo.cardgame.games;

import com.elo.cardgame.controller.GameController;
import com.elo.cardgame.model.Deck;
import com.elo.cardgame.view.View;

public class Games {
    public static void main(String[] args) {
        GameController gc = new GameController(new Deck(), new View());
        gc.run();
    }
}
