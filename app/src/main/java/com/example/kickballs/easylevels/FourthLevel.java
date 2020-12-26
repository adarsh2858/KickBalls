package com.example.kickballs.easylevels;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;

import com.example.kickballs.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Timer;
import java.util.TimerTask;

public class FourthLevel extends CommonLevelTasks implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_level);

        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.kick_balls);
            mediaPlayer.start();
        }

        mButton1 = findViewById(R.id.btn_1);
        mButton2 = findViewById(R.id.btn_2);
        mButton3 = findViewById(R.id.btn_3);
        mButton4 = findViewById(R.id.btn_4);
        mButton5 = findViewById(R.id.btn_5);
        mButton6 = findViewById(R.id.btn_6);
        mButton7 = findViewById(R.id.btn_7);
        mButton8 = findViewById(R.id.btn_8);
        mButton9 = findViewById(R.id.btn_9);

        mTextView = findViewById(R.id.score);
        mCountDownText = findViewById(R.id.countdown);

        resetButton = findViewById(R.id.btn_reset);
        startPauseButton = findViewById(R.id.btn_start);
        stopButton = findViewById(R.id.btn_stop);

        //  To fetch drawables with theme attributes
        redBall= getResources().getDrawable(R.drawable.red_ball);
        whiteBall = getResources().getDrawable(R.drawable.white_ball);
        pinkBall = getResources().getDrawable(R.drawable.pink_ball);
        basketBall = getResources().getDrawable(R.drawable.basket_ball);
        footBall = getResources().getDrawable(R.drawable.foot_ball);

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
//                Log.i("START",startPauseButton.getText().toString());
                System.out.println(getString(R.string.start));
                if (startPauseButton.getText().equals(getString(R.string.start))) {
                    startPauseButton.setText(getString(R.string.pause));
                    displayTimerStart(60 * 1000);

                } else if (startPauseButton.getText().equals(getString(R.string.pause))) {
                    startPauseButton.setText(getString(R.string.resume));
                    displayTime.cancel();
                    timer.cancel();
//                    timerPause();

                } else if (startPauseButton.getText().equals(getString(R.string.resume))) {
                    startPauseButton.setText(getString(R.string.pause));
                    displayTimerStart(timeLeft);
//                    timerResume();
                }

                if (mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.kick_balls);
                    mediaPlayer.start();
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Stopped!", Toast.LENGTH_SHORT).show();
                startPauseButton.setText(getString(R.string.start));

                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                    mediaPlayer=null;
                }

                if(timer!=null){
                    timer.cancel();
                    timer = null;
                }

                if(displayTime!=null){
                    mCountDownText.setText(R.string.initial_time);
                    displayTime.cancel();
                    displayTime = null;
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
                final int randomNumber = ((int) (Math.random() * (maximum - minimum))) + minimum;
                final int pinkRandomNumber = ((int) (Math.random() * (maximum - minimum))) + minimum;
                final int basketRandomNumber = ((int) (Math.random() * (maximum - minimum))) + minimum;
                final int redRandomNumber = ((int) (Math.random() * (maximum - minimum))) + minimum;

                // Change the red cricket ball to white cricket ball after start button is clicked
                runOnUiThread(new Runnable(){
                    @Override
                    public void run(){
                        // update ui here else wrong thread exception
                        mButtons.get(randomNumber - 1).setBackgroundResource(R.drawable.white_ball);
                        mButtons.get(basketRandomNumber - 1).setBackgroundResource(R.drawable.basket_ball);
                        mButtons.get(pinkRandomNumber - 1).setBackgroundResource(R.drawable.pink_ball);
                        mButtons.get(redRandomNumber - 1).setBackgroundResource(R.drawable.red_ball);
                    }
                });

                mButtons.get(pinkRandomNumber - 1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mTextView.setText(getResources().getString(R.string.dynamic_score, ++score));
                        mButtons.get(pinkRandomNumber - 1).setOnClickListener(null);
                    }
                });
                buttonTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        mButtons.get(pinkRandomNumber - 1).setOnClickListener(null);

                        // Change the white cricket ball to red cricket ball after 750 milliseconds
                        runOnUiThread(new Runnable(){
                            @Override
                            public void run(){
                                // update ui here else wrong thread exception
                                mButtons.get(randomNumber - 1).setBackgroundResource(R.drawable.foot_ball);
                                mButtons.get(pinkRandomNumber - 1).setBackgroundResource(R.drawable.foot_ball);
                                mButtons.get(basketRandomNumber - 1).setBackgroundResource(R.drawable.foot_ball);
                                mButtons.get(redRandomNumber - 1).setBackgroundResource(R.drawable.foot_ball);
                            }
                        });
                    }
                }, 650);
            }
        }, 500, 1400);
    }
}
