package com.example.kitchapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.NavigationMenu;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.fragment_suggestion_screen);

        setContentView(R.layout.activity_main);
        //BottomNavigationView navView = findViewById(R.id.bottomNavigationView);
        //AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.fridgeFragment,
               // R.id.shoppingListScreenFragment, R.id.suggestionScreen, R.id.recipesFragment, R.id.settingsFragment).build();
        //NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment_container);
        //NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
        //NavController navController = getNavController(); //solution in the video
        //NavigationUI.setupWithNavController(navView,navController);


        //setContentView(R.layout.fragment_suggestion_screen);

        System.out.println("KITCHAPP!");
        Ingredient deneme = new Ingredient( 200,4,true,"Hıyar");
        Ingredient deneme1 = new Ingredient( 20,4,true,"Limon");
/*
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Ingredients");
        myRef.setValue( new Ingredient( "Limoon", 40));
*/


    }
    /*
    @NonNull
    private  NavController getNavController() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fridgeFragment);
        if (!(fragment instanceof NavHostFragment)) {
            throw new IllegalStateException("Activity " + this
                    + " does not have a NavHostFragment");
        }
        return ((NavHostFragment) fragment).getNavController();

    }*/

    public void openDataInsert(){
        Intent intent = new Intent(this,DataInsert.class);
        startActivity(intent);
    }
}
