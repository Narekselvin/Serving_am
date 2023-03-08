package com.example.myfoodapp.ui.dailymeal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfoodapp.R;
import com.example.myfoodapp.adapters.DailyMealAdapter;

import com.example.myfoodapp.models.DailyMealModel;
import com.example.myfoodapp.models.FeaturedVerModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DailyMealFragment extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();;
    RecyclerView recyclerView;
    List<DailyMealModel> dailyMealModelList;
    DailyMealAdapter dailyMealAdapter;

    private CollectionReference collectionRef = db.collection("DailyMeal");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.daily_meal_fragment, container, false);

        recyclerView = view.findViewById(R.id.daily_meal_rec);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        dailyMealModelList = new ArrayList<>();
        dailyMealAdapter = new DailyMealAdapter(getContext(), dailyMealModelList);
        recyclerView.setAdapter(dailyMealAdapter);

        collectionRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {


                    String name = documentSnapshot.getString("nameDaily");
                    String image = documentSnapshot.getString("imageviewDaily");
                    String description = documentSnapshot.getString("DescriptionDaily");
                    String discount = documentSnapshot.getString("DiscountDaily");
                    String type = documentSnapshot.getString("type");


                    DailyMealModel item = new DailyMealModel(image,  name,  description,  discount, type);
                    dailyMealModelList.add(item);

                }

                dailyMealAdapter.notifyDataSetChanged();
            }
        });
return  view;
    }}