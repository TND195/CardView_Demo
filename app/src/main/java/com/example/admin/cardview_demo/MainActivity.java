package com.example.admin.cardview_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import common.constants.Constants;


public class MainActivity extends AppCompatActivity implements OnTabSelectListener {

    // view
    private FloatingActionButton fab;
    private FragmentManager fragmentManager;
    private Toolbar toolbar;
    BottomBar bottomBar;

    // fragment
    private final FragmentCategory fragmentCategory = new FragmentCategory();
    private final FragmentNew fragmentNew = new FragmentNew();
    private final FragmentMe fragmentMe = new FragmentMe();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // map view to code
        toolbar = findViewById(R.id.toolbar);
        bottomBar = findViewById(R.id.bottom_bar);
        fab = findViewById(R.id.fab);

        setSupportActionBar(toolbar);
        fragmentManager = getSupportFragmentManager();
        // set init tab home
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction().replace(R.id.fragment_switch, fragmentNew, Constants.HOME).commit();
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ContributeLayout.class);
                startActivity(intent);
            }
        });

        for (int i = 0; i < bottomBar.getTabCount(); i++) {
            bottomBar.getTabAtPosition(i).setGravity(Gravity.CENTER_VERTICAL);
        }
        // change fragment by tab
        bottomBar.setOnTabSelectListener(this);
    }

    /**
     * change fragment by tab
     * @param tabId
     */
    @Override
    public void onTabSelected(int tabId) {
        FragmentTransaction fragmentTransaction;
        switch (tabId) {
            case R.id.home:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_switch, fragmentNew, Constants.HOME);
                fragmentTransaction.commit();
                break;
            case R.id.transaction:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_switch, fragmentCategory, Constants.CATEGORY);
                fragmentTransaction.commit();
                break;
            case R.id.partners:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_switch, fragmentMe, Constants.ME);
                fragmentTransaction.commit();

        }
    }
}
