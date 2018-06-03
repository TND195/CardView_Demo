package com.example.admin.cardview_demo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentMe extends Fragment  {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LOG_A", "Create_Me");
        View myFragmentView = inflater.inflate(R.layout.fragment_me, container, false);
        viewPager =  myFragmentView.findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout =  myFragmentView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        return myFragmentView;
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new FragmentCollectCategory(), getResources().getString(R.string.category));
        adapter.addFragment(new FragmentCollectContent(), getResources().getString(R.string.collect));
        viewPager.setAdapter(adapter);
    }
}
