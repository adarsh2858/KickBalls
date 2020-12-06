package com.example.kickballs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
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

import com.example.kickballs.views.CustomView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Button> mButtons = new ArrayList<Button>(9);
    private Button mButton1, mButton2, mButton3, mButton4, mButton5, mButton6, mButton7, mButton8, mButton9;
    public Button startButton, stopButton, resetButton, mButtonLogin;
    private TextView mTextView, mCountDownText;
    private final int minimum = 1, maximum = 10;
    private int score = 0;
    private int counter;
    Timer timer;
    Timer buttonTimer;
    Handler buttonHandler;
    Drawable redBall, whiteBall;
    MediaPlayer mediaPlayer;
    CountDownTimer DisplayTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.kick_balls);
        mediaPlayer.start();

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
        startButton = findViewById(R.id.btn_start);
        stopButton = findViewById(R.id.btn_stop);

        //  To fetch drawables with theme attributes
        redBall= getResources().getDrawable(R.drawable.red_ball);
        whiteBall = getResources().getDrawable(R.drawable.white_ball);

        mButtonLogin = findViewById(R.id.btn_login);

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

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.kick_balls);
                    mediaPlayer.start();
                }

                if(timer!=null)
                    timer.cancel();
                timer = new Timer();

                if (DisplayTime == null) {
                    DisplayTime = new CountDownTimer(60000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            mCountDownText.setText("TIME - " + millisUntilFinished / 1000);
                        }

                        public void onFinish() {
                            timer.cancel();
                            Toast toast = Toast.makeText(getApplicationContext(), "TIME UP!", Toast.LENGTH_SHORT);
                            toast.show();
                            mCountDownText.setText("TIME - 60");
                            DisplayTime = null;
                            if(mediaPlayer!=null){
                                mediaPlayer.stop();
                                mediaPlayer=null;
                            }
                        }
                    };
                    DisplayTime.start();
                }

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
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                    mediaPlayer=null;
                }

                if(DisplayTime!=null){
                    DisplayTime.cancel();
                    DisplayTime.onFinish();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        score = 0;
        mTextView.setText("SCORE - " + score);
    }

    public void login(View view){
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "LOGIN BUTTON CLICKED", Toast.LENGTH_SHORT);
        toast.show();
    }
}
