package com.example.admin.cardview_demo;



import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import model.Content;


public class CardViewActivity  extends AppCompatActivity {

    private List<Content> contents = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);
        ViewPager viewPager = findViewById(R.id.viewPager);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        contents.add(new Content("1","Có việc cần đi xa , hoặc dự yến hội , tiệc tùng , đi tiểu luôn thật là bất tiện , nhất là với phái nữ. Có cách sau , khiến suốt ngày không đi tiểu. Nấu Bạch Quả ( tức Ngân Hạnh ) 7 trái , ăn trước khi đi , thì suốt ngày tránh được đi tiểu", 5,1));
        contents.add(new Content("2", "b", 5, 1));
        contents.add(null);
        CardFragmentPagerAdapter pagerAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(), dpToPixels(2, this), contents);
        ShadowTransformer fragmentCardShadowTransformer = new ShadowTransformer(viewPager, pagerAdapter);
        fragmentCardShadowTransformer.enableScaling(true);

        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(false, fragmentCardShadowTransformer);
        viewPager.setOffscreenPageLimit(3);
    }

    /**
     * Change value in dp to pixels
     * @param dp
     * @param context
     * @return
     */
    private static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }
}
