package com.example.hw4d;

import com.example.hw4d.Player.ComputerPlayer;
import com.example.hw4d.Player.GamePlayer;
import com.example.hw4d.Player.HumanPlayer;

import java.io.Serializable;
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

    /**
     * Number of Players in Game
     */
    private int numPlayers = 4;
    /**
     * Cards Played Already like Discard Pile
     */
    private ArrayList<Card> playedCards;
    /**
     * Players
     */
    private ArrayList<GamePlayer> players;
    /**
     * Current Played Cards
     */
    private ArrayList<Card> currentSet;
    /**
     * Used to check if current player's set is valid
     */
    private ArrayList<Card> currentValid;
    /**
     * Current Player's hand
     */
    private ArrayList<Card> currentPlayerHand;
    /**
     * whose turn it is and who previously played
     */
    private int turn;
    private int prevTurn;
    /**
     * Used to check if its the start of the round or not
     */
    private boolean roundStart = false;

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
        for (int i = 0; i < numPlayers; i++) {
            GamePlayer temp = new GamePlayer();
            players.add(temp);
        }

        /** CREATE'S PLAYER'S HAND */
        int count = 0;
        int size = deck.size();

        for (int i = 0; i < size; i++) {
            players.get(count).addCard(deck.getDeck().get(0));
            deck.remove(0);
            if (count < players.size() - 1) {
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
        for (GamePlayer p : masterGameState.players) {
            GamePlayer toAdd = new GamePlayer(p);
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

    /**
     * Returns played cards or discard pile
     */
    public ArrayList<Card> getPlayedCards() {
        return playedCards;
    }

    /** */
    public void setPlayedCards(ArrayList<Card> in) {
        playedCards = in;
    }

    /**
     * Returns the Player's Array list with their information
     */
    public ArrayList<GamePlayer> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<GamePlayer> in) {
        for(GamePlayer player : in)
        {
            players.add(player);
        }
    }

    /**
     * Returns Current Set
     */
    public ArrayList<Card> getCurrentSet() {
        return currentSet;
    }

    /**
     * Sets the current set
     */
    public void setCurrentSet(ArrayList<Card> in) {
        currentSet = in;
    }

    /**
     * Returns if move is valid
     */
    public ArrayList<Card> getCurrentValid() {
        return currentValid;
    }

    /**
     * Returns whose turn it is
     */
    public int getCurrentPlayer() {
        return turn;
    }

    /**
     * Sets the player, the hand, and valid cards
     */
    public void setCurrentPlayer(int in) {
        turn = in;
        currentPlayerHand = players.get(turn).getHand();
        currentValid = players.get(turn).getHand();
    }

    /**
     * Returns the turn of previous player
     */
    public int getLastPlayed() {
        return prevTurn;
    }

    /**
     * Sets previous player
     */
    public void setLastPlayed(int in) {
        prevTurn = in;
    }

    public void setPlayerSet(ArrayList<Card> in) {
        currentValid = in;
    }
    /* actions.txt methods */

//    public void setOrder(int index){
//        Card left;
//        Card right;
//        int i = players.get(index).getHand().size();
//    }
    // https://javahungry.blogspot.com/2017/11/how-to-sort-arraylist-in-descending-order-in-java.html
    /**
     * Set the round start to be false
     */
    public void setRoundStart(boolean roundStart) {
        this.roundStart = roundStart;
    }

    /**
     * trade
     * @return true (can trade) or false (cannot trade)
     */
    public boolean trade() {
        /**
         *  Check if the round is just starting and is not the first
         *  round of the game, if it isn't, initialize trade

         */
        if (roundStart) {
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getRank().equals("President")) {
                    // Get the first smallest valued card in hand
                    Card firstMinCardInPresHand = getMinCard(players.get(i).getHand());
                    players.get(i).removeCard(firstMinCardInPresHand.getSuit(),firstMinCardInPresHand.getValue());
                    // Get the second smallest valued card in hand.
                    Card secondMinCardInPresHand = getMinCard(players.get(i).getHand());
                    players.get(i).removeCard(secondMinCardInPresHand.getSuit(), secondMinCardInPresHand.getValue());

                    for (int findScum = 0; findScum < players.size(); findScum++) {
                        if (players.get(findScum).getRank().equals("Scum")) {
                            Card firstMaxCardInScumHand = getMaxCard(players.get(findScum).getHand());
                            players.get(findScum).removeCard(firstMaxCardInScumHand.getSuit(), firstMaxCardInScumHand.getValue());

                            Card secondMaxCardInScumHand = getMaxCard(players.get(findScum).getHand());
                            players.get(findScum).removeCard(secondMaxCardInScumHand.getSuit(), secondMaxCardInScumHand.getValue());

                            players.get(findScum).getHand().add(firstMinCardInPresHand);
                            players.get(findScum).getHand().add(secondMinCardInPresHand);
                            players.get(i).getHand().add(firstMaxCardInScumHand);
                            players.get(i).getHand().add(secondMaxCardInScumHand);

                        }
                    }
                } else if (players.get(i).getRank() == "Vice President") {

                    // Get the lowest valued card in hand
                    Card firstCardInVPHand = getMinCard(players.get(i).getHand());
                    players.get(i).removeCard(firstCardInVPHand.getSuit(), firstCardInVPHand.getValue());

                    Card firstCardInViceScumHand = null;
                    for (int findViceScum = 0; findViceScum < players.size(); findViceScum++) {
                        if (players.get(findViceScum).getRank() == "Vice Scum") {
                            firstCardInViceScumHand = getMaxCard(players.get(findViceScum).getHand());
                            players.get(findViceScum).removeCard(firstCardInViceScumHand.getSuit(), firstCardInViceScumHand.getValue());

                            players.get(findViceScum).getHand().add(firstCardInVPHand);
                            players.get(i).getHand().add(firstCardInViceScumHand);
                        }
                    }

                    return true;
                }
            } return true; // Trade is a valid option.
        } else {
            /** If Round Start == False
             *  e.g. if the game is in play, trade is
             *  not available so return false
             */
            return false;
        }

    }

    /**
     * Method to find the maximum valued card in the players hand
     *
     * @param playerHand
     * @return max card in player hand
     */
    Card getMaxCard(ArrayList<Card> playerHand){
        int currentIndex = 0; // For Loop variable
        Card maxCard = new Card(-1, null);
        for(Card c : playerHand){
            if(maxCard.getValue() < playerHand.get(currentIndex).getValue()){
                maxCard.setCardVal(c.getValue());
                maxCard.setCardSuit(c.getSuit());
            }
            currentIndex++;
        }
        return maxCard;
    }

    /**
     * Method to find the maximum valued card in the players hand
     *
     * @param playerHand
     * @return
     */
    Card getMinCard(ArrayList<Card> playerHand){
        int currentIndex = 0; // For Loop variable
        Card minCard = new Card(55, null); // Arbitrary
        for(Card c : playerHand){
            if(minCard.getValue() > playerHand.get(currentIndex).getValue()){
                minCard.setCardVal(c.getValue());
                minCard.setCardSuit(c.getSuit());
            }
            currentIndex++;
        }
        return minCard;
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
        nextPlayer();
        return true;
    }


    /**
     * setFinish
     * Checks if someone won the game
     *
     * @return
     */
    public boolean setFinish() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getHand().size() > 0) {
                return false;
            } else {
                players.get(i).setRank("President");
                gameWon(players.get(i));
            }
        }

        /**
         * If all players have played their cards,
         * then the round is over and
         * initialize the trade.
         */
        if (playersWithCards() == 0) {
            setRoundStart(true);
        }
        return true;
    }

    /**
     * gameWon
     * Checks if player won game
     * Must have reached 11 points
     *
     * @return true (player won game) or false (game continues)
     */
    public boolean gameWon(GamePlayer player) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i) == player) {
                if (player.getScore() >= 11) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Updates turn
     */
    public void nextPlayer() {
        if (turn == players.size() - 1) {
            turn = 0;
        } else {
            turn++;
        }
    }

    /**
     * Returns number of players with cards
     */
    public int playersWithCards() {
        int count = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getHand().size() > 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * toString
     *
     * @return String (string of gamestate)
     */
    @Override
    public String toString() {

        /**Stringing played cards*/
        String playedCards = "Played Cards:";
        for (Card c : this.playedCards) {
            playedCards = playedCards + " " + c.getCardName();
        }
        playedCards = playedCards + "\n";

        /**Current player's hand*/
        String currentHand = "Current Player's Hand:";
        for (Card c : this.currentPlayerHand) {
            currentHand = currentHand + " " + c.getCardName();
        }
        currentHand = currentHand + "" + "\n";

        /**Current player's valid cards*/
        String currentValid = "Current Player's Valid Cards:";
        for (Card c : this.currentValid) {
            currentValid = currentValid + " " + c.getCardName();
        }
        currentValid = currentValid + "\n";

        /**Stringing togther each player and the player's hand*/
        String playerString = "";
        String playerCards = "";
        for (GamePlayer p : players) {
            for (Card c : p.getHand()) {
                playerCards = playerCards + " " + c.getCardName();
            }
            playerString = playerString
                    + "Num: " + p.getPlayerNum()
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

    public int find(String rank) {
        int index = -1;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getRank().equals(rank)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * quit
     *
     * @return true (player can quit game)
     */
    public boolean quit(HumanPlayer player) {

        if (player.getPlayerNum() != turn) {
            return false;
        }
        players.remove(player);
        numPlayers--;
        return true;
    }

    /**
     * pass
     *
     * @return true (player can pass turn) or false (player cannot pass turn)
     */
    public boolean pass(GamePlayer player) {

        if (player.getPlayerNum() != turn) {
            return false;
        }
        nextPlayer();
        return true;
    }

    /**
     * playCard
     *
     * @return true (player can pass turn) or false (player cannot pass turn)
     */

    public boolean playCard(int turn, ArrayList<Card> cardsToPlay) {

        // Set of logical checks to ensure that Player logic is sound
        if(getCurrentPlayer() != turn){
            return false;
        } else if(cardsToPlay.size() == 0 || cardsToPlay.size() > 13){ /* you had  < 8 which didn't make sense */
            return false;
        } else if(cardsToPlay.size() != currentSet.size()){
            if(currentSet.size() != 0) {
                return false;
            }
            currentSet.add(new Card(0,"Default"));
        }



        // Instance variable that will be used to label the size of
        // the array of cards passed in
//        int numCardsPassedIn = cardsToPlay.size();
//        for(int checkLegalHand = 0; checkLegalHand < cardsToPlay.size(); checkLegalHand++){
//            if(cardsToPlay.get(checkLegalHand).getValue() == cardsToPlay.get(numCardsPassedIn - 1).getValue() /* changed numCardsPassedIn to numCardsPassedIn - 1 */
//                    || cardsToPlay.get(checkLegalHand).getValue() == 2){
//            } else {
//                return false;
//            }
//        }

        if(cardsToPlay.size() == 1){
            if(cardsToPlay.get(0).getValue() <= currentSet.get(0).getValue()){
                return false;
            } else if(cardsToPlay.get(0).getValue() > currentSet.get(0).getValue()){
                ArrayList<Card> tmpHand = players.get(turn).getHand();
                for(int i = 0; i < tmpHand.size(); i++) {
                    if(tmpHand.get(i).getValue() == cardsToPlay.get(0).getValue() &&
                        tmpHand.get(i).getSuit().equals(cardsToPlay.get(0).getSuit())){

                        Card cardToMakeTheCurrent = tmpHand.get(i);
                        players.get(turn).removeCard(tmpHand.get(i).getSuit(), tmpHand.get(i).getValue());
                        currentSet.removeAll(currentSet);
                        currentSet.add(cardToMakeTheCurrent);
                        nextPlayer();
                    }
                }
            }

        } else if(cardsToPlay.size() == 2){

        } else if(cardsToPlay.size() == 3){

        } else if(cardsToPlay.size() == 4){

        } else if(cardsToPlay.size() == 5){

        } else if(cardsToPlay.size() == 6){

        } else if(cardsToPlay.size() == 7){

        } else if(cardsToPlay.size() == 8){

        }else {
            return false;
        }
        return true;
    }

    public Card dumbAI(GamePlayer dumbBot){
        ArrayList<Card> botHand = new ArrayList<>();
                botHand = dumbBot.getHand();

                Card tradeCard = new Card(0, "Default");
                for(Card c: botHand){
                        if(tradeCard.getValue() < c.getValue()){
                            tradeCard.setCardVal(c.getValue());
                            tradeCard.setCardSuit(c.getSuit());
                        }
                }



                dumbBot.removeCard(tradeCard.getSuit(), tradeCard.getValue());

                // Algorithm to randomly choose an action
                // The AI might just skip its turn, or it might just
                // play its highest card randomly
                // You never know...

                // Select a random value between 1 and 100
                int max = 100;
                int min = 0;
                double turnRoulette = (int)(Math.random()*((max-min)+1));
                ArrayList<Card> cardToPlay = new ArrayList<>();
                cardToPlay.add(tradeCard);
                if(turnRoulette < 50){
                    pass(dumbBot);
                    nextPlayer();
                    return null;
                } else {
                    // If the dumb bot cant play only the 1 card it has, then it passes
                    if(currentSet.size() != 1){
                        pass(dumbBot);
                        nextPlayer();
                        return null;
                    } else {
                        if(playCard(dumbBot.getPlayerNum(), cardToPlay)) {
                            nextPlayer();
                            return cardToPlay.get(0);
                        }
                        else{
                            pass(getCurrentPlayer());
                            return null;
                        }
                    }
                }
    }

    public int getTurn() {
        return turn;
    }
}
