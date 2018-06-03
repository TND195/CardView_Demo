package com.example.admin.cardview_demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentCollectCategory extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LOG_A", "Create_Me");
        View myFragmentView = inflater.inflate(R.layout.fragment_collect_category, container, false);
        return myFragmentView;
    }
}