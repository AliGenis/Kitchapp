package com.example.kitchapp;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class fridgeUI extends AppCompatActivity {
    GridLayout mainGrid;

    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.fragment_fridge);
    }
    private void setToggleEvent(GridLayout mainGrid){

    }
    private void setSingleEvent(GridLayout mainGrid){
    //Loop all child item of MainGrid
        for(int i = 0;i < mainGrid.getChildCount();i++){
            //you can see all child item in CardView, so we just cast object in CardView
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener((view));
            Toast.makeText(fragment)

        }
    }
}
