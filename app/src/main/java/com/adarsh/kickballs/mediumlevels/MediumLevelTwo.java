package com.adarsh.kickballs.mediumlevels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.adarsh.kickballs.R;


public class MediumLevelTwo extends AppCompatActivity {
    protected static Button btnPool2, btnPool3, btnPool4, btnPool5, btnPool6, btnPool7;

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
    }
}