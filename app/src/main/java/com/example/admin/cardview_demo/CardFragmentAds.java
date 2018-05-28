package com.example.admin.cardview_demo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CardFragmentAds extends FragmentDad {
    private CardView cardView;


    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_ads, container, false);
        TextView txt_demo = view.findViewById(R.id.txt_demo);
        txt_demo.setText("LOL");
        cardView = view.findViewById(R.id.cardView);

        cardView.setMaxCardElevation(cardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);
        return view;
    }

    @Override
    CardView getCardView() {
        return cardView;
    }
}
