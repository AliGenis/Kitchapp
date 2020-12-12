package com.example.kitchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class DataInsert extends AppCompatActivity {
    EditText name;
    EditText password;
    DatabaseReference refer; //to connect databse
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datainsert);
        name = (EditText)findViewById(R.id.editTextTextPersonName);
        password = (EditText)findViewById((R.id.editTextTextPassword));
        refer = FirebaseDatabase.getInstance().getReference().child("User");
        user.setName(name.getText().toString().trim());
        user.setName(password.getText().toString().trim());
        refer.push().setValue(user);
        Toast.makeText(DataInsert.this,"user is created successfully",Toast.LENGTH_LONG).show();
    }

}
