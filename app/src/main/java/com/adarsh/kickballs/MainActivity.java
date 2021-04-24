package com.adarsh.kickballs;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setCurrentFragment(new FirstFragment());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.home:
                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                        setCurrentFragment(new FirstFragment());
                        break;

                    case R.id.daily_challenges:
                        Toast.makeText(getApplicationContext(), "Daily Challenges", Toast.LENGTH_SHORT).show();
                        setCurrentFragment(new SecondFragment());
                        break;

                    case R.id.stats:
                        Toast.makeText(getApplicationContext(), "Statistics", Toast.LENGTH_SHORT).show();
                        setCurrentFragment(new ThirdFragment());
                        break;

                    default:
                        setCurrentFragment(new FirstFragment());
                }
                return true;
            }
        });
    }

    protected void setCurrentFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFragment, fragment)
                .commit();
    }
}
