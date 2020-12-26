package com.example.kickballs.easylevels;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kickballs.FirstActivity;
import com.example.kickballs.R;
import com.example.kickballs.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class CommonLevelTasks extends AppCompatActivity implements View.OnClickListener {

    protected List<Button> mButtons = new ArrayList<>(9);
    protected Button startPauseButton, stopButton, resetButton, mButtonLogin;
    protected TextView mTextView, mCountDownText;
    protected final int minimum = 1, maximum = 10;
    protected int score = 0;
    protected long timeLeft;
    protected Button mButton1, mButton2, mButton3, mButton4, mButton5, mButton6, mButton7, mButton8, mButton9;

    Timer timer;
    Timer buttonTimer;
    Drawable redBall, whiteBall, pinkBall, footBall, basketBall, volleyBall, golfBall;
    MediaPlayer mediaPlayer;
    CountDownTimer displayTime;
    FirebaseAuth fAuth;

    protected void CommonTasks() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.kick_balls);
            mediaPlayer.start();
        }

        //  To fetch drawables with theme attributes
        redBall= getResources().getDrawable(R.drawable.red_ball);
        whiteBall = getResources().getDrawable(R.drawable.white_ball);
        pinkBall = getResources().getDrawable(R.drawable.pink_ball);
        footBall = getResources().getDrawable(R.drawable.foot_ball);
        basketBall = getResources().getDrawable(R.drawable.basket_ball);
        volleyBall = getResources().getDrawable(R.drawable.volley_ball);
        golfBall = getResources().getDrawable(R.drawable.golf_ball);

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

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "RESET ALL", Toast.LENGTH_SHORT).show();
        score = 0;
        mTextView.setText(getResources().getString(R.string.dynamic_score, score));
        startPauseButton.setText(getString(R.string.start));

        if(displayTime!=null){
            timer.cancel();
            mCountDownText.setText(R.string.initial_time);
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
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer = null;
            }

            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
    }

    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(getApplicationContext(), "Signed Out Successfully", Toast.LENGTH_SHORT).show();
        // After signing out, redirect user to first page with register, sign in and guest option
        startActivity(new Intent(getApplicationContext(), FirstActivity.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }
}
