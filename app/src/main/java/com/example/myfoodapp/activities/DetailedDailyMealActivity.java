package com.example.myfoodapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myfoodapp.R;
import com.example.myfoodapp.adapters.DetailedDailyAdapter;
import com.example.myfoodapp.adapters.FeaturedHorAdapter;
import com.example.myfoodapp.models.DetailedDailyModel;
import com.example.myfoodapp.models.FeaturedHorModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public class DetailedDailyMealActivity extends AppCompatActivity {
RecyclerView recyclerView;
List<DetailedDailyModel> detailedDailyModelList;
DetailedDailyAdapter dailyAdapter;
ImageView imageView;
private FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_daily_meal);

        String type = getIntent().getStringExtra("type");

        recyclerView = findViewById(R.id.detailed_rec);
        imageView= findViewById(R.id.detailed_img);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailedDailyModelList = new ArrayList<>();
        dailyAdapter = new DetailedDailyAdapter(detailedDailyModelList);
        recyclerView.setAdapter(dailyAdapter);

        if (type != null && type.equalsIgnoreCase("Breakfast")){
            imageView.setImageResource(R.drawable.breakfast);
            firestore.collection("DailyMealProducts").whereEqualTo("type","breakfast").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>(){
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                        String name = documentSnapshot.getString("detailed_name");
                        String image = documentSnapshot.getString("detailed_img");
                        String rating = documentSnapshot.getString("detailed_rating");
                        String timing = documentSnapshot.getString("detailed_timing");
                        String price = documentSnapshot.getString("detailed_price");
                        String description = documentSnapshot.getString("detailed_description");


                        DetailedDailyModel item = new DetailedDailyModel( image,  name,  description,  rating,  price,  timing);
                        detailedDailyModelList.add(item);
                    }

                    dailyAdapter.notifyDataSetChanged();
                }
            });
        }
        if (type != null && type.equalsIgnoreCase("Sweets")){
            imageView.setImageResource(R.drawable.sweets);
            firestore.collection("DailyMealProducts").whereEqualTo("type","sweets").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>(){
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                        String name = documentSnapshot.getString("detailed_name");
                        String image = documentSnapshot.getString("detailed_img");
                        String rating = documentSnapshot.getString("detailed_rating");
                        String timing = documentSnapshot.getString("detailed_timing");
                        String price = documentSnapshot.getString("detailed_price");
                        String description = documentSnapshot.getString("detailed_description");


                        DetailedDailyModel item = new DetailedDailyModel( image,  name,  description,  rating,  price,  timing);
                        detailedDailyModelList.add(item);
                    }

                    dailyAdapter.notifyDataSetChanged();
                }
            });
        }

        if (type != null && type.equalsIgnoreCase("Lunch")){
            imageView.setImageResource(R.drawable.lunch);
            firestore.collection("DailyMealProducts").whereEqualTo("type","lunch").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>(){
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                        String name = documentSnapshot.getString("detailed_name");
                        String image = documentSnapshot.getString("detailed_img");
                        String rating = documentSnapshot.getString("detailed_rating");
                        String timing = documentSnapshot.getString("detailed_timing");
                        String price = documentSnapshot.getString("detailed_price");
                        String description = documentSnapshot.getString("detailed_description");

                        DetailedDailyModel item = new DetailedDailyModel( image,  name,  description,  rating,  price,  timing);
                        detailedDailyModelList.add(item);
                    }

                    dailyAdapter.notifyDataSetChanged();
                }
            });
        }
        if (type != null && type.equalsIgnoreCase("Dinner")){
            imageView.setImageResource(R.drawable.dinner);
            firestore.collection("DailyMealProducts").whereEqualTo("type","dinner").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>(){
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                        String name = documentSnapshot.getString("detailed_name");
                        String image = documentSnapshot.getString("detailed_img");
                        String rating = documentSnapshot.getString("detailed_rating");
                        String timing = documentSnapshot.getString("detailed_timing");
                        String price = documentSnapshot.getString("detailed_price");
                        String description = documentSnapshot.getString("detailed_description");


                        DetailedDailyModel item = new DetailedDailyModel( image,  name,  description,  rating,  price,  timing);
                        detailedDailyModelList.add(item);
                    }

                    dailyAdapter.notifyDataSetChanged();
                }
            });
        }
        if (type != null && type.equalsIgnoreCase("Coffee")){
            imageView.setImageResource(R.drawable.coffe);
            firestore.collection("DailyMealProducts").whereEqualTo("type","coffee").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>(){
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                        String name = documentSnapshot.getString("detailed_name");
                        String image = documentSnapshot.getString("detailed_img");
                        String rating = documentSnapshot.getString("detailed_rating");
                        String timing = documentSnapshot.getString("detailed_timing");
                        String price = documentSnapshot.getString("detailed_price");
                        String description = documentSnapshot.getString("detailed_description");


                        DetailedDailyModel item = new DetailedDailyModel( image,  name,  description,  rating,  price,  timing);
                        detailedDailyModelList.add(item);
                    }

                    dailyAdapter.notifyDataSetChanged();
                }
            });
        }




    }
}