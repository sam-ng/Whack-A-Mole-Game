package com.example.ngs5.whackamole;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageButton[] moles;
    private ImageButton mole1;
    private ImageButton mole2;
    private ImageButton mole3;
    private ImageButton mole4;
    private ImageButton mole5;
    private ImageButton mole6;
    private ImageButton mole7;
    private ImageButton mole8;
    private ImageButton mole9;

    private Integer[] resource;
    private int moleNum;
    private Random random;

    private int score;
    private CountDownTimer countDownTimer;
    private TextView time;
    private TextView scoreTest;
    private long[] disappear;

    private MediaPlayer bgm;
    private MediaPlayer yoshi;

    public static final String EXTRA_MESSAGE = "com.example.ngs5.whackamole";
    private String endScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        addListenerOnButton();
        timeStarter();
        playMusic();
    }

    public void init() {
        mole1 = (ImageButton) findViewById(R.id.mole1);
        mole2 = (ImageButton) findViewById(R.id.mole2);
        mole3 = (ImageButton) findViewById(R.id.mole3);
        mole4 = (ImageButton) findViewById(R.id.mole4);
        mole5 = (ImageButton) findViewById(R.id.mole5);
        mole6 = (ImageButton) findViewById(R.id.mole6);
        mole7 = (ImageButton) findViewById(R.id.mole7);
        mole8 = (ImageButton) findViewById(R.id.mole8);
        mole9 = (ImageButton) findViewById(R.id.mole9);

        moles = new ImageButton[9];
        moles[0] = mole1;
        moles[1] = mole2;
        moles[2] = mole3;
        moles[3] = mole4;
        moles[4] = mole5;
        moles[5] = mole6;
        moles[6] = mole7;
        moles[7] = mole8;
        moles[8] = mole9;

        resource = new Integer[9];

        for (int i = 0; i < moles.length; i++) {
            moles[i].setImageResource(R.drawable.moledown);
            moles[i].setTag(R.drawable.moledown);

            resource[i] = (Integer) moles[i].getTag();
        }

        random = new Random();
        score = 0;
        time = (TextView) findViewById(R.id.time);
        scoreTest = (TextView) findViewById(R.id.ScoreTest);
        scoreTest.setText("Score: " + String.valueOf(score));

        disappear = new long[9];

        bgm = MediaPlayer.create(getApplicationContext(), R.raw.supermarioworld);
        yoshi = MediaPlayer.create(getApplicationContext(), R.raw.yoshi);
    }

    public void timeStarter() {
        countDownTimer = new CountDownTimer(120*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("Time Left: " + millisUntilFinished / 1000);
                for (int i = 0; i < disappear.length; i++) {
                    if (disappear[i] == millisUntilFinished / 1000) {
                        moles[i].setImageResource(R.drawable.moledown);
                        moles[i].setTag(R.drawable.moledown);
                        resource[i] = (Integer) moles[i].getTag();
                    }
                }
                moleNum = random.nextInt(9);
                while (resource[moleNum] == R.drawable.moleup) {
                    moleNum = random.nextInt(9);
                }

                moles[moleNum].setImageResource(R.drawable.moleup);
                moles[moleNum].setTag(R.drawable.moleup);
                resource[moleNum] = (Integer) moles[moleNum].getTag();

                if (millisUntilFinished / 1000 >= 2) {
                    disappear[moleNum] = millisUntilFinished / 1000 - 2;
                }
            }

            @Override
            public void onFinish() {
                time.setText("FINISH!");
                for (int i = 0; i < moles.length; i++) {
                    moles[i].setImageResource(R.drawable.moledown);
                }
                bgm.release();

                Intent endScreen = new Intent(MainActivity.this, EndGame.class);
                endScore = scoreTest.getText().toString();
                endScreen.putExtra(EXTRA_MESSAGE,endScore);
                startActivity(endScreen);
            }
        };
        countDownTimer.start();
    }

    public void addListenerOnButton() {

        mole1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resource[0] == R.drawable.moleup) {
                    mole1.setImageResource(R.drawable.moledown);
                    mole1.setTag(R.drawable.moledown);

                    resource[0] = (Integer) mole1.getTag();
                    score++;

                    yoshi.start();
                }
                scoreTest.setText("Score: " + String.valueOf(score));
            }
        });
        mole2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resource[1] == R.drawable.moleup) {
                    mole2.setImageResource(R.drawable.moledown);
                    mole2.setTag(R.drawable.moledown);

                    resource[1] = (Integer) mole2.getTag();
                    score++;

                    yoshi.start();
                }
                scoreTest.setText("Score: " + String.valueOf(score));
            }
        });
        mole3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resource[2] == R.drawable.moleup) {
                    mole3.setImageResource(R.drawable.moledown);
                    mole3.setTag(R.drawable.moledown);

                    resource[2] = (Integer) mole3.getTag();
                    score++;

                    yoshi.start();
                }
                scoreTest.setText("Score: " + String.valueOf(score));
            }
        });
        mole4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resource[3] == R.drawable.moleup) {
                    mole4.setImageResource(R.drawable.moledown);
                    mole4.setTag(R.drawable.moledown);

                    resource[3] = (Integer) mole4.getTag();
                    score++;

                    yoshi.start();
                }
                scoreTest.setText("Score: " + String.valueOf(score));
            }
        });
        mole5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resource[4] == R.drawable.moleup) {
                    mole5.setImageResource(R.drawable.moledown);
                    mole5.setTag(R.drawable.moledown);

                    resource[4] = (Integer) mole5.getTag();
                    score++;

                    yoshi.start();
                }
                scoreTest.setText("Score: " + String.valueOf(score));
            }
        });
        mole6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resource[5] == R.drawable.moleup) {
                    mole6.setImageResource(R.drawable.moledown);
                    mole6.setTag(R.drawable.moledown);

                    resource[5] = (Integer) mole6.getTag();
                    score++;

                    yoshi.start();
                }
                scoreTest.setText("Score: " + String.valueOf(score));
            }
        });
        mole7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resource[6] == R.drawable.moleup) {
                    mole7.setImageResource(R.drawable.moledown);
                    mole7.setTag(R.drawable.moledown);

                    resource[6] = (Integer) mole7.getTag();
                    score++;

                    yoshi.start();
                }
                scoreTest.setText("Score: " + String.valueOf(score));
            }
        });
        mole8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resource[7] == R.drawable.moleup) {
                    mole8.setImageResource(R.drawable.moledown);
                    mole8.setTag(R.drawable.moledown);

                    resource[7] = (Integer) mole8.getTag();
                    score++;

                    yoshi.start();
                }
                scoreTest.setText("Score: " + String.valueOf(score));
            }
        });
        mole9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resource[8] == R.drawable.moleup) {
                    mole9.setImageResource(R.drawable.moledown);
                    mole9.setTag(R.drawable.moledown);

                    resource[8] = (Integer) mole9.getTag();
                    score++;

                    yoshi.start();
                }
                scoreTest.setText("Score: " + String.valueOf(score));
            }
        });
    }

    public void playMusic() {
        bgm.start();
    }
}
