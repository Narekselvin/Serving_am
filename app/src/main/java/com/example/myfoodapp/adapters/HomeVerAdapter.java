package com.example.myfoodapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myfoodapp.R;
import com.example.myfoodapp.models.HomeHorModel;
import com.example.myfoodapp.models.HomeVerModel;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public class HomeVerAdapter extends RecyclerView.Adapter<HomeVerAdapter.ViewHolder> {


     List<HomeVerModel> modelList1;

    public HomeVerAdapter(List<HomeVerModel> modelList) {
        this.modelList1 = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeVerModel item = modelList1.get(position);
        holder.nameTextView.setText(item.getName());
        Glide.with(holder.itemView.getContext())
                .load(item.getImage())
                .into(holder.imageView);
        holder.timingTextView.setText(item.getTiming());
        holder.priceTextView.setText(item.getPrice());
    }

    @Override
    public int getItemCount() {
        return  modelList1.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView,timingTextView,priceTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ver_img);
            nameTextView = itemView.findViewById(R.id.ver_name);
            timingTextView = itemView.findViewById(R.id.ver_timing);
            priceTextView = itemView.findViewById(R.id.ver_price);

        }
    }
}
