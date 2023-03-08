package com.example.myfoodapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myfoodapp.R;
import com.example.myfoodapp.activities.DetailedDailyMealActivity;
import com.example.myfoodapp.models.MyCartModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.DocumentReference;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.HashMap;

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.MyCartViewHolder> {
    private ArrayList<MyCartModel> myCartModelList;


    public MyCartAdapter(Context context, ArrayList<MyCartModel> myCartModelList) {

        this.myCartModelList = myCartModelList;
    }

    @NonNull
    @Override
    public MyCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_cart_fragment_items, parent, false);
        return new MyCartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCartViewHolder holder, int position) {
        MyCartModel myCartModel = myCartModelList.get(position);
        holder.tvName.setText(myCartModel.getName());
        holder.tvPrice.setText(myCartModel.getPrice());

    }

    @Override
    public int getItemCount() {
        return myCartModelList.size();
    }

    static class MyCartViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice;

        MyCartViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPrice = itemView.findViewById(R.id.tv_price);

        }


    }}



