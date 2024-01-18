package com.elo.cardgame;

import com.elo.cardgame.controller.GameController;
import com.elo.cardgame.games.HighCardGameEvaluator;
import com.elo.cardgame.games.LowCardGameEvaluator;
import com.elo.cardgame.model.Deck;
import com.elo.cardgame.view.CommandLineView;

public class Games {
    public static void main(String[] args) {
        GameController gc = new GameController(new Deck(), new CommandLineView(), new HighCardGameEvaluator()); // highest card win
//        GameController gc = new GameController(new Deck(), new CommandLineView(), new LowCardGameEvaluator()); // lowest card win
        gc.run();
    }
}
