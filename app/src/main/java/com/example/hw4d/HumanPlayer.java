package com.example.hw4d;

public class HumanPlayer extends GamePlayer {

    private String playerName;

    public HumanPlayer() {
        super();
        playerName = "no name";
    }

    public HumanPlayer(HumanPlayer thePlayer) {
        super(thePlayer);
        playerName = thePlayer.playerName;
    }

    public String getPlayerName() { return playerName; }

    public void setPlayerName(String name) { playerName = name; }
}
