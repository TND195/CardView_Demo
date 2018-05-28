package com.example.admin.cardview_demo;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import model.Category;


public class MainActivity extends AppCompatActivity {

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

        RecyclerView rv_Category = findViewById(R.id.list_category);
        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryList, getApplicationContext());

        Category category = new Category(R.drawable.ic_dating, "1", "Dating");
        categoryList.add(category);
        category = new Category(R.drawable.ic_technology,"1", "Technology");
        categoryList.add(category);
        category = new Category(R.drawable.ic_technology,"1", "Technology");
        categoryList.add(category);
        category = new Category(R.drawable.ic_technology,"1", "Technology");
        categoryList.add(category);
        category = new Category(R.drawable.ic_technology,"1", "Technology");
        categoryList.add(category);
        category = new Category(R.drawable.ic_technology,"1", "Technology");
        categoryList.add(category);
        category = new Category(R.drawable.ic_technology,"1", "Technology");
        categoryList.add(category);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        rv_Category.setAdapter(categoryAdapter);
        rv_Category.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        rv_Category.setItemAnimator(new DefaultItemAnimator());
        rv_Category.setLayoutManager(mLayoutManager);



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

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        private GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
