package com.example.hw4d;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public PresidentGameState initial;
    private ImageView card[] = new ImageView[13];
    private Button play, pause, order, pass;
    private int index;
    private TextView p0, p1, p2, p3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        index = 0;
        card[0] = findViewById(R.id.card0);
        card[0].setOnTouchListener(new TouchListener());
        card[1] = findViewById(R.id.card1);
        card[1].setOnTouchListener(new TouchListener());
        card[2] = findViewById(R.id.card2);
        card[2].setOnTouchListener(new TouchListener());
        card[3] = findViewById(R.id.card3);
        card[3].setOnTouchListener(new TouchListener());
        card[4] = findViewById(R.id.card4);
        card[4].setOnTouchListener(new TouchListener());
        card[5] = findViewById(R.id.card5);
        card[5].setOnTouchListener(new TouchListener());
        card[6] = findViewById(R.id.card6);
        card[6].setOnTouchListener(new TouchListener());
        card[7] = findViewById(R.id.card7);
        card[7].setOnTouchListener(new TouchListener());
        card[8] = findViewById(R.id.card8);
        card[8].setOnTouchListener(new TouchListener());
        card[9] = findViewById(R.id.card9);
        card[9].setOnTouchListener(new TouchListener());
        card[10] = findViewById(R.id.card10);
        card[10].setOnTouchListener(new TouchListener());
        card[11] = findViewById(R.id.card11);
        card[11].setOnTouchListener(new TouchListener());
        card[12] = findViewById(R.id.card12);
        card[12].setOnTouchListener(new TouchListener());
        play = findViewById(R.id.playButton);
        play.setOnClickListener(this);
        pause = findViewById(R.id.pauseButton);
        pause.setOnClickListener(this);
        order = findViewById(R.id.orderButton);
        order.setOnClickListener(this);
        pass = findViewById(R.id.passButton);
        pass.setOnClickListener(this);
        p1 = findViewById(R.id.player1Text);
        p2 = findViewById(R.id.player2Text);
        p3 = findViewById(R.id.Player3Text);
        p0 = findViewById(R.id.userPlayer);
        initial = new PresidentGameState();
        updatePlayerGui(initial);
    }

    @Override
    public void onClick(View v) {
        PresidentGameState updateGS;
        switch(v.getId()){
            case R.id.playButton:
                break;
            case R.id.pauseButton:
                break;
            case R.id.orderButton:
                break;
            case R.id.passButton:
                if(initial.pass(index)) {
                    updateGS = new PresidentGameState(initial);
                    switchHighlight(updateGS.getCurrentPlayer());
                }
                else{
                    Toast.makeText(getApplication().getApplicationContext(), "Not your Turn!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    // https://www.youtube.com/watch?v=GtxVILjLcw8
    //https://stackoverflow.com/questions/1466788/android-textview-setting-the-background-color-dynamically-doesnt-work

    public class TouchListener implements View.OnTouchListener{

        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return false;
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
        }

    public void updateCardGui(PresidentGameState gs, int i) {
            Card theCard = gs.getPlayers().get(0).getHand().get(i);
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

            card[i].setImageResource(imageId);
    }

    public void updatePlayerGui (PresidentGameState gs) {
        int i = 0;
        for (Card c : gs.getPlayers().get(0).getHand()){
            updateCardGui(gs, i);
            i++;
        }
    }

    //http://www.devexchanges.info/2015/03/simple-moving-object-with-touch-events.html
}
