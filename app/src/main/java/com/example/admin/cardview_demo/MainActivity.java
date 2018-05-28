package com.example.admin.cardview_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import model.Category;


public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_Category;
    private CategoryAdapter categoryAdapter;

    private List<Category> categoryList = new ArrayList<>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard:

                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_Category = findViewById(R.id.list_category);
        categoryAdapter = new CategoryAdapter(categoryList , getApplicationContext());

        Category category = new Category(R.drawable.ic_dating, "1", "Dating");
        categoryList.add(category);
        category = new Category(R.drawable.ic_technology,"1", "Technology");
        categoryList.add(category);
        rv_Category.setAdapter(categoryAdapter);
        rv_Category.setLayoutManager(new LinearLayoutManager(this));



        rv_Category.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), rv_Category, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, CardViewActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        categoryAdapter.notifyDataSetChanged();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
    private void prepareMovieData() {

    }

}
