package com.example.hw4d;

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

    /** vinoya21 */
    @Test
    public void getCurrentPlayer() {
        PresidentGameState gs = new PresidentGameState();
        assertEquals(0, gs.getCurrentPlayer());
        gs.nextPlayer();
        assertEquals(1, gs.getCurrentPlayer());
    }

    @Test
    public void setCurrentPlayer() {
        PresidentGameState test = new PresidentGameState();
        test.setCurrentPlayer(1);
        int turn = test.getCurrentPlayer();
        assertEquals(turn, 1);
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
    }

    @Test
    public void quit() {
    }

    @Test
    public void pass() {
        PresidentGameState test = new PresidentGameState();
        test.setCurrentPlayer(0);
        int turn = test.getCurrentPlayer();
        assertEquals(0,turn);
        boolean check = test.pass(0);
        assertTrue(check);
        boolean check1 = test.pass(6);
        assertTrue(!check1);

    }

    @Test
    public void setFinish() {
    }

    @Test
    public void gameWon() {
    }

    /** vinoya21 */
    @Test
    public void nextPlayer() {
        PresidentGameState gs = new PresidentGameState();
        assertEquals(0, gs.getCurrentPlayer());
        gs.nextPlayer();
        assertEquals(1, gs.getCurrentPlayer());
        gs.nextPlayer();
        assertEquals(2, gs.getCurrentPlayer());
        gs.nextPlayer();
        assertEquals(3, gs.getCurrentPlayer());
        gs.nextPlayer();
        assertEquals(4, gs.getCurrentPlayer());
        gs.nextPlayer();
        assertEquals(0, gs.getCurrentPlayer());
    }

    @Test
    public void playersWithCards() {
    }

//    @Test
//    public void toString() {
//    }

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