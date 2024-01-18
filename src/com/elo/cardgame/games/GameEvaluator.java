package com.elo.cardgame.games;

import com.elo.cardgame.model.IPlayer;

import java.util.List;

public interface GameEvaluator {
    // initiate variables look at the card of each player and compare it to the other
    public IPlayer evaluateWinner(List<IPlayer> players);
}
