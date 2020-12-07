package com.example.kickballs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kickballs.ui.login.LoginActivity;
import com.example.kickballs.views.CustomView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Button> mButtons = new ArrayList<Button>(9);
    private Button mButton1, mButton2, mButton3, mButton4, mButton5, mButton6, mButton7, mButton8, mButton9;
    public Button startPauseButton, stopButton, resetButton, mButtonLogin;
    private TextView mTextView, mCountDownText;
    private final int minimum = 1, maximum = 10;
    private int score = 0;
    private long counter, timeLeft;

    Timer timer;
    Timer buttonTimer;
    Handler buttonHandler;
    Drawable redBall, whiteBall;
    MediaPlayer mediaPlayer;
    CountDownTimer displayTime;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (mediaPlayer == null){
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.kick_balls);
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

        mButtonLogin = findViewById(R.id.btn_login);
        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() != null)
            mButtonLogin.setText("SIGN OUT");

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
        buttonHandler = new Handler();
        counter=0;

        startPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startPauseButton.getText().equals("Start")){
                    startPauseButton.setText("Pause");
                    displayTimerStart(60*1000);

                } else if (startPauseButton.getText().equals("Pause")){
                    startPauseButton.setText("Resume");
                    displayTime.cancel();
                    timer.cancel();
//                    timerPause();

                } else if (startPauseButton.getText().equals("Resume")){
                    startPauseButton.setText("Pause");
                    Log.i("RESUME timeLeft - ", Long.toString(timeLeft));
                    displayTimerStart(timeLeft);
//                    timerResume();
                }

                if (mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.kick_balls);
                    mediaPlayer.start();
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Stopped!", Toast.LENGTH_SHORT).show();
                startPauseButton.setText("Start");

                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                    mediaPlayer=null;
                }

                if(timer!=null){
                    timer.cancel();
                    timer = null;
                }

                if(displayTime!=null){
                    mCountDownText.setText("TIME - 60");
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
                mCountDownText.setText("TIME - " + Long.toString(min) + ":" + Long.toString(sec));
            }

            public void onFinish() {
                timer.cancel();
                Toast.makeText(getApplicationContext(), "TIME UP!", Toast.LENGTH_SHORT).show();
                mCountDownText.setText("TIME - 60");
                displayTime.cancel();
                displayTime = null;
                }
            };
        displayTime.start();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                final int randomNumber = ((int) (Math.random() * (maximum - minimum))) + minimum;

                // Change the red cricket ball to white cricket ball after start button is clicked
                runOnUiThread(new Runnable(){
                    @Override
                    public void run(){
                        // update ui here else wrong thread exception
                        mButtons.get(randomNumber - 1).setBackgroundResource(R.drawable.white_ball);
                    }
                });

                mButtons.get(randomNumber - 1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mTextView.setText("SCORE - " + String.valueOf(++score));
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
                                mButtons.get(randomNumber - 1).setBackgroundResource(R.drawable.red_ball);
                            }
                        });
                    }
                }, 750);
            }
        }, 2000, 2500);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "RESET ALL", Toast.LENGTH_SHORT).show();
        score = 0;
        mTextView.setText("SCORE - " + score);
        startPauseButton.setText("Start");

        if(displayTime!=null){
            timer.cancel();
            mCountDownText.setText("TIME - 60");
            displayTime.cancel();
            displayTime = null;
        }
    }

    // Login method to switch view to login page
    public void loginFromGame(View view) {
        if (fAuth.getCurrentUser() != null){
            logout(view);
        }
        else {
            mediaPlayer.stop();
            mediaPlayer = null;

            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    public void logout(View view){
        fAuth.getInstance().signOut();
        Toast.makeText(getApplicationContext(), "Signed Out Successfully", Toast.LENGTH_SHORT).show();
        // After signing out, redirect user to first page with register, sign in and guest option
        startActivity(new Intent(getApplicationContext(), FirstActivity.class));
    }
}
