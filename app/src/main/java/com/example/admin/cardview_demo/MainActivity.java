package com.example.admin.cardview_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;



public class MainActivity extends AppCompatActivity {


    private FloatingActionButton fab;
    private FragmentManager fragmentManager;
    private final FragmentCategory fragmentCategory = new FragmentCategory();
    private final FragmentNew fragmentNew = new FragmentNew();
    private final FragmentMe fragmentMe = new FragmentMe();
    private Toolbar toolbar;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction fragmentTransaction;
            switch (item.getItemId()) {
                case R.id.action_home:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_switch, fragmentNew, "home");
                    fragmentTransaction.commit();
                    return true;
                case R.id.action_category:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_switch, fragmentCategory, "category");
                    fragmentTransaction.commit();
                    return true;
                case R.id.action_save:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_switch, fragmentMe, "me");
                    fragmentTransaction.commit();

                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction().replace(R.id.fragment_switch, fragmentNew, "home").commit();
        }
        fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ContributeLayout.class);
                startActivity(intent);
            }
        });


        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }



}
