package com.elo.cardgame;

import com.elo.cardgame.controller.GameController;
import com.elo.cardgame.games.HighCardGameEvaluator;
import com.elo.cardgame.games.LowCardGameEvaluator;
import com.elo.cardgame.model.DeckFactory;
import com.elo.cardgame.view.CommandLineView;
import com.elo.cardgame.view.GameSwingPassiveView;
import com.elo.cardgame.view.GameSwingView;
import com.elo.cardgame.view.GameViewables;

public class Games {
    public static void main(String[] args) {
        // hold multiple views
        GameViewables views = new GameViewables();

        // create a Swing view
        GameSwingView gsv = new GameSwingView();
        gsv.createAndShowGUI();
        views.addViewable(gsv);

        // instantiate multiple passive Swing views
        for (int i = 0; i < 3; i++) {
            GameSwingPassiveView passiveView = new GameSwingPassiveView();
            passiveView.createAndShowGUI();
            views.addViewable(passiveView);

            // sleep to move new Swing frame on window
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        GameController gc = new GameController(DeckFactory.makeDeck(DeckFactory.DeckType.Normal), views, new HighCardGameEvaluator()); // highest card win
//        GameController gc = new GameController(new Deck(), new CommandLineView(), new LowCardGameEvaluator()); // lowest card win
        gc.run();
    }
}
