package com.example.ngs5.whackamole;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class EndGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        Intent endScreen = getIntent();
        String endScore = endScreen.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView score= (TextView)findViewById(R.id.score);
        score.setText(endScore);

        Button endGame = (Button)findViewById(R.id.endGame);
        Button restartGame = (Button)findViewById(R.id.restartGame);
        endGame.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent endTheGame = new Intent(EndGame.this, StartUpMenu.class);
                startActivity(endTheGame);
            }
        });

        restartGame.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playGame = new Intent(EndGame.this, MainActivity.class);
                startActivity(playGame);
            }
        });

    }
}