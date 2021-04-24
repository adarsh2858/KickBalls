package com.adarsh.kickballs;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.adarsh.kickballs.ui.login.LoginActivity;

public class FirstActivity extends AppCompatActivity {

    Button mRegisterButton, mLoginButton, mGuestButton;
    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mRegisterButton = findViewById(R.id.btn_register);
        mLoginButton = findViewById(R.id.btn_login);
        mGuestButton = findViewById(R.id.btn_guest);

        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mGuestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, LevelsListActivity.class);
                startActivity(intent);
            }
        });
    }

    public void loginFromRoot(View view){
        Intent intent = new Intent(FirstActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void register(View view) {
        Intent intent = new Intent(FirstActivity.this, Register.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
