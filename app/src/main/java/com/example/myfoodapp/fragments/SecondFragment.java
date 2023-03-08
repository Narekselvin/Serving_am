package com.example.myfoodapp.fragments;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfoodapp.R;
import com.example.myfoodapp.adapters.FeaturedHorAdapter;
import com.example.myfoodapp.adapters.FeaturedVerAdapter;

import com.example.myfoodapp.models.FeaturedHorModel;
import com.example.myfoodapp.models.FeaturedVerModel;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

///featured_hor_rec, featured_ver_rec
public class SecondFragment extends Fragment {
    private FirebaseFirestore sb_hor = FirebaseFirestore.getInstance();
    private CollectionReference collectionRefHor = sb_hor.collection("DiscountProductsHor");
    private FeaturedHorAdapter adapter;
    private List<FeaturedHorModel> modelList = new ArrayList<>();

    private FirebaseFirestore sb_ver = FirebaseFirestore.getInstance();
    private CollectionReference collectionRefVer = sb_ver.collection("DiscountProductsVer");
    private FeaturedVerAdapter adapter2;
    private List<FeaturedVerModel> modelList2 = new ArrayList<>();


    public SecondFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);



        RecyclerView recyclerView = view.findViewById(R.id.featured_hor_rec2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FeaturedHorAdapter(modelList);
        recyclerView.setAdapter(adapter);

        collectionRefHor.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    String name = documentSnapshot.getString("name");
                    String imageUrl = documentSnapshot.getString("image_url");
                    String description = documentSnapshot.getString("description");

                    FeaturedHorModel item = new FeaturedHorModel(name, imageUrl, description);
                    modelList.add(item);
                }

                adapter.notifyDataSetChanged();
            }
        });
///////Vertical rec

        RecyclerView VerRecyclerview = view.findViewById(R.id.featured_ver_rec2);
        VerRecyclerview.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter2 = new FeaturedVerAdapter(modelList2);
        VerRecyclerview.setAdapter(adapter2);

        collectionRefVer.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    String name = documentSnapshot.getString("name");
                    String image = documentSnapshot.getString("image");
                    String description = documentSnapshot.getString("description");
                    String rating = documentSnapshot.getString("rating");
                    String timing = documentSnapshot.getString("timing");

                    FeaturedVerModel item2 = new FeaturedVerModel(image,  name,  description,  rating,  timing);
                    modelList2.add(item2);

                }

                adapter2.notifyDataSetChanged();
            }
        });



        return view;
    }
}


