package com.example.hw4d;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * PresidentGameState.java
 *
 * @author Ben Pirkl
 * @author Geryl Vinoya
 * @author Kama Simon
 * @author Hera Malik
 *
 * @version February 2019
 *
 */
public class PresidentGameState implements Serializable {

    /** Cards Played Already like Discard Pile */
    private ArrayList<Card> playedCards;

    /** Players */
    private ArrayList<PlayerInfo> players;

    /** Current Played Cards */
    private ArrayList<Card> currentSet;

    /** Used to check if current player's set is valid */
    private ArrayList<Card> currentValid;

    /** Current Player's hand */
    private ArrayList<Card> currentPlayerHand;

    /** whose turn it is and who previously played */
    private int turn;
    private int prevTurn;

    /** Number of Players in Game */
    private static int NUMPLAYERS = 5;

    /**
     * PresidentGameState Constructor
     */
    public PresidentGameState() {
        /* Initialize deck */
        Deck deck = new Deck();

        /* MAKE AN EMPTY LIST OF CARDS FOR DISCARD PILE AND
        * EMPTY LIST OF PLAYERS */
        playedCards = new ArrayList<>();
        players = new ArrayList<>();

        /* CREATE NEW PLAYER AND ADD TO LIST */
        for (int i = 0; i < NUMPLAYERS; i++) {
            PlayerInfo temp = new PlayerInfo();
            players.add(temp);
        }

        /** CREATE'S PLAYER'S HAND */
        int count = 0;
        int size = deck.size();

        for (int i = 0; i < size; i++) {
            players.get(count).addCard(deck.getDeck().get(0));
            deck.remove(0);
            if (count < players.size() - 1 ) {
                count++;
            } else {
                count = 0;
            }
        }

        /* Initializes current set, current valid */
        currentSet = new ArrayList<>();
        currentValid = new ArrayList<>();

        /* Initializes player with index 0 to start */
        turn = 0;

        /* Initializes previous turn -1 since nobody played yet */
        prevTurn = -1;
    }

    /**
     * PresidentGameState Constructor
     * Copy constructor for Class PresidentGameState
     *
     * @param masterGameState the master game state
     */
    public PresidentGameState(PresidentGameState masterGameState) {
        playedCards = new ArrayList<>();
        for (Card c : masterGameState.playedCards) {
            playedCards.add(new Card(c.getValue(), c.getSuit()));
        }

        players = new ArrayList<>();
        for (PlayerInfo p : masterGameState.players) {
            PlayerInfo toAdd = new PlayerInfo(p);
            players.add(toAdd);
        }

        currentSet = new ArrayList<>();
        for (Card c : masterGameState.currentSet) {
            currentSet.add(new Card(c.getValue(), c.getSuit()));
        }

        currentValid = new ArrayList<>();
        for (Card c : masterGameState.currentValid) {
            currentValid.add(new Card(c.getValue(), c.getSuit()));
        }

        currentPlayerHand = new ArrayList<>();
        if (masterGameState.currentPlayerHand != null) {
            for (Card c : masterGameState.currentPlayerHand) {
                currentPlayerHand.add(new Card(c.getValue(), c.getSuit()));
            }
        }

        turn = masterGameState.getCurrentPlayer();
        prevTurn = masterGameState.getLastPlayed();
    }

    /** Returns played cards or discard pile */
    public ArrayList<Card> getPlayedCards() { return playedCards; }

    /** Returns the Player's Array list with their information */
    public ArrayList<PlayerInfo> getPlayers() { return players; }

    /** Returns Current Set */
    public ArrayList<Card> getCurrentSet() { return currentSet; }

    /** Returns if move is valid */
    public ArrayList<Card> getCurrentValid() { return currentValid; }

    /** Returns whose turn it is */
    public int getCurrentPlayer() { return turn; }

    /** Returns the turn of previous player */
    public int getLastPlayed() { return prevTurn; }

    /** */
    public void setPlayedCards(ArrayList<Card> in) { playedCards = in; }

    public void setPlayers(ArrayList<PlayerInfo> in) { players = in; }

    /** Sets the current set */
    public void setCurrentSet(ArrayList<Card> in) { currentSet = in; }

    public void setPlayerSet(ArrayList<Card>  in) { currentValid = in; }

