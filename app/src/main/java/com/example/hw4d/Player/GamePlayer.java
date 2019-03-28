package com.example.hw4d.Player;

import com.example.hw4d.Card;

import java.util.ArrayList;

/**
 * GamePlayer.java
 *
 * @author Ben Pirkl
 * @author Geryl Vinoya
 * @author Kama Simon
 * @author Hera Malik
 *
 * @version February 2019
 *
 */
public class GamePlayer {
    /** Player's cards */
    private ArrayList<Card> playerHand;

    /** Player's Current Rank */
    private String rank;

    /** Player's Current Score */
    private int score;

    /** Player's Name */
    private int playerNum;

    /** MAX CARDS a player can have */
    /* Standard 52 deck, MAX: 4 players */
    private static int MAX_CARDS = 13;

    /**
     * GamePlayer Constructor
     * Initializes Player's information
     */


    public GamePlayer(){
        playerHand = new ArrayList<>(MAX_CARDS);
        rank = "No rank";
        score = 0;
        playerNum = -1;
    }



    /**
     * GamePlayer Copy Constructor
     * @param thePlayer
     */
    public GamePlayer(GamePlayer thePlayer) {
        playerHand = new ArrayList<>(MAX_CARDS);
        for (Card c : thePlayer.playerHand) {
            playerHand.add(new Card(c.getValue(), c.getSuit()));
        }
        rank = thePlayer.rank;
        score = thePlayer.score;
        playerNum = thePlayer.playerNum;
    }

    /** Returns Player's hand */
    public ArrayList<Card> getHand() { return playerHand; }

    /** Returns Player's Current Rank */
    public String getRank() { return rank; }

    /** Returns Player's Current Score */
    public int getScore() { return score; }
    public void setScore(int score){ this.score = score; }
    /** Returns Player's Name */
    public int getPlayerNum() { return playerNum; }

    public void setPlayerNum(int num){
        this.playerNum = num;
    }

//    public void setHand(ArrayList<Card> in) { playerHand = in; }

    public void addCard(Card in) { playerHand.add(in); }

    /**
     * removeCard
     * Removes card after set is played
     * @param in card to be removed
     * @return true (able to remove) or false (not able to remove)
     */
    public boolean removeCard(Card in){
        if(playerHand.contains(in)){
            playerHand.remove(in);
            return true;
        }
        return false;
    }

    /**
     * addScore
     * Updates Player's score depending on *NEW* Rank
     * @param playersRank the new rank of player
     */
    public void addScore(String playersRank){
        if(playersRank.equals("President")){
            score += 2;
        }
        else if(playersRank.equals("Vice President")){
            score += 1;
        }
        else{/* other players don't receive points */}
    }

    /**
     * setRank
     * Updates Player's Rank on who won game
     * @param newRank new assigned rank of player
     */
    public void setRank(String newRank){
        rank = newRank;
    }

    /**
     * resetRank
     * Should reset player's rank to nothing
     * Used after trading
     */
    public void resetRank(){
        this.setRank("");
    }

}
