package com.example.kickballs;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class FifthLevel extends CommonLevelTasks implements DefaultLevel, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_level);

        mButton1 = findViewById(R.id.btn_1);
        mButton2 = findViewById(R.id.btn_2);
        mButton3 = findViewById(R.id.btn_3);
        mButton4 = findViewById(R.id.btn_4);
        mButton5 = findViewById(R.id.btn_5);
        mButton6 = findViewById(R.id.btn_6);
        mButton7 = findViewById(R.id.btn_7);
        mButton8 = findViewById(R.id.btn_8);
        mButton9 = findViewById(R.id.btn_9);

        mButton1.setBackgroundResource(R.drawable.golf_ball);
        mButton2.setBackgroundResource(R.drawable.golf_ball);
        mButton3.setBackgroundResource(R.drawable.golf_ball);
        mButton4.setBackgroundResource(R.drawable.golf_ball);
        mButton5.setBackgroundResource(R.drawable.golf_ball);
        mButton6.setBackgroundResource(R.drawable.golf_ball);
        mButton7.setBackgroundResource(R.drawable.golf_ball);
        mButton8.setBackgroundResource(R.drawable.golf_ball);
        mButton9.setBackgroundResource(R.drawable.golf_ball);

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
                if(startPauseButton.getText().equals(getString(R.string.start))){
                    startPauseButton.setText(getString(R.string.pause));
                    displayTimerStart(60*1000);

                } else if (startPauseButton.getText().equals(getString(R.string.pause))){
                    startPauseButton.setText(getString(R.string.resume));
                    displayTime.cancel();
                    timer.cancel();

                } else if (startPauseButton.getText().equals(getString(R.string.resume))){
                    startPauseButton.setText(getString(R.string.pause));
                    displayTimerStart(timeLeft);
                }

                if (mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.kick_balls);
                    mediaPlayer.start();
                }
            }
        });

    }

    public void displayTimerStart(long timeLength) {
        if(timer!=null)
            timer.cancel();
        timer = new Timer();
        displayTime=null;

        displayTime = new CountDownTimer(timeLength, 1000) {

            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                long min = (millisUntilFinished/(1000*60));
                long sec = ((millisUntilFinished/1000)-min*60);
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
                final int[] randomNumbers = new Random().ints(minimum, maximum).distinct().limit(5).toArray();
                final int randomNumber = randomNumbers[0];
                final int pinkRandomNumber = randomNumbers[1];
                final int basketRandomNumber = randomNumbers[2];
                final int footRandomNumber = randomNumbers[3];
                final int volleyRandomNumber = randomNumbers[4];

                // Change the red cricket ball to white cricket ball after start button is clicked
                runOnUiThread(new Runnable(){
                    @Override
                    public void run(){
                        // update ui here else wrong thread exception
                        mButtons.get(randomNumber - 1).setBackgroundResource(R.drawable.red_ball);
                        mButtons.get(pinkRandomNumber - 1).setBackgroundResource(R.drawable.pink_ball);
                        mButtons.get(basketRandomNumber - 1).setBackgroundResource(R.drawable.basket_ball);
                        mButtons.get(footRandomNumber - 1).setBackgroundResource(R.drawable.foot_ball);
                        mButtons.get(volleyRandomNumber - 1).setBackgroundResource(R.drawable.volley_ball);
                    }
                });

                mButtons.get(randomNumber - 1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mTextView.setText(getResources().getString(R.string.dynamic_score, ++score));
                        mButtons.get(randomNumber - 1).setOnClickListener(null);
                    }
                });
                buttonTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        mButtons.get(randomNumber - 1).setOnClickListener(null);

                        // Change the white cricket ball to red cricket ball after 750 milliseconds
                        runOnUiThread(new Runnable(){
                            @Override
                            public void run(){
                                // update ui here else wrong thread exception
                                mButtons.get(randomNumber - 1).setBackgroundResource(R.drawable.golf_ball);
                                mButtons.get(pinkRandomNumber - 1).setBackgroundResource(R.drawable.golf_ball);
                                mButtons.get(basketRandomNumber - 1).setBackgroundResource(R.drawable.golf_ball);
                                mButtons.get(footRandomNumber - 1).setBackgroundResource(R.drawable.golf_ball);
                                mButtons.get(volleyRandomNumber - 1).setBackgroundResource(R.drawable.golf_ball);
                            }
                        });
                    }
                }, 750);
            }
        }, 500, 1400);
    }

}
