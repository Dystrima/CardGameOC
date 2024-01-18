package com.elo.cardgame.games;

import com.elo.cardgame.model.Player;
import com.elo.cardgame.model.PlayingCard;

import java.util.List;

public interface GameEvaluator {
    // initiate variables look at the card of each player and compare it to the other
    public Player evaluateWinner(List<Player> players);
}
