package com.example.kitchapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

/**
 * Ingredients
 * @author
 * @version 12/12/2020
 */
public class Ingredient {
    private int number;
    private int criticalNumber;
    private int defaultBuyValue;
    private String name;
    private boolean shopable;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference().child("Ingredients");


    public Ingredient(int number,int criticalNumber,boolean shopable,String name){
        this.number = number;
        this.criticalNumber = criticalNumber;
        this.shopable = shopable;
        this.name = name;
        myRef.child(name).setValue(this);
    }
    public Ingredient(int number,boolean shopable,String name){
        this.number = number;
        this.shopable = shopable;
        this.name = name;
        myRef.child(name).setValue(this);
    }

    //Only name and number specified, other variables has set by default values. -Burak
    public Ingredient( String name, int number) {
        this.name = name;
        this.number = number;
        shopable = false;
        defaultBuyValue = number; //How much firstly bought will be offered next time.
        criticalNumber = 3; //Or may it will be asked later when setting it shopable?
        myRef.child(name).setValue(this);
    }

    public String getName(){ return name; }

    public void setName(String newName){
        myRef.child(name).child("name").setValue(newName);
        this.name = newName;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int newNumber){
        myRef.child(name).child("number").setValue(newNumber);
        this.number = number;
    }
    /*
    ValueEventListener postListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            this = dataSnapshot.getValue(Post.class);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    }*/

}
