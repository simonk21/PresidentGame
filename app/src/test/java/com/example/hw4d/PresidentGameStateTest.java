package com.example.hw4d;

import com.example.hw4d.Player.GamePlayer;

import org.junit.Test;

import static org.junit.Assert.*;

public class PresidentGameStateTest {

    @Test
    public void getPlayedCards() {
    }

    @Test
    public void setPlayedCards() {
    }

    @Test
    public void getPlayers() {
    }

    @Test
    public void setPlayers() {
    }

    @Test
    public void getCurrentSet() {
    }

    @Test
    public void setCurrentSet() {
    }

    @Test
    public void getCurrentValid() {
    }

    @Test
    public void getCurrentPlayer() {
    }

    @Test
    public void setCurrentPlayer() {
    }

    @Test
    public void getLastPlayed() {
    }

    @Test
    public void setLastPlayed() {
    }

    @Test
    public void setPlayerSet() {
    }

    @Test
    public void setRoundStart() {
    }

    @Test
    public void trade() {
    }

    @Test
    public void getMaxCard() {
    }

    @Test
    public void getMinCard() {
        PresidentGameState testState = new PresidentGameState();
        GamePlayer player = new GamePlayer();
        Card newCard1 = new Card(8, "Spades");
        Card newCard2 = new Card(7, "Spades");
        Card newCard3 = new Card(6, "Spades");
        player.addCard(newCard1);
        player.addCard(newCard2);
        player.addCard(newCard3);
        assertTrue(testState.getMinCard(player.getHand()).getValue() == 6);
    }

    @Test
    public void quit() {
    }

    @Test
    public void pass() {
    }

    @Test
    public void setFinish() {
    }

    @Test
    public void gameWon() {
        PresidentGameState testState = new PresidentGameState();
        GamePlayer winPlayer =  new GamePlayer();
        winPlayer.setScore(11);
        testState.gameWon(winPlayer);
        assertTrue(testState.gameWon(winPlayer));
    }

    @Test
    public void nextPlayer() {
    }

    @Test
    public void playersWithCards() {
    }

    @Test
    public void testToString() {
    }

    @Test
    public void find() {
    }

    @Test
    public void quit1() {
    }

    @Test
    public void playCard() {
    }
}