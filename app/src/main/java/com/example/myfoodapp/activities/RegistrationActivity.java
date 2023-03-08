package com.example.myfoodapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfoodapp.MainActivity;
import com.example.myfoodapp.R;
import com.example.myfoodapp.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegistrationActivity extends AppCompatActivity {
Button btnRegister;
EditText edtName,edtPass,edtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        btnRegister = (Button) findViewById(R.id.btn_Register);
        edtName= (EditText) findViewById(R.id.edtName);
        edtPass = (EditText) findViewById(R.id.edtPass);
        edtPhone= (EditText) findViewById(R.id.edtPhone);

        ///Добавляем датабазу
        FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference table_user=database.getReference("User");

btnRegister.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ProgressDialog mDialog = new ProgressDialog(RegistrationActivity.this);
        mDialog.setMessage("Please Wait..");
        mDialog.show();

        table_user.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ///проверяем если уже есть пользователь с тем же маил ом
                if(dataSnapshot.child(edtPhone.getText().toString()).exists()){
                    mDialog.dismiss();
                    Toast.makeText(RegistrationActivity.this, "Phone already exists", Toast.LENGTH_SHORT).show();
                }else{
                    mDialog.dismiss();
                    User user = new User(edtName.getText().toString(),edtPass.getText().toString());
                    table_user.child(edtPhone.getText().toString()).setValue(user);
                    startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                    Toast.makeText(RegistrationActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    }
});




    }

    public void login(View view) {
        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
    }

}