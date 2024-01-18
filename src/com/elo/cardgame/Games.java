package com.elo.cardgame;

import com.elo.cardgame.controller.GameController;
import com.elo.cardgame.games.GameEvaluator;
import com.elo.cardgame.games.HighCardGameEvaluator;
import com.elo.cardgame.model.Deck;
import com.elo.cardgame.view.View;

public class Games {
    public static void main(String[] args) {
        GameController gc = new GameController(new Deck(), new View(), new HighCardGameEvaluator()); // best card win
        gc.run();
    }
}
