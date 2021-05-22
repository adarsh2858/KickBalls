package com.adarsh.kickballs.mediumlevels;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.media.Image;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.adarsh.kickballs.R;

public class MediumLevelOne extends AppCompatActivity implements Animation.AnimationListener {
    Button btnPool1;
    TranslateAnimation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_level_one);
        btnPool1 = findViewById(R.id.btn_pool_1);
        animation = new TranslateAnimation(0, 750, 0, 0);
        animation.setDuration(4000);
        animation.setDuration(4000);
        animation.setFillAfter(false);
        animation.setAnimationListener(this);
        animation.setRepeatCount(Animation.INFINITE);
        btnPool1.startAnimation(animation);

    }

    @Override
    public void onAnimationEnd(Animation animation1) {
        btnPool1.startAnimation(animation);
//        btnPool1.clearAnimation();
//        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(btnPool1.getWidth(), btnPool1.getHeight());
//        lp.setMargins(50, 100, 0, 0);
//        btnPool1.setLayoutParams(lp);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        TranslateAnimation animation2 = new TranslateAnimation(750, 0, 0, 0);
        animation2.setDuration(4000);
        animation2.setFillAfter(false);
        animation2.setAnimationListener(this);
        btnPool1.startAnimation(animation2);
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }
}