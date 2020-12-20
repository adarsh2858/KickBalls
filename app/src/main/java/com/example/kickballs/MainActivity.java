package com.example.kickballs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchFirstLevel(View view) {
        Toast.makeText(getApplicationContext(), "First Level", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), FirstLevel.class));
    }

    public void launchSecondLevel(View view) {
        Toast.makeText(getApplicationContext(), "Second Level", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), SecondLevel.class));
    }

    public void launchThirdLevel(View view) {
        Toast.makeText(getApplicationContext(), "Third Level", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), ThirdLevel.class));
    }

    public void launchFourthLevel(View view) {
        Toast.makeText(getApplicationContext(), "Fourth Level", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), FourthLevel.class));
    }

    public void launchFifthLevel(View view) {
        Toast.makeText(getApplicationContext(), "Fifth Level", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), FifthLevel.class));
    }

    public void launchSixthLevel(View view) {
        Toast.makeText(getApplicationContext(), "Sixth Level", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), SixthLevel.class));
    }
}
