package com.example.kickballs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kickballs.ui.login.LoginActivity;

public class FirstActivity extends AppCompatActivity {

    Button mRegisterButton, mLoginButton, mGuestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mRegisterButton = findViewById(R.id.btn_register);
        mLoginButton = findViewById(R.id.btn_login);
        mGuestButton = findViewById(R.id.btn_guest);

        mGuestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void loginFromRoot(View view){
        Intent intent = new Intent(FirstActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void register(View view){
        Intent intent = new Intent(FirstActivity.this, Register.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}