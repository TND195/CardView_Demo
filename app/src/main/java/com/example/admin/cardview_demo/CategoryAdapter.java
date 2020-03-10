package com.example.admin.cardview_demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;
import model.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private List<Category> categoryList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtCategory;
        ImageView imgCategory;
        TextView txtDescription;

        MyViewHolder(View view) {
            super(view);
            txtCategory = view.findViewById(R.id.txtCategory);
            imgCategory =  view.findViewById(R.id.imgCategory);
            txtDescription = view.findViewById(R.id.txtDescription);
        }
    }


    public CategoryAdapter(List<Category> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_category, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.txtCategory.setText(category.getName());
        holder.txtDescription.setText(category.getDescription());
        Glide.with(context)
                .load(category.getImg())
                .into(holder.imgCategory);

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}