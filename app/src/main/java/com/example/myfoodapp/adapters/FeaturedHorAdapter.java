package com.example.myfoodapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myfoodapp.R;
import com.example.myfoodapp.models.FeaturedHorModel;


import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public class FeaturedHorAdapter extends RecyclerView.Adapter<FeaturedHorAdapter.ViewHolder> {

    private List<FeaturedHorModel> modelList;

    public FeaturedHorAdapter(List<FeaturedHorModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_hor_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FeaturedHorModel item = modelList.get(position);


        holder.nameTextView.setText(item.getName());
        holder.descriptionTextView.setText(item.getDescription());
        Glide.with(holder.itemView.getContext())
                .load(item.getImageUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView, descriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.featured_img);
            nameTextView = itemView.findViewById(R.id.featured_name);
            descriptionTextView = itemView.findViewById(R.id.featured_desc);
        }
    }
}