package com.example.kitchapp;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Ingredient {
    private int number;
    private int criticalNumber;
    private int defaultBuyValue;
    private String name;
    private boolean shopable;

    public Ingredient(int number,int criticalNumber,boolean shopable,String name){
        this.number = number;
        this.criticalNumber = criticalNumber;
        this.shopable = shopable;
        this.name = name;
    }
    public Ingredient(int number,boolean shopable,String name){
        this.number = number;
        this.shopable = shopable;
        this.name = name;
    }
    /**
     
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("message");

    DatabaseReference usersRef = ref.child("ingredients");
    ArrayList<Ingredient> ingr
   Map<String, Ingredient> ingredients = new HashMap<>();

    ingredients.put("alanisawesome", new Ingredient(5,3,false,"tomato"));
    ingredients.put("gracehop", new Ingredient(4, ));
    **/




}
