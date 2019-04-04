package com.example.hw4d;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * class MainMenuActivity
 *
 * The activity for the main menu when starting the game
 *
 * @authors President Game Team
 * @date Spring 2019
 */
public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alpha_start_menu);

        startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(this);
    }

    /**
     * onClick
     *
     * when the start button is clicked, the InGameActivity starts
     */
    @Override
    public void onClick(View v) {
        Intent MainIntent = new Intent(this, InGameActivity.class);
        startActivity(MainIntent);
        finish();
    }
}


