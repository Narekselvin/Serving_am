package com.example.myfoodapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfoodapp.MainActivity;
import com.example.myfoodapp.R;
import com.example.myfoodapp.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
Button buttonSign_in;
EditText edtPhone,edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonSign_in =(Button) findViewById(R.id.ButtonSign_in);
        edtPhone= (EditText) findViewById(R.id.edtPhone);
        edtPass = (EditText) findViewById(R.id.edtPass);

        ///Добавляем датабазу
        FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference table_user=database.getReference("User");

        buttonSign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ProgressDialog mDialog = new ProgressDialog(LoginActivity.this);
                mDialog.setMessage("Please Wait..");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot DataSnapshot) {

                        ////Проверяем  сушествует ли пользователь
                        if (DataSnapshot.child(edtPhone.getText().toString()).exists()) {

                            ///получаем инфо от user-а
                            mDialog.dismiss();
                            User user = DataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);

                            ///проверяем правильный ли пароль
                            assert user != null;
                            if (user.getPassword().equals(edtPass.getText().toString())) {
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                Toast.makeText(LoginActivity.this, "Signed in Successfully", Toast.LENGTH_SHORT).show();
                            }else{Toast.makeText(LoginActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();}

                        }else{
                            mDialog.dismiss();
                            Toast.makeText(LoginActivity.this, "User doesn't exist ", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



            }
        });

    }



    public void register(View view) {
        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));

    }
}