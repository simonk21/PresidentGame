package com.example.hw4d.Player;

public class ComputerPlayer extends GamePlayer {

    private boolean isDumb;

    public ComputerPlayer() {
        super();
        isDumb = true;
    }

    public ComputerPlayer(ComputerPlayer thePlayer) {
        super(thePlayer);
        isDumb = thePlayer.isDumb;
    }

    public boolean getIsDumb() { return isDumb; }

    public void setIsDumb(boolean dumb) {
        isDumb = dumb;
    }
}
