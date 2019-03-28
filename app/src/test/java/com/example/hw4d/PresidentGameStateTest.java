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
        PlayerInfo player1 = new PlayerInfo();
        Card lowp1 = new Card(5, "Spades");
        Card lowp2 = new Card(7, "Spades");
        player1.addCard(lowp1);
        player1.addCard(lowp2);
        player1.addCard(new Card(12,"Spades"));
        PlayerInfo player2 = new PlayerInfo();
        Card lowvp = new Card(5,"Hearts");
        player2.addCard(lowvp);
        player2.addCard(new Card(7, "Hearts"));
        player2.addCard(new Card(12,"Hearts"));
        PlayerInfo player3 = new PlayerInfo();
        Card highvs = new Card(12,"Diamonds");
        player3.addCard(new Card(5,"Diamonds"));
        player3.addCard(new Card(7, "Diamonds"));
        player3.addCard(highvs);
        PlayerInfo player4 = new PlayerInfo();
        Card highs1 = new Card(12, "Clubs");
        Card highs2 = new Card(11, "Clubs");
        player4.addCard(new Card(5,"Clubs"));
        player4.addCard(highs1);
        player4.addCard(highs2);
        player1.setRank("President");
        player2.setRank("Vice President");
        player3.setRank("Vice Scum");
        player4.setRank("Scum");
        test.setPlayers(player1);
        test.setPlayers(player2);
        test.setPlayers(player3);
        test.setPlayers(player4);
        test.setRoundStart(true);
        test.trade();
        Card correct = new Card(55, "Nope");

        /** CHECK FOR PRESIDENT */
        assertEquals(player1.getHand().size(), 3);
        for(Card c : player1.getHand()){
            if (c.getValue() == highs1.getValue() && c.getSuit().equals(highs1.getSuit())){
                correct.setCardVal(highs1.getValue());
                correct.setCardSuit(highs1.getSuit());
            }
        }
        assertTrue(highs1.getValue() == correct.getValue() && highs1.getSuit().equals(correct.getSuit()));
//        for(Card c : player1.getHand()){
//            if (c.getValue() == highs2.getValue() && c.getSuit().equals(highs2.getSuit())){
//                correct.setCardVal(highs2.getValue());
//                correct.setCardSuit(highs2.getSuit());
//            }
//        }
//        assertTrue(highs2.getValue() == correct.getValue() && highs2.getSuit().equals(correct.getSuit()));
    }
    @Test
    public void getMaxCard() {
        PresidentGameState testState = new PresidentGameState();
        PlayerInfo player = new PlayerInfo();
        testState.setPlayers(player);
        Card newCard1 = new Card(8, "Spades");
        Card newCard2 = new Card(7, "Spades");
        Card newCard3 = new Card(6, "Spades");
        player.addCard(newCard1);
        player.addCard(newCard2);
        player.addCard(newCard3);
        int val = testState.getMaxCard(player.getHand()).getValue();
        assertEquals(val, 8);
    }

    @Test
    public void getMinCard() {
        PresidentGameState testState = new PresidentGameState();
        GamePlayer player = new GamePlayer();
        Card newCard1 = new Card(8, "Spades");
        Card newCard2 = new Card(7, "Spades");
        Card newCard3 = new Card(9, "Spades");
        player.addCard(newCard1);
        player.addCard(newCard2);
        player.addCard(newCard3);
        testState.setPlayers(player);
        int val = testState.getMinCard(player.getHand()).getValue();
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
        PlayerInfo winPlayer =  new PlayerInfo();
        winPlayer.setScore(15);
        testState.setPlayers(winPlayer);
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