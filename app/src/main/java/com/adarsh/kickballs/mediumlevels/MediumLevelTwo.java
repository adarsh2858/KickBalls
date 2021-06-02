package com.adarsh.kickballs.mediumlevels;

import android.os.Bundle;
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

        animationBall7 = new TranslateAnimation(500, 700, 1750, 1300);
        animationBall7.setDuration(2000);
        animationBall7.setFillAfter(false);
        animationBall7.setAnimationListener(this);
        animationBall7.setRepeatCount(Animation.INFINITE);
        btnPool7.startAnimation(animationBall7);
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
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        btnPool7.startAnimation(animationBall7);
    }
}
