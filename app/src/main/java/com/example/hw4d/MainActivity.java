package com.example.hw4d;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView card0, card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12;
    Button play, pause, order, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card0 = findViewById(R.id.card0);
        card0.setOnClickListener(this);
        card1 = findViewById(R.id.card1);
        card1.setOnClickListener(this);
        card2 = findViewById(R.id.card2);
        card2.setOnClickListener(this);
        card3 = findViewById(R.id.card3);
        card3.setOnClickListener(this);
        card4 = findViewById(R.id.card4);
        card4.setOnClickListener(this);
        card5 = findViewById(R.id.card5);
        card5.setOnClickListener(this);
        card6 = findViewById(R.id.card6);
        card6.setOnClickListener(this);
        card7 = findViewById(R.id.card7);
        card7.setOnClickListener(this);
        card8 = findViewById(R.id.card8);
        card8.setOnClickListener(this);
        card9 = findViewById(R.id.card9);
        card9.setOnClickListener(this);
        card10 = findViewById(R.id.card10);
        card10.setOnClickListener(this);
        card11 = findViewById(R.id.card11);
        card11.setOnClickListener(this);
        card12 = findViewById(R.id.card12);
        card12.setOnClickListener(this);
        play = findViewById(R.id.playButton);
        play.setOnClickListener(this);
        pause = findViewById(R.id.pauseButton);
        pause.setOnClickListener(this);
        order = findViewById(R.id.orderButton);
        order.setOnClickListener(this);
        pass = findViewById(R.id.passButton);
        pass.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


    }
}
