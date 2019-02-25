package com.example.hw4d;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Deck.java
 *
 * @author Ben Pirkl
 * @author Geryl Vinoya
 * @author Kama Simon
 * @author Hera Malik
 *
 * @version February 2019
 *
 */
public class Deck {
    private static int SUITDECKSIZE = 13;
    /* Holds Deck of Cards */
    private ArrayList<Card> presidentDeck;
    private int playerCount;

    /**
     * Deck Constructor
     * Creates Deck to play with
     * Adds information to each card such as
     * SUIT AND CARD VALUE
     */
    public Deck(){
        String suit = "Default";
        for(int i = 0; i < 4; i++){
            if(i == 0){
                suit = "hearts";
            }
            else if(i == 1){
                suit = "clubs";
            }
            else if(i == 2){
                suit = "spades";
            }
            else if(i == 3){
                suit = "diamonds";
            }
            for(int j = 0; j < 13; j++){
                Card card = new Card(j, suit);
                presidentDeck.add(card);
            }
        }
        Collections.shuffle(presidentDeck);
    }

    public Deck(int numPlayers){
        playerCount = numPlayers;
        presidentDeck = new ArrayList<Card>();
        String suit = "Default";
    }

    public ArrayList<Card> getDeck() { return presidentDeck; }

    public int size() { return presidentDeck.size(); }

    public Card remove(int index) { return presidentDeck.remove(index); }

//    public void init(){
//        for(int i = 0; i < SUITDECKSIZE; i++ ){
//            String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
//            for(String str: suits){
//                presidentDeck.add(new Card(i,str));
//            }
//            if(i==0) continue;
//            for(String str: suits){
//                presidentDeck.add(new Card(i,str));
//            }
//
//            /* Shuffle Deck */
//
//        }
//        this.shuffle();
//        }
//
//    public void shuffle(){
//        Random r = new Random();
//        for(int i = 0; i < SUITDECKSIZE*4; i++){
//            int index = r.nextInt(SUITDECKSIZE*4);
//            Card card = presidentDeck.get(index);
//            presidentDeck.remove(index);
//            index = r.nextInt(SUITDECKSIZE*4);
//            presidentDeck.add(index,card);
//        }
//    }
//
//    public void put(Card card) { put(card,0); }
//
//    public void put(Card card, int index) { this.presidentDeck.add(index,card); }
//
//    public Card take() { return presidentDeck.remove(0); }
//
//    public Card getCard(int index) { return presidentDeck.get(index); }
//
//    public Card getCardAt(int index) { return presidentDeck.get(index); }
//
//    public int getDeckSize() { return presidentDeck.size(); }
//
//    public Card getTopCard() { return presidentDeck.get(0); }
//
//    public ArrayList<Card> getDeck() { return presidentDeck; }




}

