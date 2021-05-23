package com.adarsh.kickballs.mediumlevels;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public class MediumLevelAnimation extends MediumLevelOne implements Animation.AnimationListener {
    @Override
    public void onAnimationEnd(Animation animation) {
        MediumLevelOne.btnPool2.startAnimation(MediumLevelOne.animationBall2);
        MediumLevelOne.btnPool3.startAnimation(MediumLevelOne.animationBall3);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        TranslateAnimation animationBall2Return = new TranslateAnimation(0, 350, 0, 0);
        animationBall2Return.setDuration(2000);
        animationBall2Return.setFillAfter(false);
        animationBall2Return.setAnimationListener(this);
        MediumLevelOne.btnPool2.startAnimation(animationBall2Return);

        TranslateAnimation animationBall3Return = new TranslateAnimation(600, 350, 0, 0);
        animationBall3Return.setDuration(2000);
        animationBall3Return.setFillAfter(false);
        animationBall3Return.setAnimationListener(this);
        MediumLevelOne.btnPool3.startAnimation(animationBall3Return);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }
}
