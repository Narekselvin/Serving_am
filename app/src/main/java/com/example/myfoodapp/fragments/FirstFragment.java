package com.example.myfoodapp.fragments;

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

public class FirstFragment extends Fragment {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionRef = db.collection("products");
    private FeaturedHorAdapter adapter;
    private List<FeaturedHorModel> modelList = new ArrayList<>();

    private FirebaseFirestore dbver = FirebaseFirestore.getInstance();
    private CollectionReference collectionRefVer = dbver.collection("verticalproducts");
    private FeaturedVerAdapter adapter2;
    private List<FeaturedVerModel> modelList2 = new ArrayList<>();


    public FirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);



        RecyclerView recyclerView = view.findViewById(R.id.featured_hor_rec);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FeaturedHorAdapter(modelList);
        recyclerView.setAdapter(adapter);

        collectionRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
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

        RecyclerView VerRecyclerview = view.findViewById(R.id.featureed_ver_rec);
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

                // Notify the adapter that the data has changed
                adapter2.notifyDataSetChanged();
            }
        });



        return view;










    }
}