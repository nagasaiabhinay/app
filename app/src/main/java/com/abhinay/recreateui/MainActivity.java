package com.abhinay.recreateui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_main);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main,
                    new LoginFragment()).commit();
        }
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item){
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_login:
                    selectedFragment = new LoginFragment();
                    break;
                case R.id.navigation_signup:
                    selectedFragment = new SignupFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main,
                    selectedFragment).commit();
            return true;
        }
    };
}