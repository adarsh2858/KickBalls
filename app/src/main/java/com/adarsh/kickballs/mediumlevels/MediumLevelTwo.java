package com.adarsh.kickballs.mediumlevels;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Toast;

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
                System.out.println("Lorem ipsum dolor sit amet...");

        animationBall7 = new TranslateAnimation(500, 700, 1750, 1300);
        animationBall7.setDuration(1800);
        animationBall7.setFillAfter(false);
        animationBall7.setAnimationListener(this);
        animationBall7.setRepeatCount(Animation.INFINITE);
        btnPool7.startAnimation(animationBall7);

        animationBall2 = new TranslateAnimation(200, 700, 1750, 1000);
        animationBall2.setDuration(1800);
        animationBall2.setFillAfter(false);
        animationBall2.setAnimationListener(this);
        animationBall2.setRepeatCount(Animation.INFINITE);
        btnPool2.startAnimation(animationBall2);

        animationBall3 = new TranslateAnimation(-100, 550, 1450, 600);
        animationBall3.setDuration(1800);
        animationBall3.setFillAfter(false);
        animationBall3.setAnimationListener(this);
        animationBall3.setRepeatCount(Animation.INFINITE);
        btnPool3.startAnimation(animationBall3);

        animationBall4 = new TranslateAnimation(50, 700, 1150, 300);
        animationBall4.setDuration(1800);
        animationBall4.setFillAfter(false);
        animationBall4.setAnimationListener(this);
        animationBall4.setRepeatCount(Animation.INFINITE);
        btnPool4.startAnimation(animationBall4);

        animationBall5 = new TranslateAnimation(-100, 450, 850, 100);
        animationBall5.setDuration(1800);
        animationBall5.setFillAfter(false);
        animationBall5.setAnimationListener(this);
        animationBall5.setRepeatCount(Animation.INFINITE);
        btnPool5.startAnimation(animationBall5);

//        btnPool5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("Lorem ipsum dolor sit amet...");
//                Toast.makeText(getApplicationContext(), "Foo bar", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        TranslateAnimation animationBall7Return = new TranslateAnimation(700, 500, 1300, 1750);
        animationBall7Return.setDuration(1800);
        animationBall7Return.setFillAfter(false);
        animationBall7Return.setAnimationListener(this);
        btnPool7.startAnimation(animationBall7Return);

        TranslateAnimation animationBall2Return = new TranslateAnimation(700, 200, 1000, 1750);
        animationBall2Return.setDuration(1800);
        animationBall2Return.setFillAfter(false);
        btnPool2.startAnimation(animationBall2Return);

        TranslateAnimation animationBall3Return = new TranslateAnimation(550, -100, 600, 1450);
        animationBall3Return.setDuration(1800);
        animationBall3Return.setFillAfter(false);
        btnPool3.startAnimation(animationBall3Return);

        TranslateAnimation animationBall4Return = new TranslateAnimation(700, 50, 300, 1150);
        animationBall4Return.setDuration(1800);
        animationBall4Return.setFillAfter(false);
        btnPool4.startAnimation(animationBall4Return);

        TranslateAnimation animationBall5Return = new TranslateAnimation(450, -100, 100, 850);
        animationBall5Return.setDuration(1800);
        animationBall5Return.setFillAfter(false);
        btnPool5.startAnimation(animationBall5Return);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        btnPool7.startAnimation(animationBall7);
        btnPool2.startAnimation(animationBall2);
        btnPool3.startAnimation(animationBall3);
        btnPool4.startAnimation(animationBall4);
        btnPool5.startAnimation(animationBall5);
    }

    public void btn5Click(View view) {
        System.out.println("Lorem ipsum dolor sit amet...");
        Toast.makeText(getApplicationContext(), "Foo bar", Toast.LENGTH_SHORT).show();

    }
}
