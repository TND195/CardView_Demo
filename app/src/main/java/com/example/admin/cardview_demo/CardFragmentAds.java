package com.example.admin.cardview_demo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CardFragmentAds extends FragmentDad {
    private CardView cardView;
    private TextView txt_demo;


    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_ads, container, false);
        txt_demo = view.findViewById(R.id.txt_demo);
        txt_demo.setText("LOL");
        cardView = (CardView) view.findViewById(R.id.cardView);

        cardView.setMaxCardElevation(cardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);
        return view;
    }

    @Override
    CardView getCardView() {
        return cardView;
    }
}
