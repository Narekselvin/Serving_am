package com.example.myfoodapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myfoodapp.R;
import com.example.myfoodapp.models.FeaturedVerModel;


import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public class FeaturedVerAdapter extends RecyclerView.Adapter<FeaturedVerAdapter.ViewHolder> {

    private List<FeaturedVerModel> modelList2;

    public FeaturedVerAdapter(List<FeaturedVerModel> modelList) {
        this.modelList2 = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_ver_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FeaturedVerModel item = modelList2.get(position);

        // Set the data in the views
        holder.nameTextView.setText(item.getName());
        holder.ratingTextView.setText(item.getRating());
        holder.timingTextView.setText(item.getTiming());
        holder.descriptionTextView.setText(item.getDescription());
        Glide.with(holder.itemView.getContext())
                .load(item.getImage())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelList2.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView, descriptionTextView, ratingTextView,timingTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.detailed_img);
            nameTextView = itemView.findViewById(R.id.detailed_name);
            descriptionTextView = itemView.findViewById(R.id.detailed_description);
            ratingTextView = itemView.findViewById(R.id.detailed_rating);
            timingTextView = itemView.findViewById(R.id.detailed_timing);
        }
    }
}