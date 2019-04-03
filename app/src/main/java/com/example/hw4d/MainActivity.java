package com.example.hw4d;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    public PresidentGameState initial;
    private ImageButton card[] = new ImageButton[13];
    private ImageButton selectedCard;
    private Button play, pause, order, pass;
    private ImageView currentPlay;
    private int index;
    private TextView p0, p1, p2, p3;
    private TextView cards_1, cards_2, cards_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        index = 0;
        card[0] = findViewById(R.id.card0);
        card[1] = findViewById(R.id.card1);
        card[2] = findViewById(R.id.card2);
        card[3] = findViewById(R.id.card3);
        card[4] = findViewById(R.id.card4);
        card[5] = findViewById(R.id.card5);
        card[6] = findViewById(R.id.card6);
        card[7] = findViewById(R.id.card7);
        card[8] = findViewById(R.id.card8);
        card[9] = findViewById(R.id.card9);
        card[10] = findViewById(R.id.card10);
        card[11] = findViewById(R.id.card11);
        card[12] = findViewById(R.id.card12);
        currentPlay = findViewById(R.id.currentPlay);
        cards_1 = findViewById(R.id.p1);
        cards_2 = findViewById(R.id.p2);
        cards_3 = findViewById(R.id.p3);
        for (int i = 0; i < 13; i++) {
            card[i].setOnClickListener(new CardClickListener());
        }

        play = findViewById(R.id.playButton);
        play.setOnClickListener(new ButtonClickListener());
        pause = findViewById(R.id.pauseButton);
        pause.setOnClickListener(new ButtonClickListener());
        order = findViewById(R.id.orderButton);
        order.setOnClickListener(new ButtonClickListener());
        pass = findViewById(R.id.passButton);
        pass.setOnClickListener(new ButtonClickListener());
        p1 = findViewById(R.id.player1Text);
        p2 = findViewById(R.id.player2Text);
        p3 = findViewById(R.id.Player3Text);
        p0 = findViewById(R.id.userPlayer);
        cards_1 = findViewById(R.id.p1);
        cards_2 = findViewById(R.id.p2);
        cards_3 = findViewById(R.id.p3);
        initial = new PresidentGameState();
        for (int i = 0; i < 4; i++) {
            initial.getPlayers().get(i).setPlayerNum(i);
        }
        updatePlayerGui(initial);

    }


    // https://www.youtube.com/watch?v=GtxVILjLcw8
    //https://stackoverflow.com/questions/1466788/android-textview-setting-the-background-color-dynamically-doesnt-work

    public class CardClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            for (int i = 0; i < 13; i++) {
                card[i].getBackground().clearColorFilter();
                v.invalidate();
            }
            selectedCard = (ImageButton) v;
            selectedCard.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
            v.invalidate();

        }
        //https://stackoverflow.com/questions/5327553/android-highlight-an-imagebutton-when-clicked
    }

    public class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            PresidentGameState updateGS;
            ArrayList<Card> play =  new ArrayList<>();
            Card toAdd = new Card(0, null);
            for(int i = 0; i < play.size(); i++) {
                play.remove(0);
            }
            switch (v.getId()) {
                case R.id.playButton:
                    if(selectedCard.getTag() == null) {
                        Toast.makeText(getApplication().getApplicationContext(),"No card selected!",
                                Toast.LENGTH_SHORT).show();
                    }
                    else {
                        int tagValue = (Integer)selectedCard.getTag();
                        switch (tagValue) {
                            case 0:
                                Toast.makeText(getApplication().getApplicationContext(), "No card selected!",
                                        Toast.LENGTH_SHORT).show();
                                break;

                            case R.drawable.two_clubs:
                                toAdd.setCardVal(13);
                                toAdd.setCardSuit("Clubs");
                                break;

                            case R.drawable.three_clubs:
                                toAdd.setCardVal(1);
                                toAdd.setCardSuit("Clubs");
                                break;

                            case R.drawable.four_clubs:
                                toAdd.setCardVal(2);
                                toAdd.setCardSuit("Clubs");
                                break;

                            case R.drawable.five_clubs:
                                toAdd.setCardVal(3);
                                toAdd.setCardSuit("Clubs");
                                break;

                            case R.drawable.six_clubs:
                                toAdd.setCardVal(4);
                                toAdd.setCardSuit("Clubs");
                                break;

                            case R.drawable.seven_clubs:
                                toAdd.setCardVal(5);
                                toAdd.setCardSuit("Clubs");
                                break;

                            case R.drawable.eight_clubs:
                                toAdd.setCardVal(6);
                                toAdd.setCardSuit("Clubs");
                                break;

                            case R.drawable.nine_clubs:
                                toAdd.setCardVal(7);
                                toAdd.setCardSuit("Clubs");
                                break;

                            case R.drawable.ten_clubs:
                                toAdd.setCardVal(8);
                                toAdd.setCardSuit("Clubs");
                                break;

                            case R.drawable.jack_clubs:
                                toAdd.setCardVal(9);
                                toAdd.setCardSuit("Clubs");
                                break;

                            case R.drawable.queen_clubs:
                                toAdd.setCardVal(10);
                                toAdd.setCardSuit("Clubs");

                                break;

                            case R.drawable.king_clubs:
                                toAdd.setCardVal(11);
                                toAdd.setCardSuit("Clubs");
                                break;

                            case R.drawable.ace_clubs:
                                toAdd.setCardVal(12);
                                toAdd.setCardSuit("Clubs");
                                break;

                            case R.drawable.two_spades:
                                toAdd.setCardVal(13);
                                toAdd.setCardSuit("Spades");
                                break;

                            case R.drawable.three_spades:
                                toAdd.setCardVal(1);
                                toAdd.setCardSuit("Spades");
                                break;

                            case R.drawable.four_spades:
                                toAdd.setCardVal(2);
                                toAdd.setCardSuit("Spades");
                                break;

                            case R.drawable.five_spades:
                                toAdd.setCardVal(3);
                                toAdd.setCardSuit("Spades");
                                break;

                            case R.drawable.six_spades:
                                toAdd.setCardVal(4);
                                toAdd.setCardSuit("Spades");
                                break;

                            case R.drawable.seven_spades:
                                toAdd.setCardVal(5);
                                toAdd.setCardSuit("Spades");
                                break;

                            case R.drawable.eight_spades:
                                toAdd.setCardVal(6);
                                toAdd.setCardSuit("Spades");
                                break;

                            case R.drawable.nine_spades:
                                toAdd.setCardVal(7);
                                toAdd.setCardSuit("Spades");
                                break;

                            case R.drawable.ten_spades:
                                toAdd.setCardVal(8);
                                toAdd.setCardSuit("Spades");
                                break;

                            case R.drawable.jack_spades:
                                toAdd.setCardVal(9);
                                toAdd.setCardSuit("Spades");
                                break;

                            case R.drawable.queen_spades:
                                toAdd.setCardVal(10);
                                toAdd.setCardSuit("Spades");
                                break;

                            case R.drawable.king_spades:
                                toAdd.setCardVal(11);
                                toAdd.setCardSuit("Spades");
                                break;

                            case R.drawable.ace_spades:
                                toAdd.setCardVal(12);
                                toAdd.setCardSuit("Spades");
                                break;

                            case R.drawable.two_diamonds:
                                toAdd.setCardVal(13);
                                toAdd.setCardSuit("Diamonds");
                                break;

                            case R.drawable.three_diamonds:
                                toAdd.setCardVal(1);
                                toAdd.setCardSuit("Diamonds");
                                break;

                            case R.drawable.four_diamonds:
                                toAdd.setCardVal(2);
                                toAdd.setCardSuit("Diamonds");
                                break;

                            case R.drawable.five_diamonds:
                                toAdd.setCardVal(3);
                                toAdd.setCardSuit("Diamonds");
                                break;

                            case R.drawable.six_diamonds:
                                toAdd.setCardVal(4);
                                toAdd.setCardSuit("Diamonds");
                                break;

                            case R.drawable.seven_diamonds:
                                toAdd.setCardVal(5);
                                toAdd.setCardSuit("Diamonds");
                                break;

                            case R.drawable.eight_diamonds:
                                toAdd.setCardVal(6);
                                toAdd.setCardSuit("Diamonds");
                                break;

                            case R.drawable.nine_diamonds:
                                toAdd.setCardVal(7);
                                toAdd.setCardSuit("Diamonds");
                                break;

                            case R.drawable.ten_diamonds:
                                toAdd.setCardVal(8);
                                toAdd.setCardSuit("Diamonds");
                                break;

                            case R.drawable.jack_diamonds:
                                toAdd.setCardVal(9);
                                toAdd.setCardSuit("Diamonds");
                                break;

                            case R.drawable.queen_diamonds:
                                toAdd.setCardVal(10);
                                toAdd.setCardSuit("Diamonds");
                                break;

                            case R.drawable.king_diamonds:
                                toAdd.setCardVal(11);
                                toAdd.setCardSuit("Diamonds");
                                break;

                            case R.drawable.ace_diamonds:
                                toAdd.setCardVal(12);
                                toAdd.setCardSuit("Diamonds");
                                break;

                            case R.drawable.two_hearts:
                                toAdd.setCardVal(13);
                                toAdd.setCardSuit("Hearts");
                                break;

                            case R.drawable.three_hearts:
                                toAdd.setCardVal(1);
                                toAdd.setCardSuit("Hearts");
                                break;

                            case R.drawable.four_hearts:
                                toAdd.setCardVal(2);
                                toAdd.setCardSuit("Hearts");
                                break;

                            case R.drawable.five_hearts:
                                toAdd.setCardVal(3);
                                toAdd.setCardSuit("Hearts");
                                break;

                            case R.drawable.six_hearts:
                                toAdd.setCardVal(4);
                                toAdd.setCardSuit("Hearts");
                                break;

                            case R.drawable.seven_hearts:
                                toAdd.setCardVal(5);
                                toAdd.setCardSuit("Hearts");
                                break;

                            case R.drawable.eight_hearts:
                                toAdd.setCardVal(6);
                                toAdd.setCardSuit("Hearts");
                                break;

                            case R.drawable.nine_hearts:
                                toAdd.setCardVal(7);
                                toAdd.setCardSuit("Hearts");
                                break;

                            case R.drawable.ten_hearts:
                                toAdd.setCardVal(8);
                                toAdd.setCardSuit("Hearts");
                                break;

                            case R.drawable.jack_hearts:
                                toAdd.setCardVal(9);
                                toAdd.setCardSuit("Hearts");
                                break;

                            case R.drawable.queen_hearts:
                                toAdd.setCardVal(10);
                                toAdd.setCardSuit("Hearts");
                                break;

                            case R.drawable.king_hearts:
                                toAdd.setCardVal(11);
                                toAdd.setCardSuit("Hearts");
                                break;

                            case R.drawable.ace_hearts:
                                toAdd.setCardVal(12);
                                toAdd.setCardSuit("Hearts");
                                break;
                        }

                        play.add(toAdd);
                        if(initial.playCard(index, play)) {
                            switchHighlight(initial.getCurrentPlayer());
                            selectedCard.setBackgroundResource(0);
                            currentPlay.setImageResource(tagValue);
                            computerMoves();
                        }
                        else{
                            Toast.makeText(getApplication().getApplicationContext(), "Invalid Move!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                    updatePlayerGui(initial);

                    break;
                case R.id.pauseButton:
                    break;
                case R.id.orderButton:
                    break;
                case R.id.passButton:
                    if (initial.pass(index)) {
                        switchHighlight(initial.getCurrentPlayer());
                        computerMoves();
                    } else {
                        Toast.makeText(getApplication().getApplicationContext(), "Not your Turn!",
                                Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    }


    public void switchHighlight(int idx){
            switch(idx) {
                case 0:
                    p0.setBackgroundResource(R.color.yellow);
                    p0.setTextColor(getResources().getColor(R.color.black));
                    p1.setBackgroundResource(R.color.black);
                    p2.setBackgroundResource(R.color.black);
                    p3.setBackgroundResource(R.color.black);
                    p1.setTextColor(getResources().getColor(R.color.white));
                    p2.setTextColor(getResources().getColor(R.color.white));
                    p3.setTextColor(getResources().getColor(R.color.white));
                    break;
                case 1:
                    p1.setBackgroundResource(R.color.yellow);
                    p1.setTextColor(getResources().getColor(R.color.black));
                    p0.setBackgroundResource(R.color.black);
                    p2.setBackgroundResource(R.color.black);
                    p3.setBackgroundResource(R.color.black);
                    p0.setTextColor(getResources().getColor(R.color.white));
                    p2.setTextColor(getResources().getColor(R.color.white));
                    p3.setTextColor(getResources().getColor(R.color.white));
                    break;
                case 2:
                    p2.setBackgroundResource(R.color.yellow);
                    p2.setTextColor(getResources().getColor(R.color.black));
                    p1.setBackgroundResource(R.color.black);
                    p0.setBackgroundResource(R.color.black);
                    p3.setBackgroundResource(R.color.black);
                    p1.setTextColor(getResources().getColor(R.color.white));
                    p0.setTextColor(getResources().getColor(R.color.white));
                    p3.setTextColor(getResources().getColor(R.color.white));
                    break;
                case 3:
                    p3.setBackgroundResource(R.color.yellow);
                    p3.setTextColor(getResources().getColor(R.color.black));
                    p1.setBackgroundResource(R.color.black);
                    p2.setBackgroundResource(R.color.black);
                    p0.setBackgroundResource(R.color.black);
                    p1.setTextColor(getResources().getColor(R.color.white));
                    p2.setTextColor(getResources().getColor(R.color.white));
                    p0.setTextColor(getResources().getColor(R.color.white));
                    break;
            }
            p0.invalidate();
            p1.invalidate();
            p2.invalidate();
            p3.invalidate();
        }

    public void updateCardGui(PresidentGameState gs, int i) {
            Card theCard = gs.getPlayers().get(0).getHand().get(i);
            int imageId = getImageId(theCard);

            card[i].setTag(Integer.valueOf(imageId));
            card[i].setBackgroundResource(imageId);
    }

    public void updatePlayerGui (PresidentGameState gs) {
        int i = 0;
        for (int j = 0; j < 13; j++) {
            card[j].setBackgroundResource(R.drawable.scoreboard);
        }
        for (Card c : gs.getPlayers().get(0).getHand()){
            updateCardGui(gs, i);
            card[i].getBackground().setAlpha(255);
            card[i].invalidate();
            i++;
        }
    }

    public void computerMoves() {
        while (initial.getTurn() != 0) {
            int turn = initial.getTurn();
            switchHighlight(initial.getCurrentPlayer());

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Card computerPlayedCard = initial.dumbAI(initial.getPlayers().get(initial.getTurn()));
            if(computerPlayedCard == null) {
                //dont change card UI
            }
            else {
                currentPlay.setImageResource(getImageId(computerPlayedCard));
                changeCardNum(turn);
            }
        }
        switchHighlight(initial.getCurrentPlayer());
    }

    public void changeCardNum(int idx){
        String num = Integer.toString(initial.getPlayers().get(idx).getHand().size());
        switch (idx){
            case 1:
                cards_1.setText(num);
                break;
            case 2:
                cards_2.setText(num);
                break;
            case 3:
                cards_3.setText(num);
                break;
        }
    }
    public int getImageId(Card theCard) {
        int imageId = 0;
        if(theCard.getSuit().equals("Spades")) {
            switch(theCard.getValue()) {
                case 1:
                    imageId = R.drawable.three_spades;
                    break;
                case 2:
                    imageId = R.drawable.four_spades;
                    break;
                case 3:
                    imageId = R.drawable.five_spades;
                    break;
                case 4:
                    imageId = R.drawable.six_spades;
                    break;
                case 5:
                    imageId = R.drawable.seven_spades;
                    break;
                case 6:
                    imageId = R.drawable.eight_spades;
                    break;
                case 7:
                    imageId = R.drawable.nine_spades;
                    break;
                case 8:
                    imageId = R.drawable.ten_spades;
                    break;
                case 9:
                    imageId = R.drawable.jack_spades;
                    break;
                case 10:
                    imageId = R.drawable.queen_spades;
                    break;
                case 11:
                    imageId = R.drawable.king_spades;
                    break;
                case 12:
                    imageId = R.drawable.ace_spades;
                    break;
                case 13:
                    imageId = R.drawable.two_spades;
                    break;
            }
        }
        else if(theCard.getSuit().equals("Hearts")){
            switch(theCard.getValue()) {
                case 1:
                    imageId = R.drawable.three_hearts;
                    break;
                case 2:
                    imageId = R.drawable.four_hearts;
                    break;
                case 3:
                    imageId = R.drawable.five_hearts;
                    break;
                case 4:
                    imageId = R.drawable.six_hearts;
                    break;
                case 5:
                    imageId = R.drawable.seven_hearts;
                    break;
                case 6:
                    imageId = R.drawable.eight_hearts;
                    break;
                case 7:
                    imageId = R.drawable.nine_hearts;
                    break;
                case 8:
                    imageId = R.drawable.ten_hearts;
                    break;
                case 9:
                    imageId = R.drawable.jack_hearts;
                    break;
                case 10:
                    imageId = R.drawable.queen_hearts;
                    break;
                case 11:
                    imageId = R.drawable.king_hearts;
                    break;
                case 12:
                    imageId = R.drawable.ace_hearts;
                    break;
                case 13:
                    imageId = R.drawable.two_hearts;
                    break;
            }
        }
        else if(theCard.getSuit().equals("Diamonds")){
            switch(theCard.getValue()) {
                case 1:
                    imageId = R.drawable.three_diamonds;
                    break;
                case 2:
                    imageId = R.drawable.four_diamonds;
                    break;
                case 3:
                    imageId = R.drawable.five_diamonds;
                    break;
                case 4:
                    imageId = R.drawable.six_diamonds;
                    break;
                case 5:
                    imageId = R.drawable.seven_diamonds;
                    break;
                case 6:
                    imageId = R.drawable.eight_diamonds;
                    break;
                case 7:
                    imageId = R.drawable.nine_diamonds;
                    break;
                case 8:
                    imageId = R.drawable.ten_diamonds;
                    break;
                case 9:
                    imageId = R.drawable.jack_diamonds;
                    break;
                case 10:
                    imageId = R.drawable.queen_diamonds;
                    break;
                case 11:
                    imageId = R.drawable.king_diamonds;
                    break;
                case 12:
                    imageId = R.drawable.ace_diamonds;
                    break;
                case 13:
                    imageId = R.drawable.two_diamonds;
                    break;
            }
        }
        else if(theCard.getSuit().equals("Clubs")){
            switch(theCard.getValue()) {
                case 1:
                    imageId = R.drawable.three_clubs;
                    break;
                case 2:
                    imageId = R.drawable.four_clubs;
                    break;
                case 3:
                    imageId = R.drawable.five_clubs;
                    break;
                case 4:
                    imageId = R.drawable.six_clubs;
                    break;
                case 5:
                    imageId = R.drawable.seven_clubs;
                    break;
                case 6:
                    imageId = R.drawable.eight_clubs;
                    break;
                case 7:
                    imageId = R.drawable.nine_clubs;
                    break;
                case 8:
                    imageId = R.drawable.ten_clubs;
                    break;
                case 9:
                    imageId = R.drawable.jack_clubs;
                    break;
                case 10:
                    imageId = R.drawable.queen_clubs;
                    break;
                case 11:
                    imageId = R.drawable.king_clubs;
                    break;
                case 12:
                    imageId = R.drawable.ace_clubs;
                    break;
                case 13:
                    imageId = R.drawable.two_clubs;
                    break;
            }
        }
        return imageId;
    }
    //http://www.devexchanges.info/2015/03/simple-moving-object-with-touch-events.html
}
