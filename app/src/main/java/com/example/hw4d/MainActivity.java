package com.example.hw4d;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button test = (Button) findViewById(R.id.runButton);
        test.setOnClickListener(this);
        this.tv = (EditText) findViewById(R.id.editText);
    }

    @Override
    public void onClick(View v) {
    if(v.getId() == R.id.runButton){
        this.tv.setText("");

        PresidentGameState firstInstance = new PresidentGameState();

        PresidentGameState secondInstance = new PresidentGameState(firstInstance);

        firstInstance.setCurrentPlayer(0);
        this.tv.append("Player 1 has Traded with Player 5(2_spades and 2_diamonds with 3_spades and 3_diamonds)\n");
        firstInstance.trade();

        this.tv.append("Player 1 has passed\n");
        //firstInstance.pass(0);

        firstInstance.setCurrentPlayer(1);
        this.tv.append("Player 2 has played a card(2_hearts)\n");
        //firstInstance.playCard(1);

        firstInstance.setCurrentPlayer(2);
        this.tv.append("Player 3 has quit the game\n\n");
        //firstInstance.quit(2);


        PresidentGameState thirdInstance = new PresidentGameState();

        PresidentGameState fourthInstance = new PresidentGameState(thirdInstance);

        this.tv.append(secondInstance.toString());
        this.tv.append(fourthInstance.toString());
    }
    }
}
