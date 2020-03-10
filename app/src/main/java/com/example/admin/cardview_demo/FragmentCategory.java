package com.example.admin.cardview_demo;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import model.Category;

public class FragmentCategory extends Fragment {
    private List<Category> categoryList = new ArrayList<>();
    private RecyclerView rv_Category;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LOG_A", "Create");
        View myFragmentView = inflater.inflate(R.layout.fragment_category, container, false);
        rv_Category = myFragmentView.findViewById(R.id.list_category);
        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryList, getActivity());

        Category category = new Category(R.drawable.ic_dating, "1", "Dating", "Tra từ 'mô tả' trong từ điển Tiếng Anh miễn phí và các bản dịch Anh khác.");
        categoryList.add(category);
        category = new Category(R.drawable.ic_technology,"1", "Technology", "Tra từ 'mô tả' trong từ điển Tiếng Anh miễn phí và các bản dịch Anh khác.");
        categoryList.add(category);
        category = new Category(R.drawable.ic_technology,"1", "Technology", "Tra từ 'mô tả' trong từ điển Tiếng Anh miễn phí và các bản dịch Anh khác.");
        categoryList.add(category);
        category = new Category(R.drawable.ic_technology,"1", "Technology", "Tra từ 'mô tả' trong từ điển Tiếng Anh miễn phí và các bản dịch Anh khác.");
        categoryList.add(category);
        category = new Category(R.drawable.ic_technology,"1", "Technology", "Tra từ 'mô tả' trong từ điển Tiếng Anh miễn phí và các bản dịch Anh khác.");
        categoryList.add(category);
        category = new Category(R.drawable.ic_technology,"1", "Technology", "Tra từ 'mô tả' trong từ điển Tiếng Anh miễn phí và các bản dịch Anh khác.");
        categoryList.add(category);
        category = new Category(R.drawable.ic_technology,"1", "Technology", "Tra từ 'mô tả' trong từ điển Tiếng Anh miễn phí và các bản dịch Anh khác.");
        categoryList.add(category);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        rv_Category.setAdapter(categoryAdapter);
        // rv_Category.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(10), true));
        rv_Category.setItemAnimator(new DefaultItemAnimator());
        rv_Category.setLayoutManager(mLayoutManager);



        rv_Category.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), rv_Category, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getActivity(), CardViewActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        categoryAdapter.notifyDataSetChanged();

        return myFragmentView;
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
