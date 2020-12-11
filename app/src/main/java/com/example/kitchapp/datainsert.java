package com.example.kitchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class datainsert extends AppCompatActivity {
    EditText name;
    DatabaseReference refer;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_datainsert);
        name = (EditText)findViewById((R.id.name));
    }

}
