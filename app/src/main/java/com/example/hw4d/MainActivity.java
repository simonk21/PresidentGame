package com.example.hw4d;

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


        this.tv.append("Player 1 has passed his turn\n");
        firstInstance.setCurrentPlayer(0);
        firstInstance.pass(0);
        firstInstance.setCurrentPlayer(1);

        PresidentGameState secondInstance = new PresidentGameState(firstInstance);

        PresidentGameState thirdInstance = new PresidentGameState();

        PresidentGameState fourthInstance = new PresidentGameState(thirdInstance);

        this.tv.append(firstInstance.toString());
        /*this.tv.append(secondInstance.toString());
        this.tv.append(fourthInstance.toString());*/

    }
    }
}
