package com.example.kitchapp;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Ingredient {
    private int number;
    private int criticalNumber;
    private int defaultBuyValue;
    private String name;
    private boolean shopable;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");


    public Ingredient(int number,int criticalNumber,boolean shopable,String name){
        this.number = number;
        this.criticalNumber = criticalNumber;
        this.shopable = shopable;
        this.name = name;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Ingredients");
        myRef.setValue(this);
    }
    public Ingredient(int number,boolean shopable,String name){
        this.number = number;
        this.shopable = shopable;
        this.name = name;
    }

    //Only name and number specified, other variables has set by default values. -Burak
    public Ingredient( String name, int number) {
        this.name = name;
        this.number = number;
        shopable = false;
        defaultBuyValue = number; //How much firstly bought will be offered next time.
        criticalNumber = 3; //Or may it will be asked later when setting it shopable?
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    /*
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("message");

    DatabaseReference usersRef = ref.child("ingredients");
    ArrayList<Ingredient> ingr
   Map<String, Ingredient> ingredients = new HashMap<>();

    ingredients.put("alanisawesome", new Ingredient(5,3,false,"tomato"));
    ingredients.put("gracehop", new Ingredient(4, ));
    */




}
