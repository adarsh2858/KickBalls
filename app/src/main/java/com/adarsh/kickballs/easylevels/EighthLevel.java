package com.adarsh.kickballs.easylevels;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;

import com.adarsh.kickballs.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class EighthLevel extends CommonLevelTasks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighth_level);

        mButton1 = findViewById(R.id.btn_1);
        mButton2 = findViewById(R.id.btn_2);
        mButton3 = findViewById(R.id.btn_3);
        mButton4 = findViewById(R.id.btn_4);
        mButton5 = findViewById(R.id.btn_5);
        mButton6 = findViewById(R.id.btn_6);
        mButton7 = findViewById(R.id.btn_7);
        mButton8 = findViewById(R.id.btn_8);
        mButton9 = findViewById(R.id.btn_9);

        mButton1.setBackgroundResource(R.drawable.white_ball);
        mButton2.setBackgroundResource(R.drawable.white_ball);
        mButton3.setBackgroundResource(R.drawable.white_ball);
        mButton4.setBackgroundResource(R.drawable.white_ball);
        mButton5.setBackgroundResource(R.drawable.white_ball);
        mButton6.setBackgroundResource(R.drawable.white_ball);
        mButton7.setBackgroundResource(R.drawable.white_ball);
        mButton8.setBackgroundResource(R.drawable.white_ball);
        mButton9.setBackgroundResource(R.drawable.white_ball);

        mTextView = findViewById(R.id.score);
        mCountDownText = findViewById(R.id.countdown);

        resetButton = findViewById(R.id.btn_reset);
        startPauseButton = findViewById(R.id.btn_start);
        stopButton = findViewById(R.id.btn_stop);

        mButtonLogin = findViewById(R.id.btn_login);
        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() != null)
            mButtonLogin.setText(R.string.sign_out);

//        for(int i = 1; i<=9;i++){
//            int id = getResources().getIdentifier()
//            mButtons.add(mButton1);
//        }

        mButtons.add(mButton1);
        mButtons.add(mButton2);
        mButtons.add(mButton3);
        mButtons.add(mButton4);
        mButtons.add(mButton5);
        mButtons.add(mButton6);
        mButtons.add(mButton7);
        mButtons.add(mButton8);
        mButtons.add(mButton9);

        resetButton.setOnClickListener(this);
        buttonTimer = new Timer();

        super.CommonTasks();

        startPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startPauseButton.getText().equals(getString(R.string.start))) {
                    startPauseButton.setText(getString(R.string.pause));
                    displayTimerStart(60 * 1000);

                } else if (startPauseButton.getText().equals(getString(R.string.pause))) {
                    startPauseButton.setText(getString(R.string.resume));
                    displayTime.cancel();
                    timer.cancel();

                } else if (startPauseButton.getText().equals(getString(R.string.resume))) {
                    startPauseButton.setText(getString(R.string.pause));
                    displayTimerStart(timeLeft);
                }

                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.kick_balls);
                    mediaPlayer.start();
                }
            }
        });

    }

    public void displayTimerStart(long timeLength) {
        if (timer != null)
            timer.cancel();
        timer = new Timer();
        displayTime = null;

        displayTime = new CountDownTimer(timeLength, 1000) {

            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                long min = (millisUntilFinished / (1000 * 60));
                long sec = ((millisUntilFinished / 1000) - min * 60);
                mCountDownText.setText(getResources().getString(R.string.dynamic_time, min, sec));
            }

            public void onFinish() {
                timer.cancel();
                startPauseButton.setText(getString(R.string.start));
                Toast.makeText(getApplicationContext(), "TIME UP!", Toast.LENGTH_SHORT).show();
                mCountDownText.setText(R.string.initial_time);
                displayTime.cancel();
                displayTime = null;
            }
        };
        displayTime.start();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                final int[] randomNumbers = new Random().ints(minimum, maximum).distinct().limit(8).toArray();
                final int volleyRandomNumber = randomNumbers[0];
                final int golfRandomNumber = randomNumbers[1];
                final int pinkRandomNumber = randomNumbers[2];
                final int basketRandomNumber = randomNumbers[3];
                final int footRandomNumber = randomNumbers[4];
                final int redRandomNumber = randomNumbers[5];
                final int poolRandomNumber = randomNumbers[6];
                final int bowlingRandomNumber = randomNumbers[7];

                // Change the red cricket ball to white cricket ball after start button is clicked
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // update ui here else wrong thread exception
                        mButtons.get(volleyRandomNumber - 1).setBackgroundResource(R.drawable.volley_ball);
                        mButtons.get(golfRandomNumber - 1).setBackgroundResource(R.drawable.golf_ball);
                        mButtons.get(pinkRandomNumber - 1).setBackgroundResource(R.drawable.pink_ball);
                        mButtons.get(basketRandomNumber - 1).setBackgroundResource(R.drawable.basket_ball);
                        mButtons.get(footRandomNumber - 1).setBackgroundResource(R.drawable.foot_ball);
                        mButtons.get(redRandomNumber - 1).setBackgroundResource(R.drawable.red_ball);
                        mButtons.get(poolRandomNumber - 1).setBackgroundResource(R.drawable.pool_ball_1);
                        mButtons.get(bowlingRandomNumber - 1).setBackgroundResource(R.drawable.bowling_ball_1);
                    }
                });

                mButtons.get(redRandomNumber - 1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mTextView.setText(getResources().getString(R.string.dynamic_score, ++score));
                        // When button is clicked by the user, reset the ball to not clickable behaviour
                        mButtons.get(redRandomNumber - 1).setOnClickListener(null);
                    }
                });
                buttonTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // When button click is missed by the user, reset the ball to not clickable behaviour
                        mButtons.get(redRandomNumber - 1).setOnClickListener(null);

                        // Change the white cricket ball to red cricket ball after 750 milliseconds
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // update ui here else wrong thread exception
                                mButtons.get(redRandomNumber - 1).setBackgroundResource(R.drawable.white_ball);
                                mButtons.get(volleyRandomNumber - 1).setBackgroundResource(R.drawable.white_ball);
                                mButtons.get(golfRandomNumber - 1).setBackgroundResource(R.drawable.white_ball);
                                mButtons.get(pinkRandomNumber - 1).setBackgroundResource(R.drawable.white_ball);
                                mButtons.get(basketRandomNumber - 1).setBackgroundResource(R.drawable.white_ball);
                                mButtons.get(footRandomNumber - 1).setBackgroundResource(R.drawable.white_ball);
                                mButtons.get(poolRandomNumber - 1).setBackgroundResource(R.drawable.white_ball);
                                mButtons.get(bowlingRandomNumber - 1).setBackgroundResource(R.drawable.white_ball);
                            }
                        });
                    }
                }, 750);
            }
        }, 500, 1400);
    }
}
