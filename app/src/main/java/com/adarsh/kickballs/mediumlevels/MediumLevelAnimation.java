package com.adarsh.kickballs.mediumlevels;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public class MediumLevelAnimation extends MediumLevelOne implements Animation.AnimationListener {
    @Override
    public void onAnimationEnd(Animation animation) {
        MediumLevelOne.btnPool2.startAnimation(MediumLevelOne.animationBall2);
        MediumLevelOne.btnPool3.startAnimation(MediumLevelOne.animationBall3);
        MediumLevelOne.btnPool4.startAnimation(MediumLevelOne.animationBall4);
        MediumLevelOne.btnPool5.startAnimation(MediumLevelOne.animationBall5);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        TranslateAnimation animationBall2Return = new TranslateAnimation(0, 350, 950, 950);
        animationBall2Return.setDuration(2000);
        animationBall2Return.setFillAfter(false);
        animationBall2Return.setAnimationListener(this);
        MediumLevelOne.btnPool2.startAnimation(animationBall2Return);

        TranslateAnimation animationBall3Return = new TranslateAnimation(600, 350, 950, 950);
        animationBall3Return.setDuration(2000);
        animationBall3Return.setFillAfter(false);
        animationBall3Return.setAnimationListener(this);
        MediumLevelOne.btnPool3.startAnimation(animationBall3Return);

        TranslateAnimation animationBall4Return = new TranslateAnimation(50, 200, 100, 800);
        animationBall4Return.setDuration(2000);
        animationBall4Return.setFillAfter(false);
        animationBall4Return.setAnimationListener(this);
        MediumLevelOne.btnPool4.startAnimation(animationBall4Return);

        TranslateAnimation animationBall5Return = new TranslateAnimation(400, 200, 100, 800);
        animationBall5Return.setDuration(2000);
        animationBall5Return.setFillAfter(false);
        animationBall5Return.setAnimationListener(this);
        MediumLevelOne.btnPool5.startAnimation(animationBall5Return);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }
}
