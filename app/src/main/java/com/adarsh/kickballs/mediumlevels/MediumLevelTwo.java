package com.adarsh.kickballs.mediumlevels;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.kickballs.R;


public class MediumLevelTwo extends AppCompatActivity implements Animation.AnimationListener {
    protected static Button btnPool2, btnPool3, btnPool4, btnPool5, btnPool6, btnPool7;
    protected static TranslateAnimation animationBall2, animationBall3, animationBall4,
            animationBall5, animationBall6, animationBall7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_level_two);

        btnPool2 = findViewById(R.id.btn_pool_2);
        btnPool3 = findViewById(R.id.btn_pool_3);
        btnPool4 = findViewById(R.id.btn_pool_4);
        btnPool5 = findViewById(R.id.btn_pool_5);
        btnPool6 = findViewById(R.id.btn_pool_6);
        btnPool7 = findViewById(R.id.btn_pool_1);

        btnPool7.setBackground(getDrawable(R.drawable.pool_ball_7));
        btnPool6.setVisibility(View.INVISIBLE);

        animationBall7 = new TranslateAnimation(500, 700, 1750, 1300);
        animationBall7.setDuration(2000);
        animationBall7.setFillAfter(false);
        animationBall7.setAnimationListener(this);
        animationBall7.setRepeatCount(Animation.INFINITE);
        btnPool7.startAnimation(animationBall7);

        animationBall2 = new TranslateAnimation(200, 700, 1750, 1000);
        animationBall2.setDuration(2000);
        animationBall2.setFillAfter(false);
        animationBall2.setAnimationListener(this);
        animationBall2.setRepeatCount(Animation.INFINITE);
        btnPool2.startAnimation(animationBall2);

        animationBall3 = new TranslateAnimation(-100, 550, 1450, 600);
        animationBall3.setDuration(2000);
        animationBall3.setFillAfter(false);
        animationBall3.setAnimationListener(this);
        animationBall3.setRepeatCount(Animation.INFINITE);
        btnPool3.startAnimation(animationBall3);

        animationBall4 = new TranslateAnimation(50, 700, 1150, 300);
        animationBall4.setDuration(2000);
        animationBall4.setFillAfter(false);
        animationBall4.setAnimationListener(this);
        animationBall4.setRepeatCount(Animation.INFINITE);
        btnPool4.startAnimation(animationBall4);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        TranslateAnimation animationBall7Return = new TranslateAnimation(700, 500, 1300, 1750);
        animationBall7Return.setDuration(2000);
        animationBall7Return.setFillAfter(false);
        animationBall7Return.setAnimationListener(this);
        btnPool7.startAnimation(animationBall7Return);

        TranslateAnimation animationBall2Return = new TranslateAnimation(700, 200, 1000, 1750);
        animationBall2Return.setDuration(2000);
        animationBall2Return.setFillAfter(false);
        btnPool2.startAnimation(animationBall2Return);

        TranslateAnimation animationBall3Return = new TranslateAnimation(550, -100, 600, 1450);
        animationBall3Return.setDuration(2000);
        animationBall3Return.setFillAfter(false);
        btnPool3.startAnimation(animationBall3Return);

        TranslateAnimation animationBall4Return = new TranslateAnimation(700, 50, 300, 1150);
        animationBall4Return.setDuration(2000);
        animationBall4Return.setFillAfter(false);
        btnPool4.startAnimation(animationBall4Return);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        btnPool7.startAnimation(animationBall7);
        btnPool2.startAnimation(animationBall2);
        btnPool3.startAnimation(animationBall3);
        btnPool4.startAnimation(animationBall4);
    }
}
