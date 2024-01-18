package com.elo.cardgame;

import com.elo.cardgame.controller.GameController;
import com.elo.cardgame.games.HighCardGameEvaluator;
import com.elo.cardgame.games.LowCardGameEvaluator;
import com.elo.cardgame.model.DeckFactory;
import com.elo.cardgame.view.CommandLineView;
import com.elo.cardgame.view.GameSwingView;

public class Games {
    public static void main(String[] args) {
        GameSwingView gsv = new GameSwingView();
        gsv.createAndShowGUI();

        GameController gc = new GameController(DeckFactory.makeDeck(DeckFactory.DeckType.Normal), gsv, new HighCardGameEvaluator()); // highest card win
//        GameController gc = new GameController(new Deck(), new CommandLineView(), new LowCardGameEvaluator()); // lowest card win
        gc.run();
    }
}
