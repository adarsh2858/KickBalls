package com.example.kickballs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.kickballs.views.CustomView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private CustomView mCustomView;
    private Button mFirstButton;
    private Button mSecondButton;
    private Button mThirdButton;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mCustomView = (CustomView) findViewById(R.id.customView);
        mFirstButton = findViewById(R.id.btn_one);
        mSecondButton = findViewById(R.id.btn_two);
        mThirdButton = findViewById(R.id.btn_three);

        System.out.println(mFirstButton.getBackground());
        mFirstButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.v("I am TAG", "HELLO WORLD");
            }
        });
//        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
////                mCustomView.swapColor();
//                System.out.println(mFirstButton.getBackground());
//                mSecondButton.getBackground();
//                mThirdButton.getBackground();
//            }
//        },1000, 2000);

        findViewById(R.id.btn_swap_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCustomView.swapColor();
            }
        });

    }
    public void swapColor(){
        return;
    }
}
