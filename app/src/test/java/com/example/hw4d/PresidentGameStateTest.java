package com.example.hw4d;

import com.example.hw4d.Player.GamePlayer;

import org.junit.Test;

import java.util.ArrayList;

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
        PresidentGameState test = new PresidentGameState();

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
        PresidentGameState test = new PresidentGameState();
        GamePlayer player1 = new GamePlayer();
        Card lowp1 = new Card(5, "Spades");
        Card lowp2 = new Card(7, "Spades");
        player1.addCard(lowp1);
        player1.addCard(lowp2);
        player1.addCard(new Card(12,"Spades"));
        GamePlayer player2 = new GamePlayer();
        Card lowvp = new Card(5,"Hearts");
        player2.addCard(lowvp);
        player2.addCard(new Card(7, "Hearts"));
        player2.addCard(new Card(12,"Hearts"));
        GamePlayer player3 = new GamePlayer();
        Card highvs = new Card(12,"Diamonds");
        player3.addCard(new Card(5,"Diamonds"));
        player3.addCard(new Card(7, "Diamonds"));
        player3.addCard(highvs);
        GamePlayer player4 = new GamePlayer();
        Card highs1 = new Card(12, "Clubs");
        Card highs2 = new Card(11, "Clubs");
        player4.addCard(new Card(5,"Clubs"));
        player4.addCard(highs1);
        player4.addCard(highs2);
        player1.setRank("President");
        player2.setRank("Vice President");
        player3.setRank("Vice Scum");
        player4.setRank("Scum");
        ArrayList<GamePlayer> player = new ArrayList<GamePlayer>();
        player.add(player1);
        player.add(player2);
        player.add(player3);
        player.add(player4);
        test.setPlayers(player);
        test.setRoundStart(true);
        test.trade();
        Card correct = new Card(55, "Nope");

        /** CHECK FOR PRESIDENT */
            for(int i = 0; i < player.size(); i++) {
                assertEquals(player.get(i).getHand().size(), 3);
            }
        for(Card c : player1.getHand()){
            if (c.getValue() == highs1.getValue() && c.getSuit().equals(highs1.getSuit())){
                correct.setCardVal(highs1.getValue());
                correct.setCardSuit(highs1.getSuit());
            }
        }
        assertTrue(highs1.getValue() == correct.getValue() && highs1.getSuit().equals(correct.getSuit()));
        for(Card c : player1.getHand()){
            if (c.getValue() == highs2.getValue() && c.getSuit().equals(highs2.getSuit())){
                correct.setCardVal(highs2.getValue());
                correct.setCardSuit(highs2.getSuit());
            }
        }
        assertTrue(highs2.getValue() == correct.getValue() && highs2.getSuit().equals(correct.getSuit()));
    }
    @Test
    public void getMaxCard() {
        PresidentGameState testState = new PresidentGameState();
        GamePlayer player1 = new GamePlayer();
        ArrayList<GamePlayer> players = new ArrayList<GamePlayer>();
        players.add(player1);
        testState.setPlayers(players);
        Card newCard1 = new Card(8, "Spades");
        Card newCard2 = new Card(7, "Spades");
        Card newCard3 = new Card(6, "Spades");
        player1.addCard(newCard1);
        player1.addCard(newCard2);
        player1.addCard(newCard3);
        int val = testState.getMaxCard(player1.getHand()).getValue();
        assertEquals(val, 8);
    }

    @Test
    public void getMinCard() {
        PresidentGameState testState = new PresidentGameState();
        GamePlayer player1 = new GamePlayer();
        ArrayList<GamePlayer> players = new ArrayList<GamePlayer>();
        players.add(player1);
        testState.setPlayers(players);
        Card newCard1 = new Card(8, "Hearts");
        Card newCard2 = new Card(7, "Spades");
        Card newCard3 = new Card(9, "Spades");
        player1.addCard(newCard1);
        player1.addCard(newCard2);
        player1.addCard(newCard3);
        int val = testState.getMinCard(player1.getHand()).getValue();
        assertEquals(val, 7);
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
        ArrayList<GamePlayer> players = new ArrayList<GamePlayer>();
        players.add(winPlayer);
        winPlayer.setScore(15);
        testState.setPlayers(players);
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