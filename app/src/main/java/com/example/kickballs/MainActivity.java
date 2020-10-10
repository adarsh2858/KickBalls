package com.example.kickballs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kickballs.views.CustomView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //    private CustomView mCustomView;
    Drawable pinkBall;
    Drawable greenBall;
    private List<Button> mButtons = new ArrayList<Button>(9);
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    public Button resetButton;
    private TextView mTextView;
    private final int minimum = 1;
    private final int maximum = 10;
    private int score = 0;
    private int counter;
    Timer timer;
    Timer buttonTimer;
    Handler buttonHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mCustomView = (CustomView) findViewById(R.id.customView);
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
        resetButton = findViewById(R.id.btn_reset);
        //  To fetch drawables with theme attributes
        pinkBall= ContextCompat.getDrawable(this, R.drawable.round_button);
        greenBall = ContextCompat.getDrawable(this, R.drawable.new_round_button);

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
//        Button randomButton = (Button)(MainActivity.class.getField("mButton"+i));
        resetButton.setOnClickListener(this);
        timer = new Timer();
        buttonTimer = new Timer();
        buttonHandler = new Handler();
        counter=0;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                final int randomNumber = ((int) (Math.random() * (maximum - minimum))) + minimum; //7
                mButtons.get(randomNumber - 1).setText("X");
//                mButtons.get(randomNumber - 1).setBackground(greenBall);
                mButtons.get(randomNumber - 1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mTextView.setText("Score : " + String.valueOf(++score));
                    }
                });
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        mButtons.get(randomNumber - 1).setOnClickListener(null);
////                        mButtons.get(randomNumber - 1).setText(Integer.toString(randomNumber));
//                        mButtons.get(randomNumber - 1).setBackground(pinkBall);
//                    }
//                },1000);
                buttonTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        mButtons.get(randomNumber - 1).setOnClickListener(null);
                        mButtons.get(randomNumber - 1).setText(Integer.toString(randomNumber));
//                        mButtons.get(randomNumber - 1).setBackground(pinkBall);
                    }
                }, 500);
//                Log.v("Random", String.valueOf(randomNumber));
//                Log.v("Current Score", String.valueOf(score));
//                score+=1;
//                mButtons.get(randomNumber-1).setText("X");
//                System.out.println(mButtons.get(randomNumber-1).getText());
//                mButtons.get(randomNumber-1).setOnClickListener(new View.OnClickListener() {
//                    public void onClick(View v) {
//                        if(mButtons.get(randomNumber-1).getText() == "")
//                            score+=1;
//                        // Code here executes on main thread after user presses button
//                        Log.v("Clicked", "HELLO WORLD");
//                    }
//                });
//                mCustomView.swapColor();
//                System.out.println(mFirstButton.getBackground());
//                mSecondButton.getBackground();
//                mThirdButton.getBackground();
            }
        }, 2000, 2500);

//        findViewById(R.id.btn_swap_color).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mCustomView.swapColor();
//            }
//        });

    }

    public void swapColor() {
        return;
    }

    @Override
    public void onClick(View v) {
        score = 0;
        mTextView.setText("Score : " + score);
    }
}
