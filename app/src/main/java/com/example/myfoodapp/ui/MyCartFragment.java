package com.example.myfoodapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfoodapp.R;
import com.example.myfoodapp.adapters.MyCartAdapter;
import com.example.myfoodapp.models.MyCartModel;

import java.util.ArrayList;

public class MyCartFragment extends Fragment {
    private ArrayList<MyCartModel> myCartModelList = new ArrayList<>();
    private MyCartAdapter myCartAdapter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);
        recyclerView = view.findViewById(R.id.cart_items_recycler_view);
        myCartAdapter = new MyCartAdapter(getContext(), myCartModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(myCartAdapter);
        return view;
    }

    public void addToCart(MyCartModel myCartModel) {
        myCartModelList.add(myCartModel);
        myCartAdapter.notifyDataSetChanged();
    }
}