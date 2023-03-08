package com.example.myfoodapp.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfoodapp.R;

import com.example.myfoodapp.adapters.HomeHorAdapter;
import com.example.myfoodapp.adapters.HomeVerAdapter;
import com.example.myfoodapp.models.HomeHorModel;
import com.example.myfoodapp.models.HomeVerModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment  {

    EditText searchEditText;

   /////Horizontal
   FirebaseFirestore db_hor = FirebaseFirestore.getInstance();
   CollectionReference collectionRefHor = db_hor.collection("HomeHorProduct");
   HomeHorAdapter homeHorAdapter;
    List<HomeHorModel> modelList = new ArrayList<>();


  //////////////Vertical
  FirebaseFirestore db_ver = FirebaseFirestore.getInstance();
    CollectionReference collectionRefVer = db_ver.collection("HomeVerProduct");
    HomeVerAdapter   homeVerAdapter;
    List<HomeVerModel> modelList1 = new ArrayList<>();



    public HomeFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
searchEditText = view.findViewById(R.id.searchEditText);
        RecyclerView homeHorizontalRec = view.findViewById(R.id.home_hor_rec);
        RecyclerView homeVerticalRec = view.findViewById(R.id.home_ver_rec);



 ///////////////////////////////Horizontal Recyclerview
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        homeHorizontalRec.setLayoutManager(layoutManager);
        homeHorAdapter = new HomeHorAdapter(modelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);

        collectionRefHor.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    String image = documentSnapshot.getString("image");
                    HomeHorModel item = new HomeHorModel(image);
                    modelList.add(item);
                }
                homeHorAdapter.notifyDataSetChanged();
            }
        });

 ///////////////////////////////Vertical Recyclerview
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        homeVerticalRec.setLayoutManager(layoutManager2);
        homeVerAdapter = new HomeVerAdapter(modelList1);
        homeVerticalRec.setAdapter(homeVerAdapter);

        collectionRefVer.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    String name = documentSnapshot.getString("name");
                    String image = documentSnapshot.getString("image");
                    String timing = documentSnapshot.getString("timing");
                    String price = documentSnapshot.getString("price");

                    HomeVerModel item = new HomeVerModel( image,  name,  timing,   price);
                    modelList1.add(item);
                }

                homeVerAdapter.notifyDataSetChanged();
            }
        });

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String searchText = s.toString();
                Query query = collectionRefVer.whereEqualTo("name", searchText);
                query.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        modelList1.clear();
                        for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                            String name = documentSnapshot.getString("name");
                            String image = documentSnapshot.getString("image");
                            String timing = documentSnapshot.getString("timing");
                            String price = documentSnapshot.getString("price");

                            HomeVerModel item = new HomeVerModel(image, name, timing, price);
                            modelList1.add(item);
                        }
                        homeVerAdapter.notifyDataSetChanged();
                    }
                });
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        return view;
    }


}