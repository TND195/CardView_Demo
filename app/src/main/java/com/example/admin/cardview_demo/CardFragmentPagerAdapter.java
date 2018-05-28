package com.example.admin.cardview_demo;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import model.Content;

public class CardFragmentPagerAdapter extends FragmentStatePagerAdapter implements CardAdapter {

    private List<FragmentDad> fragments;
    private float baseElevation;

    public CardFragmentPagerAdapter(FragmentManager fm, float baseElevation, List<Content> contents) {
        super(fm);
        fragments = new ArrayList<>();
        List<Content> contents1 = contents;
        this.baseElevation = baseElevation;

        for (Content content : contents) {
            if (content != null ) {
                CardFragment cardFragment = new CardFragment();
                cardFragment.setContent(content);
                addCardFragment(cardFragment);
            } else {
                addCardFragment(new CardFragmentAds());
            }
        }
    }

    @Override
    public float getBaseElevation() {
        return baseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return fragments.get(position).getCardView();
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object fragment = super.instantiateItem(container, position);
        fragments.set(position, (FragmentDad) fragment);
        return fragment;
    }

    private void addCardFragment(FragmentDad fragment) {
        fragments.add(fragment);
    }

}