package com.example.hw4d;

import java.io.Serializable;

/**
 * Card.java
 *
 * @author Ben Pirkl
 * @author Geryl Vinoya
 * @author Kama Simon
 * @author Hera Malik
 *
 * @version February 2019
 *
 */
public class Card implements Serializable {
    /** Descriptive variable for the card */
    /* 0-7: numbers 8: Jack, 9: Queen, 10: King, 11: A, 12: 2 */
    private int cardVal;

    /** Card suit */
    /* Types: Spades, Hearts, Diamonds, Clubs */
    private String cardSuit;

    /**
     * Card constructor
     * initializes values of card depending on parameters
     * @param cardVal descriptive integer value of card
     * @param cardSuit card's suit
     */
    public Card(int cardVal, String cardSuit){
        this.cardVal = cardVal;
        this.cardSuit = cardSuit;
    }

    /** Returns the card's value */
    public int getValue() { return cardVal; }

    /** Returns the card's suit */
    public String getSuit() { return cardSuit; }

    /**
     * getFace
     * returns the string of card value
     * @return String of Card Value
     */
    public String getFace(){
        int temp = this.cardVal;
        if(temp == 0){
            return "three";
        }
        else if(temp == 1){
            return "four";
        }
        else if(temp == 2){
            return "five";
        }
        else if(temp == 3){
            return "six";
        }
        else if(temp == 4){
            return "seven";
        }
        else if(temp == 5){
            return "eight";
        }
        else if(temp == 6){
            return "nine";
        }
        else if(temp == 7){
            return "ten";
        }
        else if(temp == 8){
            return "jack";
        }
        else if(temp == 9){
            return "queen";
        }
        else if(temp == 10){
            return "king";
        }
        else if(temp == 11){
            return "ace";
        }
        else if(temp == 12){
            return "two";
        }
        return null;
    }

    /** Returns card name and suit */
    public String getCardName() { return this.getFace() + "_" + this.getSuit(); }

}