    /** Sets the player, the hand, and valid cards */
    public void setCurrentPlayer(int in) {
        turn = in;
        currentPlayerHand = players.get(turn).getHand();
        currentValid = players.get(turn).getHand();
    }

    /** Sets previous player */
    public void setLastPlayed(int in) {
        prevTurn = in;
    }
    /* actions.txt methods */

    /**
     * trade
     * @return true (can trade) or false (cannot trade)
     */
    public boolean trade(){
        for(int i = 0; i < players.size(); i++){
            ArrayList<Card> scumHand = null;
            ArrayList<Card> viceScumHand = null;
            ArrayList<Card> presidentHand = null;
            ArrayList<Card> vicePresidentHand = null;

            if(players.get(i).getRank() == "President"){
                 presidentHand =  players.get(i).getHand();
                for(int findScum = 0; findScum < players.size(); findScum++){
                    if(players.get(findScum).getRank() == "Scum"){
                        scumHand = players.get(findScum).getHand();
                    }
                    for(int scumHandSize = 0; scumHandSize < scumHand.size(); scumHandSize++){
                    }
                }




                return true;
            }
            else if(players.get(i).getRank() == "Vice President"){
                return true;
            }
            else if(players.get(i).getRank() == "Scum"){
                return false;
            }
            else if(players.get(i).getRank() == "Vice Scum"){
                return false;
            }
        }
        return false;
    }

    /**
     * quit
     * @return true (player can quit game)
     */
    public boolean quit(){
        return true;
    }

    /**
     * pass
     * @return true (player can pass turn) or false (player cannot pass turn)
     */
    public boolean pass(int turn){
        if(this.turn != turn){
            return false;
        }
        return true;
    }


    /**
     * setFinish
     * Checks if someone won the game
     * @return
     */
    public boolean setFinish() {
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).getHand().size() > 0){
                return false;
            }
            else{
                players.get(i).setRank("President");
                gameWon(players.get(i));
            }
        }
        return true;
    }

    /**
     * gameWon
     * Checks if player won game
     * Must have reached 11 points
     * @return true (player won game) or false (game continues)
     */
    public boolean gameWon(PlayerInfo player){
        for(int i = 0; i < players.size(); i++){
            if(players.get(i) == player){
                if(player.getScore() >= 11) {
                    return true;
                }
            }
        }
        return false;
    }

    /** Updates turn */
    public void nextPlayer(){
        if(turn == players.size() - 1){
            turn = 0;
        }
        else{
            turn++;
        }
    }

    /** Returns number of players with cards */
    public int playersWithCards() {
        int count = 0;
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).getHand().size() > 0){
                count++;
            }
        }
        return count;
    }

    /** Redeals Cards after each set */
    /*public void reDeal(){
        for(int i = 0; i < players.size(); i++){
            players.get(i).getHand().clear();
        }
       Deck deck = new Deck(players.size());
        int j = 0;
        int size = deck.size();
        for(int i = 0; i < size; i++){
            players.get(i).addCard(deck.remove(0));
            if(i < players.size() - 1){
                j++;
            }
            else{
                j = 0;
            }
        }
    }*/

    @Override
    public String toString(){

        /**Stringing played cards*/
        String playedCards = "Played Cards:";
        for(Card c : this.playedCards){
            playedCards = playedCards + " " + c.getCardName();
        }
        playedCards = playedCards + "\n";

        /**Current player's hand*/
        String currentHand = "Current Player's Hand:";
        for(Card c : this.currentPlayerHand){
            currentHand = currentHand + " " + c.getCardName();
        }
        currentHand = currentHand + "" + "\n";

        /**Current player's valid cards*/
        String currentValid = "Current Player's Valid Cards:";
        for(Card c : this.currentValid){
            currentValid = currentValid + " " + c.getCardName();
        }
        currentValid = currentValid + "\n";

        /**Stringing togther each player and the player's hand*/
        String playerString = "";
        String playerCards = "";
        for(PlayerInfo p : players){
            for(Card c : p.getHand()){
                playerCards = playerCards + " " + c.getCardName();
            }
            playerString = playerString
                    + "Name: " + p.getName()
                    + "Rank: " + p.getRank()
                    + "Score: " + p.getScore()
                    + "\nCards:" + playerCards + "\n";
            playerCards = "";
        }



        String str = "Current President Game State:\n"
                + playedCards
                + currentHand
                + currentValid
                + playerCards;
        return str;
    }
}


